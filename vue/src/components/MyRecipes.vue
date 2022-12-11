<template>
  <div>
      <recipe-card />
      <v-container fluid>
			<v-slide-group v-model="model" class="pa-12 d-flex flex-wrap" center-active show-arrows>
				<v-slide-item v-for="recipe in savedRecipes" v-bind:key="recipe.id" v-slot="{ active, toggle }" class="ma-12 d-flex flex-wrap">
					<recipe-card v-bind:recipe="recipe" @click="toggle" class="ma-12 pa-12">
						<v-scale-transition>
							<v-icon v-if="active" color="white" size="48" v-text="'mdi-close-circle-outline'"></v-icon>
						</v-scale-transition>
					</recipe-card>
				</v-slide-item>
			</v-slide-group>
			</v-container>
  </div>
</template>

<script>
import AppService from '../services/AppService'
import RecipeCard from './RecipeCard.vue'
export default {
  components: { RecipeCard },

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