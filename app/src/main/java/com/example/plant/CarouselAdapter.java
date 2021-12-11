package com.example.plant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.CaraouselViewAdapter> {

    private List<CarouselItem> carouselitems;

    private ViewPager2 viewPager2;

    public CarouselAdapter(List<CarouselItem> carouselitems, ViewPager2 viewPager2){
        this.carouselitems = carouselitems;
        this.viewPager2= viewPager2;
    }


    @NonNull
    @Override
    public CaraouselViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CaraouselViewAdapter(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.carousel_item_discovery,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull CaraouselViewAdapter holder, int position) {
        holder.setImage(carouselitems.get(position));
    }

    @Override
    public int getItemCount() {
        return carouselitems.size();
    }

    class CaraouselViewAdapter extends RecyclerView.ViewHolder{

        private RoundedImageView imageView;

        CaraouselViewAdapter(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageSlide);
        }

        void setImage(CarouselItem carouselItem){
            imageView.setImageResource(carouselItem.getImage());
        }
    }
}
