package com.example.fragmentodinamicoclase11;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentodinamicoclase11.databinding.FragmentLosserBinding;
import com.example.fragmentodinamicoclase11.databinding.FragmentWinBinding;

public class LosserFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private FragmentLosserBinding fragmentLosserBinding;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private FragmentLosserBinding FragmentLosserBinding;


    public LosserFragment() {
        // Required empty public constructor
    }

    public static LosserFragment newInstance(String param1) {
        LosserFragment fragment = new LosserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentLosserBinding = FragmentLosserBinding.inflate(inflater,container,false);
        return FragmentLosserBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String perdiste = getString(R.string.perdiste, mParam1);
        FragmentLosserBinding.msjLoss.setText(perdiste);
    }
}