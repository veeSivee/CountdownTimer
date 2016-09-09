package com.tes.vi.countdowntimer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainView  {

    TextView mTxtHour, mTxtMinute, mTxtSecond, mTxtDiff;
    Button btn_start;

    private static MainPresenter mMainPresenter;

    public MainActivity() {
        this.mMainPresenter = MainPresenterFactory.getInstance(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtHour = (TextView)findViewById(R.id.tv_hour);
        mTxtMinute = (TextView)findViewById(R.id.tv_minute);
        mTxtSecond = (TextView)findViewById(R.id.tv_second);
        mTxtDiff = (TextView)findViewById(R.id.tv_diff);
        btn_start = (Button)findViewById(R.id.btn_start);
        btn_start.setEnabled(false);

        try {
            mMainPresenter.getTimeNow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void buttonClick() {
    }

    @Override
    public void updateTime(String h, String m, String s) {
        mTxtHour.setText(h);
        mTxtMinute.setText(m);
        mTxtSecond.setText(s);
    }

    @Override
    public void showDiff(String diff) {
        mTxtDiff.setText(diff);
    }

    @Override
    public void showButton() {
        btn_start.setEnabled(true);
    }
}
