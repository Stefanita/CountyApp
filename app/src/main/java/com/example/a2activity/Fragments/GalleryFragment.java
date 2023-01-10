package com.example.a2activity.Fragments;

import android.animation.ArgbEvaluator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.a2activity.Adapters.Adapter;
import com.example.a2activity.Email;
import com.example.a2activity.Models.Model;
import com.example.a2activity.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GalleryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GalleryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors=null;
    ArgbEvaluator argbEvaluator=new ArgbEvaluator();

    //private Adapter adapter;

    public GalleryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GallaryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
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
        View view= inflater.inflate(R.layout.fragment_gallery, container, false);


        models=new ArrayList<>();
        models.add(new Model(getString(R.string.urlMuzJudeteanAgPoza),"Muzeul judetean",getString(R.string.DescMuzeuJudetean),getString(R.string.UrlMuzeulJudetean)));
        models.add(new Model(getString(R.string.urlManastireaArgesPoza),"Manastirea Curtea de Arges",getString(R.string.DescCurteaDeArges),getString(R.string.UrlCurteaDeArges)));
        models.add(new Model(getString(R.string.urlVidraruPoza),"Lacul Vidraru", getString(R.string.DescLaculVidraru),getString(R.string.UrlLaculVidraru)));
        models.add(new Model(getString(R.string.urlTransfPoza),"Transfagrasan",getString(R.string.DescTransfagrasan),getString(R.string.UrlTransfagrasan)));
        models.add(new Model(getString(R.string.urlValeaReaPoza),"Valea rea",getString(R.string.DescValeaRea),getString(R.string.UrlValeaRea)));
        models.add(new Model(getString(R.string.UrlMuzeulGolesti),"Muzeul Golesti",getString(R.string.DescGolesti),getString(R.string.UrlMuzeulGolesti)));



        adapter = new Adapter(models, getContext());

        viewPager=view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);


        return view;
    }


}