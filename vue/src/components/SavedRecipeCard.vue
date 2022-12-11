<template>
  <div>
        
          <div class="saved-recipe-card">
          
          <div class="saved-container">
              <img v-bind:src="`${recipe.imgLink}`" >
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
    border: 2px black solid;
    width: 25%;
    height: auto;
    border-radius: 25px;
    margin: 5px;
    padding: 8px
    
}
 .saved-recipe-card:hover {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}


.saved-container {

    height: auto;
    width: 100%;
 
    
}
h3 {
    font-size: 14px
}

p{
    font-size: 12px;
}

img {
    width: 100%;
    width: 100%
}


</style>