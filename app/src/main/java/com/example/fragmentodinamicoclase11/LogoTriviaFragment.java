package com.example.fragmentodinamicoclase11;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragmentodinamicoclase11.databinding.FragmentLogoTriviaBinding;

public class LogoTriviaFragment extends Fragment {

    
    private static final String ARG_PARAM1 = "param1";
    private String name;
    int choice;
   
    private FragmentLogoTriviaBinding fragmentLogoTriviaBinding ;
    public LogoTriviaFragment() {
        // Required empty public constructor
    }

    public static LogoTriviaFragment newInstance(String param1) {
        LogoTriviaFragment fragment = new LogoTriviaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentLogoTriviaBinding=FragmentLogoTriviaBinding.inflate(inflater,container,false);
        return fragmentLogoTriviaBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String saludo = getString(R.string.saludo, name);
        fragmentLogoTriviaBinding.name.setText(saludo);

        fragmentLogoTriviaBinding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                View radioButton = fragmentLogoTriviaBinding.radioGroup.findViewById(i);
                int index = fragmentLogoTriviaBinding.radioGroup.indexOfChild(radioButton);
                switch (index) {
                    case 0:
                        choice = 0;
                        break;
                    case 1:
                        choice = 1;
                        break;
                    case 2:
                        choice = 2;
                        break;
                    case 3:
                        choice = 3;
                        break;
                    case 4:
                        choice = 4;
                        break;
                    default:
                        choice = 5;
                        break;

                }

            }
        });

        fragmentLogoTriviaBinding.sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice == 2) {
                    //TODO metodo fragmento ganador
                    addWinnerFragment(name);
                } else {
                    //TODO metodo fragmento perdedor
                    addLosserFragment(name);
                }
            }
        });
    }
     //TODO crear metodo fragmento ganador

    private void addWinnerFragment (String name){
        WinFragment winFragment = WinFragment.newInstance(name);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().
                replace(R.id.contenedor_main,winFragment,LogoTriviaFragment.class.
                        getSimpleName()).addToBackStack(null);
        fragmentTransaction.commit();

    }
    // TODO metodo fragmento perdedor
    private void addLosserFragment (String mParam1) {
        LosserFragment losserFragment = LosserFragment.newInstance(mParam1);
        FragmentManager fragmentManager =getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction().
            replace(R.id.contenedor_main,losserFragment,LogoTriviaFragment.class.getSimpleName()).addToBackStack(null);
        fragmentTransaction.commit();
    }

}