package design.patterns.behavioral.observer;

public class ObserverPatternImpl {
    public static void main(String[] args) {
        SampleTopic topic = new SampleTopic();

        Observer observer1 = new SampleSubscriber("Subscriber 1");
        Observer observer2 = new SampleSubscriber("Subscriber 2");
        Observer observer3 = new SampleSubscriber("Subscriber 3");

        topic.register(observer1);
        topic.register(observer2);
        topic.register(observer3);

        observer1.setSubject(topic);
        observer2.setSubject(topic);
        observer3.setSubject(topic);

        observer1.update();
        observer2.update();
        observer3.update();

        topic.postMessage("New message");
    }
}
