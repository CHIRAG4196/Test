package com.example.utsav.test.activity.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.utsav.test.R;
import com.example.utsav.test.activity.MainActivity;
import com.example.utsav.test.activity.NavigationActivity;


public class SigninFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private AppCompatButton btnSignin, btnSignup, btnReset, btnCancel;
    private AppCompatEditText etEmail, etPassword, etForgotPassword;
    private RadioGroup rgUser;
    private AppCompatRadioButton rbUser;
    private AppCompatTextView tvForgot;
    private SharedPreferences preferences;


    public SigninFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SigninFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SigninFragment newInstance(String param1, String param2) {
        SigninFragment fragment = new SigninFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signin, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        preferences = getActivity().getSharedPreferences("SignupFragment", Context.MODE_PRIVATE);

        if (preferences.getBoolean("login", false)) {

        } else {
            etEmail = (AppCompatEditText) view.findViewById(R.id.et_signin);
            etPassword = (AppCompatEditText) view.findViewById(R.id.et_password);
            btnSignin = (AppCompatButton) view.findViewById(R.id.btn_signin);
            btnSignup = (AppCompatButton) view.findViewById(R.id.btn_signup);

            tvForgot = (AppCompatTextView) view.findViewById(R.id.tv_forgot_pwd);
            rgUser = (RadioGroup) view.findViewById(R.id.rg_user);
            int selectedid = rgUser.getCheckedRadioButtonId();
            rbUser = (AppCompatRadioButton) view.findViewById(selectedid);

            listners();
            tvForgot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogForgot();
                }
            });

        }
    }

    private void listners() {
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignupFragment signupFragment = SignupFragment.newInstance("", "");
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.addFragment(R.id.container, signupFragment);

            }
        });

    }

    public void dialogForgot() {
        final String[] forgotPassword = new String[1];
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_forgot, null);
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
        alertDialog.setCancelable(false);

        btnReset = (AppCompatButton) view.findViewById(R.id.btn_forgot);
        etForgotPassword = (AppCompatEditText) view.findViewById(R.id.et_forgot);
        btnCancel = (AppCompatButton) view.findViewById(R.id.btn_cancel);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                forgotPassword[0] = etForgotPassword.getText().toString().trim();
                if (TextUtils.isEmpty(forgotPassword[0])) {
                    Toast.makeText(getActivity(), "Enter Register Email id", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getActivity(), "Email is sent", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

    }

    private void userLogin() {
        String email, password;
        email = etEmail.getText().toString().trim();
        password = etPassword.getText().toString();
        if (TextUtils.isEmpty(email)) {
            etEmail.setError("enter email");
            Toast.makeText(getActivity(), "ENter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getActivity(), "Enter Password", Toast.LENGTH_SHORT).show();
            etPassword.setError("enter password ");
            return;
        }
        if (email.equals(preferences.getString("email", "no value")) && password.equals(preferences.getString("password", "no value"))) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("login", true);
            editor.apply();
            startActivity(new Intent(getActivity(), NavigationActivity.class));
            getActivity().finish();

            return;
        }
    }
}
