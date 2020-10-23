package com.example.favouritelist;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class CategoryManager {
   private Context mcontext;
    SharedPreferences.Editor editor;
    SharedPreferences pref;
   public CategoryManager(Context context){
       mcontext=context;
      pref = PreferenceManager.getDefaultSharedPreferences(mcontext);
      editor=pref.edit();
   }
   public void setCategory(Category category){

       HashSet itemsset=new HashSet(category.getItems()) ;

       editor.putStringSet(category.getName(),itemsset);

       editor.apply();
   }
   public ArrayList<Category> retrievecategory(){
       ArrayList<Category>cc=new ArrayList<>();
       Map<String,?> data =pref.getAll();
       for(Map.Entry<String,?> entry:data.entrySet()){

           Category category=new Category(entry.getKey(),(ArrayList<String>) entry.getValue());
          cc.add(category);
       }
return cc;
   }


}
