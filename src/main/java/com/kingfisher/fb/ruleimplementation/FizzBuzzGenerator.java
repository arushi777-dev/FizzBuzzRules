package com.kingfisher.fb.ruleimplementation;

import com.kingfisher.fb.exceptionhandler.InvalidRangeException;
import com.kingfisher.fb.rules.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * FizzBuzzGenerator provides a solution to the FizzBuzz problem
 * A range of numbers are iterated upon and
 * Generates 'fizz' for multiples of 3
 * Generates 'buzz' for multiples of 5
 * Generates 'fizzbuzz' for multiples of 15
 * Returns the number itself for other cases
 * Generates 'lucky' if the number contains a three overriding other rules
 */
public class FizzBuzzGenerator {

   private final List<Rule> rules;

   public FizzBuzzGenerator() {
       this.rules = Arrays.asList(
               new FizzBuzzRule(),
               new FizzRule(),
               new BuzzRule()
       );
   }

   public String generateFizzBuzzValues(int initialRange, int endRange) {
       if (initialRange <= 0 || endRange <= 0 || initialRange > endRange)
           throw new InvalidRangeException("Initial and end range numbers must be positive and initial range must be less than or equal to end range");

       return IntStream.rangeClosed(initialRange, endRange)
               .mapToObj(this::applyRules)
               .collect(Collectors.joining(" "));
   }

    /**
     * Method to apply rules for fizzbuzz solution
     * @param number
     * @return text representing the rules or the number itself
     */
   private String applyRules(int number) {
       // Lucky rule for presence of three in a number gets precedence over other rules
       if (new LuckyRule().matches(number)) {
           return new LuckyRule().apply(number);
       }

       for (Rule rule : rules) {
           if (rule.matches(number)) {
               return rule.apply(number);
           }
       }
       return String.valueOf(number);
   }
}