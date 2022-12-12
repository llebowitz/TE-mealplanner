<template>
  <div>
      <!-- <h2>Sunday</h2>
      <ul>
        <li v-for="(recipe, index) in mealPlanRecipes.sunday" v-bind:key="index">{{recipe.name}}</li>
      </ul> -->
      <h1>My Meal Plan</h1>
    <div class="table">
      <table>
        <thead>
     <tr>
          <th>Sunday</th>
          <th>Monday</th>
          <th>Tuesday</th>
          <th>Wednesday</th>
          <th>Thursday</th>
          <th>Friday</th>
          <th>Saturday</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td v-for="(recipe, index) in mealPlanRecipes.sunday" v-bind:key="index">{{recipe.name}}</td>
        <td v-for="(recipe, index) in mealPlanRecipes.monday" v-bind:key="index">{{recipe.name}}</td>
        <td v-for="(recipe, index) in mealPlanRecipes.tuesday" v-bind:key="index">{{recipe.name}}</td>
        <td v-for="(recipe, index) in mealPlanRecipes.wednesday" v-bind:key="index">{{recipe.name}}</td>
        <td v-for="(recipe, index) in mealPlanRecipes.thursday" v-bind:key="index">{{recipe.name}}</td>
        <td v-for="(recipe, index) in mealPlanRecipes.friday" v-bind:key="index">{{recipe.name}}</td>
        <td v-for="(recipe, index) in mealPlanRecipes.saturday" v-bind:key="index">{{recipe.name}}</td>
      </tr>
      </tbody>
      </table>

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
table, th, td{
  height: 50vh;
  border:1px black solid

}
</style>