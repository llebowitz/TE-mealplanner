<template>
  <div>
      <h3>{{ recipe.recipeName}} </h3>
      <!-- add image -->
        <body> 
            <div>{{ recipe.instructions }}</div>
            <div>{{ recipe.ingredients }}</div>
        </body>
        <!-- add event: on click, save to user recipes -->
        <button>Save Recipe</button>
        <!-- add event: on click, save to user meal plan

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

addToMealPlan()
            'if Monday, add to ""'
deleteFromMealPlan()

toggleSave() 
} -->

</script>

<style>

</style>