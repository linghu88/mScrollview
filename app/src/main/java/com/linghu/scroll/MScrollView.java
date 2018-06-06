package com.linghu.scroll;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by linghu on 2018/6/6.
 * 自定义拖动view
 */
public class MScrollView extends View {

    public MScrollView(Context context) {
        super(context);
    }

    public MScrollView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MScrollView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MScrollView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private float lastX;
    private float lastY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = event.getRawX();
                lastY = event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = event.getRawX() - lastX;
                float dy = event.getRawY() - lastY;
                move(dx, dy);
                lastX = event.getRawX();
                lastY = event.getRawY();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    private void move(float dx, float dy){
        setTranslationX(getTranslationX() + dx);
        setTranslationY(getTranslationY() + dy);
    }

    /*private void move(float dx, float dy) {
        setLeft((int) (getLeft()+dx));
        setRight((int) (getRight()+dx));
        setTop((int) (getTop()+dy));
        setBottom((int) (getBottom()+dy));
    }*/

    /*private void move(float dx, float dy) {
        //这里要用负数，因为滑动的是布局的边框，正好和内容的滑动方向相反
        int x = (int) -dx;
        int y = (int) -dy;
        this.scrollBy(x, y);
    }*/

}