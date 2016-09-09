package com.tes.vi.countdowntimer;

import android.content.Context;

/**
 * Created by taufiqotulfaidah on 9/8/16.
 */
public interface MainView {

    Context getContext();

    void buttonClick();

    void updateTime(String h, String m, String s);

    void showButton();
}
