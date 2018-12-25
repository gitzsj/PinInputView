package com.tapapk.pininputview;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class PinInputView extends LinearLayout {
    private LinearLayout pointLayout;
    private ImageView point1;
    private ImageView point2;
    private ImageView point3;
    private ImageView point4;
    private ImageView cancel;
    private TextView one;
    private TextView two;
    private TextView three;
    private TextView four;
    private TextView five;
    private TextView six;
    private TextView seven;
    private TextView eight;
    private TextView nine;
    private TextView zero;
    private TextView clean;
    private ArrayList<String> input = new ArrayList<>();

    public PinInputView(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
        LayoutInflater.from(context).inflate(R.layout.pin_input_layout, this);
        pointLayout = findViewById(R.id.pointLayout);
        point1 = (ImageView)findViewById(R.id.point1);
        point2 = (ImageView)findViewById(R.id.point2);
        point3 = (ImageView)findViewById(R.id.point3);
        point4 = (ImageView)findViewById(R.id.point4);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        clean = findViewById(R.id.clean);
        cancel = (ImageView) findViewById(R.id.cancel);
        cancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.size()>0){
                    remove(context);
                }else {
                    if (onCancelClickListener != null) {
                        onCancelClickListener.OnCancelClick();
                    }
                }
            }
        });
        clean.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.size()>0) {
                    input.clear();
                    final Drawable avd = AnimatedVectorDrawableCompat.create(context, R.drawable.anim_pin_output);
                    point1.setImageDrawable(avd);
                    point2.setImageDrawable(avd);
                    point3.setImageDrawable(avd);
                    point4.setImageDrawable(avd);
                    ((Animatable) avd).start();
                    final Drawable cancelAvd = AnimatedVectorDrawableCompat.create(context, R.drawable.anim_back_to_cancel);
                    cancel.setImageDrawable(cancelAvd);
                    ((Animatable) cancelAvd).start();
                }
            }
        });
        one.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                add("1",context);
            }
        });
        two.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                add("2",context);
            }
        });
        three.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                add("3",context);
            }
        });
        four.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                add("4",context);
            }
        });
        five.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                add("5",context);
            }
        });
        six.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                add("6",context);
            }
        });
        seven.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                add("7",context);
            }
        });
        eight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                add("8",context);
            }
        });
        nine.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                add("9",context);
            }
        });
        zero.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                add("0",context);
            }
        });
    }

    public PinInputView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PinInputView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public PinInputView(Context context) {
        super(context);

    }
    private void add(String pin, Context context){
        final Drawable avd = AnimatedVectorDrawableCompat.create(context, R.drawable.anim_pin_input);
        if (input.size() == 0){
            final Drawable cancelAvd = AnimatedVectorDrawableCompat.create(context, R.drawable.anim_cancel_to_back);
            cancel.setImageDrawable(cancelAvd);
            Animatable animatable = ((Animatable)cancel.getDrawable());
            animatable.start();
            point1.setImageDrawable(avd);
            animatable = ((Animatable)point1.getDrawable());
            animatable.start();
            input.add(pin);
        }else if (input.size() == 1){
            point2.setImageDrawable(avd);
            Animatable animatable = ((Animatable)point2.getDrawable());
            animatable.start();
            input.add(pin);
        }else if (input.size() == 2){
            point3.setImageDrawable(avd);
            Animatable animatable = ((Animatable)point3.getDrawable());
            animatable.start();
            input.add(pin);
        }else if (input.size() == 3){
            point4.setImageDrawable(avd);
            Animatable animatable = ((Animatable)point4.getDrawable());
            animatable.start();
            input.add(pin);
        }
        if (input.size() == 4){
            StringBuilder stringBuilder = new StringBuilder();
            for (String str:input){
                stringBuilder.append(str);
            }
            if (onFullListener != null){
                onFullListener.OnFull(stringBuilder.toString());
            }
        }

    }
    private void remove(Context context){
        final Drawable avd = AnimatedVectorDrawableCompat.create(context, R.drawable.anim_pin_output);
        if (input.size() == 4){
            input.remove(input.size()-1);
            point4.setImageDrawable(avd);
            Animatable animatable = ((Animatable)point4.getDrawable());
            animatable.start();
        }else if (input.size() == 3){
            input.remove(input.size()-1);
            point3.setImageDrawable(avd);
            Animatable animatable = ((Animatable)point3.getDrawable());
            animatable.start();
        }else if (input.size() == 2){
            input.remove(input.size()-1);
            point2.setImageDrawable(avd);
            Animatable animatable = ((Animatable)point2.getDrawable());
            animatable.start();
        }else if (input.size() == 1){
            input.remove(input.size()-1);
            point1.setImageDrawable(avd);
            Animatable animatable = ((Animatable)point1.getDrawable());
            animatable.start();
            final Drawable cancelAvd = AnimatedVectorDrawableCompat.create(context, R.drawable.anim_back_to_cancel);
            cancel.setImageDrawable(cancelAvd);
            animatable = ((Animatable)cancel.getDrawable());
            animatable.start();
        }
    }
    OnCancelClickListener onCancelClickListener;
    OnFullListener onFullListener;
    public interface OnCancelClickListener{
        void OnCancelClick();
    }
    public interface OnFullListener{
        void OnFull(String vaule);
    }
    public void setOnCancelClickListener(PinInputView.OnCancelClickListener  mListener){
        this.onCancelClickListener=mListener;
    }
    public boolean setOnFullClick(OnFullListener mListener){
        this.onFullListener = mListener;
        return false;
    }
    public void setNumColor(int color){
        one.setTextColor(color);
        two.setTextColor(color);
        three.setTextColor(color);
        four.setTextColor(color);
        five.setTextColor(color);
        six.setTextColor(color);
        seven.setTextColor(color);
        eight.setTextColor(color);
        nine.setTextColor(color);
        zero.setTextColor(color);
    }
    public void setClearButtonColor(int color){
        clean.setTextColor(color);
    }
    public void setPointColor(int color){
        point1.setColorFilter(color);
        point2.setColorFilter(color);
        point3.setColorFilter(color);
        point4.setColorFilter(color);
    }
    public void setCancelButtonColor(int color){
        cancel.setColorFilter(color);
    }
    public void Error(){
        Animation mShakeAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.pin_error);
        pointLayout.startAnimation(mShakeAnimation);
        ClearAll();
    }
    public void ClearAll(){
        input.clear();
        final Drawable avd = AnimatedVectorDrawableCompat.create(getContext(), R.drawable.anim_pin_output);
        point1.setImageDrawable(avd);
        point2.setImageDrawable(avd);
        point3.setImageDrawable(avd);
        point4.setImageDrawable(avd);
        ((Animatable) avd).start();
        final Drawable cancelAvd = AnimatedVectorDrawableCompat.create(getContext(), R.drawable.anim_back_to_cancel);
        cancel.setImageDrawable(cancelAvd);
        ((Animatable) cancelAvd).start();
    }
}
