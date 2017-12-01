package demo.huangli.mydemosnew.logic_set_1.algorithm;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Arrays;
import java.util.HashMap;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 17/4/30.
 */

public class AlgorithmActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm);

        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
        findViewById(R.id.btn_4).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                //TODO implement
                break;
            case R.id.btn_2:
                algorithm2_2();
                //TODO implement
                break;
            case R.id.btn_3:
                algorithm3();
                break;
            case R.id.btn_4:
                algorithm4();
                break;
        }
    }

    /**
     * 选择排序
      */
    private void algorithm4(){
        int[] array = new int[]{3,10,20,7,13,8,9,22,55,1};
        for (int i = 0; i < array.length; i++){
            int key = i;
            for(int j = i+1;j < array.length; j++){
                if (array[j] < array[key]) {
                    key = j;
                }
            }
            if (i != key){
                int temp = array[key];
                array[key] = array[i];
                array[i] = temp;
            }
        }
        for (int x = 0 ; x < array.length; x++){
            Log.i("tag",array[x]+" ");
        }
    }

    /**
     * 二分法查找
     */
    private int algorithm1(int[] num,int key){
        int start = 0;
        int end = num.length - 1;
        int middle = -1;
        while(start <= end){
            middle = (start + end)/2;
            if (num[middle] == key){
                return middle;
            }else if(num[middle] < key){
                start = middle+1;
            }else if(num[middle] > key){
                end = middle-1;
            }
        }
        return -1;
    }

    /**
     * 冒泡排序
     */
    private void algorithm3(){
        int[] array = new int[]{3,10,20,7,13,8,9,22,55,1};
        int length = array.length;
        for (int i = 0 ; i < length; i++){
            for (int j = 0; j < length-1-i; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        for (int x = 0 ; x < array.length; x++){
            System.out.print(array[x]+" ");
        }
    }


    /**
     * 两个字符串 String str1 = "aderttyuuus", String str2 = "sdaertyyt" 找出相同的字符并构建新的字符串
     */
    private void algorithm2_1(){
        String str1 = "aderttyuuus";
        String str2 = "artttswwwas";
        char[] char1Array = str1.toCharArray();
        char[] char2Array = str2.toCharArray();
        StringBuilder sb = new StringBuilder();
        HashMap<Integer,Character> map = new HashMap<>();
        for (int i = 0; i < char1Array.length ; i++){
            map.put(i,char1Array[i]);
        }
        for (int i = 0; i < char2Array.length ; i++){
            if(map.containsKey(char2Array[i])){
                sb.append(char2Array[i]);
            }
        }
        System.out.println("结果 "+sb);
    }

    private void algorithm2_2(){
        String str1 = "aderttyuuus";
        String str2 = "artttswwwas";
        char[] char1Array = str1.toCharArray();
        char[] char2Array = str2.toCharArray();
        Arrays.sort(char1Array);  //升序
        Arrays.sort(char2Array);
        StringBuilder sb = new StringBuilder();
        int k = 0;
        int j = 0;
        while(k<char1Array.length && j<char2Array.length) {
                if(char1Array[k] == char2Array[j]) {
                    sb.append(char1Array[k]);
                    k++;
                    j++;
                }
                else if (char1Array[k] > char2Array[j]){
                    j++;
                }else{
                    k++;
                }
            }
        System.out.println("结果 "+sb);
    }

}
