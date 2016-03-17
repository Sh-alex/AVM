package ua.AVM.simplex.impl;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SimplexMethodTest {
    public List<List<Float>> matrixPerm = Arrays.asList(Arrays.asList(3f,6f,-4f, 1f, 12f), Arrays.asList(-4f,13f,-10f,-5f,-6f),
            Arrays.asList(-3f,-7f,-1f,0f,-1f), Arrays.asList(2f, 5f, 3f, 8f, 0f));

    public List<List<Float>> matrixOpt = Arrays.asList(Arrays.asList(1f,-2f,1f), Arrays.asList(-2f,1f,2f),
            Arrays.asList(2f,1f,6f), Arrays.asList(-3f, -1f, 0f));

    @Test
    public void testCreateSimplexTable() throws Exception {

    }

    @Test
    public void testCheckPermissibility() throws Exception {


        SimplexMethod sm = new SimplexMethod();
        sm.createSimplexTable(2, 3);

        sm.checkPermissibility();

        assertEquals(sm.getMatrix().get(0).get(0), 4.6, 0);
    }

    @Test
    public void testCheckOptimality() throws Exception {
        SimplexMethod sm = new SimplexMethod();
        sm.createSimplexTable(2, 3);

        sm.checkOptimality();

        assertEquals(sm.getMatrix().get(3).get(2), 3, 0);

        sm.checkOptimality();

        assertEquals(sm.getMatrix().get(3).get(2), 43f/5, 0);
    }

    @Test
    public void testSolve() throws Exception {
        SimplexMethod sm = new SimplexMethod();
        sm.createSimplexTable(2, 3);

        sm.solve();

        assertEquals(sm.getMatrix().get(3).get(2), 43f/5, 0);
    }
}