package demo.huangli.mydemosnew.logic_set_1.fastjson;

import com.alibaba.fastjson.JSON;

/**
 * Created by huangli on 17/12/19.
 */

public class FastJsonUtil {
    public static String toJsonString(Object obj){
        String jsonString = JSON.toJSONString(obj);
        return jsonString;
    }

    public static <T> T parseObject(String text, Class<T> clazz){
        return JSON.parseObject(text,clazz);
    }
}
