package student.examples.watcher;

import java.io.IOException;
import java.nio.file.*;

public class DirectoryWatcher {
    private Path directory;
    private WatchService watchService;

    public DirectoryWatcher(Path directory) throws IOException, InterruptedException {
        this.directory = directory;
        watchService = FileSystems.getDefault().newWatchService();
        Path directoryPath = Paths.get(directory.toUri());
        directoryPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY);

        System.out.println("Watching for changes...");
        while (true) {
            WatchKey key = watchService.take();
            for (WatchEvent<?> event: key.pollEvents()){
                if (event.kind().equals(StandardWatchEventKinds.ENTRY_CREATE) || event.kind().equals(StandardWatchEventKinds.ENTRY_MODIFY)) {
                    ProcessBuilder processBuilder = new ProcessBuilder("mvn.cmd", "test");
                    processBuilder.redirectErrorStream(true);
                    processBuilder.inheritIO();
                    System.out.println("starting tst w maven");
                    Process process = processBuilder.start();
                    int exitCode = process.waitFor();
                    System.out.println("Process finished with exit code: " + exitCode);
                }
            }
            key.reset();
        }
    }
}
