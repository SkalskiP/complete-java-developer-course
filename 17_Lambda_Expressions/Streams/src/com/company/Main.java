/*
 *  ==========================================================
 *  Author 	      :      AFGHAN (Piotr Skalski)
 *  Website       :      https://github.com/SkalskiP
 *  Date          :      24.02.18 12:53
 *  Project       :      Streams
 *  ==========================================================
 */

package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71");

        List<String> gNumbers = new ArrayList<>();

        // -----------------------------------------------------------------------
        // Code using several lambdas
        // -----------------------------------------------------------------------

//        someBingoNumbers.forEach(number -> {
//            if(number.toUpperCase().startsWith("G")) {
//                gNumbers.add(number);
//            }
//        });
//
//        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
//        gNumbers.forEach(s -> System.out.println(s));

        // -----------------------------------------------------------------------
        // Code using several stream
        // -----------------------------------------------------------------------

        // When a chain is evaluated, a stream pipeline is created.
        // The stream pipeline consists of source, zero or momre intermediate operations, and a terminal operation.
        // In our example, we used a collection as the source, but we could also be an array or an I/O channel, and we can build streams from scratch.

        // The items in the source enter the pipeline, and the chain result emerges at the other end of the pipe.
        // As we've seen, elements may be removed from the stream as a result of an operation,
        // so the set of elements that  comes out at the other end of the pipe doesn't have to match the number that entered the pipe.

        // We noticed that when we weren't using streams, our "g64" number was printed with a lower-cased 'g'.
        // But when we used streams, it was printed with an upper-cased 'G'.
        // In the non-stream case, we didn't use the result of the toUpperCase() call.
        // When an item passed test, we assigned the original string with the lower-cased 'g' to new list.

        // In the stream case, the map() method maps each source string to the Function result,
        // therefore the upper-cased string is added to resulting stream and passed to the next step in the chain.
        // That's why the non-stream case prints a lower-cased 'g', and the stream case prints an upper-cased 'G'.

        someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        // -----------------------------------------------------------------------
        // Creating stream from scratch
        // -----------------------------------------------------------------------

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
        System.out.println("-----------------------------");
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count());

        // -----------------------------------------------------------------------
        // Flatmap & Lambda Best Practices
        // -----------------------------------------------------------------------

        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Deer", 25);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        System.out.println("--------------------------------");

//        List<String> sortedGNumbers = someBingoNumbers
//                .stream()
//                .map(String::toUpperCase)
//                .filter(s -> s.startsWith("G"))
//                .sorted()
//                .collect(Collectors.toList());

        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        // 1. argument is supplier which will construct a new array list
        // 2. argument is accumulator is the array list add method for single item into the list
        // 3. argument is combiner is the array list add method for single item into result

        for(String s : sortedGNumbers) {
            System.out.println(s);
        }

        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

        Stream.of("ABC", "AC", "BAA", "CCCC", "XY","ST")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                })

        .count();
    }
}
