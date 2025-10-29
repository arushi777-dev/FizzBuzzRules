package com.kingfisher.fb;

import com.kingfisher.fb.exceptionhandler.InvalidRangeException;
import com.kingfisher.fb.ruleimplementation.FizzBuzzGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class FizzBuzzGeneratorTest {

    private FizzBuzzGenerator fizzBuzzGenerator;

    @Before
    public void setup() {
        fizzBuzzGenerator = new FizzBuzzGenerator();
    }

    @Test
    public void testDefaultFizzBuzzRule() {
        String expected = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz";
        assertEquals(expected, fizzBuzzGenerator.generateFizzBuzzValues(1,20));
    }

    @Test
    public void testForFizzRuleForSingleNumber() {
        assertEquals("lucky", fizzBuzzGenerator.generateFizzBuzzValues(3,3));
    }

    @Test
    public void testForBuzzRuleForSingleNumber() {
        assertEquals("buzz", fizzBuzzGenerator.generateFizzBuzzValues(5,5));
    }

    @Test
    public void testForFizzBuzzRuleForSingleNumber() {
        assertEquals("fizzbuzz", fizzBuzzGenerator.generateFizzBuzzValues(15,15));
    }

    @Test
    public void testForInvalidRangeInitialRangeGreaterThanEndRange() {
        assertThrows(InvalidRangeException.class, () -> fizzBuzzGenerator.generateFizzBuzzValues(10, 5));
    }

    @Test
    public void testInvalidNegativeInitialRange() {
        assertThrows(InvalidRangeException.class, () -> fizzBuzzGenerator.generateFizzBuzzValues(-1, 15));
    }

    @Test
    public void testInvalidZeroEndRange() {
        assertThrows(InvalidRangeException.class, () -> fizzBuzzGenerator.generateFizzBuzzValues(1, 0));
    }

    @Test
    public void testFizzBuzzRuleForPresenceOfThreeInANumber() {
        String expected = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz";
        assertEquals(expected, fizzBuzzGenerator.generateFizzBuzzValues(1,20));
    }

    @Test
    public void testForLuckyRuleForSingleNumber() {
        assertEquals("lucky", fizzBuzzGenerator.generateFizzBuzzValues(13,13));
    }
}
