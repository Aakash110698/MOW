package com.snackhoop.mealsonwheels.view.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.snackhoop.mealsonwheels.R;
import com.snackhoop.mealsonwheels.model.UserDetails;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {


    @BindView(R.id.et_user_name)
    TextInputEditText etUserName;
    @BindView(R.id.et_user_mailid)
    TextInputEditText etUserMailid;
    @BindView(R.id.et_user_password)
    TextInputEditText etUserPassword;
    @BindView(R.id.signup_now_btn)
    Button signupNowBtn;
    @BindView(R.id.tv_already_acc_login)
    TextView tvAlreadyAccLogin;
    Unbinder unbinder;

    public SignInFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_near_by, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments()!=null){
            Bundle bundle = getArguments();
            UserDetails userDetails =bundle.getParcelable("user_details");
            filldetails(userDetails);
        }
    }

    private void filldetails(UserDetails userDetails) {
    etUserName.setText(userDetails.getName());
    etUserMailid.setText(userDetails.getEmail());

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.signup_now_btn)
    public void onViewClicked() {
        String email = etUserMailid.getText().toString();
        String userName = etUserName.getText().toString();
        String age = etUserPassword.getText().toString();
        String time = ""+System.currentTimeMillis();
        String password=1234+"";
        String city = "Trichy";
        UserDetails userDetails = new UserDetails(userName, FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber(),email,time,city,age);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        databaseReference.setValue(userDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getContext(),"Sorry",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
