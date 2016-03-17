package ua.AVM.simplex.impl;

import org.springframework.stereotype.Component;
import ua.AVM.simplex.interfaces.Simplex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SimplexMethod implements Simplex {

    private List<String> basicVariables;
    private List<String> notBasicVariables;

    /**
     * Початкова симплекс таблиця, де останній рядок - цільова функція,
     *               а останній стовпець - вільні члени
     */
    private List<List<Float>> matrix;

    public List<List<Float>> getMatrix() {
        return matrix;
    }

    public List<String> getBasicVariables() {
        return basicVariables;
    }

    public List<String> getNotBasicVariables() {
        return notBasicVariables;
    }

    @Override
    public List<List<Float>> createSimplexTable(int numVar, int numRestriction) {
        /*matrix = new ArrayList<>(Arrays.asList(Arrays.asList(1f,-2f,1f), Arrays.asList(-2f,1f,2f),
                Arrays.asList(2f,1f,6f), Arrays.asList(-3f, -1f, 0f)));*/
        /* matrix = new ArrayList<>(Arrays.asList(Arrays.asList(1f, 0f, 1f, 0f, 2f), Arrays.asList(0f, 1f, 0f, 1f, 5f),
                Arrays.asList(-5f, -10f, 0f, 0f,-25f),Arrays.asList(0f, 0f, -5f, -10f,-40f),
                 Arrays.asList(-20f, -25f, -15f, -20f, 0f)));*/
          /*matrix = new ArrayList<>(Arrays.asList(Arrays.asList(0.1f, 0.3f, 0f,17f), Arrays.asList(0.4f, 0.1f, 0f,11f),
                Arrays.asList(0.2f, 0.2f, 0f,13f),Arrays.asList(-6f, -5f, 0f, 0f)));*/
        matrix = new ArrayList<>(Arrays.asList(Arrays.asList(1f, 1f, 0f,0f,8f), Arrays.asList(0f, 0f, 1f,1f,12f),
                Arrays.asList(-60f, 0f, -40f,0f,-240f),Arrays.asList(0f, -60f, 0f, -40f,-180f),
                Arrays.asList(310f, 380f, 420f, 480f,0f)));

        basicVariables = new ArrayList<>();
        notBasicVariables = new ArrayList<>();

        for (int i = 0; i < numRestriction; i++) {
            basicVariables.add("u" + (i+1));
        }
        basicVariables.add("F");
        for (int i = 0; i < numVar; i++) {
            notBasicVariables.add("x" + (i+1));
        }
        notBasicVariables.add("B");
        return matrix;
    }
    /**
     *Робить одну ітерацію симплекс перетворення(якщо дане рішення недопустиме)
     * @return Булеве значення допустимості розв'язку
     */
    @Override
    public Boolean checkPermissibility() {

        int row = -1;//Ведучий рядок
        int col = -1;//Ведучий стовпець
        double minElementInCol = 0;
        double minElementInRow = 0;

        //Перевірка на допустимість рішення і знаходження ведучого рядка
        for (int i = 0; i < matrix.size() - 1; i++) {

            if (matrix.get(i).get(matrix.get(i).size() - 1) < 0 && matrix.get(i).get(matrix.get(i).size() - 1) < minElementInCol) {
                row = i;
                minElementInCol = matrix.get(i).get(matrix.get(i).size() - 1);
            }
        }
        if (row == -1) return true;//Рішення допустиме

        //Знаходжу ведучий стовпець
        for (int j = 0; j < matrix.get(row).size() - 1; j++) {
            if (matrix.get(row).get(j) < minElementInRow) {
                minElementInRow = matrix.get(row).get(j);
                col = j;
            }
        }
        if(col == -1) {
            throw new IllegalArgumentException("Задача розв'язку немає");
        }

        //Перераховую таблицю (row і col - індекси ведучого елемента)
        transformationTable(row, col);

        //Нове рішення допустиме?
        for (int i = 0; i < matrix.size() - 1; i++) {

            if (matrix.get(i).get(matrix.get(i).size() - 1) < 0 && i != matrix.size() - 1) {
                return false;

            }
        }

        return true;

    }

    /**
     *
     * @param row Індекс рядка ведучого елементу
     * @param col Індекс стовпця ведучого елементу
     */
    private void transformationTable(int row, int col) {
        //Міняю місцями базисну й небазисну змінну
        String temp =  basicVariables.get(row);
        basicVariables.set(row, notBasicVariables.get(col));
        notBasicVariables.set(col, temp);

        List<List<Float>> newMatrix = new ArrayList<>();
        //Копіюю елементи
        for (int i = 0; i < matrix.size(); i++) {
            newMatrix.add(new ArrayList<>());
            for (int j = 0; j < matrix.get(i).size(); j++) {
                newMatrix.get(i).add(matrix.get(i).get(j));
            }
        }

        //Змінюю матрицю
        //Всі елементи ведучого рядка
        for (int j = 0; j < matrix.get(row).size(); j++) {
            if (j != col) {
                newMatrix.get(row).set(j, matrix.get(row).get(j) / matrix.get(row).get(col));
            }
        }

        //Всі елементи ведучого стовпця
        for (int i = 0; i < matrix.size(); i++) {
            if (i != row) {
                newMatrix.get(i).set(col, matrix.get(i).get(col) * (-1 / matrix.get(row).get(col)));
            }
        }

        //Всі інші елементи(крім ведучого)
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (i != row && j != col) {
                    newMatrix.get(i).set(j, matrix.get(i).get(j) - matrix.get(row).get(j) * matrix.get(i).get(col) / matrix.get(row).get(col));
                }
            }
        }

        //Ведучий елемент
        newMatrix.get(row).set(col, 1 / matrix.get(row).get(col));
        matrix.clear();
        matrix.addAll(newMatrix);
    }

    /**
     *Робить одну ітерацію симплекс перетворення(якщо дане рішення неоптимальне)
     * @return Булеве значення оптимальності розв'язку
     */
    @Override
    public Boolean checkOptimality() {
        int row = -1;//Ведучий рядок
        int col = -1;//Ведучий стовпець
        double minElementInCol = 1000000000;
        double minElementInRow = 0;
        //Знаходжу ведучий стовпець
        for (int j = 0; j < matrix.get(matrix.size() - 1).size() - 1; j++) {
            if (matrix.get(matrix.size() - 1).get(j) < minElementInRow) {
                minElementInRow = matrix.get(matrix.size() - 1).get(j);
                col = j;
            }
        }
        if (col == -1) return true;//Рішення оптимальне
        //Знаходжу ведучий рядок
        for (int i = 0; i < matrix.size() - 1; i++) {
            if (matrix.get(i).get(col) > 0 && matrix.get(i).get(matrix.get(i).size() - 1) / matrix.get(i).get(col) < minElementInCol) {
                minElementInCol = matrix.get(i).get(matrix.get(i).size() - 1) / matrix.get(i).get(col);
                row = i;
            }
        }

        if (row == -1) throw new IllegalArgumentException("Задача розв'язку не має");

        transformationTable(row, col);

        //Нове рішення оптимальне?
        for (int j = 0; j < matrix.get(matrix.size() - 1).size() - 1; j++) {

            if (matrix.get(matrix.size() - 1).get(j) < 0) {
               return false;
            }
        }
        return true;
    }

    /**
     * @return Матрицю розв'язку симплекс методом
     */
    @Override
    public List<List<Float>> solve() {

        Boolean permissibility = false;

        while (!permissibility) {
            permissibility = checkPermissibility();
        }


        Boolean optimality = false;
        while (!optimality) {
            optimality = checkOptimality();
        }

        return matrix;
    }

}