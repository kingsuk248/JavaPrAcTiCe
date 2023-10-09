package functional.programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HigherOrderFunctionExample {
    public static void main(String[] args) {
        HigherOrderFunctionExample hofe = new HigherOrderFunctionExample();
        hofe.sortElements();
    }

    private void sortElements() {
        List<String> elements = new ArrayList<>();
        elements.add("one");
        elements.add("AbC");
        elements.add("rGb");

        /*
         * Collections.sort is a higher order function
         * as it takes a Comparator as parameter
         */
        Collections.sort(elements, (String a, String b) -> {
            return a.compareTo(b);
        });
        System.out.println(elements);


        /*
         * An alternative implementation of the collections sort
         */
        elements.sort(Comparator.naturalOrder());
        System.out.println(elements);

        Comparator<String> comparator = (String a, String b) -> {
            return a.compareTo(b);
        };

        /*
         * 'comparator.reversed' is a higher order function
         * as it returns another function as its result.
         * 'reversed' reverses the result of the first comparator implementation
         */
        Comparator<String> reversedComparator = comparator.reversed();
        Collections.sort(elements, reversedComparator);
        System.out.println(elements);
    }
}
