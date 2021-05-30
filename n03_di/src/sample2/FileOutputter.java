package sample2;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter implements Outputter{

	private String filePath;
	
	@Override
	public void output(String message) throws IOException {
		// 파일로 출력하는 기능을 작성..
		FileWriter fw = new FileWriter(filePath);
		fw.write(message);
		fw.close();
	}
	
	// 이 부분이 없으면 안된다..
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
  