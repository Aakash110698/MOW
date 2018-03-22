package com.snackhoop.mealsonwheels.view.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.firebase.auth.FirebaseAuth;
import com.snackhoop.mealsonwheels.R;
import com.snackhoop.mealsonwheels.presenter.LogInPresenter;
import com.snackhoop.mealsonwheels.presenter.ipresenter.ILogInPresenter;
import com.snackhoop.mealsonwheels.view.fragment.SignUpFragment;
import com.snackhoop.mealsonwheels.view.fragment.both_fragment;
import com.snackhoop.mealsonwheels.view.iview.ILogInView;

/**
 * Created by malavan on 22/03/18.
 */

public class LoginActivity extends BaseActivity<ILogInPresenter> implements ILogInView,FirebaseAuth.AuthStateListener{
    @NonNull
    @Override
    ILogInPresenter bindView(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        initialize();
        return new LogInPresenter(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView(savedInstanceState);
        if (savedInstanceState==null){
            android.support.v4.app.FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
            transaction.addToBackStack(null);
            transaction.add(R.id.login_container,new both_fragment()).commit();
        }
    }

    private void initialize() {

    }

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        if(firebaseAuth!=null){
            //TODO: Goto main activty

        }
    }
}
