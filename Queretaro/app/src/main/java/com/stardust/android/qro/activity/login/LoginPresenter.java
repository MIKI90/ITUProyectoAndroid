package com.stardust.android.qro.activity.login;

import android.support.v4.app.FragmentActivity;

import com.stardust.android.qro.model.User;
import com.stardust.android.qro.preferences.Preferences;
import com.stardust.android.qro.presenter.Presenter;


public class LoginPresenter extends Presenter<LoginPresenter.View> {

    private final FragmentActivity activity;

    public LoginPresenter(FragmentActivity activity) {
        this.activity = activity;
    }


    public void loginRequest(String user, String password) {
        getView().showProgress();
        //TODO: Realizar peticion al servidor enviando las credenciales del usuario
        //
        //
        //
        //
        //

        if (true) {
            getView().hideProgress();
            saveUser();
            getView().loginSuccess();
        } else {
            getView().hideProgress();
            getView().errorMessage("Email incorrecto");
        }
    }

    private void saveUser() {
        Preferences.getInstance(activity).putUser(User.Builder()
                .userId(1)
                .build());
    }


    public interface View extends Presenter.View {

        void showProgress();

        void hideProgress();

        void errorMessage(String message);

        void loginSuccess();
    }
}