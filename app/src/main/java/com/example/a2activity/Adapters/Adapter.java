package com.example.a2activity.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.a2activity.Email;
import com.example.a2activity.Models.Model;
import com.example.a2activity.R;

import java.util.List;

public class Adapter extends PagerAdapter {

    private List<Model>models;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.item,container,false);

        ImageView imageView;
        TextView title,desc;
        Button btn;

        imageView=view.findViewById(R.id.image);
        title=view.findViewById(R.id.title);
        desc=view.findViewById(R.id.desc);
        btn = view.findViewById(R.id.btnSeeMore);

        imageView.setImageResource(models.get(position).getImage());
        title.setText(models.get(position).getTitle());
        desc.setText(models.get(position).getDescription());

        container.addView(view,0);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context, btn);
                // Inflating popup menu from popup_menu.xml file
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,
                        popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @SuppressLint("NonConstantResourceId")
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        // Toast message on menu item clicked
                        switch (menuItem.getItemId()){
                            case R.id.email:
                                Intent intent = new Intent(context, Email.class);
                                intent.putExtra("SBOras",models.get(position).getTitle());
                                intent.putExtra("MessageOras",models.get(position).getDescription()+ models.get(position).getURL() +" " );
                                context.startActivity(intent);
                                break;
                            case R.id.more:
                           gotoUrl(models.get(position).getURL());
                           break;
                        }
                        return true;
                    }

                    private void gotoUrl(String s) {
                        Uri uriUrl = Uri.parse(s);
                        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                        context.startActivity(launchBrowser);
                    }
                });
                // Showing the popup menu
                popupMenu.show();
            }
        });

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
