package demo.huangli.mydemosnew.logic_set_1.fastjson;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import demo.huangli.mydemosnew.R;
import demo.huangli.mydemosnew.logic_set_1.fastjson.data.Group;
import demo.huangli.mydemosnew.logic_set_1.fastjson.data.User;

/**
 * Created by huangli on 17/12/19.
 */

public class FastJsonActivity extends Activity {

    public final static String TAG = "FastJsonActivity";

    @BindView(R.id.btn_fast_json_to_obj)
    Button btnFastJsonToObj;
    @BindView(R.id.btn_fast_obj_to_json)
    Button btnFastObjToJson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_json);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_fast_json_to_obj, R.id.btn_fast_obj_to_json})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_fast_json_to_obj:
                Log.i(TAG,"序列化 "+testToStr());
                break;
            case R.id.btn_fast_obj_to_json:
                String text = testToStr();
                Group group = FastJsonUtil.parseObject(text,Group.class);
                Log.i(TAG,"反序列化 "+group.getName());
                break;
        }
    }

    private String testToStr(){
        Group group = new Group();
        group.setId(0L);
        group.setName("admin");
        User guestUser = new User();
        guestUser.setId(2L);
        guestUser.setName("guest");
        User rootUser = new User();
        rootUser.setId(3L);
        rootUser.setName("root");
        group.addUser(guestUser);
        group.addUser(rootUser);
        return FastJsonUtil.toJsonString(group);
    }
}
