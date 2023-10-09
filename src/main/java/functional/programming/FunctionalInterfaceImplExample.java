package functional.programming;

import java.math.BigDecimal;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfaceImplExample implements
        BuiltInFunctionalInterfaces.Function<Long, Long>,
        BuiltInFunctionalInterfaces.Predicate<String> {

    public Long apply(Long parameter) {
        return parameter + Integer.MAX_VALUE;
    }

    public boolean test(String value) {
        return value != null;
    }

    public static void main(String[] args) {
        FunctionalInterfaceImplExample impl = new FunctionalInterfaceImplExample();

        /*
         * Test 'Function' interface 'apply' method.
         */
        // Method 1: Using implementation class
        long output = impl.apply(10L);
        System.out.println(output);

        // Method 2: Using lambda expression
        BuiltInFunctionalInterfaces.Function<Long, Long> function =
                (Long param) -> param + Integer.MIN_VALUE;
        long output2 = function.apply(100L);
        System.out.println(output2);

        /*
         * Test 'Predicate' interface 'test' method.
         */
        // Method 1: Using implementation class
        boolean flag = impl.test("some value");
        System.out.println(flag);

        // Method 2: Using lambda expression
        BuiltInFunctionalInterfaces.Predicate<String> predicate =
                (String value) -> (value.length() > 20);
        boolean flag2 = predicate.test("small string");
        System.out.println(flag2);

        /*
         * Test 'UnaryOperator' interface 'test' method.
         */
        // Method 1: Using lambda expression
        UnaryOperator<String> unaryOperator = (String s) -> s + s;
        String appendedVal = unaryOperator.apply("appendme");
        System.out.println(appendedVal);

        /*
         * Test 'BinaryOperator' interface 'test' method.
         */
        // Method 1: Using lambda expression
        BinaryOperator<BigDecimal> binaryOperator = (BigDecimal bd1, BigDecimal bd2)
                -> new BigDecimal(bd1.longValueExact() + bd2.longValueExact());
        BigDecimal megaValue = binaryOperator.apply(new BigDecimal(Integer.MAX_VALUE),
                new BigDecimal(Integer.MAX_VALUE));
        System.out.println(megaValue.longValue());

        /*
         * Test 'Supplier' interface 'get' method.
         */
        // Method 1: Using lambda expression
        Supplier<Double> supplier = () -> Math.random() * 1000.0;
        Double suppliedVal = supplier.get();
        System.out.println(suppliedVal);

        /*
         * Test 'Consumer' interface 'accept' method.
         */
        // Method 1: Using lambda expression
        Consumer<Float> consumer = (Float f) -> System.out.println(f);
        consumer.accept(1123f);
    }

}
