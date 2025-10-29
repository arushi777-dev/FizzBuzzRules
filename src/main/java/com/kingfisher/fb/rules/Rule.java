package com.kingfisher.fb.rules;

public interface Rule {
    String apply(int number);
    boolean matches(int number);
}
