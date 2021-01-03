package com.example.fragmentodinamicoclase11;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentodinamicoclase11.databinding.FragmentWinBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WinFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WinFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "name";
    private String name;
    private FragmentWinBinding FragmentWinBinding;


    public WinFragment() {
        // Required empty public constructor
    }

    public static WinFragment newInstance(String name) {
        WinFragment fragment = new WinFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override //inflar la vista del fragmento con view binding
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentWinBinding = FragmentWinBinding.inflate(inflater,container,false);
        return FragmentWinBinding.getRoot();
    }

    @Override//traer variabe del nombre
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String ganaste = getString(R.string.ganaste, name);
        FragmentWinBinding.msjWin.setText(ganaste);
    }
}