package ua.AVM.controllers;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

class DataSimplex implements Serializable {

    private static final long serialVersionUID = 4628593099340657499L;
    private List<List<Float>> a;
    private List<Float> b;
    private List<Float> c;
    private String optCriterion;
    private List<String> inequalityTypes;


    public List<List<Float>> getA() {
        return a;
    }

    public List<Float> getB() {
        return b;
    }

    public List<Float> getC() {
        return c;
    }

    public String getOptCriterion() {
        return optCriterion;
    }

    public List<String> getInequalityTypes() {
        return inequalityTypes;
    }
    @JsonProperty("A")
    public void setA(List<List<Float>> a) {
        this.a = a;
    }
    @JsonProperty("B")
    public void setB(List<Float> b) {
        this.b = b;
    }
    @JsonProperty("C")
    public void setC(List<Float> c) {
        this.c = c;
    }

    public void setOptCriterion(String optCriterion) {
        this.optCriterion = optCriterion;
    }

    public void setInequalityTypes(List<String> inequalityTypes) {
        this.inequalityTypes = inequalityTypes;
    }
}
