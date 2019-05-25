package com.haerul.foodsapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class Meals{

	@SerializedName("meals")
	private List<MealsItem> meals;

	public void setMeals(List<MealsItem> meals){
		this.meals = meals;
	}

	public List<MealsItem> getMeals(){
		return meals;
	}

	@Override
 	public String toString(){
		return 
			"Meals{" + 
			"meals = '" + meals + '\'' + 
			"}";
		}
}