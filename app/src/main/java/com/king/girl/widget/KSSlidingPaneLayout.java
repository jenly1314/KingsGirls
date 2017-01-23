package com.king.girl.widget;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import com.king.widget.SuperSlidingPaneLayout;

/**
 * @author Jenly <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * @since 2017/1/16
 */
public class KSSlidingPaneLayout extends SuperSlidingPaneLayout {

    private float mInitialMotionX;
    private float mInitialMotionY;
    private float mEdgeSlop;


    public KSSlidingPaneLayout(Context context) {
        this(context,null);
    }

    public KSSlidingPaneLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public KSSlidingPaneLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        ViewConfiguration config = ViewConfiguration.get(context);
        mEdgeSlop = config.getScaledEdgeSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        switch (MotionEventCompat.getActionMasked(ev)) {
            case MotionEvent.ACTION_DOWN: {
                mInitialMotionX = ev.getX();
                mInitialMotionY = ev.getY();
                break;
            }

            case MotionEvent.ACTION_MOVE: {
                final float x = ev.getX();
                final float y = ev.getY();
                // The user should always be able to "close" the pane, so we only check
                // for child scrollability if the pane is currently closed.
                if (mInitialMotionX > mEdgeSlop && !isOpen() && canScroll(this, false,
                        Math.round(x - mInitialMotionX), Math.round(x), Math.round(y))) {

                    // How do we set super.mIsUnableToDrag = true?

                    // send the parent a cancel event
                    MotionEvent cancelEvent = MotionEvent.obtain(ev);
                    cancelEvent.setAction(MotionEvent.ACTION_CANCEL);
                    return super.onInterceptTouchEvent(cancelEvent);
                }
            }
        }

        return super.onInterceptTouchEvent(ev);
    }
}
