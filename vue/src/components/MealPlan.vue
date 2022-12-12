<template>
  <div>
      <h1>My Meal Plan</h1>
    <div class="week">
     
     <meal-plan-day v-on:recipeRemoved="getMealPlanRecipes" v-bind:mealPlanDay="{recipes: mealPlanRecipes.sunday, dayOfWeek: 1, dayName: 'Sun'}" />
     <!-- <div id="sunday">
      <div class="day">Sun</div>
        <ul class="recipe">
              <li v-for="(recipe, index) in mealPlanRecipes.sunday" v-bind:key="index">
                <router-link :to="{name: 'singleRecipe', params: {recipeId: recipe.id}}">{{recipe.name}}</router-link>
                  <button id="remove-button" v-on:click="removeFromDay({recipeID: recipe.id, dayOfWeek: 1})"><img class="remove-button" src="../assets/x-icon.png"></button>
              </li>
          </ul>
      </div> -->

      <meal-plan-day v-on:recipeRemoved="getMealPlanRecipes" v-bind:mealPlanDay="{recipes: mealPlanRecipes.monday, dayOfWeek: 2, dayName: 'Mon'}" />

      <div id="tuesday">
        <div class="day">Tues</div>
        <ul class="recipe">
          <li v-for="(recipe, index) in mealPlanRecipes.tuesday" v-bind:key="index"><router-link :to="{name: 'singleRecipe', params: {recipeId: recipe.id}}">{{recipe.name}}</router-link></li>
        </ul>
      </div>

      <div id="wednesday">
        <div class="day">Wed</div>
        <ul class="recipe">
          <li v-for="(recipe, index) in mealPlanRecipes.wednesday" v-bind:key="index"><router-link :to="{name: 'singleRecipe', params: {recipeId: recipe.id}}">{{recipe.name}}</router-link></li>
        </ul>
      </div>

      <div id="thursday">
        <div class="day">Thurs</div>
        <ul class="recipe">
          <li v-for="(recipe, index) in mealPlanRecipes.thursday" v-bind:key="index"><router-link :to="{name: 'singleRecipe', params: {recipeId: recipe.id}}">{{recipe.name}}</router-link></li>
        </ul>
      </div>

      <div id="friday">
        <div class="day">Fri</div>
        <ul class="recipe">
          <li v-for="(recipe, index) in mealPlanRecipes.friday" v-bind:key="index"><router-link :to="{name: 'singleRecipe', params: {recipeId: recipe.id}}">{{recipe.name}}</router-link></li>
        </ul>
      </div>

      <div id="saturday">
        <div class="day">Sat</div>
        <ul class="recipe">
          <li v-for="(recipe, index) in mealPlanRecipes.saturday" v-bind:key="index"><router-link :to="{name: 'singleRecipe', params: {recipeId: recipe.id}}">{{recipe.name}}</router-link></li>
        </ul>
      </div>
        <br>
        <br>

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
      },

      removeFromDay(recipe) {
        AppService.removeFromMealPlan(recipe).then((response) => {
          if(response.status === 204) {
            this.getMealPlanRecipes();
          }
        })
      }

      },

      created() {
        this.getMealPlanRecipes();
      }

      

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
  padding-left: 5px;
}

.recipe{
  color: blue;
  padding-left: 5px;
}

ul {
  list-style-image: url(../assets/carrot.png);
}

.remove-button{
  width: 10px;
  height: auto;
  margin-left: 5px;
}

</style>