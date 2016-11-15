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
		// 是目录，同时需要遍历子目录
		if (f.isDirectory() && isdepth == true) {
			File[] t = f.listFiles();
			for (int i = 0; i < t.length; i++) {
				listFile(t[i], suffix, isdepth,fileList);
			}
		} else {
			String filePath = f.getAbsolutePath();
			if (suffix != null) {
				int begIndex = filePath.lastIndexOf(".");// 最后一个.(即后缀名前面的.)的索引
				String tempsuffix = "";
				if (begIndex != -1)// 防止是文件但却没有后缀名结束的文件
				{
					tempsuffix = filePath.substring(begIndex + 1,
							filePath.length());
				}
				if (tempsuffix.equals(suffix)) {
					fileList.add(filePath);	
				}
			} else {
				// 后缀名为null则为所有文件
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