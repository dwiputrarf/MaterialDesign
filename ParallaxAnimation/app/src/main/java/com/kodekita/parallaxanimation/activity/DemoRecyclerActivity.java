package com.kodekita.parallaxanimation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;
import com.kodekita.parallaxanimation.R;

import java.util.UUID;

public class DemoRecyclerActivity extends AppCompatActivity {

    private final static String[] data;

    static {
        data = new String[50];
        for (int i = 0; i < data.length; i++) {
            data[i] = UUID.randomUUID().toString();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_recycler);
        setTitle("Ripple Effect On RecyclerView");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter());
    }

    private static class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            final LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            return new MyViewHolder(
                    MaterialRippleLayout.on(inflater.inflate(R.layout.demo_recycler_item, viewGroup, false))
                            .rippleOverlay(true)
                            .rippleAlpha(0.2f)
                            .rippleColor(0xFF585858)
                            .rippleHover(true)
                            .create()
            );
        }
        @Override
        public void onBindViewHolder(MyViewHolder viewHolder, int i) {
            viewHolder.text.setText(data[i]);
        }

        @Override
        public int getItemCount() {
            return data.length;
        }
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnLongClickListener {

        TextView text;

        public MyViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(android.R.id.text1);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Rippled item: " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onLongClick(View v) {
            if (getAdapterPosition() % 2 == 0) {
                Toast.makeText(v.getContext(), "long item: " + getAdapterPosition() + " and not consumed",
                        Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
            Toast.makeText(v.getContext(), "long item: " + getAdapterPosition() + " and consumed", Toast.LENGTH_SHORT)
                    .show();
            return true;
        }
    }
}