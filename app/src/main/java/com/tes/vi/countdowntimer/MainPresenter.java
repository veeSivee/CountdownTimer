package com.tes.vi.countdowntimer;

/**
 * Created by taufiqotulfaidah on 9/8/16.
 */
public interface MainPresenter {

    void getTimeNow() throws Exception;

    String getHour();

    String getMinute();

    String getSecond();
}
