package lesson2;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

public class FilesTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final File	f = new File("c:/users/student/test.txt");
		final Path	p = f.toPath();
		
		System.err.println("Exists(1): "+f.exists());
		System.err.println("Exists(2): "+Files.exists(p));

		System.err.println("IsDirectory(1): "+f.isDirectory());
		System.err.println("IsDirectory(2): "+Files.isDirectory(p));
	
		System.err.println("Name(1):"+f.getName());
		System.err.println("Name(2):"+p.getName(p.getNameCount()-1));

		final File	f2 = new File("c:/users/student");
		final Path	p2 = f2.toPath();

		System.err.println("List(1):"+Arrays.toString(f2.listFiles()));

		try(DirectoryStream<Path> stream = Files.newDirectoryStream(p2)) {
			for(Path item : stream) {
				System.err.println("Item="+item);
			}
		}
	}
	
	private static void copy(final Path from, final Path to) throws IOException {
		if (Files.isDirectory(from)) {
			Files.createDirectory(to);
			try(DirectoryStream<Path> stream = Files.newDirectoryStream(to)) {
				for(Path item : stream) {
					copy(from.resolve(item.getName(item.getNameCount()-1)), 
						 to.resolve(item.getName(item.getNameCount()-1)));
				}
			}
		}
		else {
			Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
		}
	}
}
