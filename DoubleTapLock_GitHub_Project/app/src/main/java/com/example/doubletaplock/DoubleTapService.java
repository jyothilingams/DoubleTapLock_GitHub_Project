package com.example.doubletaplock;

import android.accessibilityservice.AccessibilityService;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import android.os.SystemClock;

public class DoubleTapService extends AccessibilityService {
    private long lastTapTime = 0L;
    private float lastTapX = 0f;
    private float lastTapY = 0f;
    private static final long DOUBLE_TAP_MS = 350L;
    private static final float TAP_DISTANCE_PX = 80f;

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        // Touch input is handled in onMotionEvent.
    }

    @Override
    public void onInterrupt() {
        // No ongoing operation to interrupt.
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
    }

    @Override
    public void onMotionEvent(MotionEvent event) {
        if (event == null || event.getActionMasked() != MotionEvent.ACTION_UP) {
            return;
        }

        long now = SystemClock.uptimeMillis();
        float x = event.getX();
        float y = event.getY();

        if (now - lastTapTime <= DOUBLE_TAP_MS
                && Math.abs(x - lastTapX) <= TAP_DISTANCE_PX
                && Math.abs(y - lastTapY) <= TAP_DISTANCE_PX) {
            lastTapTime = 0L;
            performGlobalAction(GLOBAL_ACTION_LOCK_SCREEN);
        } else {
            lastTapTime = now;
            lastTapX = x;
            lastTapY = y;
        }
    }
}
