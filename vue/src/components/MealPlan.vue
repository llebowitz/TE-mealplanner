<template>
  <div>
      <h1>My Meal Plan</h1>
    <div class="week">
     
     <meal-plan-day class="sunday" v-on:recipeRemoved="getMealPlanRecipes" v-bind:mealPlanDay="{recipes: mealPlanRecipes.sunday, dayOfWeek: 1, dayName: 'Sun'}" />

      <meal-plan-day class="monday" v-on:recipeRemoved="getMealPlanRecipes" v-bind:mealPlanDay="{recipes: mealPlanRecipes.monday, dayOfWeek: 2, dayName: 'Mon'}" />

      <meal-plan-day class="tuesday" v-on:recipeRemoved="getMealPlanRecipes" v-bind:mealPlanDay="{recipes: mealPlanRecipes.tuesday, dayOfWeek: 3, dayName: 'Tue'}" />

      <meal-plan-day class="wednesday" v-on:recipeRemoved="getMealPlanRecipes" v-bind:mealPlanDay="{recipes: mealPlanRecipes.wednesday, dayOfWeek: 4, dayName: 'Wed'}" />

      <meal-plan-day class="thursday" v-on:recipeRemoved="getMealPlanRecipes" v-bind:mealPlanDay="{recipes: mealPlanRecipes.thursday, dayOfWeek: 5, dayName: 'Thu'}" />

      <meal-plan-day class="friday" v-on:recipeRemoved="getMealPlanRecipes" v-bind:mealPlanDay="{recipes: mealPlanRecipes.friday, dayOfWeek: 6, dayName: 'Fri'}" />

      <meal-plan-day class="saturday" v-on:recipeRemoved="getMealPlanRecipes" v-bind:mealPlanDay="{recipes: mealPlanRecipes.saturday, dayOfWeek: 7, dayName: 'Sat'}" />
      
        <br>
        <br>

     </div>

</div>


      <!--Button to add ingredients to Grocery List -->

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

<style scoped>
.week{
  display: grid;
  grid-template-columns: repeat(7, 1fr);
  grid-template-areas: "sunday monday tuesday wednesday thursday friday saturday";
  width: 100%;
  border: solid black;
  border-left: hidden;
}

#sunday{
  grid-area: sunday;
}

#monday{
  grid-area: monday;
}

#tuesday{
  grid-area: tuesday;
}

#wednesday{
  grid-area: wednesday;
}

#thursday{
  grid-area: thursday;
}

#friday{
  grid-area: friday;
}

#saturday{
  grid-area: saturday;
}

.day{
  font-weight: bold;
  font-size: 30px;
  border-left: solid black;
  padding-left: 5px;
}

.recipe{
  color: blue;
  border-left: solid black;
  border-top: solid black;
  padding-left: 5px;
}

ul {
  list-style-image: url(../assets/carrot.png);
}

</style>