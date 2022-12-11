<template>
  <div>
      <div class="saved-recipe-card">
          <div class="saved-container">
              <img v-bind:src="`${recipe.imgLink}`">
              <router-link v-bind:to="{ name : 'singleRecipe', params: { recipeId: recipe.id } }">
              <h3>{{recipe.name}}</h3> </router-link>
              <p>{{recipe.yield}}</p>
              <p>{{recipe.blurb}}</p>
          </div>
      </div>
  </div>
</template>

<script>
export default {
    props: ['recipe'],

}
</script>

<style>
.saved-recipe-card {
    width: 33%;
    border: 1px black solid

}
.saved-container {
    width: 33%;
    border: 1px black solid
   
}
</style>