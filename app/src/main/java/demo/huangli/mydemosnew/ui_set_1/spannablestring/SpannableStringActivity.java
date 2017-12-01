package demo.huangli.mydemosnew.ui_set_1.spannablestring;

import android.app.Activity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.widget.TextView;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 16/9/23.
 */
public class SpannableStringActivity extends Activity{

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spannable_str);

        textView = (TextView)findViewById(R.id.textview);

        String timeSug = "Suggest to save immediately \\nEst. extension 55min";

        textView.setText(transForText(timeSug, "55min"));
    }

    private SpannableString transForText(String timeSug, String time) {
        int startIndex = timeSug.indexOf(time);
        SpannableString msp = new SpannableString(timeSug);
        msp.setSpan(new TextAppearanceSpan(this, R.style.ExamineIncreaseTimeSug), startIndex, startIndex + time.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return msp;
    }
}
