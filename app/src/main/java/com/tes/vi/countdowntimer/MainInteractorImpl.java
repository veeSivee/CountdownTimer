package com.tes.vi.countdowntimer;

import android.os.CountDownTimer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by taufiqotulfaidah on 9/8/16.
 */
public class MainInteractorImpl implements MainInteractor {


    private long mHour, mMinute, mSecond, total;
    private String mDiffStr;

    private MainProcessingListener mMainProcessingListener;

    @Override
    public void setMainProcessorListener(MainProcessingListener mainProcessorListener) {
        mMainProcessingListener = mainProcessorListener;
    }

    @Override
    public void getTimeNowIntr() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = new Date(); //current date time
        Date date2 = sdf.parse("2016-09-31 06:30:00"); //ex : from server

        System.out.println(sdf.format(date1));
        System.out.println(sdf.format(date2));

        if(date1.after(date2)){
            System.out.println("Date1 is after Date2");
        }

        if(date1.before(date2)){
            System.out.println("Date1 is before Date2");

            long diff = date2.getTime() - date1.getTime();

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            mDiffStr = diffDays + " days  "
                    + diffHours + " : " // " hours, "
                    + diffMinutes +  " : " //" minutes, "
                    + diffSeconds; // +" seconds.";
        }

        if(date1.equals(date2)){
            System.out.println("Date1 is equal Date2");
        }

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

    @Override
    public String getDiff() {
        return mDiffStr;
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
