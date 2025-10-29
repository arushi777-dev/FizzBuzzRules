package com.kingfisher.fb.rules;

import com.kingfisher.fb.exceptionhandler.InvalidRangeException;

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
 */
public class FizzBuzzGenerator {

   private final List<Rule> rules;

   public FizzBuzzGenerator(List<Rule> rules) {
       this.rules = rules;
   }

   public String generateFizzBuzzValues(int initialRange, int endRange) {
       if (initialRange <= 0 || endRange <= 0 || initialRange > endRange)
           throw new InvalidRangeException("Initial and end range numbers must be positive and initial range must be less than or equal to end range");

       return IntStream.rangeClosed(initialRange, endRange)
               .mapToObj(this::applyRules)
               .collect(Collectors.joining(" "));
   }

   private String applyRules(int number) {
       for (Rule rule : rules) {
           if (rule.matches(number)) {
               return rule.apply(number);
           }
       }
       return String.valueOf(number);
   }

   public static FizzBuzzGenerator createDefaultRules() {
       return new FizzBuzzGenerator(Arrays.asList(
               new FizzBuzzRule(),
               new FizzRule(),
               new BuzzRule()
       ));
   }
}