package com.example.favouritelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategorViewHolder> {

    //String [] categories={"Hobbies","Sports","games","food","rajma","chaawal","india","countries","hanuman","gghgames","fghgood","gameghs","food","games","food","games","food","games","food","games","food","games","food","games","food","games","food","games","food","games","food","games","food","games","food","games","food","games","food","games","food","games","food","games","food","games","food","games","food","games","food","games","food"};
    private ArrayList<Category> categories;

    public CategoryRecyclerAdapter(ArrayList<Category> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater  layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.category_viewholder,parent,false);
        return new CategorViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CategorViewHolder holder, int position) {
    holder.getCategorynum().setText(position+"");
    holder.getCategorynam().setText(categories.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public void addCategory(Category category){
        categories.add(category);
        notifyItemInserted(categories.size()-1);
    }
}
