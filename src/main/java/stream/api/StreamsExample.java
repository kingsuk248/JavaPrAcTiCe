package stream.api;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {
    public static void main(String[] args) {
        StreamsExample se = new StreamsExample();
        se.testStreamsExampleSet1();
        se.testStreamsExampleSet2();
    }

    private void testStreamsExampleSet1() {
        List<String> numbers = new ArrayList<>();
        numbers.add("one");
        numbers.add("two");
        numbers.add("three");

        List<String> uppercases = numbers.stream()
                .map((String value) -> value.toUpperCase()) // map is a non-terminal function
                        .collect(Collectors.toList()); // collect is a terminal function
        System.out.println("Num of elements: " + uppercases);

        List<Integer> naturalNumbers = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            naturalNumbers.add(i);
        }

        /*
         * Chaining multiple non-terminal operations and finally one terminal operation
         */
        List<Integer> evenNumbers = naturalNumbers.stream()
                .map((Integer i) -> i + 1)
                .map((Integer i) -> i * i)
                .filter((Integer i) -> i % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers);

        /*
         * Example of 'flatMap' non-terminal operation on streams
         */
        List<String> books = new ArrayList<>();
        books.add("Rain in the mountains");
        books.add("Gulliver's travels");
        books.add("The Time Machine");
        books.add("The mountains between us");
        books.add("The Time Keeper");

        List<String> wordList = books.stream()
                .flatMap((String str) -> {
                    String[] words = str.split(" ");
                    return Arrays.asList(words).stream();
                })
                .collect(Collectors.toList());

        System.out.println(wordList);

        /*
         * Example of 'distinct' non-terminal operation on streams
         */
        List<String> distinctWordsList = books.stream()
                .flatMap((str) -> {
                    String[] words = str.split(" ");
                    return Arrays.stream(words);
                })
                .map((str) -> str.toLowerCase())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctWordsList);

        /*
         * Example of 'limit' non-terminal operation on streams
         */
        naturalNumbers.stream()
                .limit(5)
                .forEach(System.out::println);

        /*
         * Example of 'peek' non-terminal operation on streams
         */
        Stream<String> peekedValue = books.stream()
                .peek((value) -> System.out.println(value));
        List<String> peekedOutput = peekedValue.collect(Collectors.toList());
        System.out.println(peekedOutput);
    }

    private void testStreamsExampleSet2() {
        /*
         * Example of 'anyMatch' terminal operation on streams
         */
        List<Integer> naturalNumbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            naturalNumbers.add(i);
        }
        boolean isPrimeFound = naturalNumbers.stream()
                .anyMatch((Integer i) -> isPrime(i));
        System.out.println(isPrimeFound);

        /*
         * Example of 'allMatch' terminal operation on streams
         */
        List<Integer> someNumbers = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            someNumbers.add((int)(Math.random() * 10));
        }
        boolean isAllPve = someNumbers.stream()
                .allMatch((Integer i) -> i > 5);
        System.out.println(isAllPve);

        /*
         * Example of 'noneMatch' terminal operation on streams
         */
        boolean isGreaterThan10 = someNumbers.stream()
                .noneMatch((Integer i) -> i > 10);
        System.out.println(isGreaterThan10);

        /*
         * Example of 'findAny' terminal operation on streams
         */
        String[] numInWords = {"one", "two", "three", "four", "five"};
        Optional<String> anyString = Arrays.stream(numInWords)
                .findAny();
        System.out.println(anyString.get());

        /*
         * Example of 'findFirst' terminal operation on streams
         */
        Optional<String> firstString = Arrays.stream(numInWords)
                .findFirst();
        System.out.println(firstString.get());

        /*
         * Example of 'min' and 'max' terminal operation on streams
         */
        Optional<String> minString = Arrays.stream(numInWords)
                .min((String str1, String str2) -> str1.compareTo(str2));

        Optional<String> maxString = Arrays.stream(numInWords)
                .max((String str1, String str2) -> str1.compareTo(str2));

        System.out.println(minString.get());
        System.out.println(maxString.get());

        /*
         * Example of 'reduce' terminal operation on streams
         */
        Optional<String> concatValues = Arrays.stream(numInWords)
                .reduce((String val1, String val2) -> val1 + " " + val2);
        System.out.println(concatValues.get());


        /*
         * Example of 'Stream.concat' terminal operation on streams
         */
        String[] moreNumInWords = {"six", "seven", "eight"};
        Stream<String> stream1 = Arrays.stream(numInWords).map(String::toUpperCase);
        Stream<String> stream2 = Arrays.stream(moreNumInWords).map(String::toUpperCase);
        List<String> allNums = Stream.concat(stream1, stream2).collect(Collectors.toList());
        System.out.println(allNums);

        /*
         * Example of 'Stream.of' terminal operation on streams
         */
        Stream<Double> doubles = Stream.of(1.0, 2.0, 2.1, 1.2);
        Optional<Double> sum = doubles.reduce(Double::sum);
        System.out.println(sum.get());
    }

    private boolean isPrime(Integer value) {
        double sqrt = Math.ceil(Math.sqrt(value));
        for (int i = 2; i <= sqrt; i++) {
            if (value % i == 0) {
                return false;
            }
        }

        return value > 1;
    }


}
