/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 3/17/19 5:24 AM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.haerul.foodsapp.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.haerul.foodsapp.R;
import com.haerul.foodsapp.Utils;
import com.haerul.foodsapp.adapter.RecyclerViewHomeAdapter;
import com.haerul.foodsapp.adapter.ViewPagerHeaderAdapter;
import com.haerul.foodsapp.model.Categories;
import com.haerul.foodsapp.model.Category;
import com.haerul.foodsapp.model.Meals;
import com.haerul.foodsapp.model.MealsItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

// TODO 31 implement the HomeView interface at the end
public class HomeActivity extends AppCompatActivity implements HomeView {

   @BindView(R.id.recyclerCategory)
   RecyclerView recyclerViewCategory;

   @BindView(R.id.viewPagerHeader)
   ViewPager viewPager;

   HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       ButterKnife.bind(this);
         presenter = new HomePresenter(this);
         presenter.getMeals();
         presenter.getCategories();

    }

    @Override
    public void showLoading() {
        findViewById(R.id.shimmerMeal).setVisibility(View.VISIBLE);
        findViewById(R.id.shimmerCategory).setVisibility(View.VISIBLE);

    }

    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(this,"Title", message);
    }

    @Override
    public void hideLoading() {
        findViewById(R.id.shimmerMeal).setVisibility(View.GONE);
        findViewById(R.id.shimmerCategory).setVisibility(View.GONE);
    }

    @Override
    public void setMeal(List<MealsItem> mealsItems) {
     ViewPagerHeaderAdapter viewPagerHeaderAdapter= new ViewPagerHeaderAdapter(mealsItems,this);
     viewPager.setAdapter(viewPagerHeaderAdapter);
     viewPager.setPadding(20,0,150,0);
     viewPagerHeaderAdapter.notifyDataSetChanged();

     viewPagerHeaderAdapter.setOnItemClickListener(new ViewPagerHeaderAdapter.ClickListener() {
         @Override
         public void onClick(View v, int position) {
             Toast.makeText(HomeActivity.this, "" + mealsItems.get(position).getStrMeal(), Toast.LENGTH_SHORT).show();
         }
     });
    }

    @Override
    public void setCategories(List<Category> categories) {
        RecyclerViewHomeAdapter recyclerViewHomeAdapter= new RecyclerViewHomeAdapter(categories,this);
        recyclerViewCategory.setAdapter(recyclerViewHomeAdapter);
        recyclerViewCategory.setLayoutManager(new GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false));
        recyclerViewCategory.setNestedScrollingEnabled(true);
        recyclerViewHomeAdapter.notifyDataSetChanged();

        recyclerViewHomeAdapter.setOnItemClickListener(new RecyclerViewHomeAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(HomeActivity.this, "" + categories.get(position).getStrCategory(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
