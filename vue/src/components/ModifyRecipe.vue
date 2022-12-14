<template>
  <div>
    <form @submit.prevent="updateRecipe">
        <label for="recipe-name" class="label">Recipe Name:</label><br>
        <input type="text" id="recipe-name" v-model="modifyRecipe.name"> <br><br>

        <div class="label">Ingredient List:</div>
        <div class="ingredient-list">
        <ingredient-input-row v-for="(ingredient, index) in modifyRecipe.ingredients" :key="index" v-bind:ingredient="ingredient" v-model="modifyRecipe.ingredient"/> 
        </div><br>
 
        <label for="instructions" class="label">Instructions:</label><br>
        <textarea id="instructions" class="text-area" rows="7" v-model="modifyRecipe.instructions" > </textarea>

        <br>  
        <input type="checkbox" v-model="modifyRecipe.published" >
        <label> Publish?</label>
        <br><br>

        <input class="submit-button" type="submit" value="Update Recipe">
        </form>
  </div>

</template>

<script>
import AppService from '../services/AppService'
import IngredientInputRow from './IngredientInputRow.vue';

export default {
  name: "modify-recipe",
  props: ['recipe'],
  components:{IngredientInputRow},
  data() {
    return {
      modifyRecipe: {
        isEdited: true
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
          this.modifyRecipe.isEdited = true;
            AppService.updateRecipe(this.modifyRecipe).then((response) => {
                if(response.status === 200) {
                    alert("Recipe updated!")
                }
            })
        }
    }

}


</script>

<style scoped>

#instructions{
  width: 100%;
  padding: 8px;
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  border-right:  lightgrey 3px solid;
    border-bottom:  lightgrey 3px solid;
    border-radius: 7px;
}

#recipe-name{
  width: 50%;
  padding: 8px;
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  border-right:  lightgrey 3px solid;
    border-bottom:  lightgrey 3px solid;
    border-radius: 7px;
}

.label{
  font-size: 18pt;
  font-weight: bold;
}

.ingredient-list{
  /* display: grid;
  grid-template-columns: repeat(3, 1fr); */

  display: flex;
  flex-wrap: wrap;
  justify-content:space-evenly;
  
}

.submit-button{
  width: 100%;
  padding: 8px;
  box-shadow: 8px 0 8px 0 rgba(0,0,0,0.2);
  border-top:  lightgrey 3px solid;
  border-radius: 7px;
  font-size: 15pt;
}


</style>