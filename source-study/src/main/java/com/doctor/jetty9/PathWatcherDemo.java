package com.doctor.jetty9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.util.PathWatcher;
import org.eclipse.jetty.util.PathWatcher.PathWatchEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sdcuike
 *
 *         Create At 2016年4月14日 上午10:49:22
 * @see https://github.com/eclipse/jetty.project/blob/master/jetty-util/src/test/java/org/eclipse/jetty/util/PathWatcherDemo.java
 */
public class PathWatcherDemo {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String path = PathWatcherDemo.class.getClassLoader().getResource("").getFile();
        System.out.println(path);
        Path path2 = Paths.get(path);

        PathWatcherLister pathWatcherLister = new PathWatcherLister();
        pathWatcherLister.setConfigPath(path2);
        pathWatcherLister.start();

        TimeUnit.MINUTES.sleep(8);

    }

    // public void run(List<Path> paths) throws Exception {
    // PathWatcher watcher = new PathWatcher();
    // watcher.addListener(new PathWatcherLister());
    // watcher.setNotifyExistingOnStart(true);
    // for (Path path : paths) {
    // if (Files.isDirectory(path)) {
    // PathWatcher.Config config = new PathWatcher.Config(path);
    // config.setRecurseDepth(1);
    // watcher.watch(config);
    // } else {
    // watcher.watch(path);
    // }
    // }
    // watcher.start();
    // Thread.currentThread().join();
    // }

    public static class PathWatcherLister implements PathWatcher.Listener {
        protected Logger log = LoggerFactory.getLogger(getClass());
        private Path configPath;
        private PathWatcher pathWatcher;

        public void setConfigPath(Path configPath) {
            this.configPath = configPath;
        }

        public Path getConfigPath() {
            return configPath;
        }

        public void start() throws Exception {
            this.pathWatcher = new PathWatcher();
            this.pathWatcher.watch(configPath);
            this.pathWatcher.addListener(this);
            this.pathWatcher.setNotifyExistingOnStart(false);
            this.pathWatcher.start();
        }

        public void stop() throws Exception {
            if (this.pathWatcher != null)
                this.pathWatcher.stop();
            this.pathWatcher = null;
        }

        @Override
        public void onPathWatchEvent(PathWatchEvent event) {
            StringBuilder msg = new StringBuilder();
            msg.append("onPathWatchEvent: [");
            msg.append(event.getType());
            msg.append("] ");
            msg.append(event.getPath());
            msg.append(" (count=").append(event.getCount()).append(")");
            if (Files.isRegularFile(event.getPath())) {
                try {
                    String fsize = String.format(" (filesize=%,d)", Files.size(event.getPath()));
                    msg.append(fsize);
                } catch (IOException e) {
                    log.warn("Unable to get filesize", e);
                }
            }
            log.info("onPathWatchEvent {}", msg.toString());

        }

    }

}
