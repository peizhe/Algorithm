package cn.bupt.sse309.wisdomAgriculture.backgroundService.Tag;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class TagImage {

    public static String main(String imgurl) {
        String poem = "对不起，无匹配。";
        HttpClient httpclient = HttpClients.createDefault();
        try {
            String tagImgUri = "https://api.projectoxford.ai/vision/v1.0/tag";
            HttpPost request = RequestHeader.getHeader(tagImgUri);
            // Request body

            String imgURL = "{\"url\":\"" + imgurl + "\"}";//成功,雪

            //	String imgURL = "{\"url\":\"http://img2.imgtn.bdimg.com/it/u=578140212,1247034920&fm=23&gp=0.jpg\"}";
            StringEntity reqEntity = new StringEntity(imgURL);
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                //内容类型
                System.out.println(entity.getContentType());

                String content = EntityUtils.toString(entity);//获取微软API返回的内容
                //       System.out.println("content: "+content);
                Analyze analyze = new Analyze();//分析内容
                poem = analyze.returnPoem(content);
                System.out.println(poem);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return poem;
    }


}
