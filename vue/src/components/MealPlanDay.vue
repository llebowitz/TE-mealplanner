<template>
  <div>
    <div id="day-of-week">
      <div class="day">{{ mealPlanDay.dayName }}</div>
      <ul class="recipe">
        <li v-for="(recipe, index) in mealPlanDay.recipes" v-bind:key="index">
          <router-link
            :to="{ name: 'singleRecipe', params: { recipeId: recipe.id } }"
            >{{ recipe.name }}</router-link
          >
          <button
            id="remove-button"
            v-on:click="removeFromDay({ recipeID: recipe.id, dayOfWeek: mealPlanDay.dayOfWeek })"
          >
            <img class="remove-button" src="../assets/x-icon.png" />
          </button>
        </li>
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

.remove-button{
  width: 10px;
  height: auto;
  margin-left: 5px;
}
</style>