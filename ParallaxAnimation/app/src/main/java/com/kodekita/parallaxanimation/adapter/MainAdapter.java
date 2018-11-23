package com.kodekita.parallaxanimation.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kodekita.parallaxanimation.activity.DemoActivity;
import com.kodekita.parallaxanimation.activity.DemoListActivity;
import com.kodekita.parallaxanimation.activity.DemoRecyclerActivity;
import com.kodekita.parallaxanimation.R;

public class MainAdapter extends BaseAdapter {
    private Context context;
    private int[] IMAGE;
    private String[] JUDUL;
    private String[] DESKRIPSI;

    public MainAdapter(Context context, int[] IMAGE, String[] JUDUL, String[] DESKRIPSI) {
        this.context = context;
        this.IMAGE = IMAGE;
        this.JUDUL = JUDUL;
        this.DESKRIPSI = DESKRIPSI;
    }

    @Override
    public int getCount() {
        return IMAGE.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.custom_list_layout, null);
            holder.icon = (ImageView) view.findViewById(R.id.iconList);
            holder.judul = (TextView) view.findViewById(R.id.judulList);
            holder.desk = (TextView) view.findViewById(R.id.deskripsiList);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        // Set isi item Pada Layout
        holder.icon.setImageResource(IMAGE[position]);
        holder.judul.setText(JUDUL[position]);
        holder.desk.setText(DESKRIPSI[position]);

        LinearLayout list = (LinearLayout) view.findViewById(R.id.listMenu);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 0) {
                    Intent intent = new Intent(context, DemoActivity.class);
                    context.startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(context, DemoListActivity.class);
                    context.startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(context, DemoRecyclerActivity.class);
                    context.startActivity(intent);
//                } else if (position == 3) {
//                    Intent intent = new Intent(context, AutoPagerActivity.class);
//                    context.startActivity(intent);
//                } else if (position == 4) {
//                    Intent intent = new Intent(context, BelajarDBActivity.class);
//                    context.startActivity(intent);
//                } else if (position == 5) {
//                    Intent intent = new Intent(context, DBImportActivity.class);
//                    context.startActivity(intent);
//                } else if (position == 6) {
////                    Intent intent = new Intent(context, MapsActivity.class);
////                    context.startActivity(intent);
//                } else if (position == 7) {
//                    Intent intent = new Intent(context, GalleryActivity.class);
//                    context.startActivity(intent);
//                } else if (position == 8) {
//                    Intent intent = new Intent(context, GPSActivity.class);
//                    context.startActivity(intent);
//                } else if (position == 9) {
////                    Intent intent = new Intent(context, LocateGooglePSActivity.class);
////                    context.startActivity(intent);
//                } else if (position == 10) {
//                    Intent intent = new Intent(context, TabViewMenuActivity.class);
//                    context.startActivity(intent);
//                } else if (position == 11) {
//                    Intent intent = new Intent(context, DrawerViewMenuActivity.class);
//                    context.startActivity(intent);
//                } else {
//
                }
            }
        });
        view.setTag(holder);
        return view;
    }

    class ViewHolder{
        ImageView icon;
        TextView judul,desk;
    }
}