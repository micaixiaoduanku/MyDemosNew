package demo.huangli.mydemosnew.logic_set_1.retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import demo.huangli.mydemosnew.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by huangli on 17/8/26.
 */

public class RetrofitActivity extends Activity implements View.OnClickListener{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        findViewById(R.id.btn_retrofit_get).setOnClickListener(this);
        findViewById(R.id.btn_retrofit_post).setOnClickListener(this);

    }

    private void requestPost(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build();

        PostRequest_Interface request = retrofit.create(PostRequest_Interface.class);

        Call<Translation1> call = request.getCall("I love you");

        call.enqueue(new Callback<Translation1>() {

            //请求成功时回调
            @Override
            public void onResponse(Call<Translation1> call, Response<Translation1> response) {
                System.out.println(response.body().getTranslateResult().get(0).get(0).getTgt());
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<Translation1> call, Throwable throwable) {
                System.out.println("请求失败");
                System.out.println(throwable.getMessage());
            }
        });
    }

    private void requestGet(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://fy.iciba.com/").addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();

        GetRequest_Interface request_interface = retrofit.create(GetRequest_Interface.class);


        Call<Translation> call = request_interface.getCall();

        call.enqueue(new Callback<Translation>() {
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                response.body().show();
            }

            @Override
            public void onFailure(Call<Translation> call, Throwable t) {
                System.out.println("连接失败");
            }
        });
    }


    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.btn_retrofit_get:
               requestGet();
               break;
           case R.id.btn_retrofit_post:
               requestPost();
               break;
       }
    }
}
