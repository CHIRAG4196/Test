package com.example.utsav.test.activity.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.utsav.test.R;
import com.example.utsav.test.activity.UpdateStudentDataActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeTeacherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeTeacherFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private AppCompatButton btnManageStudentRecord, btnTakeAttendance, btnViewAttendance, btnRateStudent;


    public HomeTeacherFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeTeacherFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeTeacherFragment newInstance(String param1, String param2) {
        HomeTeacherFragment fragment = new HomeTeacherFragment();
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
        return inflater.inflate(R.layout.fragment_home_teacher, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnManageStudentRecord = (AppCompatButton) view.findViewById(R.id.btn_manage_student_record);
        btnTakeAttendance = (AppCompatButton) view.findViewById(R.id.btn_take_attendance);
        btnRateStudent = (AppCompatButton) view.findViewById(R.id.btn_rate_student);
        btnViewAttendance = (AppCompatButton) view.findViewById(R.id.btn_view_attendance);

        btnManageStudentRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), UpdateStudentDataActivity.class));
            }
        });

    }
}
