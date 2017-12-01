package demo.huangli.mydemosnew.ui_set_1.meminfo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 16/9/22.
 */
public class MemInfoActivity extends Activity{
    private TextView tvMem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem_info);
        findViewsByid();
        tvMem.setText(loadMemInfo());
    }

    private String loadMemInfo(){
        StringBuilder sb = new StringBuilder();
        long[] items = MemUtils.getMemInfo();
        sb.append("获取内存信息来自MemUtils"+"\n");
        if (items.length == 4){
            for (int i = 0 ; i < 4; i++){
                switch (i){
                    case 0:
                        sb.append("total : "+items[i]+"\n");
                        break;
                    case 1:
                        sb.append("free : "+items[i]+"\n");
                        break;
                    case 2:
                        sb.append("buffers : "+items[i]+"\n");
                        break;
                    case 3:
                        sb.append("cached : "+items[i]+"\n");
                        break;
                }
            }
        }
        sb.append("获取内存信息来自Runtime"+"\n");
        long total = Runtime.getRuntime().totalMemory();
        long free = Runtime.getRuntime().freeMemory();
        sb.append("total "+total+"\n");
        sb.append("free "+free+"\n");
        return sb.toString();
    }

    private void findViewsByid(){
        tvMem = (TextView)findViewById(R.id.tv_mem_text);
    }
}
