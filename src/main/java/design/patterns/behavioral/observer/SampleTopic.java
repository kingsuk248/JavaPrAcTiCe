package design.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class SampleTopic implements Subject {

    private final List<Observer> observers;
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object();

    public SampleTopic() {
        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        if (observer == null) {
            throw new NullPointerException("Null observer");
        }
        synchronized (MUTEX) {
            if (!observers.contains(observer)) {
                this.observers.add(observer);
            }
        }
    }

    @Override
    public void unregister(Observer observer) {
        synchronized (MUTEX) {
            this.observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersLocal = null;
        //synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (MUTEX) {
            if (!changed)
                return;
            observersLocal = new ArrayList<>(this.observers);
            this.changed=false;
        }
        for (Observer obj : observersLocal) {
            obj.update();
        }
    }

    @Override
    public Object getUpdate(Observer observer) {
        return this.message;
    }

    public void postMessage(String message) {
        this.message = message;
        this.changed = true;
        notifyObservers();
    }
}
