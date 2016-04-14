package zlz.by.com.heat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
//    http://op.juhe.cn/onebox/hospital/queryhospital=%E5%AE%81%E6%B3%A2%E7%AC%AC%E4%B8%80%E5%8C%BB%E9%99%A2&dtype=&key=80e6cb4b13532b62ba8f00c3505a6988
    private String surl = "http://op.juhe.cn/onebox/hospital/query.php?";
    private String key = "80e6cb4b13532b62ba8f00c3505a6988";
    private  String content = "hospital=宁波第一医院";
    private String zlz = "http://zlzxm.com/he/helogin.php";
    private  String name = "username=zlz&&password=11";
    //207802 医院名不正确

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        HttpUrlConnect connect = new HttpUrlConnect();
        String str = connect.httpgetjson(zlz,name,"POST",key);
        Log.e("zlz",str + "l");


    }



}