package com.stardust.android.qro.presenter;

public class Presenter<T extends Presenter.View> {

    protected T view;

    public void setView(T view) {
        this.view = view;
    }

    public T getView() {
        return view;
    }

    public interface View {

    }
}
