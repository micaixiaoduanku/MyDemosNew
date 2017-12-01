package li.huang.poptextscreen;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by huangli on 17/1/11.
 */

public class PopScreenModule {
    public static void startScreenModule(Activity activity){
        Intent intent = new Intent(activity,PopScreenActivity.class);
        activity.startActivity(intent);
    }
}
