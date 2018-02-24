/*
 *  ==========================================================
 *  Author 	      :      AFGHAN (Piotr Skalski)
 *  Website       :      https://github.com/SkalskiP
 *  Date          :      24.02.18 21:58
 *  Project       :      Lambda_Challenge
 *  ==========================================================
 */

package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    // ---------------------------------------------------------
    // Challenge 1
    // ---------------------------------------------------------

    public static void main(String[] args) {
	    Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this into an array";
                String[] parts = myString.split(" ");
                for (String part: parts) {
                    System.out.println(part);
                }
            }
        };

	    Runnable runnable1 = () -> {
            String myString = "Let's split this into an array";
            String[] parts = myString.split(" ");
            for (String part: parts) {
                System.out.println(part);
            }
        };

        // ---------------------------------------------------------
        // Challenge 2
        // ---------------------------------------------------------

        Function<String, String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i = 0; i < s.length(); i++) {
                if(i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        // ---------------------------------------------------------
        // Challenge 3
        // ---------------------------------------------------------

        System.out.println(lambdaFunction.apply("1234567890"));

        // ---------------------------------------------------------
        // Challenge 5
        // ---------------------------------------------------------

        System.out.println(Main.everySecondCharacter(lambdaFunction, "1234567890"));

        // ---------------------------------------------------------
        // Challenge 6
        // ---------------------------------------------------------

//        Supplier<String> iLoveJava = () -> "I love Java!";

        Supplier<String> iLoveJava = () -> {
            return "I love Java!";
        };

        // ---------------------------------------------------------
        // Challenge 7
        // ---------------------------------------------------------

        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        // ---------------------------------------------------------
        // Challenge 10
        // ---------------------------------------------------------

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob");

        List<String> firstUpperCaseList = new ArrayList<>();
        topNames2015.forEach(name -> {
            firstUpperCaseList.add(name.substring(0, 1).toUpperCase() + name.substring(1));
        });
        firstUpperCaseList.sort(String::compareTo);
        firstUpperCaseList.forEach(System.out::println);

        // ---------------------------------------------------------
        // Challenge 11
        // ---------------------------------------------------------

        topNames2015.stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .sorted(String::compareTo)
                .forEach(System.out::println);

        // ---------------------------------------------------------
        // Challenge 12
        // ---------------------------------------------------------

        long numberOfANames =  topNames2015.stream()
                .map(s -> s.toUpperCase())
                .filter(s -> s.startsWith("A"))
                .count();
        System.out.println(numberOfANames);
    }

    // ---------------------------------------------------------
    // Challenge 4
    // ---------------------------------------------------------

    public static String everySecondCharacter(Function<String, String> func, String source) {
        return func.apply(source);
    }
}
