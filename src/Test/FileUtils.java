package Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
	/**
	 * 
	 * @param dirPath
	 * @return
	 */
	public static List<String> getFileList(String dirPath ) {
		if(dirPath == null || dirPath.equals("")){
			return null;
		}
		List<String> fileList = new ArrayList<String>();
		File f = new File(dirPath);
		FileUtils.listSubFile(f, fileList);
		return fileList;
	}
	public static List<String> listSubDir(String dirPath){
		List<String> dirList = new ArrayList<String>();
		File f = new File(dirPath);
		File[] t = f.listFiles();
		for(int i = 0 ; i<t.length;i++){
			dirList.add(t[i].getAbsolutePath());
		}
		return dirList;
	}
	public static void listFile(File f, String suffix, boolean isdepth,List<String> fileList) {
		// ��Ŀ¼��ͬʱ��Ҫ������Ŀ¼
		if (f.isDirectory() && isdepth == true) {
			File[] t = f.listFiles();
			for (int i = 0; i < t.length; i++) {
				listFile(t[i], suffix, isdepth,fileList);
			}
		} else {
			String filePath = f.getAbsolutePath();
			if (suffix != null) {
				int begIndex = filePath.lastIndexOf(".");// ���һ��.(����׺��ǰ���.)������
				String tempsuffix = "";
				if (begIndex != -1)// ��ֹ���ļ���ȴû�к�׺���������ļ�
				{
					tempsuffix = filePath.substring(begIndex + 1,
							filePath.length());
				}
				if (tempsuffix.equals(suffix)) {
					fileList.add(filePath);	
				}
			} else {
				// ��׺��Ϊnull��Ϊ�����ļ�
				fileList.add(filePath);	
			}
		}
	}
	
	public static void listSubFile(File f,List<String> fileList){
		if(f.isDirectory()){
			File[] t = f.listFiles();
			for(int i = 0;i<t.length;i++){
				if(!t[i].isDirectory()){
					fileList.add(t[i].getAbsolutePath());
				}
			}
		}
	}
}