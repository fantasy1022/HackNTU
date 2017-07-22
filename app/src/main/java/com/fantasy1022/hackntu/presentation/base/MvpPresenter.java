package com.fantasy1022.hackntu.presentation.base;

/**
 * Created by fantasy_apple on 2017/7/22.
 */

public interface MvpPresenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
