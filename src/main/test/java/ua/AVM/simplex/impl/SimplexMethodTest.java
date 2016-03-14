package ua.AVM.simplex.impl;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SimplexMethodTest {
    public List<List<Double>> matrixPerm = Arrays.asList(Arrays.asList(3d,6d,-4d, 1d, 12d), Arrays.asList(-4d,13d,-10d,-5d,-6d),
            Arrays.asList(-3d,-7d,-1d,0d,-1d), Arrays.asList(2d, 5d, 3d, 8d, 0d));

    public List<List<Double>> matrixOpt = Arrays.asList(Arrays.asList(1d,-2d,1d), Arrays.asList(-2d,1d,2d),
            Arrays.asList(2d,1d,6d), Arrays.asList(-3d, -1d, 0d));

    @Test
    public void testCreateSimplexTable() throws Exception {

    }

    @Test
    public void testCheckPermissibility() throws Exception {

        List<List<Double>> matrix2 = new ArrayList<>();
        SimplexMethod sm = new SimplexMethod();

        for (int i = 0; i < matrixPerm.size(); i++) {
            matrix2.add(new ArrayList<>());
            for (int j = 0; j < matrixPerm.get(i).size(); j++) {
                matrix2.get(i).add(matrixPerm.get(i).get(j));
            }
        }

        sm.checkPermissibility(matrix2);

        assertEquals(matrix2.get(0).get(0), 4.6, 0);
    }

    @Test
    public void testCheckOptimality() throws Exception {
        List<List<Double>> matrix2 = new ArrayList<>();
        SimplexMethod sm = new SimplexMethod();

        for (int i = 0; i < matrixOpt.size(); i++) {
            matrix2.add(new ArrayList<>());
            for (int j = 0; j < matrixOpt.get(i).size(); j++) {
                matrix2.get(i).add(matrixOpt.get(i).get(j));
            }
        }

        sm.checkOptimality(matrix2);

        assertEquals(matrix2.get(3).get(2), 3, 0);

        sm.checkOptimality(matrix2);

        assertEquals(matrix2.get(3).get(2), 43d/5, 0);
    }

    @Test
    public void testGetResult() throws Exception {
        List<List<Double>> matrix2 = new ArrayList<>();
        SimplexMethod sm = new SimplexMethod();

        for (int i = 0; i < matrixOpt.size(); i++) {
            matrix2.add(new ArrayList<>());
            for (int j = 0; j < matrixOpt.get(i).size(); j++) {
                matrix2.get(i).add(matrixOpt.get(i).get(j));
            }
        }

        sm.getResult(matrix2);

        assertEquals(matrix2.get(3).get(2), 43d/5, 0);
    }
}