<template>
  <div>
      <h2>Sunday</h2>
      <ul>
        <li v-for="(recipe, index) in mealPlanRecipes.sunday" v-bind:key="index">{{recipe.name}}</li>
      </ul>

     <tr>
          <th>Sun</th>
          <th>Mon</th>
          <th>Tue</th>
          <th>Wed</th>
          <th>Thi</th>
          <th>Fri</th>
          <th>Sat</th>
          
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>






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
            alert("Here are your recipes");
          }
          this.mealPlanRecipes = response.data;
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

</style>