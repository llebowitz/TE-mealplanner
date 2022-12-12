<template>
  <div>
    <div id="day-of-week">
      <div class="day">{{ mealPlanDay.dayName }}</div>
      <ul id="recipe">
          <div v-for="(recipe, index) in mealPlanDay.recipes" v-bind:key="index">
        <li id="li">
          <router-link
            :to="{ name: 'singleRecipe', params: { recipeId: recipe.id } }"
            >{{ recipe.name }}</router-link
          >
        </li>
        <button
            id="remove-button"
            v-on:click="removeFromDay({ recipeID: recipe.id, dayOfWeek: mealPlanDay.dayOfWeek })"
          >
            <img class="remove-button" src="../assets/x-icon.png" />
          </button>
        </div>
      </ul>
    </div>
  </div>
</template>

<script>
import AppService from "../services/AppService";

export default {
  props: ['mealPlanDay'],

  methods: {
    removeFromDay(recipe) {
      AppService.removeFromMealPlan(recipe).then((response) => {
        if (response.status === 204) {
          this.$emit('recipeRemoved');
        }
      });
    },
  },
};
</script>

<style>

.day{
  font-weight: bold;
  font-size: 30px;
  padding-left: 5px;
}

ul {
  list-style-image: url(../assets/carrot.png);
}

#remove-button{
  width: 10px;
  height: auto;
  margin-left: 5px;
}





</style>