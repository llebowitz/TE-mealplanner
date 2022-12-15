<template>
	<!-- Note: Routes to Saved Recipes and Meal Plan go in here! -->
    <div>
    
        <meal-plan ref="mealPlan" />
        
        <view-grocery-list />
        <my-recipes @get-meal-plan-recipes="refreshMealPlans()"></my-recipes>
        <br>
        <add-recipe />
        
    </div>
</template>

<script>
import AddRecipe from '../components/AddRecipe.vue';
import MealPlan from "../components/MealPlan.vue";
import MyRecipes from '../components/MyRecipes.vue';
// import SavedRecipeCard from '../components/SavedRecipeCard.vue';
import ViewGroceryList from '../components/ViewGroceryList.vue';




export default {
  components: { MealPlan,
    MyRecipes,
    ViewGroceryList,
    // SavedRecipeCard,
    AddRecipe
   
  
    }, 
    methods: {
        refreshMealPlans() {
            this.$refs.mealPlan.getMealPlanRecipes();
        }
    }


};


</script>

<style></style>
