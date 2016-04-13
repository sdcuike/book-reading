package com.doctor.java7;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

/**
 * @author sdcuike
 *
 *         Create At 2016年4月13日 下午5:55:17
 */
public class WatchEventExample {

    /**
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        String path = WatchEventExample.class.getClassLoader().getResource("").getFile();
        System.out.println(path);
        Path path2 = Paths.get(path);
        WatchKey watchKey = path2.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
        System.out.println("watch path:" + path);

        while (true) {
            try {
                WatchKey key = watchService.take();
                if (key == null) {
                    continue;
                }

                List<WatchEvent<?>> pollEvents = key.pollEvents();
                for (WatchEvent<?> watchEvent : pollEvents) {

                    System.out.println(watchEvent.kind().toString());
                    WatchEvent<Path> e = (WatchEvent<Path>) watchEvent;
                    Path p = e.context();
                    if (watchEvent.kind() == StandardWatchEventKinds.OVERFLOW) {

                        System.out.println("lost :" + p);
                        continue;
                    }
                    Path child = path2.resolve(p);
                    System.out.println(child);
                }
                if (!key.reset()) {
                    System.out.println("key reset");
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }

}
