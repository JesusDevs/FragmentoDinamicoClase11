package com.example.fragmentodinamicoclase11;

import android.media.tv.TvContract;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fragmentodinamicoclase11.databinding.FragmentTitleBinding;


public class TitleFragment extends Fragment {
    private FragmentTitleBinding fragmentTitleBinding;


    public TitleFragment() {
        // Required empty public constructor
    }

    public static TitleFragment newInstance() {
        TitleFragment fragment = new TitleFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentTitleBinding = FragmentTitleBinding.inflate(inflater,container,false);
        return fragmentTitleBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentTitleBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!fragmentTitleBinding.editTextTextPersonName2.getText().toString().isEmpty()) {
                    addLogoTriviaFragment( fragmentTitleBinding.editTextTextPersonName2.getText().toString());
                } else {
                    Toast.makeText(getContext(), "ESCRIBE ALGO", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addLogoTriviaFragment (String name){
        LogoTriviaFragment logoTriviaFragment = LogoTriviaFragment.newInstance(name);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().
                replace(R.id.contenedor_main,logoTriviaFragment,LogoTriviaFragment.class.
                        getSimpleName()).addToBackStack(null);

        fragmentTransaction.commit();

    }
}