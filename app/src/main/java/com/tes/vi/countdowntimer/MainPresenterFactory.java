package com.tes.vi.countdowntimer;

/**
 * Created by taufiqotulfaidah on 9/8/16.
 */
public class MainPresenterFactory {

    public static MainPresenter getInstance(MainView mainView){
        MainInteractor mainInteractor = new MainInteractorImpl();
        MainPresenterImpl mainPresenter = new MainPresenterImpl(mainView,mainInteractor);
        mainInteractor.setMainProcessorListener(mainPresenter);
        return mainPresenter;
    }
}
