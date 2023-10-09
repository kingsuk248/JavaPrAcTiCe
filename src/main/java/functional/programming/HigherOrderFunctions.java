package functional.programming;

public class HigherOrderFunctions {

    /**
     * A HigherOrderFunction
     * 1. Takes one or more functions as parameters
     * 2. Returns another function as result
     */
    public <T> IFactory<T> createFactory(IProducer<T> producer, IConfigurator<T> configurator) {
        return () -> {
            T instance = producer.produce();
            configurator.configure(instance);
            return instance;
        };
    }

    public interface IFactory<T> {
        T create();
    }

    public interface IProducer<T> {
        T produce();
    }

    public interface IConfigurator<T> {
        T configure(T t);
    }
}
