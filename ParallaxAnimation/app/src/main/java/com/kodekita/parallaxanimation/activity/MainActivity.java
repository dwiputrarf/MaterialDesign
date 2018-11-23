package com.kodekita.parallaxanimation.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ListView;

import com.kodekita.parallaxanimation.R;
import com.kodekita.parallaxanimation.adapter.MainAdapter;

public class MainActivity extends Activity {

    private Context mContext = this;
    private ListView listBerita;

    private int[] IMAGE = {
            R.mipmap.icon_education,
            R.mipmap.icon_education,
            R.mipmap.icon_education
//            R.mipmap.icon_company_office,
//            R.mipmap.icon_chevron,
//            R.mipmap.icon_education,
//            R.mipmap.icon_google,
//            R.mipmap.icon_cards_focus,
//            R.mipmap.icon_back,
//            R.mipmap.card_yes_button,
//            R.mipmap.eye_circle,
//            R.mipmap.eye_circle
    };

    private String[] JUDUL ={
            "Material Design : Ripple Effect on Button",
            "Material Design : Ripple Effect on ListView",
            "Material Design : Ripple Effect on RecyclerView"
//            "AutoScroll View Pager",
//            "SQLite Database",
//            "SQLite Database Advanced",
//            "Google Maps (Obsolete)",
//            "Gallery",
//            "Longitude Latitude",
//            "Location With Google Play Services (Obsolete)",
//            "Tab Menu Navigation",
//            "Drawer Menu Navigation"
    };

    private String[] DESKRIPSI = {
            "Ripple on button can be applied in xml or java.",
            "Ripple handling on a ListView handled by xml.",
            "Ripple handling on a ListView handled by the ViewHolder in java."
//            "AutoScroll Images with Glide",
//            "CRUD Simple DataBase (SQLite)",
//            "SQLite with Import Data",
//            "Standard Maps Interaction",
//            "A standard permission to camera and access gallery",
//            "GPS, COARSE & Internet for Acurate Location",
//            "Locatoin Find with Google Play Services",
//            "Simple Tab Menu Navigator",
//            "Simple Drawer Menu Navigator"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listBerita = (ListView) findViewById(R.id.listBerita);
        MainAdapter adapter = new MainAdapter(this, IMAGE,JUDUL,DESKRIPSI);
        listBerita.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
        alert.setMessage("Are You Sure Want to Exit?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setCancelable(false);
        AlertDialog showAlert = alert.create();
        showAlert.show();
    }
}
