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

        Button btnSeemore;
        models=new ArrayList<>();
        models.add(new Model(R.drawable.muzeul_judetean,"Muzeul judetean",getString(R.string.DescMuzeuJudetean),getString(R.string.UrlMuzeulJudetean)));
        models.add(new Model(R.drawable.manastirea_curtea_de_arges,"Manastirea Curtea de Arges",getString(R.string.DescCurteaDeArges),getString(R.string.UrlCurteaDeArges)));
        models.add(new Model(R.drawable.download,"Lacul Vidraru", getString(R.string.DescLaculVidraru),getString(R.string.UrlLaculVidraru)));
        models.add(new Model(R.drawable.drum,"Transfagrasan",getString(R.string.DescTransfagrasan),getString(R.string.UrlTransfagrasan)));
        models.add(new Model(R.drawable.valea_rea,"Valea rea",getString(R.string.DescValeaRea),getString(R.string.UrlValeaRea)));
        models.add(new Model(R.drawable.golesti,"Muzeul Golesti",getString(R.string.DescGolesti),getString(R.string.UrlMuzeulGolesti)));

      //  btnSeemore=view.findViewById(R.id.btnSeeMore);


        adapter = new Adapter(models, getContext());

        viewPager=view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

//        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//                if(position<(adapter.getCount()-1) && position <(colors.length -1)){
//                    int color = (Integer) argbEvaluator.evaluate(
//                            positionOffset,
//                            colors[position],
//                            colors[position + 1]
//                    );
//                }
//                else{
//                    viewPager.setBackgroundColor(colors[colors.length-1]);
//                }
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });







        //ViewPager viewPager= view.findViewById(R.id.viewPager);

        //Adapter adapter=new Adapter((FragmentActivity) getContext());
       // viewPager.setAdapter(adapter);

        return view;
    }


}