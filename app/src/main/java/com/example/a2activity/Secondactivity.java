package com.example.a2activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.a2activity.Database.DBHelper;
import com.example.a2activity.Fragments.AccountFragment;
import com.example.a2activity.Fragments.GalleryFragment;
import com.example.a2activity.Fragments.HomeFragment;
import com.example.a2activity.Fragments.InfoFragment;
import com.example.a2activity.Fragments.QuizFragment;
import com.example.a2activity.databinding.ActivitySecondactivityBinding;

public class Secondactivity extends AppCompatActivity {

    ActivitySecondactivityBinding binding;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            String j =(String) b.get("username");
            username = j; //aici preiau username ul cu care m am conectat da?da
            //Toast.makeText(getBaseContext(), email, Toast.LENGTH_SHORT).show();
        }


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
                    //caut in baza de date emailul cu username ul cu care m am conectat
                    DBHelper db = new DBHelper(getApplicationContext());
                    String[] values = db.CheckData(username);
                    Bundle bundle= new Bundle();
                    bundle.putString("username", values[0]);
                    bundle.putString("email", values[1]); //trebuie cautat in baza de date mai intai

                    Fragment fragment = new AccountFragment();
                    fragment.setArguments(bundle);

                    //acum trebuie cauti in baza de date emailul aferent username ului si sa ii dai pass
                    //prin putString
                    replaceFragment(fragment);
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