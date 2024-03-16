package dev.cisnux.virtualthread;

public class Test {
    private final String test;
    private int otherTest;


    public Test(String test) {
        this.test = test;
    }

    public Test(int otherTest) {
        this("");
        this.otherTest = otherTest;
    }
}
