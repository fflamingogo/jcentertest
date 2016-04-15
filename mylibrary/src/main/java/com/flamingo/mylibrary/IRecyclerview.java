package com.flamingo.mylibrary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by flamingo on 2016/2/23.
 */
public class IRecyclerview extends RecyclerView {
    public IRecyclerview(Context context) {
        super(context);
    }

    public IRecyclerview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IRecyclerview(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    public void setOnItemTouchListener(OnItemTouchListener listener) {
        try {
            Field f = getClass().getSuperclass().getDeclaredField("mOnItemTouchListeners");
            f.setAccessible(true);
            ArrayList<OnItemTouchListener> mOnItemTouchListeners = (ArrayList<OnItemTouchListener>) f.get(this);
            mOnItemTouchListeners.clear();
            mOnItemTouchListeners.add(listener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
