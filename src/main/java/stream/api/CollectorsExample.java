package stream.api;

import org.assertj.core.api.Assertions;

import java.lang.instrument.UnmodifiableClassException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsExample {
    public static void main(String[] args) {
        //CollectorsExample.testCollectorsSet1();
        //CollectorsExample.testCollectorsSet2();
        CollectorsExample.testCollectorsSet3();
    }

    private static void testCollectorsSet1() {

        /*
         * Example of 'Collectors.toList' on streams
         */
        List<String> inputList = new ArrayList<>();
        inputList.add("abc");
        inputList.add("bcd");
        inputList.add("cde");
        inputList.add("def");
        List<String> outputList = inputList.stream().collect(Collectors.toList());
        System.out.println(outputList);

        List<String> unmodOutputList = inputList.stream().collect(Collectors.toUnmodifiableList());
        Assertions.assertThatThrownBy(() -> unmodOutputList.add("aaa"))
                .isInstanceOf(UnsupportedOperationException.class);

        /*
         * Example of 'Collectors.toSet' on streams
         */
        inputList.add("abc");
        inputList.add("bcd");
        Set<String> outputSet = inputList.stream().collect(Collectors.toSet());
        System.out.println(outputSet);

        Set<String> unmodOutputSet = inputList.stream().collect(Collectors.toUnmodifiableSet());
        Assertions.assertThatThrownBy(() -> unmodOutputSet.add("zzz"))
                .isInstanceOf(UnsupportedOperationException.class);

        /*
         * Example of 'Collectors.toCollection' on streams
         */
        List<String> elems = inputList.stream()
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(elems);

        /*
         * Example of 'Collectors.toMap' on streams
         */
        Map<String, Integer> elemLenMap = inputList.stream()
                .collect(Collectors.toSet())
                .stream()
                //.collect(Collectors.toMap((String s) -> s, (String s) -> s.length()));
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(elemLenMap);

        /*
         * 'Collectors.toMap' throws IllegalStateException in case of duplicate keys
         */
        Assertions.assertThatThrownBy(() -> inputList.stream()
                        .collect(Collectors.toMap(Function.identity(), String::length)))
                .isInstanceOf(IllegalStateException.class);

        /*
         * 'Collectors.toMap' handle duplicate keys with additional 'BinaryOperator' parameter
         * to 'toMap'
         */
        Map<String, Integer> elemLenWithDupsMap = inputList.stream()
                .collect(Collectors.toMap(Function.identity(), String::length, (s, t) -> s));
        System.out.println(elemLenWithDupsMap);
    }

    private static void testCollectorsSet2() {
        /*
         * Example of 'Collectors.collectingAndThen' on streams
         */
        List<String> inputList = new ArrayList<>();
        inputList.add("abc");
        inputList.add("bcd");
        inputList.add("cde");
        inputList.add("def");
        inputList.add("cde");
        inputList.add("def");

        Set<String> outputSet = inputList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toSet(), TreeSet::new));
        System.out.println(outputSet);

        /*
         * Example of 'Collectors.joining' on streams
         */
        String output = inputList.stream().collect(Collectors.joining("+", "PRE", "SUFF"));
        System.out.println(output);

        /*
         * Example of 'Collectors.summarizingInt', '.averagingDouble', '.minBy'
         */
        IntSummaryStatistics stats = inputList.stream()
                .collect(Collectors.summarizingInt(String::length));
        Double avgLen = inputList.stream()
                .collect(Collectors.averagingDouble(String::length));

        Optional<String> minElem = inputList.stream()
                .collect(Collectors.minBy(Comparator.naturalOrder()));
        System.out.println(stats);
        System.out.println(avgLen);
        System.out.println(minElem.get());
    }

    private static void testCollectorsSet3() {

        /*
         * Example of 'Collectors.groupingBy' on streams
         */
        List<String> persons = new ArrayList<>();
        persons.add("1,John,Bangalore,45");
        persons.add("2,Bob,Mumbai,32");
        persons.add("3,Ray,Bangalore,35");
        persons.add("4,Marley,Pune,29");
        persons.add("5,Janice,Bangalore,31");
        persons.add("6,Joe,Pune,41");
        Map<String, Long> cityCountMap = persons.stream()
                .map(person -> person.split(","))
                .collect(Collectors.groupingBy(str -> str[2],
                        Collectors.counting()
                ));
        System.out.println(cityCountMap);

        /*
         * Example of 'Collectors.partitioningBy' on streams
         */
        Map<Boolean, List<String>> isMetro = persons.stream()
                .collect(Collectors.partitioningBy(str -> str.split(",")[2].equals("Mumbai"),
                        Collectors.mapping(str -> str.split(",")[1], Collectors.toList())
                ));
        System.out.println(isMetro);
    }
}
