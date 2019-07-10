package com.saifi369.firebaseauthapp;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout mEmailLayout, mPasswordLayout;
    private Button mBtnSignin, mBtnRegisterUser;
    private TextView mOutputText;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initViews();

        mBtnSignin.setOnClickListener(this::singInUser);
        mBtnRegisterUser.setOnClickListener(this::createUser);

    }

    private void singInUser(View view) {

        if (!validateEmailAddress() | !validatePassword()) {
            // Email or Password not valid,
            return;
        }
        //Email and Password valid, sign in user here

    }

    private void createUser(View view) {

        if (!validateEmailAddress() | !validatePassword()) {
            // Email or Password not valid,
            return;
        }
        //Email and Password valid, create user here


    }

    private void initViews() {
        mEmailLayout = findViewById(R.id.et_email);
        mPasswordLayout = findViewById(R.id.et_password);
        mBtnSignin = findViewById(R.id.btn_singin);
        mBtnRegisterUser = findViewById(R.id.btn_registeruser);
        mOutputText = findViewById(R.id.tv_output);
        mProgressBar = findViewById(R.id.progressbar);
    }

    private boolean validateEmailAddress() {

        String email = mEmailLayout.getEditText().getText().toString().trim();

        if (email.isEmpty()) {
            mEmailLayout.setError("Email is required. Can't be empty.");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmailLayout.setError("Invalid Email. Enter valid email address.");
            return false;
        } else {
            mEmailLayout.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {

        String password = mPasswordLayout.getEditText().getText().toString().trim();

        if (password.isEmpty()) {
            mPasswordLayout.setError("Password is required. Can't be empty.");
            return false;
        } else if (password.length() < 6) {
            mPasswordLayout.setError("Password length short. Minimum 6 characters required.");
            return true;
        } else {
            mPasswordLayout.setError(null);
            return true;
        }
    }

    private void showProgressBar() {
        mProgressBar.setIndeterminate(true);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}
