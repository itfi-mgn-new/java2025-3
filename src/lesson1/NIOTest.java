package lesson1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		final File		f = new File("c:/windows/explorer.exe");
		final byte[]	buffer = new byte[8192];
		int	total = 0;
		
		final ByteBuffer	bb = ByteBuffer.allocate(8192);
//		final ByteBuffer	bb = ByteBuffer.wrap(buffer);
		long	totalTime = 0;
		try(final FileInputStream	is = new FileInputStream(f);
			final FileChannel	fc = is.getChannel();) {
			
			int	len = 0;
			
			long startTime = System.currentTimeMillis();
//			while ((len = fc.read(bb)) > 0) {
			while ((len = is.read(buffer)) > 0) {
				total += len;
//				bb.clear();
				//System.currentTimeMillis();
			}
			totalTime += (System.currentTimeMillis() - startTime);
		}
		System.err.println(total+" bytes read, total time "+totalTime);
	}

}
