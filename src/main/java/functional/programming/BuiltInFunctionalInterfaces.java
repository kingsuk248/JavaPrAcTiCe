package functional.programming;

import java.util.function.UnaryOperator;

public interface BuiltInFunctionalInterfaces {
    public interface Function<T, R> {
        public R apply(T parameter);
    }

    public interface Predicate<T> {
        public boolean test(T t);
    }

    // TODO: UnaryOperator, BinaryOperator, Supplier, Consumer
}
