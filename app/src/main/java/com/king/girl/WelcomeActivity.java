package com.king.girl;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.king.base.SplashActivity;
import com.king.base.util.LogUtils;
import com.king.base.util.SharedPreferencesUtils;

/**
 * @author Jenly <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * @since 2017/2/4
 */
public class WelcomeActivity extends SplashActivity {

    @Override
    public int getContentViewId() {
        return R.layout.activity_welcome;
    }

    public void setTranslucentStatusBar(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // Translucent navigation bar
//            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    @Override
    public void initData() {
        setTranslucentStatusBar();
        ImageView iv = findView(R.id.iv);
        String url = SharedPreferencesUtils.getString(context,Constants.FIRST_GIRL_URL);
        Glide.with(context).load(url).error(R.drawable.ic_welcome).crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);
        super.initData();
    }

    @Override
    public Animation.AnimationListener getAnimationListener() {
        return new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                LogUtils.d("1111");
                startActivityFinish(MainActivity.class);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };
    }
}
