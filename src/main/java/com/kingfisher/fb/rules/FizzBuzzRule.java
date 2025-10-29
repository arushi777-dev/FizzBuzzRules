package com.kingfisher.fb.rules;

public class FizzBuzzRule implements Rule {

    private static final String FIZZBUZZ = "fizzbuzz";

    @Override
    public String apply(int number) {
        return FIZZBUZZ;
    }

    @Override
    public boolean matches(int number) {
        return number % 15 == 0;
    }
}
