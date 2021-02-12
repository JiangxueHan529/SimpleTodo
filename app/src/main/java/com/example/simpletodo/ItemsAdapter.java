package com.example.simpletodo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.Viewholder>{
    List<String> items;
    OnLongClickListener longClickListener;
    public interface OnLongClickListener{
        void onItemsLongClicked(int position);
    }

    public ItemsAdapter(List<String> items, OnLongClickListener longClickListener) {
        this.items = items;
        this.longClickListener = longClickListener;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View todoView = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_1,viewGroup, false);
        return new Viewholder(todoView);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int i) {
        String item = items.get(i);
        viewholder.bind(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{
    TextView tvItem;
     public Viewholder(@NonNull View itemView) {
         super(itemView);
         tvItem = itemView.findViewById(android.R.id.text1);
     }

     public void bind(String item){
        tvItem.setText(item);
        tvItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClickListener.onItemsLongClicked(getAdapterPosition());
                return true;
            }
        });
    }
 }

}
