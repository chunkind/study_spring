package step07;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter implements Outputter{
	private String filePath;

	// 파일로 출력하는 기능을 작성..
	@Override
	public void output(String message) throws IOException {
		FileWriter fw = new FileWriter(filePath, true);
		fw.write(message);
		fw.close();
	}

	// 이 부분이 없으면 안된다..
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}