package com.stardust.android.qro.activity.login;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.stardust.android.qro.R;

import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginPresenter.View {

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initPresenter();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initPresenter() {
        if (presenter == null) {
            presenter = new LoginPresenter(this);
        }
        presenter.setView(this);
    }

    @Override
    public void showProgress() {
        Toast.makeText(this, "Iniciando sesión", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProgress() {
        Toast.makeText(this, "Peticion terminada", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void errorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        //TODO: Enviar al usuario a una actividad especifica (MainActivity)
    }


    @OnClick(R.id.fab)
    public void loginRequest() {
        presenter.loginRequest("noemartinez", "123456789");
    }
}
