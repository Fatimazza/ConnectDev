package id.co.binar.connectdev.components.textview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by rioswarawan on 11/7/17.
 */

public class MontserratBold extends AppCompatTextView {


    public MontserratBold(Context context) {
        super(context);
        setFont(context);
    }

    public MontserratBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public MontserratBold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }

    private void setFont(Context context) {
        setTransformationMethod(null);
        Typeface type = Typeface.createFromAsset(context.getAssets(), "font/Montserrat/Montserrat-Bold.ttf");
        setTypeface(type);
    }
}
