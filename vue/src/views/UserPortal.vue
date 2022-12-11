<template>
	<!-- Note: Routes to Saved Recipes and Meal Plan go in here! -->
    <div>

        <my-recipes />
        <meal-plan />
        
    </div>
</template>

<script>
import MealPlan from "../components/MealPlan.vue";
import MyRecipes from '../components/MyRecipes.vue';



export default {
  components: { MealPlan,
    MyRecipes
  
    }, 


};


</script>

<style></style>
