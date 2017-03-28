package com.mobileappscompany.training.mymyrecyclersqliteapp;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseHandler db;
    private RecyclerView recyclerView;
    private List<Car> carList;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHandler(this);
        carList = db.getAllCars();

        imageView = (ImageView) findViewById(R.id.imageView);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.hasFixedSize();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        CarAdapter myRecyclerAdapter = new CarAdapter(carList);
        recyclerView.setAdapter(myRecyclerAdapter);

        imageView.getLayoutParams().width=300;
        imageView.getLayoutParams().height=300;
        imageView.requestLayout();

        Glide.with(this).load("https://images4.alphacoders.com/179/thumb-1920-179936.jpg").into(imageView);
    }

    public void loadCarInfo(View view) {
        LinearLayout linearLayout = (LinearLayout) view.getParent();
        TextView indexTextView = (TextView) ((LinearLayout)linearLayout.getChildAt(0)).getChildAt(0);

        imageView.getLayoutParams().width=300;
        imageView.getLayoutParams().height=300;
        imageView.requestLayout();

        Glide.with(this).load(carList.get(Integer.valueOf(indexTextView.getText().toString())).getPhoto()).into(imageView);
    }
}
