<template>
  <div>
      <h1>My Saved Recipes</h1>
      <div class="flex-grid">
		
				<div class="col" v-for="recipe in savedRecipes" v-bind:key="recipe.id">
					<saved-recipe-card v-bind:recipe="recipe" @get-meal-plan-recipes="refreshMealPlans">
			
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
    },
    refreshMealPlans() {
      this.$emit("get-meal-plan-recipes");
    },
}
}
</script>

<style scoped>

.flex-grid {
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
  justify-content: center
}
.flex-grid .col {
  width: 100%;
}



</style>