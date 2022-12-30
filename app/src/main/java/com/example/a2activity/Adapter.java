package com.example.a2activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;

public class Adapter extends PagerAdapter {


    public FragmentActivity ctx;
    private int[] ImageArray= new int[]{R.drawable.png_principala, R.drawable.primaria ,R.drawable.ramada, R.drawable.mall, R.drawable.strand ,R.drawable.lunca ,R.drawable.trivale};

    public Adapter(FragmentActivity context){ctx=context;}

    @Override
        public int getCount () {
            return ImageArray.length;
        }

    @Override
        public boolean isViewFromObject (@NonNull View view, @NonNull Object object){
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem (@NonNull ViewGroup container,int position){
            ImageView imageView = new ImageView(ctx);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(ImageArray[position]);
            container.addView(imageView, 0);
            return imageView;
        }

        @Override
        public void destroyItem (@NonNull ViewGroup container,int position, @NonNull Object object){
            container.removeView((ImageView) object);
        }


}
