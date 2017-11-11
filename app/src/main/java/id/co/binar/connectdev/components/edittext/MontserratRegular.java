package id.co.binar.connectdev.components.edittext;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by rioswarawan on 11/7/17.
 */

public class MontserratRegular extends AppCompatEditText {


    public MontserratRegular(Context context) {
        super(context);
        setFont(context);
    }

    public MontserratRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public MontserratRegular(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }

    private void setFont(Context context) {
        setTransformationMethod(null);
        Typeface type = Typeface.createFromAsset(context.getAssets(), "font/Montserrat/Montserrat-Regular.ttf");
        setTypeface(type);
    }
}
