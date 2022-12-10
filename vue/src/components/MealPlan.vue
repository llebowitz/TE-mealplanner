<template>
  <div>
      <h2>Sunday</h2>
      <ul>
        <!-- <li v-on="getMealPlanRecipes" v-for="recipe in recipes" v-bind:key="">{{recipe.name}}</li> -->


      </ul>






      <!--Button to add ingredients to Grocery List -->
  </div>
</template>

<script>
import AppService from '../services/AppService'
export default {

    props: ['recipe', 'mealplan'],

    methods: {
      getMealPlanRecipes(){
        AppService.getMealPlanRecipes().then((response) => {
          if(response.status === 200){
            alert("Here are your recipes");
          }
        })
      }

      }

      // updateRecipeDay()

      // clearMP()

        
          // generateGroceryList()
    }



</script>

<style>

</style>