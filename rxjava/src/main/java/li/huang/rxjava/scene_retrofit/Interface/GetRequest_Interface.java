package li.huang.rxjava.scene_retrofit.Interface;

import li.huang.rxjava.scene_retrofit.beans.TranslationGet;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by huangli on 17/10/3.
 */

public interface GetRequest_Interface {
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello%20world")
    Observable<TranslationGet> getCall();
}
