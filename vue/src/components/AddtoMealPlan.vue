<template>
  <div>
        <div>
            <select class= "selections" v-model="mealPlan.dayOfWeek">
                <option value="0" hidden disabled>Select a Day</option>
                <option value="1">Sunday</option>
                <option value="2">Monday</option>
                <option value="3">Tuesday</option>
                <option value="4">Wednesday</option>
                <option value="5">Thursday</option>
                <option value="6">Friday</option>
                <option value="7">Saturday</option>
            </select>

           <!-- <button id="add-to-meal-plan" v-on:click="flipStatus(mealPlan)">{{ mealPlan.status === "added" ? "Remove from Meal Plan" :"Add to Meal Plan" }}</button> -->
        <!-- v-on:click="removeFromDay({ recipeID: recipe.id, dayOfWeek: mealPlanDay.dayOfWeek }) -->
        
            <button id="add-to-meal-plan" v-on:click="addToMealPlan(mealPlan)">{{ mealPlan.status === "added" ? "Added to Meal Plan" :"Add to Meal Plan" }}</button>
        </div>
  </div>
</template>

<script>
import AppService from '../services/AppService'

export default {
    name: 'meal-plan',
    props: ['recipe', 'getMealPlanRecipes'],
    data() {
        return {
            mealPlan: {
                dayOfWeek: 0,
                recipeID: 0,
                status: 'notAdded',
            },
        
        }
    },
    created() {
        this.mealPlan.recipeID = this.recipe.id;
    },
    methods: {

        addToMealPlan(mealPlan) {
            if (mealPlan.status == 'notAdded') {
                AppService.addToMealPlan(this.mealPlan).then( (response) => {
                if (response.status === 201) {
                    this.mealPlan.status = "added";
                    // this.$emit('get-meal-plan-recipe');
                    location.reload();
                } 
                
                });
            } 
      
        },
        refreshMealPlans() {
            console.log('here')
        }
    }
}


</script>

<style scoped>
#add-to-meal-plan {
    border: 2px;
    border-color: black;
    border-style: solid;
    background-color: lightgrey;
    padding-right: 4px;
    padding-left: 4px;
    font-size: 11px;
    padding: 2px;
    border-radius: 5px;

  
    
}

#select {
    border: 2px;
    border-color: black;
    background-color: lightgrey;
    border-style: solid;
    border-radius:2rem;
    padding-right: 4px;
    padding-left: 4px;
}

.selections{
    /* border: 2px;
    border-color: black;
    border-style: solid; */
    border-radius: 8%;
    margin-right: 6px;
    padding-right: 4px;
    padding-left: 4px;
    border-color: gray;
    border-style: solid;
    font-size: 11px;
    margin: 5px;
    width: 90px;

   
}



</style>