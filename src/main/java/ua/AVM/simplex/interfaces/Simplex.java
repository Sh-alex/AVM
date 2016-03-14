package ua.AVM.simplex.interfaces;

import java.util.List;

public interface Simplex {

    List<List<Double>> createSimplexTable();//TODO Визначити список параметрів(як считувати з front-end)


    Boolean checkPermissibility(List<List<Double>> matrix);

    Boolean checkOptimality(List<List<Double>> matrix);

    List<List<Double>> getResult(List<List<Double>> matrix);
}
