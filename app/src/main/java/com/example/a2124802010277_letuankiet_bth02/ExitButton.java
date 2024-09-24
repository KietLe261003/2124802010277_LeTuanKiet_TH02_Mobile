package com.example.a2124802010277_letuankiet_bth02;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

public class ExitButton extends androidx.appcompat.widget.AppCompatButton {
    public ExitButton(Context context) {
        super(context);
        init();
    }

    public ExitButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setText("Thoát chương trình");
        setTextColor(Color.RED);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            ((Activity) getContext()).finish(); // Thoát activity
        }
        return true;
    }
}
