<template>
  <div>
    <form>
        <label for="recipe-name">Recipe name:</label><br>
        <input type="text" id="recipe-name" v-model="modifyRecipe.name"> <br>
            
 
        <label for="quantity">Quantity:</label><br>
        <input type="text" id="quantity" v-for="(ingredient, index) in modifyRecipe.ingredients" :key="index" v-model="ingredient.quantity"><br>

      

       
        <label for="measurement">Measurement:</label><br>
         <input type="text" id="measurement" v-for="(ingredient, index) in modifyRecipe.ingredients" :key="index" v-model="ingredient.measurement"><br>


      
        <label for="ingredients">Ingredients:</label><br>
        <input type="text" id="ingredients" v-for="(ingredient, index) in modifyRecipe.ingredients" :key="index" v-model="ingredient.name" > <br>
     
 
        <label for="instructions">Instructions:</label><br>
        <textarea id="ingredients" v-model="modifyRecipe.instructions" > </textarea>

<br><button type="submit">Submit</button>
        </form>
  </div>

</template>

<script>
import AppService from '../services/AppService'

export default {
  name: "modify-recipe",
  props: ['recipe'],
  data() {
    return {
      modifyRecipe: {
        // id: 0,
        // name: '',
        // ingredients: [],
        // instructions: ''
      },
    };
  },

  created() {

    AppService.getRecipe(this.$route.params.recipeId).then((response) => {
        this.modifyRecipe = response.data;

        });
    },
    methods: {
        updateRecipe() {
            AppService.updateRecipe(this.modifyRecipe).then((response) => {
                if(response.status === 200) {
                    alert("Recipe updated!")
                }
            })
        }
    }

}


</script>

<style>
button, input, textarea {
    border: black 1px solid
}


</style>