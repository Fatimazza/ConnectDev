package id.co.binar.connectdev.components.layoutmanager;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * Created by rioswarawan on 11/10/17.
 */

public class NonScrollableLinearLayoutManager extends LinearLayoutManager {
    public NonScrollableLinearLayoutManager(Context context) {
        super(context);
    }

    public NonScrollableLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    @Override
    public boolean canScrollVertically() {
        return false;
    }
}
