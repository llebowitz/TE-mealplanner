<template>
  <div>
      <div class="container">
			<h1>My Saved Recipes</h1>
				<div v-for="recipe in savedRecipes" v-bind:key="recipe.id">
					<saved-recipe-card v-bind:recipe="recipe">
			
					</saved-recipe-card>
				</div>
	
			</div>
  </div>
</template>

<script>
import AppService from '../services/AppService';
import SavedRecipeCard from '../components/SavedRecipeCard.vue';
export default {
  components: { SavedRecipeCard },

    props: ['recipe'],

    data() {
        return {
            savedRecipes: [],
        }
    },

    created() {
        this.getMyRecipes();
    },

methods: {
    getMyRecipes() {
        AppService.getSavedRecipes().then( (response) => {
            if(response.status === 200) {
                this.savedRecipes = response.data;
            }
        })
    }
}
}
</script>

<style>



</style>