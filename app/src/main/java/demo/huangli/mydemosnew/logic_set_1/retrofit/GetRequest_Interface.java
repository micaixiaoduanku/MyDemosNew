package demo.huangli.mydemosnew.logic_set_1.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by huangli on 17/10/3.
 */

public interface GetRequest_Interface {
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello%20world")
    Call<Translation> getCall();
}
