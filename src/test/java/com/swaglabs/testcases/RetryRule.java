package com.swaglabs.testcases;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RetryRule implements TestRule {
    private int maxRetries;

    public RetryRule(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return statement(base, description);
    }

    private Statement statement(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Throwable caughtThrowable = null;

                // implement retry logic here
                for (int i = 0; i < maxRetries; i++) {
                    try {
                        base.evaluate();
                        return; // test passed, no need to retry
                    } catch (Throwable t) {
                        caughtThrowable = t;
                        System.err.println(description.getDisplayName() + ": run " + (i + 1) + " failed");
                    }
                }
                System.err.println(description.getDisplayName() + ": giving up after " + maxRetries + " failures");
                throw caughtThrowable;
            }
        };
    }

}
