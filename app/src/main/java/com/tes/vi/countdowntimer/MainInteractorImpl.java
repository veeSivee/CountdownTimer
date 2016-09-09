package com.tes.vi.countdowntimer;

import android.os.CountDownTimer;

import java.text.ParseException;

/**
 * Created by taufiqotulfaidah on 9/8/16.
 */
public class MainInteractorImpl implements MainInteractor {


    private long mHour, mMinute, mSecond, total;

    private MainProcessingListener mMainProcessingListener;

    @Override
    public void setMainProcessorListener(MainProcessingListener mainProcessorListener) {
        mMainProcessingListener = mainProcessorListener;
    }

    @Override
    public void getTimeNowIntr() throws ParseException {

        mHour = 0;
        mMinute = 1;
        mSecond = 1;

        setNewTime();

        timerUpdate();
    }

    @Override
    public String getHourIntr() {
        return String.valueOf(mHour);
    }

    @Override
    public String getMinuteIntr() {
        return String.valueOf(mMinute);
    }

    @Override
    public String getSecondIntr() {
        return String.valueOf(mSecond);
    }

    private void timerUpdate(){

        long totalTime = ((mHour*3600) + (mMinute*60) + (mSecond))*1000;

        CountDownTimer tim = new CountDownTimer(totalTime,1000) {
            @Override
            public void onTick(long l) {

                setNewTime();
                mMainProcessingListener.onUpdateTime();
            }

            @Override
            public void onFinish() {

                setNewTime();
                mMainProcessingListener.onUpdateTime();
                mMainProcessingListener.onFinishTime();
            }
        }.start();
    }

    private void setNewTime(){

        mSecond--;

        if(mSecond==0){

            mMinute--;

            if(mMinute>=0){
                mSecond = 59;
            }else{
                mMinute = 0;

                mHour--;

                if(mHour>=0){
                    mMinute = 59;
                    mSecond = 59;
                }else{
                    mHour = 0;
                }
            }

        }

    }
}
