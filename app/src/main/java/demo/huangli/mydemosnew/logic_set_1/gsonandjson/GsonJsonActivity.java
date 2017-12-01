package demo.huangli.mydemosnew.logic_set_1.gsonandjson;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 17/1/20.
 */

public class GsonJsonActivity extends Activity implements View.OnClickListener{

    private String str = "{\"feedback\":{\"email\":\"aa@aa.com\",\"content\":\"123\"}}";

    private Button btnObjToJson,btnJsonToObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson_json);
        btnObjToJson = (Button)findViewById(R.id.btn_obj_to_json);
        btnJsonToObj = (Button)findViewById(R.id.btn_json_to_obj);
        btnObjToJson.setOnClickListener(this);
        btnJsonToObj.setOnClickListener(this);

        try {
            JSONObject jsonObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void testObjToJson(){
        FeedBackItem.FeedBack feedBack = new FeedBackItem.FeedBack("351573105@qq.com","不错不错");
        FeedBackItem feedBackItem = new FeedBackItem(feedBack);
        Gson gson = new Gson();
        String data = gson.toJson(feedBackItem);
        Log.i("test",data);
    }

    private void testJsonToObj(){
//        String json = new String("{\"content\":\"不错不错\",\"email\":\"351573105@qq.com\"}");
//        Gson gson = new Gson();
//        FeedBackItem feedBackItem = gson.fromJson(json,FeedBackItem.class);
//        Log.i("test","email "+feedBackItem.feedback.getEmail()+" content "+feedBackItem.feedback.getContent());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_obj_to_json:
                testObjToJson();
                break;
            case R.id.btn_json_to_obj:
                testJsonToObj();
                break;
        }
    }
}
