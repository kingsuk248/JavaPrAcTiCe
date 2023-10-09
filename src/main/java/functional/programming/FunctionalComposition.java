package functional.programming;

import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalComposition {
    public static void main(String[] args) {
        FunctionalComposition funcComp = new FunctionalComposition();
        funcComp.testPredicateComposition();
        funcComp.testFunctionComposition();
    }

    public void testPredicateComposition() {
        Predicate<String> startsWithA = (String s) -> s.startsWith("A");
        Predicate<String> endsWithZ = (String s) -> s.endsWith("Z");

        Predicate<String> startsAndEnds = (String s) ->
                startsWithA.test(s) && endsWithZ.test(s);
        boolean flag = startsAndEnds.test("A letter to Z");
        System.out.println(flag);

        /*
         * Test 'Predicate' 'and' method.
         */
        Predicate<Integer> greaterThan = (Integer i) -> i > -1;
        Predicate<Integer> lesserThan = (Integer i) -> i < 1;
        Predicate<Integer> composed = greaterThan.and(lesserThan);
        boolean test1 = composed.test(0);
        boolean test2 = composed.test(2);
        System.out.println("Is zero ?: " + test1);
        System.out.println("Is zero ?: " + test2);

        /*
         * Test 'Predicate' 'or' method.
         */
        Predicate<Character> lowercase = (Character c) -> c >= 'a' && c <= 'z';
        Predicate<Character> uppercase = (Character c) -> c >= 'A' && c <= 'Z';
        Predicate<Character> composed1 = lowercase.or(uppercase);
        boolean test3 = composed1.test('G');
        boolean test4 = composed1.test('#');
        System.out.println("Is alphabet ?: " + test3);
        System.out.println("Is alphabet ?: " + test4);
    }

    public void testFunctionComposition() {
        /*
         * Test 'Function' 'compose' method.
         */
        Function<Integer, Integer> addNum = (Integer i) -> i + 10;
        Function<Integer, Integer> multiplyNum = (Integer i) -> i * 1000;
        Function<Integer, Integer> addAndMultiply = multiplyNum.compose(addNum);
        System.out.println("Add and Multiply: " + addAndMultiply.apply(2525));

        /*
         * Test 'Function' 'andThen' method.
         */
        Function<Integer, Integer> substractNum = (Integer i) -> i - 10;
        Function<Integer, Double> divideNum = (Integer i) -> i / 1000.0;
        Function<Integer, Double> substractAndDivide = substractNum.andThen(divideNum);
        System.out.println("Subtract and Divide: " + substractAndDivide.apply(121210));
    }
}
