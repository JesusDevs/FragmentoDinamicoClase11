package com.example.fragmentodinamicoclase11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.fragmentodinamicoclase11.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        openTitleFragment(); //instanciar
    }

    private void openTitleFragment (){
        TitleFragment titleFragment = TitleFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().
                add(binding.contenedorMain.getId(),titleFragment,TitleFragment.class.getSimpleName());
                //.addToBackStack(null);
        fragmentTransaction.commit();

    }
}