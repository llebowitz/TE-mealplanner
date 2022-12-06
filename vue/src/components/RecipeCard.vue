<template>
  <div>
      <h3>{{ recipe.name}} </h3>
      <!-- add image -->
        <body> 
            <!-- how do we pull this from database/external API? -->
            <div>{{ recipe.instructions }}</div>
            <div>{{ recipe.ingredients }}</div>
        </body>
        <!-- add event: on click, save to user recipes -->
        <button>Save Recipe</button>
        <!-- add event: on click, save to user meal plan
            change button to dropdown with days of week
        <form>Add to Meal Plan
            <select>
                <option>Monday</option>
                <option>Tuesday</option>
                <option>Wednesday</option>
                <option>Thursday</option>
                <option>Friday</option>
                <option>Saturday</option>
                <option>Sunday</option>
            </select>
        </form>

        Add button to add recipe ingredients to grocery list

</div>
</template> -->

<script>
export default {

    data() {
        return{
             recipe: {
                recipeID: "",
                recipeName: "",
                cookTime: 0,
                ingredients: [],
                blurb: "",
                instructions: "",
                isSaved: false,
            },
    }
}

}


 

<!-- methods: {
saveRecipe()
Should we set it up to automatically save a copy of the recipe here?

unSaveRecipe()

ddToMealPlan()
            'if Monday, add to ""'
deleteFromMealPlan()
} -->

</script>

<style>

</style>