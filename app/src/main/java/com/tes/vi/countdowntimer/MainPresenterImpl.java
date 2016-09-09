package com.tes.vi.countdowntimer;

/**
 * Created by taufiqotulfaidah on 9/8/16.
 */
public class MainPresenterImpl implements MainPresenter, MainProcessingListener{

    private final MainView mMainView;
    private final MainInteractor mMainInteractor;



    public MainPresenterImpl(MainView mainView, MainInteractor mainInteractor){
        mMainView = mainView;
        mMainInteractor = mainInteractor;
    }

    @Override
    public void getTimeNow(){
        try{
            mMainInteractor.getTimeNowIntr();
        }catch (Exception e){}
    }

    @Override
    public String getHour() {
        return mMainInteractor.getHourIntr();
    }

    @Override
    public String getMinute() {
        return mMainInteractor.getMinuteIntr();
    }

    @Override
    public String getSecond() {
        return mMainInteractor.getSecondIntr();
    }

    //listener
    @Override
    public void onUpdateTime() {
        mMainView.updateTime(mMainInteractor.getHourIntr(),
                mMainInteractor.getMinuteIntr(),
                mMainInteractor.getSecondIntr());
        mMainView.showDiff(mMainInteractor.getDiff());
    }

    @Override
    public void onFinishTime() {
        mMainView.showButton();
    }
}
