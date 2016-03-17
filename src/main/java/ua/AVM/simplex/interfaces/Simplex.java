package ua.AVM.simplex.interfaces;

import java.util.List;

public interface Simplex {

    List<List<Float>> createSimplexTable(int numVar, int numRestriction);//TODO Визначити список параметрів(як считувати з front-end)
    /*List<List<Float>> createSimplexTable(List<List<Float>> A, List<Float> B, List<Float> C,
                                         String optCriterion, List<String> inequalityTypes,
                                         int numVar, int numRestriction);*/

    Boolean checkPermissibility();

    Boolean checkOptimality();

    List<List<Float>> solve();
}
