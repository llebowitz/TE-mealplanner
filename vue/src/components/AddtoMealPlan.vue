<template>
  <div>

        <button>Add to Meal Plan</button>
        <div>
            <select v-model="mealPlan.dayOfWeek">
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
                dayOfWeek: "1",
                recipeID: "",
            },
            
        }
    },
    created() {
        this.mealPlan.recipeID = this.recipe.recipeID;
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