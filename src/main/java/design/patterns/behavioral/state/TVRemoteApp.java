package design.patterns.behavioral.state;

public class TVRemoteApp {
    public static void main(String[] args) {
        TVContext context = new TVContext();
        State start = new TVStartState();
        State stop = new TVStopState();

        context.setState(start);
        context.doAction();

        context.setState(stop);
        context.doAction();
    }
}
