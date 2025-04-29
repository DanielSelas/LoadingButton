package com.example.loadingbutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.Gravity;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;


public class LoadingButton extends AppCompatButton {

    private String originalText;
    private boolean isLoading = false;
    private String loadingText = "Loading...";
    private ColorStateList originalBackgroundTint;
    private int loadingColor = R.color.neutral_light_gray; // ברירת מחדל אפור ניטרלי

    public LoadingButton(Context context) {
        super(context);
        init();
    }

    public LoadingButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoadingButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setGravity(Gravity.CENTER);
        if (getBackgroundTintList() == null) {
            setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.neutral_light_gray));
        }
    }

    public void setLoadingText(String text) {
        this.loadingText = text;
    }

    public void setLoadingColor(int colorResId) {
        this.loadingColor = colorResId;
    }

    public void showLoading() {
        if (isLoading) return;
        isLoading = true;
        originalText = getText().toString();
        originalBackgroundTint = getBackgroundTintList();
        setText(loadingText);
        setEnabled(false);

        if (loadingColor != 0) {
            setBackgroundTintList(ContextCompat.getColorStateList(getContext(), loadingColor));
        }
    }

    public void hideLoading() {
        if (!isLoading) return;
        isLoading = false;
        setText(originalText);
        setEnabled(true);

        if (originalBackgroundTint != null) {
            setBackgroundTintList(originalBackgroundTint);
        }
    }
}