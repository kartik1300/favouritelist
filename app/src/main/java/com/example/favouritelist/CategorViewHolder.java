package com.example.favouritelist;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CategorViewHolder extends RecyclerView.ViewHolder {
        private TextView categorynum,categorynam;
    public CategorViewHolder(View view){
        super(view);
        categorynam=view.findViewById(R.id.categoryitem);
        categorynum=view.findViewById(R.id.categorynumber);
    }

    public TextView getCategorynum() {
        return categorynum;
    }



    public TextView getCategorynam() {
        return categorynam;
    }


}

