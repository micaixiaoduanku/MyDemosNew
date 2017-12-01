package li.huang.rxjava.scene_retrofit;

import li.huang.rxjava.scene_retrofit.Interface.GetRequest_Interface;
import li.huang.rxjava.scene_retrofit.Interface.PostRequest_Interface;
import li.huang.rxjava.scene_retrofit.beans.TranslationGet;
import li.huang.rxjava.scene_retrofit.beans.TranslationPost;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by huangli on 17/10/5.
 */

public class RetrofitHelper {

    public static final String TAG = "RetrofitHelper";

    public RetrofitHelper() {
    }

    public void requestGet(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://fy.iciba.com/").addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        GetRequest_Interface request_interface = retrofit.create(GetRequest_Interface.class);
        request_interface.getCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<TranslationGet>() {
            @Override
            public void call(TranslationGet translationGet) {
                translationGet.show();
            }
        });
    }

    public void requestPost(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        PostRequest_Interface postRequest_interface = retrofit.create(PostRequest_Interface.class);
        postRequest_interface.getCall("hello").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<TranslationPost>() {
            @Override
            public void call(TranslationPost translationPost) {
                System.out.println("target : "+translationPost.getTranslateResult().get(0).get(0).getTgt());
            }
        });
    }
}
