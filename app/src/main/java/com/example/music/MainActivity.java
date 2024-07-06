package com.example.music;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "MyPrefs";
    private static final String PRIVACY_AGREED = "privacy_agreed";

    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean privacyAgreed = sharedPreferences.getBoolean(PRIVACY_AGREED, false);

        if (privacyAgreed) {
            // 用户已经同意隐私政策，直接进入主活动
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
        } else {
            // 显示隐私政策对话框
            showPrivacyDialog();
        }

    }

    private void showPrivacyDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.dialog);
        View view = getLayoutInflater().inflate(R.layout.splash_privacy_dialog, null);
        builder.setView(view);
        dialog = builder.create();

        Button btnAgree = view.findViewById(R.id.btn_agree);
        TextView tvDisagree = view.findViewById(R.id.tv_disagree);

        btnAgree.setOnClickListener(v -> {
            SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(PRIVACY_AGREED, true);
            editor.apply();
            // 同意跳转首页
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        });

        tvDisagree.setOnClickListener(v -> {
            // 不同意退出APP
            Toast.makeText(this, "已退出", Toast.LENGTH_SHORT).show();
            finish();
        });

        // 富文本设置
        SpannableString spannableString = new SpannableString("欢迎使用音乐社区，我们将严格遵守相关法律和隐私政策保护您的个人隐私，请您阅读并同意《用户协议》与《隐私政策》。");
        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(MainActivity.this, "查看用户协议", Toast.LENGTH_SHORT).show();
            }
        };

        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(MainActivity.this, "查看隐私协议", Toast.LENGTH_SHORT).show();
            }
        };
        spannableString.setSpan(clickableSpan1, 41, 46, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        spannableString.setSpan(clickableSpan2, 48, 54, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        TextView textView = view.findViewById(R.id.dialog_text);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        dialog.setCancelable(false);
        dialog.show();
    }
}