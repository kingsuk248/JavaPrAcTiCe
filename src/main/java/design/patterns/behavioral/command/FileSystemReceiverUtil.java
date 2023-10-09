package design.patterns.behavioral.command;

public class FileSystemReceiverUtil {
    public static FileSystemReceiver getUnderlyingFileSystem() {
        String os = System.getProperty("os.name");
        System.out.println("OS: " + os);
        if (os.contains("Windows")) {
            return new WindowsFileSystemReceiver();
        } else {
            return new UnixFileSystemReceiver();
        }
    }
}
