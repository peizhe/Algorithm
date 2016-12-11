package cn.bupt.sse309.wisdomAgriculture.backgroundService.DataBase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import cn.bupt.sse309.wisdomAgriculture.backgroundService.Tag.Poem;


public class FileDataBase {
    private String fileFullPath = "E:\\PoemDataBase.txt";
    public Map<String, Poem> keyandPoem = new HashMap<String, Poem>();

    public Map<String, Poem> initFileDataBase() {
        File file = new File(fileFullPath);
        if (!file.exists()) {
            return null;
        }
        try {
            FileReader filein = new FileReader(file);
            BufferedReader bufferRead = new BufferedReader(filein);

            String str = new String();
            while ((str = bufferRead.readLine()) != null) {
                String[] tmpContent = str.split(":");
                assert (tmpContent.length != 2);
                if (tmpContent.length == 2) {//
                    Poem poem = new Poem(tmpContent[1]);
                    keyandPoem.put(tmpContent[0], poem);
                }
            }
            filein.close();


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return keyandPoem;
    }


}
