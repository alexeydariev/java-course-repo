package student.examples.auto;

import student.examples.watcher.DirectoryWatcher;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AutoTestRunnerApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Path resourceDirectory = Paths.get(AutoTestRunnerApp.class.getClassLoader().getResource("").getPath());
        Path pathOf = Path.of("C:\\Users\\AlexeiD\\IdeaProjects\\tst-average\\src\\test\\resources");
        System.out.println(pathOf);
        DirectoryWatcher directoryWatcher = new DirectoryWatcher(pathOf);
    }
}
