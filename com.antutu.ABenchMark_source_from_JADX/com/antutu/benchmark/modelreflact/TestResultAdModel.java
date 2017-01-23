package com.antutu.benchmark.modelreflact;

public class TestResultAdModel {
    private TestResultAdData data;
    private String type;

    public TestResultAdData getData() {
        return this.data;
    }

    public String getType() {
        return this.type;
    }

    public void setData(TestResultAdData testResultAdData) {
        this.data = testResultAdData;
    }

    public void setType(String str) {
        this.type = str;
    }
}
