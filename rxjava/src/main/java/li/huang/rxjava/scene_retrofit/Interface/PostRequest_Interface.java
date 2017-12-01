package li.huang.rxjava.scene_retrofit.Interface;

import li.huang.rxjava.scene_retrofit.beans.TranslationPost;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by huangli on 17/10/3.
 */

public interface PostRequest_Interface {
    @POST("translate?doctype=json&jsonversion=&type=&keyfrom=&model=&mid=&imei=&vendor=&screen=&ssid=&network=&abtest=")
    @FormUrlEncoded
    Observable<TranslationPost> getCall(@Field("i") String targetSentence);
}
