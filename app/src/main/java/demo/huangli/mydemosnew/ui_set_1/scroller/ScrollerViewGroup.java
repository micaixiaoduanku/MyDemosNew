package demo.huangli.mydemosnew.ui_set_1.scroller;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.Scroller;

/**
 * Created by huangli on 17/5/9.
 */

public class ScrollerViewGroup extends RelativeLayout{

    public static String TAG = "ScrollerViewGroup";

    private Scroller scroller;

    public ScrollerViewGroup(Context context) {
        super(context);
        scroller = new Scroller(context);
    }

    public ScrollerViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        scroller = new Scroller(context);
    }

    public void smoothScrollTo(int destX){
        int scrollX = getScrollX();
        int deltaX = destX - scrollX;
        scroller.startScroll(scrollX,0,deltaX,0,3000);
        invalidate();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        Log.i(TAG,"onLayout...");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i(TAG,"onDraw...");
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (scroller.computeScrollOffset()){
            scrollTo(scroller.getCurrX(),scroller.getCurrY());
            postInvalidate();
        }
    }
}
