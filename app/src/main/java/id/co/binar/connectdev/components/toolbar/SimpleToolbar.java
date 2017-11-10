package id.co.binar.connectdev.components.toolbar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import id.co.binar.connectdev.R;

/**
 * Created by rioswarawan on 11/9/17.
 */

public class SimpleToolbar extends LinearLayout {

    private View rootView;
    private ImageView imageBack, imageEdit;
    private TextView textName;

    private SimpleToolbarListener listener;

    public SimpleToolbar(Context context) {
        super(context);
        init(context);
    }

    public SimpleToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.view_toolbar_simple, this, true);
        this.imageBack = (ImageView) rootView.findViewById(R.id.button_back);
        this.imageEdit = (ImageView) rootView.findViewById(R.id.button_edit);
        this.textName = (TextView) rootView.findViewById(R.id.text_name);
    }

    public void setListener(SimpleToolbarListener listener) {
        this.listener = listener;
        this.imageBack.setOnClickListener(onBackClicked);
        this.imageEdit.setOnClickListener(onEditClicked);
    }

    public void edit(boolean hasEdit) {
        this.imageEdit.setVisibility(hasEdit ? VISIBLE : GONE);
    }

    public void setName(String name) {
        this.textName.setText(name);
    }

    private OnClickListener onBackClicked = new OnClickListener() {
        @Override
        public void onClick(View view) {
            listener.onDestroy();
        }
    };
    private OnClickListener onEditClicked = new OnClickListener() {
        @Override
        public void onClick(View view) {
            listener.onEdit();
        }
    };
}
