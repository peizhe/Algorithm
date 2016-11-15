package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

	private static String desFile = "POSCAR";
	private static String targetPath = "E:\\desdata\\2\\4layer";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dirPath = "E:\\data\\02.101\\4layer";
		listSecondSubFile(getDirList(dirPath));
	}

	// 得到第二层下面的所有文件
	public static void listSecondSubFile(List<String> dirList) {
		int len = dirList.size();
		for (int i = 0; i < len; i++) {
			File subFileTemp = new File(dirList.get(i));
			File[] t = subFileTemp.listFiles();
			for (int k = 0; k < t.length; k++) {
				if (t[k].getName().equals(desFile)) {
					String originalPath = t[k].getAbsolutePath();
					String desPath = targetPath;
					int index = t[k].getParent().length();
					String name = t[k].getParent().substring(index - 4);

					System.out.println(originalPath + " " + desPath + " "
							+ name);
					writeToDisk(originalPath, desPath, name);
				}
			}
		}
	}

	public static void writeToDisk(String originalPath, String desPath,
			String pathname) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		int line = 0;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					originalPath)));
			bw = new BufferedWriter(new FileWriter(desPath + "\\" + pathname,
					true));

			String str = "";

			while(true){
				str = br.readLine();
				if(line == 2){
					break;
				}
				if(str == null){
					bw.write("");
					line ++;
				}
				else{
					bw.write(str);
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.flush();
				br.close();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 下面这两个函数是 得到E:\data\01.001下的所有目录
	public static List<String> getDirList(String dirPath) {
		if (dirPath == null || dirPath.equals("")) {
			return null;
		}
		File f = new File(dirPath);
		List<String> dirList = listSubDir(f);
		return dirList;
	}

	public static List<String> listSubDir(File f) {
		List<String> subDirList = new ArrayList<String>();
		if (f.isDirectory()) {
			File[] t = f.listFiles();
			for (int i = 0; i < t.length; i++) {
				if (t[i].isDirectory()) {
					subDirList.add(t[i].getAbsolutePath());
				}
			}
		}

		return subDirList;
	}

}
