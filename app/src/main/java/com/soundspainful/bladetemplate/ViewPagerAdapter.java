package com.soundspainful.bladetemplate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.AdapterViewHolder> {

    private ArrayList<RecyclerItem> itemList;

    public ViewPagerAdapter(ArrayList<RecyclerItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @NotNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new AdapterViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.recycler_item_view, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AdapterViewHolder holder, int position) {
        holder.setData(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView textFileName;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            textFileName = itemView.findViewById(R.id.tvRecItemName);
        }

        void setData(RecyclerItem recyclerItem) {
            textFileName.setText(recyclerItem.getItemName());
        }

    }

}
