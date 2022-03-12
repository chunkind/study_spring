package step8;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter implements Outputter{
	private String filePath;
	
	public FileOutputter() {
		System.out.println("call FileOutputter..");
	}
	
	public void setFilePath(String filePath) {
		System.out.println("call setFilePath..");
		this.filePath = filePath;
	}
	
	@Override
	public void output(String message) throws IOException {
		System.out.println("call output..");
		FileWriter fw = new FileWriter(filePath);
		fw.write(message);
		fw.close();
	}
}