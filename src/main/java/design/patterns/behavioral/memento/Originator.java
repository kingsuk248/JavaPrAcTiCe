package design.patterns.behavioral.memento;

public class Originator {
    private String state;

    public void set(String state) {
        this.state = state;
        System.out.println("Originator: Setting state to " + state);
    }

    Memento saveToMemento() {
        System.out.println("Originator: Saving to Memento.");
        return new Memento(this.state);
    }

    void restoreFromMemento(Memento memento) {
        this.state = memento.getSavedState();
        System.out.println("Originator: State after restoring from Memento: " + state);
    }

    static class Memento {
        private final String state;

        Memento(String state) {
            this.state = state;
        }

        private String getSavedState() {
            return this.state;
        }
    }
}
