package com.kingfisher.fb.rules;

public class LuckyRule implements Rule {

    private static final String LUCKY = "lucky";

    @Override
    public String apply(int number) {
        return LUCKY;
    }

    @Override
    public boolean matches(int number) {
        return String.valueOf(number).contains("3");
    }
}
