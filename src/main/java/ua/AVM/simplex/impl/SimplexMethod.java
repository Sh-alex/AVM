package ua.AVM.simplex.impl;

import ua.AVM.simplex.interfaces.Simplex;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SimplexMethod implements Simplex {

    private List<String> basicVariables;
    private List<String> notBasicVariables;
    private Set<String> setVariables;

    /**
     * Початкова симплекс таблиця, де останній рядок - цільова функція,
     *               а останній стовпець - вільні члени
     */
    private List<List<Double>> matrix;


    @Override
    public List<List<Double>> createSimplexTable() {
        matrix = new ArrayList<>();
        return null;
    }
    /**
     *Робить одну ітерацію симплекс перетворення(якщо дане рішення недопустиме)
     * @param matrix Початкова симплекс таблиця, де останній рядок - цільова функція,
     *               а останній стовпець - вільні члени
     * @return Булеве значення допустимості розв'язку
     */
    @Override
    public Boolean checkPermissibility(List<List<Double>> matrix) {

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
        /*if(col == -1) {
            throw new IllegalArgumentException();
        }*/

        //Перераховую таблицю (row і col - індекси ведучого елемента)
        transformationTable(row, col, matrix);

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
     * @param matrix Початкова симплекс таблиця, де останній рядок - цільова функція,
     *               а останній стовпець - вільні члени
     */
    private void transformationTable(int row, int col, List<List<Double>> matrix) {
        List<List<Double>> newMatrix = new ArrayList<>();
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
     * @param matrix Початкова симплекс таблиця, де останній рядок - цільова функція,
     *               а останній стовпець - вільні члени
     * @return Булеве значення оптимальності розв'язку
     */
    @Override
    public Boolean checkOptimality(List<List<Double>> matrix) {
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

        transformationTable(row, col, matrix);

        //Нове рішення оптимальне?
        for (int j = 0; j < matrix.get(matrix.size() - 1).size() - 1; j++) {

            if (matrix.get(matrix.size() - 1).get(j) < 0) {
               return false;
            }
        }
        return true;
    }

    /**
     * @param matrix Початкова симплекс таблиця, де останній рядок - цільова функція,
     *               а останній стовпець - вільні члени
     * @return Матрицю розв'язку симплекс методом
     */
    @Override
    public List<List<Double>> getResult(List<List<Double>> matrix) {

        Boolean permissibility = false;

        while (!permissibility) {
            permissibility = checkPermissibility(matrix);
        }


        Boolean optimality = false;
        while (!optimality) {
            optimality =checkOptimality(matrix);
        }

        return matrix;
    }

}