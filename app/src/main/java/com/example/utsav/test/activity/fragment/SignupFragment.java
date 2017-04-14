package com.example.utsav.test.activity.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatSpinner;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.utsav.test.R;
import com.example.utsav.test.activity.MainActivity;
import com.example.utsav.test.activity.database.DatabaseHelper;
import com.example.utsav.test.activity.model.User;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignupFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private DatabaseHelper databaseHelper;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private AppCompatEditText etName, etEmail, etPassword, etConfirmPassword, etMobile;
    private AppCompatButton btnSignup;
    private AppCompatSpinner spnBatch;
    private RadioGroup rgIdentity, rgGender;
    private AppCompatRadioButton rbIdentity, rbGender, rbTeacher, rbStudent;


    public SignupFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignupFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SignupFragment newInstance(String param1, String param2) {
        SignupFragment fragment = new SignupFragment();
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
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        databaseHelper = new DatabaseHelper(getActivity());

        etName = (AppCompatEditText) view.findViewById(R.id.et_user);
        etEmail = (AppCompatEditText) view.findViewById(R.id.et_email);
        etPassword = (AppCompatEditText) view.findViewById(R.id.et_password);
        etConfirmPassword = (AppCompatEditText) view.findViewById(R.id.et_cfpassword);
        etMobile = (AppCompatEditText) view.findViewById(R.id.et_number);
        spnBatch = (AppCompatSpinner) view.findViewById(R.id.spn_batch);
        rgGender = (RadioGroup) view.findViewById(R.id.rg_gender);
        rgIdentity = (RadioGroup) view.findViewById(R.id.rg_identity);
        rbStudent = (AppCompatRadioButton) view.findViewById(R.id.rb_student1);
        rbTeacher = (AppCompatRadioButton) view.findViewById(R.id.rb_teacher1);
        rbTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spnBatch.setVisibility(View.GONE);
            }
        });
        rbStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spnBatch.setVisibility(View.VISIBLE);
            }
        });

        int selectGender = rgGender.getCheckedRadioButtonId();
        rbGender = (AppCompatRadioButton) view.findViewById(selectGender);
        int selectIdentity = rgIdentity.getCheckedRadioButtonId();
        rbIdentity = (AppCompatRadioButton) view.findViewById(selectIdentity);


        btnSignup = (AppCompatButton) view.findViewById(R.id.btn_signup);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();


            }
        });
    }

    private void registerUser() {
        String email = etEmail.getText().toString().trim();
        String name = etName.getText().toString();
        String mobile = etMobile.getText().toString().trim();
        String gender = rbGender.getText().toString();
        String identity = rbIdentity.getText().toString();
        String batch = spnBatch.getSelectedItem().toString();

        final String password = etPassword.getText().toString();
        String confirmPassword = etConfirmPassword.getText().toString();


        if (TextUtils.isEmpty(name)) {
            etName.setError("enter name");
            return;
        }
        if (TextUtils.isEmpty(email)) {
            etEmail.setError("enter email");
            Toast.makeText(getActivity(), "enter email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            etPassword.setText("enter password");
            Toast.makeText(getActivity(), "Enter password", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(confirmPassword)) {
            etConfirmPassword.setText("Enter Confirm password");
            Toast.makeText(getActivity(), "Enter Confirm Password", Toast.LENGTH_SHORT).show();
            return;
        }
        if (checkPassword() == true) {

            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setMobileNo(mobile);
            user.setGender(gender);
            user.setIdentity(identity);
            user.setBatchName(batch);
            databaseHelper.insertUserData(user);

            Toast.makeText(getActivity(), "Sucess", Toast.LENGTH_SHORT).show();
            SigninFragment signinFragmentFragment = SigninFragment.newInstance("", "");
            MainActivity mainActivity = (MainActivity) getActivity();
            mainActivity.addFragment(R.id.container, signinFragmentFragment);


        } else {
            Toast.makeText(getActivity(), "Password not same", Toast.LENGTH_SHORT).show();
        }


    }

    private boolean checkPassword() {
        String password, confirmPassword;
        password = etPassword.getText().toString();
        confirmPassword = etConfirmPassword.getText().toString();
        boolean answer = password.equals(confirmPassword);


        return answer;
    }
}
