package zlz.by.com.heat;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by mac on 16/4/13.
 */
public class HttpUrlConnect {
    private  String  urlstr;
    private  String  content;
    private  String  resultjson;
    private  String  key;

   public  String  httpgetjson(String urlstr,String content, final String  method,String key)
   {
       this.urlstr  = urlstr;
       this.content = content;
       this.key = key;

        new Thread(new Runnable() {
            @Override
            public void run() {
                if(method == "GET"){
                    getjson();

                }else {
                    postjson();

                }



            }
        }).start();

        return  resultjson;
   }
   private void getjson(){
       try {
           String str = urlstr + "key=" + key + "&" + content;
           Log.e("zlz",key);
           Log.e("zlz",str);
           URL url = new URL(str);
           HttpURLConnection conn = (HttpURLConnection) url.openConnection();
           BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
           StringBuilder sb = new StringBuilder();
           String line = "";
           while ((line = br.readLine()) != null)
           {
             sb.append(line);

           }
           conn.disconnect();
           resultjson = sb.toString();
           Log.e("zlz",resultjson  + "re");

           } catch (IOException e) {
               e.printStackTrace();
           }

   }
    private  void postjson(){
        try {
            Log.e("zlz","post");
            URL url = new URL(urlstr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            bw.write(content);
            bw.flush();
            bw.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = "";
            while ((line = br.readLine()) != null)
            {
                sb.append(line);

            }
            conn.disconnect();
            resultjson = sb.toString();
            Log.e("zlz",resultjson  + "re");
            } catch (IOException e) {
                e.printStackTrace();
            }



    }


}
