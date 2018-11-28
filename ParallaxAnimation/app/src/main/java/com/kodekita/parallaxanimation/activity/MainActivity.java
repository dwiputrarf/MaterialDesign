package com.kodekita.parallaxanimation.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.kodekita.parallaxanimation.R;
import com.kodekita.parallaxanimation.adapter.MainAdapter;

public class MainActivity extends Activity {

    private Context mContext = this;
    private ListView listMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listMenu = (ListView) findViewById(R.id.listBerita);
        MainAdapter adapter = new MainAdapter(mContext);
        listMenu.setAdapter(adapter);
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