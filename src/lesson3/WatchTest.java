package lesson3;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WatchTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		final WatchService ws = FileSystems.getDefault().newWatchService();
	
		final File	f = new File("c:/users/student");
		final Path	p = f.toPath();
		
		p.register(ws, StandardWatchEventKinds.ENTRY_CREATE
					, StandardWatchEventKinds.ENTRY_MODIFY
					, StandardWatchEventKinds.ENTRY_DELETE);
		System.err.println("Start");
		for(;;) {
			final WatchKey	key = ws.take();
			
			for (WatchEvent<?> event : key.pollEvents()) {
				System.err.println("Event: "+event.kind());
				System.err.println("File: "+event.context());
			}
			key.reset();
		}
	}

}
