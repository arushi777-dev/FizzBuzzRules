package com.kingfisher.fb.rules;

public class FizzRule implements Rule {

    private static final String FIZZ = "fizz";

    @Override
    public String apply(int number) {
        return FIZZ;
    }

    @Override
    public boolean matches(int number) {
        return number % 3 == 0;
    }
}
