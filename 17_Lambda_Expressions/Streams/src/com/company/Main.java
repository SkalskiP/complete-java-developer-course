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
    }
}
