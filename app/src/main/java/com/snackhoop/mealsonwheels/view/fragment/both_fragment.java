package com.snackhoop.mealsonwheels.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.snackhoop.mealsonwheels.R;
import com.snackhoop.mealsonwheels.view.activity.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class both_fragment extends Fragment implements View.OnClickListener{


    @BindView(R.id.get_started)
    Button getStarted;
    Unbinder unbinder;

    public both_fragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getStarted.setOnClickListener(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.signup_login_screen, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == getStarted.getId()){
          FragmentTransaction transaction =((LoginActivity)getActivity()).getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
            transaction.addToBackStack(null);
          transaction.add(R.id.login_container,new SignUpFragment()).commit();
        }
    }
}
