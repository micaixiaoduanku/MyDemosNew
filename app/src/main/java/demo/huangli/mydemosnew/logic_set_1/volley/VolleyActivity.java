package demo.huangli.mydemosnew.logic_set_1.volley;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 16/7/15.
 */
public class VolleyActivity extends Activity implements View.OnClickListener{
    public static final String TAG = "MyTag";
    private TextView tv;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        tv = (TextView) findViewById(R.id.tv);
        imageView = (ImageView)findViewById(R.id.imageView);
        findViewById(R.id.btn_send_stringrequest).setOnClickListener(this);
        findViewById(R.id.btn_send_jsonrequest).setOnClickListener(this);
        findViewById(R.id.btn_load_image).setOnClickListener(this);
        findViewById(R.id.btn_send_xmlrequest).setOnClickListener(this);
        findViewById(R.id.btn_send_gsonrequest).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_send_stringrequest:
                sendStringRequest();
                break;
            case R.id.btn_send_jsonrequest:
                sendJsonRequest();
                break;
            case R.id.btn_load_image:
                requestImage();
                break;
            case R.id.btn_send_xmlrequest:
                sendXmlRequest();
                break;
            case R.id.btn_send_gsonrequest:
                sendGsonRequest();
                break;
        }
    }

    private void requestImage() {
        ImageLoader imageLoader = new ImageLoader(VolleySingleton.getInstance(this).getRequestQueue(), new BitmapCache());
        ImageLoader.ImageListener listener = ImageLoader.getImageListener(imageView,
                0, 0);
        imageLoader.get("http://img.my.csdn.net/uploads/201404/13/1397393290_5765.jpeg", listener);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void sendJsonRequest(){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("member_id","dsdad");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://192.168.40.123:8020/v1/album/sync?debug=1&no_encrypt=1&country=null&lang=en", jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("tag","天气 ： "+response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("tag","天气 ： error");
            }
        });
        VolleySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }

    private void sendXmlRequest(){
        XMLRequest xmlRequest = new XMLRequest(
                "http://flash.weather.com.cn/wmaps/xml/china.xml",
                new Response.Listener<XmlPullParser>() {
                    @Override
                    public void onResponse(XmlPullParser response) {
                        try {
                            int eventType = response.getEventType();
                            while (eventType != XmlPullParser.END_DOCUMENT) {
                                switch (eventType) {
                                    case XmlPullParser.START_TAG:
                                        String nodeName = response.getName();
                                        if ("city".equals(nodeName)) {
                                            String pName = response.getAttributeValue(0);
                                            Log.d("TAG", "pName is " + pName);
                                        }
                                        break;
                                }
                                eventType = response.next();
                            }
                        } catch (XmlPullParserException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });
        VolleySingleton.getInstance(this).addToRequestQueue(xmlRequest);
    }

    private void sendStringRequest(){
        String url ="http://192.168.40.123:8020/v1/album/sync?debug=1&no_encrypt=1&country=null&lang=en";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG,response);
//                tv.setText("Response is: "+ response.substring(0,500));
            }

        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                tv.setText("That didn't work! "+error.getLocalizedMessage());
            }
        });
        stringRequest.setTag(TAG);
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    private void sendGsonRequest(){
        GsonRequest<Weather> gsonRequest = new GsonRequest<>("http://www.weather.com.cn/data/sk/101010100.html",
                Weather.class,null,new Response.Listener<Weather>() {
            @Override
            public void onResponse(Weather weather) {
                WeatherInfo weatherInfo = weather.getWeatherinfo();
                Log.d("TAG", "city is " + weatherInfo.getCity());
                Log.d("TAG", "temp is " + weatherInfo.getTemp());
                Log.d("TAG", "time is " + weatherInfo.getTime());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });
        VolleySingleton.getInstance(this).addToRequestQueue(gsonRequest);
    }
}
