package com.example.a2activity.Fragments;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.a2activity.Adapters.Adapter;
import com.example.a2activity.Models.Model;
import com.example.a2activity.R;
import com.example.a2activity.Singup;

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
        models.add(new Model(R.drawable.muzeul_judetean,"Muzeul judetean","Muzeul Judeţean Argeş este instituţia muzeală argeşeană proeminentă care tezaurizează colecţii de obiecte remarcabile spre ilustrarea civilizaţiei argeşene şi româneşti."));
        models.add(new Model(R.drawable.manastirea_curtea_de_arges,"Manastirea Curtea de Arges","Una dintre cea mai încărcate spiritual, istoric și cultural, așezări din județul Argeș  este orașul Curtea de Argeș. Capitala a Țării Românești, Curtea de Argeș poartă cu sine  secole de istorie, civilizație și cultură, și  arată cu mândrie locuitorilor săi, dar și turiștilor care o vizitează minunile arhitecturale pe care le poseda."));
        models.add(new Model(R.drawable.download,"Lacul Vidraru", "Barajul Vidraru a fost construit pe raul Arges in 1965 fiind primul baraj construit in Romania. Este un baraj in arc cu inaltimea de 166,60 m, iar lungimea coronamentului este de 305 m. Grosimea barajului la baza este 25 m iar la coronament 6 m. Lacul, in conditii optime are o suprafata de 870 de hectare si 465 milioane metrii cubi de apa."));
        models.add(new Model(R.drawable.drum,"Transfagrasan","Un drum magic…asta reprezintă șoseaua printre munții Făgărașului, ce începe din localitatea Bascov, județul Argeș, și se termină în apropierea localității Cârțișoara, județul Sibiu. Te lasă pur și simplu fără răsuflare, fără cuvinte și profund impresionat toată această împrejmuire."));
        models.add(new Model(R.drawable.valea_rea,"Valea rea","Valea Rea este o vale orientată nord-sud din partea sudică a munților Făgăraș din județul Argeș. Valea, prin care curge cursul de apă omonim, râul Valea Rea, este una din căile de acces cele mai directe, dar și cele mai dificile, către cel mai înalt vârf montan din România, vârful Vârful Moldoveanu."));
        models.add(new Model(R.drawable.golesti,"Muzeul Golesti","Situat în orașul Ștefănești, la doar 10 kilometri de Pitești, pe șoseaua veche Pitești - București, Muzeul Viticulturii și Pomiculturii Golești este o adevărată bijuterie a meleagurilor argeșene, fiind un loc încărcat de istorie și tradiții populare."));

        btnSeemore=view.findViewById(R.id.btnSeemore);

        adapter = new Adapter(models, getContext());

        viewPager=view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] colors_temp={
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };

        colors=colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if(position<(adapter.getCount()-1) && position <(colors.length -1)){
                    int color = (Integer) argbEvaluator.evaluate(
                            positionOffset,
                            colors[position],
                            colors[position + 1]
                    );
                }
                else{
                    viewPager.setBackgroundColor(colors[colors.length-1]);
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        btnSeemore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });





        //ViewPager viewPager= view.findViewById(R.id.viewPager);

        //Adapter adapter=new Adapter((FragmentActivity) getContext());
       // viewPager.setAdapter(adapter);

        return view;
    }


}