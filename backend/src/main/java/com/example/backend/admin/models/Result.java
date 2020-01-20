package com.example.backend.admin.models;

import java.util.Map;

public class Result {
    private int resultId;

    private int subjectId;

    private String subjectName;

    private int year;

    private Map<Integer, String> results;

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Map<Integer, String> getResults() {
        return results;
    }

    public void setResults(Map<Integer, String> results) {
        this.results = results;
    }
}
