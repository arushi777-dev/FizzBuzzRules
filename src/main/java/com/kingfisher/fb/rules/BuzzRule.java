package com.kingfisher.fb.rules;

public class BuzzRule implements Rule {

    private static final String BUZZ = "buzz";

    @Override
    public String apply(int number) {
        return BUZZ;
    }

    @Override
    public boolean matches(int number) {
        return number % 5 == 0;
    }
}
