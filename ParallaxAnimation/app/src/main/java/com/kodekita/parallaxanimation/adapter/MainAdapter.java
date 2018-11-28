package com.kodekita.parallaxanimation.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kodekita.parallaxanimation.activity.DemoActivity;
import com.kodekita.parallaxanimation.activity.DemoListActivity;
import com.kodekita.parallaxanimation.activity.DemoRecyclerActivity;
import com.kodekita.parallaxanimation.R;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends BaseAdapter {
    private Context mContext;
    Intent intent;
    public static String[] listArray;
    public static String[] subTitleArray;

    public void setHomeActivitiesList(Context context) {
        listArray = context.getResources().getStringArray(R.array.home_list_title);
        subTitleArray = context.getResources().getStringArray(R.array.home_list_description);
    }

    public MainAdapter(Context context) {
        this.mContext = context;
        setHomeActivitiesList(context);
    }

    @Override
    public int getCount() {
        return listArray.length;
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
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
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

        holder.icon.setImageResource(R.mipmap.icon_cards_focus);
        holder.judul.setText(listArray[position]);
        holder.desk.setText(subTitleArray[position]);

        CardView list = (CardView) view.findViewById(R.id.listMenu);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position) {
                    case 0:
                        intent = new Intent(mContext, DemoActivity.class);
                        break;
                    case 1:
                        intent = new Intent(mContext, DemoListActivity.class);
                        break;
                    case 2:
                        intent = new Intent(mContext, DemoRecyclerActivity.class);
                        break;
                    default:
                        Toast.makeText(mContext, "Undefined Click!", Toast.LENGTH_SHORT).show();
                }

                if (intent != null)
                    mContext.startActivity(intent);
            }
        });
        view.setTag(holder);
        return view;
    }

    class ViewHolder {
        ImageView icon;
        TextView judul,desk;
    }
}