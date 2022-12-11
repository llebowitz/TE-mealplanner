<template>
  <div>
        <div>
            <select v-model="mealPlan.dayOfWeek">
                <option value="1" >Sunday</option>
                <option value="2">Monday</option>
                <option value="3">Tuesday</option>
                <option value="4">Wednesday</option>
                <option value="5">Thursday</option>
                <option value="6">Friday</option>
                <option value="7">Saturday</option>
            </select>

            <button id="add-to-meal-plan" v-on:click="addToMealPlan">Add to Meal Plan</button>

        </div>

        <button id="remove-from-meal-plan" v-on:click="removeFromMealPlan">Remove from Meal Plan</button>
        
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

        removeFromMealPlan() {
            AppService.removeFromMealPlan(this.mealPlan).then( (response) => {
                if (response.status === 204) {
                    alert("Removed from meal plan.")
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
#add-to-meal-plan {
    border: 2px;
    border-color: black;
    border-style: solid;
}

#remove-from-meal-plan {
    border: 2px;
    border-color: black;
    border-style: solid;
}


</style>