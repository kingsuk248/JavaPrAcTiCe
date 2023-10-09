package design.patterns.structural.proxy;

public class ProxyPatternTest {
    public static void main(String[] args) {
        CommandExecutor commandExecutor = new CommandExecutorProxy("user");
        try {
            commandExecutor.runCommand("ls -lrt");
            commandExecutor.runCommand("rm test.txt");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
