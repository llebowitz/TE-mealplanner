<template>
  <div class="main">
       
        <div class="saved-recipe-card">
          
          <div class="saved-container">
              <img v-bind:src="`${recipe.imgLink}`" >
              
              <router-link v-bind:to="{ name : 'singleRecipe', params: { recipeId: recipe.id } }">
              <h3>{{recipe.name}}</h3> </router-link>
              <!-- <p>{{recipe.yield}}</p> -->
              <!-- <div class="blurb-container">
              <p>{{recipe.blurb}}</p> -->
              <p> </p>
              </div>
              <addto-meal-plan v-bind:recipe="recipe" />
              <button id="unsave-recipe">Unsave</button>
              <save-recipe v-bind:recipe="recipe" />
          </div>
    </div>
</template>

<script>
import AddtoMealPlan from './AddtoMealPlan.vue'
import SaveRecipe from './SaveRecipe.vue'

export default {
  components: { AddtoMealPlan, SaveRecipe },
    props: ['recipe'],

}
</script>

<style>

.blurb-container{
    
        height: 90px;
        overflow: hidden;
        text-overflow: ellipsis;
        padding-bottom: 3px;
        border: 1px black solid

}

.saved-recipe-card {
    border: 2px black solid;
    width: 260px;
    height: 260px;
    border-radius: 25px;
    margin: 2px;
    padding: 12px;
    padding-top: 25px;
   
    
}
 .saved-recipe-card:hover {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}


.saved-container {

    height: auto;
    width: 100%;
 
    
}
h3 {
    font-size: 14px;
    text-align: center
}


p{
    font-size: 12px;
    text-align: center;
   
}

img {
    width: 150px;
    max-height: 150px;
    object-fit: cover;
    display: block;
    margin: auto
}


</style>