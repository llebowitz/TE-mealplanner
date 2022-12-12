<template>
  <div>
      <!-- <h2>Sunday</h2>
      <ul>
        <li v-for="(recipe, index) in mealPlanRecipes.sunday" v-bind:key="index">{{recipe.name}}</li>
      </ul> -->
      <h1>My Meal Plan</h1>
    <div class="day-of-week">
     
      <div>Sun</div>
      <div>Mon</div>
      <div>Tues</div>
      <div>Wed</div>
      <div>Thurs</div>
      <div>Fri</div>
      <div>Sat</div>

    <div class="day-grid">
     <ul>
       <li v-for="(recipe, index) in mealPlanRecipes.sunday" v-bind:key="index">{{recipe.name}}</li>
     </ul>
    
         </div>
     <ul>
       <li v-for="(recipe, index) in mealPlanRecipes.monday" v-bind:key="index">{{recipe.name}}</li>
     </ul>

     <ul>
       <li v-for="(recipe, index) in mealPlanRecipes.tuesday" v-bind:key="index">{{recipe.name}}</li>
     </ul>

       <ul>
       <li v-for="(recipe, index) in mealPlanRecipes.wednesday" v-bind:key="index">{{recipe.name}}</li>
     </ul>

     <ul>
       <li v-for="(recipe, index) in mealPlanRecipes.thursday" v-bind:key="index">{{recipe.name}}</li>
     </ul>

      <ul>
       <li v-for="(recipe, index) in mealPlanRecipes.friday" v-bind:key="index">{{recipe.name}}</li>
     </ul>

      <ul>
       <li v-for="(recipe, index) in mealPlanRecipes.saturday" v-bind:key="index">{{recipe.name}}</li>
     </ul>
   

    

   

   

</div>




      <!--Button to add ingredients to Grocery List -->
  </div>
</template>

<script>
import AppService from '../services/AppService'
export default {

    data() {
      return {
        mealPlanRecipes: [
        ],

      };
    },

    methods: {
      getMealPlanRecipes(){
        AppService.getMealPlanRecipes().then((response) => {
          if(response.status === 200){
            this.mealPlanRecipes = response.data;
          }
          
        })
      }

      },

      created() {
        this.getMealPlanRecipes();
      }

      // updateRecipeDay()

      // clearMP()

        
          // generateGroceryList()
    }



</script>

<style>
.day-of-week,
.day-grid{
  display: grid;
  grid-template-columns: repeat(7, 1fr);
}

.day-grid{
  font-size: 12px
}
</style>