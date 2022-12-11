<template>
  <div>
        
          <div class="saved-recipe-card">
          <img height="300" max-width="300" v-bind:src="`${recipe.imgLink}`">
          <div class="saved-container">
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
    border: 1px black solid;
    width: 25%;
    height: 25%

}
.saved-container {

    height: auto;
    width: 100%%;
    border: 1px black solid
    
   
}
h3 {
    font-size: 14px
}

p{
    font-size: 12px;
}


</style>