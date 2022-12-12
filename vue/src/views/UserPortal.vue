<template>
	<!-- Note: Routes to Saved Recipes and Meal Plan go in here! -->
    <div>
    
        <meal-plan ref="mealPlan" />
        <view-grocery-list />
        <my-recipes><saved-recipe-card @get-meal-plan-recipe="getMealPlanRecipes()"></saved-recipe-card></my-recipes>
   
       
        
    </div>
</template>

<script>
import MealPlan from "../components/MealPlan.vue";
import MyRecipes from '../components/MyRecipes.vue';
import SavedRecipeCard from '../components/SavedRecipeCard.vue';
import ViewGroceryList from '../components/ViewGroceryList.vue';




export default {
  components: { MealPlan,
    MyRecipes,
    ViewGroceryList,
    SavedRecipeCard,
   
  
    }, 
    methods: {
        refreshMealPlans() {
            this.$refs['mealPlans'].getMealPlanRecipes();
        }
    }


};


</script>

<style></style>
