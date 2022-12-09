<template>
  <div>
      <button id='add-to-meal-plan' v-on:click="showSelect">Add to Meal Plan</button>
      <select v-on:click="addToMealPlan" id='select-day'>
          <option value='1'>Sunday</option>
          <option value='2'>Monday</option>
          <option value='3'>Tuesday</option>
          <option value='4'>Wednesday</option>
          <option value='5'>Thursday</option>
          <option value='6'>Friday</option>
          <option value='7'>Saturday</option>
  </div>
</template>

<script>
import AppService from '../services/AppService'
export default {
    name: 'meal-plan',
    props: ['recipe'],
    data() {
        return {
            mealPlan: {
                dayOfWeek: 0,
                recipeID: this.recipe.recipeID,
            },
            showSelect: false,
        }
    },
    methods: {
        addToMealPlan() {
            AppService.addToMealPlan(this.mealPlan).then( (response) => {
                if (response.status === 201) {
                    alert("Success!");
                }
            })
        },

        selectDay() {

        }
    }

}
</script>

<style>

</style>