<template>
	<!-- Note: Routes to Saved Recipes and Meal Plan go in here! -->
    <div>
    
        <meal-plan ref="mealPlan" />
        <view-grocery-list />
        <my-recipes @recipe-added="refreshMealPlans"/>
   
       
        
    </div>
</template>

<script>
import MealPlan from "../components/MealPlan.vue";
import MyRecipes from '../components/MyRecipes.vue';
import ViewGroceryList from '../components/ViewGroceryList.vue';




export default {
  components: { MealPlan,
    MyRecipes,
    ViewGroceryList,
   
  
    }, 
    methods: {
        refreshMealPlans() {
            this.$refs['mealPlans'].getMealPlanRecipes();
        }
    }


};


</script>

<style></style>
