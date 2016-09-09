package com.tes.vi.countdowntimer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainView  {

    TextView tv_hour,tv_minute,tv_second;
    Button btn_start;

    private static MainPresenter mMainPresenter;

    public MainActivity() {
        this.mMainPresenter = MainPresenterFactory.getInstance(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_hour = (TextView)findViewById(R.id.tv_hour);
        tv_minute = (TextView)findViewById(R.id.tv_minute);
        tv_second = (TextView)findViewById(R.id.tv_second);
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
        tv_hour.setText(h);
        tv_minute.setText(m);
        tv_second.setText(s);
    }

    @Override
    public void showButton() {
        btn_start.setEnabled(true);
    }
}
