package design.patterns.structural.proxy;

import jdk.jshell.spi.ExecutionControlProvider;

public interface CommandExecutor {
    void runCommand(String cmd) throws Exception;
}
