package lesson3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class MemoryMappedTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		final File	f = new File("c:/users/student/test.jar");
		try(final RandomAccessFile	raf = new RandomAccessFile(f, "rw");
			final FileChannel	fc = raf.getChannel()) {
			final MappedByteBuffer mm = fc.map(MapMode.READ_WRITE, 0, f.length());
			
			
		}
	}

}
