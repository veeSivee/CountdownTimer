package com.tes.vi.countdowntimer;

import java.text.ParseException;

/**
 * Created by taufiqotulfaidah on 9/8/16.
 */
public interface MainInteractor {

    void setMainProcessorListener(MainProcessingListener mainProcessorListener);

    void getTimeNowIntr() throws ParseException;

    String getHourIntr();

    String getMinuteIntr();

    String getSecondIntr();
}
