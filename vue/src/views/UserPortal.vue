<template>
	<!-- Note: Routes to Saved Recipes and Meal Plan go in here! -->
    <div>
    
        <meal-plan ref="mealPlan" />
        <clear-meal-plan v-on:cleared="refreshMealPlans()"/>
        <view-grocery-list />
        <my-recipes @get-meal-plan-recipes="refreshMealPlans()"><saved-recipe-card ></saved-recipe-card></my-recipes>
   
       <add-recipe />
        
    </div>
</template>

<script>
import AddRecipe from '../components/AddRecipe.vue';
import ClearMealPlan from '../components/ClearMealPlan.vue';
import MealPlan from "../components/MealPlan.vue";
import MyRecipes from '../components/MyRecipes.vue';
import SavedRecipeCard from '../components/SavedRecipeCard.vue';
import ViewGroceryList from '../components/ViewGroceryList.vue';




export default {
  components: { MealPlan,
    MyRecipes,
    ViewGroceryList,
    SavedRecipeCard,
    AddRecipe,
    ClearMealPlan
   
  
    }, 
    methods: {
        refreshMealPlans() {
            this.$refs.mealPlan.getMealPlanRecipes();
        }
    }


};


</script>

<style></style>
