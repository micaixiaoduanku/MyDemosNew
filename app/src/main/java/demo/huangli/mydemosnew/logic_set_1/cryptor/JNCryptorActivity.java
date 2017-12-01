package demo.huangli.mydemosnew.logic_set_1.cryptor;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import demo.huangli.mydemosnew.R;
import demo.huangli.mydemosnew.logic_set_1.cryptor.src.main.java.org.cryptonode.jncryptor.AES256JNCryptor;
import demo.huangli.mydemosnew.logic_set_1.cryptor.src.main.java.org.cryptonode.jncryptor.CryptorException;
import demo.huangli.mydemosnew.logic_set_1.cryptor.src.main.java.org.cryptonode.jncryptor.JNCryptor;

/**
 * Created by huangli on 17/8/16.
 */

public class JNCryptorActivity extends Activity implements View.OnClickListener{

    private Bitmap bitmap;
    private  String password = "secretsquirrel";
    private byte[] ciphertext,decrypttext;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cryptor_jn);
        imageView = (ImageView) findViewById(R.id.image_view);
        findViewById(R.id.btn_encrypt).setOnClickListener(this);
        findViewById(R.id.btn_decode).setOnClickListener(this);
        bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.demo1);
    }

    @Override
    public void onClick(View v) {
        long time;
        long cons;
        switch (v.getId()){
            case R.id.btn_encrypt:
                JNCryptor cryptor1 = new AES256JNCryptor();
                byte[] plaintext = "Hello, World!".getBytes();
                 time = System.currentTimeMillis();
                try {
                    ciphertext = cryptor1.encryptData(bitmap.toString().getBytes(),password.toCharArray());
                } catch (CryptorException e) {
                    // Something went wrong
                    e.printStackTrace();
                    Log.i("tag","CryptorException 1");
                }
                 cons = System.currentTimeMillis() - time;
                Log.i("tag","耗时 "+cons);
                break;
            case R.id.btn_decode:
                 time = System.currentTimeMillis();
                JNCryptor cryptor2 = new AES256JNCryptor();
                try {
                    decrypttext = cryptor2.decryptData(ciphertext,password.toCharArray());
                    Bitmap bitmap2 = BitmapFactory.decodeByteArray(decrypttext,0,decrypttext.length);
                    imageView.setImageBitmap(bitmap2);
                } catch (CryptorException e) {
                    e.printStackTrace();
                    Log.i("tag","CryptorException 2");
                }
                cons = System.currentTimeMillis() - time;
                Log.i("tag","耗时 "+cons);
                break;
        }
    }
}
