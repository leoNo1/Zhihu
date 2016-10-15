import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileReaderWriter {
	
	public static boolean createNewFile(String filePath) {
		boolean isSuccess = true;
		// ������"\\"תΪ"/",û���򲻲����κα仯
		String filePathTurn = filePath.replaceAll("\\\\", "/");
		// �ȹ��˵��ļ���
		int index = filePathTurn.lastIndexOf("/");
		String dir = filePathTurn.substring(0, index);
		// �ٴ����ļ���
		File fileDir = new File(dir);
		isSuccess = fileDir.mkdirs();
		// �����ļ�
		File file = new File(filePathTurn);
		try {
			isSuccess = file.createNewFile();
		} catch (IOException e) {
			isSuccess = false;
			e.printStackTrace();
		}
		return isSuccess;
	}
	public static boolean writeIntoFile(String content, String filePath,
			boolean isAppend) {
		boolean isSuccess = true;
		// �ȹ��˵��ļ���
		int index = filePath.lastIndexOf("/");
		String dir = filePath.substring(0, index);
		// �������ļ���·��
		File fileDir = new File(dir);
		fileDir.mkdirs();
		// �ٴ���·���µ��ļ�
		File file = null;
		try {
			file = new File(filePath);
			file.createNewFile();
		} catch (IOException e) {
			isSuccess = false;
			e.printStackTrace();
		}
		// д���ļ�
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file, isAppend);
			fileWriter.write(content);
			fileWriter.flush();
		} catch (IOException e) {
			isSuccess = false;
			e.printStackTrace();
		} finally {
			try {
				if (fileWriter != null)
					fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return isSuccess;
	}
}
