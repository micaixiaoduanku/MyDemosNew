package demo.huangli.mydemosnew.logic_set_1.okhttp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.IOException;

import demo.huangli.mydemosnew.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by huangli on 17/4/22.
 */

public class OkHttpActivity extends Activity implements View.OnClickListener{

    public static final String TAG = "OkHttpActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
        findViewById(R.id.btn_test_get).setOnClickListener(this);
        findViewById(R.id.btn_test_post).setOnClickListener(this);
        findViewById(R.id.btn_upload_file).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_test_get:
                testGet();
                break;
            case R.id.btn_test_post:
                testPost();
                break;
            case R.id.btn_upload_file:
                testUploadFile();
                break;
        }
    }

    private void testUploadFile(){
        OkHttpClient mOkHttpClient = new OkHttpClient();
        File file = new File(Environment.getExternalStorageDirectory(), "balabala.mp4");
        RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);

        RequestBody requestBody = new MultipartBody.Builder()
                .addPart(Headers.of(
                        "Content-Disposition",
                        "form-data; name=\"username\""),
                        RequestBody.create(null, "张鸿洋"))
                .addPart(Headers.of(
                        "Content-Disposition",
                        "form-data; name=\"mFile\"; filename=\"wjd.mp4\""), fileBody)
                .build();

        Request request = new Request.Builder()
                .url("http://192.168.1.103:8080/okHttpServer/fileUpload")
                .post(requestBody)
                .build();

        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

    private void testPost(){
        OkHttpClient mOkHttpClient = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        String data = "{\"member_id\":\"mimi\"}";
        Request request = new Request.Builder()
                .url("http://192.168.40.123:8020/v1/album/sync?debug=1&no_encrypt=1&country=null&lang=en")
                .post(RequestBody.create(MediaType.parse("text/plain"), data))
                .build();
        mOkHttpClient.newCall(request).enqueue(new Callback(){
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("tag","onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("tag","onResponse "+response.body().string());
            }
        });
    }

    private void testGet(){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("https://github.com/hongyangAndroid").build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i(TAG,"onFailure ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i(TAG,response.toString());
            }
        });
    }
}
