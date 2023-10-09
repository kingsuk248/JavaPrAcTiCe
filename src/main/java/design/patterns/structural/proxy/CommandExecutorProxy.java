package design.patterns.structural.proxy;

public class CommandExecutorProxy implements CommandExecutor {
    private boolean isAdmin;
    private final CommandExecutor commandExecutor;

    public CommandExecutorProxy(String user) {
        if (user.equals("root")) {
            isAdmin = true;
        }
        commandExecutor = new CommandExecutorImpl();
    }

    @Override
    public void runCommand(String cmd) throws Exception {
        if (isAdmin) {
            commandExecutor.runCommand(cmd);
        } else {
            if (cmd.trim().startsWith("del")) {
                throw new Exception("you need to be root to 'rm'");
            } else {
                commandExecutor.runCommand(cmd);
            }
        }

    }
}
