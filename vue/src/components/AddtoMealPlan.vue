<template>
  <div>

        <button>Add to Meal Plan</button>
        <div>
            <select v-on:click="addToMealPlan" v-model="mealPlan.dayOfWeek">
                <option value="1">Sunday</option>
                <option value="2">Monday</option>
                <option value="3">Tuesday</option>
                <option value="4">Wednesday</option>
                <option value="5">Thursday</option>
                <option value="6">Friday</option>
                <option value="7">Saturday</option>
            </select>
        </div>
        
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
                recipeID: 0,
            },
            
        }
    },
    created() {
        this.mealPlan.recipeID = this.recipe.id;
    },
    methods: {
        addToMealPlan() {
            AppService.addToMealPlan(this.mealPlan).then( (response) => {
                if (response.status === 201) {
                    alert("Success!");
                }
            })
        },

        toggleSelect() {
            this.showSelect = !this.showSelect;
         }
    }

}
</script>

<style>



</style>