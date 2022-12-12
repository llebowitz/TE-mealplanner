<template>
  <div>
      <!-- <h2>Sunday</h2>
      <ul>
        <li v-for="(recipe, index) in mealPlanRecipes.sunday" v-bind:key="index">{{recipe.name}}</li>
      </ul> -->
      <h1>My Meal Plan</h1>
    <div class="week">
     
     <div id="sunday">
      <div class="day">Sun</div>
        <ul class="recipe">
              <li v-for="(recipe, index) in mealPlanRecipes.sunday" v-bind:key="index">{{recipe.name}}</li>
          </ul>
      </div>

      <div id="monday">
        <div class="day">Mon</div>
        <ul class="recipe">
              <li v-for="(recipe, index) in mealPlanRecipes.monday" v-bind:key="index">{{recipe.name}}</li>
          </ul>
      </div>

      <div id="tuesday">
        <div class="day">Tues</div>
        <ul class="recipe">
          <li v-for="(recipe, index) in mealPlanRecipes.tuesday" v-bind:key="index">{{recipe.name}}</li>
        </ul>
      </div>

      <div id="wednesday">
        <div class="day">Wed</div>
        <ul class="recipe">
          <li v-for="(recipe, index) in mealPlanRecipes.wednesday" v-bind:key="index">{{recipe.name}}</li>
        </ul>
      </div>

      <div id="thursday">
        <div class="day">Thurs</div>
        <ul class="recipe">
          <li v-for="(recipe, index) in mealPlanRecipes.thursday" v-bind:key="index">{{recipe.name}}</li>
        </ul>
      </div>

      <div id="friday">
        <div class="day">Fri</div>
        <ul class="recipe">
          <li v-for="(recipe, index) in mealPlanRecipes.friday" v-bind:key="index">{{recipe.name}}</li>
        </ul>
      </div>

      <div id="saturday">
        <div class="day">Sat</div>
        <ul class="recipe">
          <li v-for="(recipe, index) in mealPlanRecipes.saturday" v-bind:key="index">{{recipe.name}}</li>
        </ul>
      </div>

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

<style>
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