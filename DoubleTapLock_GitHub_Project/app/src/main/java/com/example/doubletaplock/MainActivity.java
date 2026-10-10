package com.example.doubletaplock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(32, 48, 32, 32);
        layout.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView title = new TextView(this);
        title.setText("Double Tap to Lock");
        title.setTextSize(26);
        title.setPadding(0, 0, 0, 24);
        layout.addView(title);

        TextView info = new TextView(this);
        info.setText("To enable the service, open Accessibility Settings and turn on “Double Tap to Lock”.\n\nNote: Android requires Accessibility permission for screen-wide touch detection. On some phones, touch-exploration settings can change how taps and swipes work.");
        info.setTextSize(16);
        info.setPadding(0, 0, 0, 24);
        layout.addView(info, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        Button settingsButton = new Button(this);
        settingsButton.setText("Open Accessibility Settings");
        settingsButton.setOnClickListener(v ->
                startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)));
        layout.addView(settingsButton);

        setContentView(layout);
    }
}
