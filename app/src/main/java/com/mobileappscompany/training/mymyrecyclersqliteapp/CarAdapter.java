package com.mobileappscompany.training.mymyrecyclersqliteapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 2/9/2017.
 */

public class CarAdapter extends RecyclerView.Adapter <CarAdapter.CarViewHolder> {

    private List<Car> cars;

    public CarAdapter(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_item, parent, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarViewHolder holder, int position) {
        Car client = cars.get(position);
        holder.index.setText(String.valueOf(position));
        holder.name.setText(client.getName());
        holder.dealer.setText(client.getDealer());
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public class CarViewHolder extends RecyclerView.ViewHolder {

        private TextView index;
        private TextView name;
        private TextView dealer;

        public CarViewHolder(View itemView) {
            super(itemView);
            index = (TextView) itemView.findViewById(R.id.textId);
            name = (TextView) itemView.findViewById(R.id.textName);
            dealer = (TextView) itemView.findViewById(R.id.textDealer);
        }
    }
}
