<template>
  <div>
      <h1>My Meal Plan</h1>
    <div class="week">
     
      <meal-plan-day class="day" id="sunday" v-on:recipeRemoved="getMealPlanRecipes" v-bind:mealPlanDay="{recipes: mealPlanRecipes.sunday, dayOfWeek: 1, dayName: 'Sun'}" />

      <meal-plan-day class="day" id="monday" v-on:recipeRemoved="getMealPlanRecipes" v-bind:mealPlanDay="{recipes: mealPlanRecipes.monday, dayOfWeek: 2, dayName: 'Mon'}" />

      <meal-plan-day class="day" id="tuesday" v-on:recipeRemoved="getMealPlanRecipes" v-bind:mealPlanDay="{recipes: mealPlanRecipes.tuesday, dayOfWeek: 3, dayName: 'Tue'}" />

      <meal-plan-day class="day" id="wednesday" v-on:recipeRemoved="getMealPlanRecipes" v-bind:mealPlanDay="{recipes: mealPlanRecipes.wednesday, dayOfWeek: 4, dayName: 'Wed'}" />

      <meal-plan-day class="day" id="thursday" v-on:recipeRemoved="getMealPlanRecipes" v-bind:mealPlanDay="{recipes: mealPlanRecipes.thursday, dayOfWeek: 5, dayName: 'Thu'}" />

      <meal-plan-day class="day" id="friday" v-on:recipeRemoved="getMealPlanRecipes" v-bind:mealPlanDay="{recipes: mealPlanRecipes.friday, dayOfWeek: 6, dayName: 'Fri'}" />

      <meal-plan-day class="day" id="saturday" v-on:recipeRemoved="getMealPlanRecipes" v-bind:mealPlanDay="{recipes: mealPlanRecipes.saturday, dayOfWeek: 7, dayName: 'Sat'}" />

     </div>

</div>


      <!--Button to add ingredients to Grocery List -->

</template>

<script>
import AppService from '../services/AppService';
import MealPlanDay from '../components/MealPlanDay.vue';


export default {
    components: {
      MealPlanDay,
    },
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
    }



</script>

<style scoped>
.week{
  display: flex;
  overflow-x: auto;
  /* grid-template-columns: repeat(7, 1fr);
  grid-template-areas: "sunday monday tuesday wednesday thursday friday saturday"; */
  width: 100%;
  border: solid black;
  background-color: black;
  grid-gap: 1px;
}

#sunday{
  grid-area: sunday;
  background-color: white;
}
#monday{
  grid-area: monday;
  background-color: white;
}
#tuesday{
  grid-area: tuesday;
  background-color: white;
}
#wednesday{
  grid-area: wednesday;
  background-color: white;
}
#thursday{
  grid-area: thursday;
  background-color: white;
}
#friday{
  grid-area: friday;
  background-color: white;
}
#saturday{
  grid-area: saturday;
  background-color: white;
}

.week::-webkit-scrollbar {
  width: 16px;
}

.week::-webkit-scrollbar-track {
  background-color: rgb(255, 255, 255);
  border-radius: 100px;
}

.week::-webkit-scrollbar-thumb {
  background: url('../assets/rolling-pin.png');
  background-repeat: space;
  background-size: contain, contain;
  background-position: center bottom, center;
  background-color: rgb(240, 226, 209);
  border-radius: 100px;
}
</style>