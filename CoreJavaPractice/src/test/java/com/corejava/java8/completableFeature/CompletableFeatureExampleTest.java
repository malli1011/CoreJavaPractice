package com.corejava.java8.completableFeature;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompletableFeatureExampleTest {

    @Test
    void simpleExampleTest() throws Exception {
        CompletableFeatureExample.simpleExample();
    }

    @Test
    void simpleExampleWithExecutorTest() throws Exception {
        CompletableFeatureExample.simpleExampleWithExecutor();
    }

    @Test
    void handleExceptionInCompletableFeatureTest() throws Exception {
        CompletableFeatureExample.handleExceptionInCompletableFeature();
    }

    @Test
    void completableFeatureWithTimeoutTest() {
        CompletableFeatureExample.completableFeatureWithTimeout();
    }
}