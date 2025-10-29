package com.kingfisher.fb;

import com.kingfisher.fb.exceptionhandler.InvalidRangeException;
import com.kingfisher.fb.rules.FizzBuzzGenerator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class FizzBuzzGeneratorTest {

    @Test
    public void testDefaultFizzBuzzRule() {
        FizzBuzzGenerator fizzBuzzGenerator = FizzBuzzGenerator.createDefaultRules();
        String expected = "1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz";
        assertEquals(expected, fizzBuzzGenerator.generateFizzBuzzValues(1,20));
    }

    @Test
    public void testForFizzRuleForSingleNumber() {
        FizzBuzzGenerator fizzBuzzGenerator = FizzBuzzGenerator.createDefaultRules();
        assertEquals("fizz", fizzBuzzGenerator.generateFizzBuzzValues(3,3));
    }

    @Test
    public void testForBuzzRuleForSingleNumber() {
        FizzBuzzGenerator fizzBuzzGenerator = FizzBuzzGenerator.createDefaultRules();
        assertEquals("buzz", fizzBuzzGenerator.generateFizzBuzzValues(5,5));
    }

    @Test
    public void testForFizzBuzzRuleForSingleNumber() {
        FizzBuzzGenerator fizzBuzzGenerator = FizzBuzzGenerator.createDefaultRules();
        assertEquals("fizzbuzz", fizzBuzzGenerator.generateFizzBuzzValues(15,15));
    }

    @Test
    public void testForInvalidRangeInitialRangeGreaterThanEndRange() {
        FizzBuzzGenerator fizzBuzzGenerator = FizzBuzzGenerator.createDefaultRules();
        assertThrows(InvalidRangeException.class, () -> fizzBuzzGenerator.generateFizzBuzzValues(10, 5));
    }

    @Test
    public void testInvalidNegativeInitialRange() {
        FizzBuzzGenerator fizzBuzzGenerator = FizzBuzzGenerator.createDefaultRules();
        assertThrows(InvalidRangeException.class, () -> fizzBuzzGenerator.generateFizzBuzzValues(-1, 15));
    }

    @Test
    public void testInvalidZeroEndRange() {
        FizzBuzzGenerator fizzBuzzGenerator = FizzBuzzGenerator.createDefaultRules();
        assertThrows(InvalidRangeException.class, () -> fizzBuzzGenerator.generateFizzBuzzValues(1, 0));
    }
}
