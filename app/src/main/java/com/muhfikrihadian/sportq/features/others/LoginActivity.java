package com.muhfikrihadian.sportq.features.others;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.muhfikrihadian.sportq.R;
import com.muhfikrihadian.sportq.features.home.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.txtRegister)
    TextView txtRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.btnLogin, R.id.txtRegister})
    void onClick(View v) {
        if(v.getId() == R.id.btnLogin){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.txtRegister){
            Toast.makeText(this, "Register", Toast.LENGTH_SHORT).show();
        }
    }
}
