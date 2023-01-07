package com.example.a2activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.a2activity.Fragments.AccountFragment;
import com.example.a2activity.Fragments.GalleryFragment;
import com.example.a2activity.Fragments.HomeFragment;
import com.example.a2activity.Fragments.InfoFragment;
import com.example.a2activity.Fragments.QuizFragment;
import com.example.a2activity.databinding.ActivitySecondactivityBinding;

public class Secondactivity extends AppCompatActivity {

    ActivitySecondactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item ->{

            switch (item.getItemId()){

                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.info:
                    replaceFragment(new InfoFragment());
                    break;
                case R.id.gallery:
                    replaceFragment(new GalleryFragment());
                    break;
                case R.id.quiz:
                    replaceFragment(new QuizFragment());
                    break;
                case R.id.accont:
                    replaceFragment(new AccountFragment());
                    break;

            }
           return true;

        });

    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();

    }

}