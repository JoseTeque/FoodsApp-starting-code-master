/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 3/17/19 5:24 AM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.haerul.foodsapp.view.home;

import com.haerul.foodsapp.model.Categories;
import com.haerul.foodsapp.model.Category;
import com.haerul.foodsapp.model.Meals;
import com.haerul.foodsapp.model.MealsItem;

import java.util.List;

public interface HomeView {

    void showLoading();
    void onErrorLoading(String message);
    void hideLoading();
    void setMeal(List<MealsItem> mealsItems);
    void setCategories(List<Category> categories);

}
