<template>
	<div>
		<div class="search-bar">
			<label>Search:</label>
			<input id="search" type="text" v-model="filter" v-on:change="searchRecipes" />
			<!-- can duplicate the event on a search button -->
		</div>

		<!-- <div class="recipe-container ma-12 d-flex flex-wrap"> -->
			<v-container fluid>
			<v-slide-group v-model="model" class="pa-1 d-flex flex-nowrap" center-active show-arrows>
				<v-slide-item v-for="recipe in recipes" v-bind:key="recipe.recipeID" v-slot="{ active, toggle }" class="ma-12 d-flex flex-wrap">
					<recipe-card v-bind:recipe="recipe" @click="toggle" class="ma-12 pa-12">
						<!-- <v-row class="fill-height pa-12 ma-12" align="center" justify="center"> -->
						<v-scale-transition>
							<v-icon v-if="active" color="white" size="48" v-text="'mdi-close-circle-outline'"></v-icon>
						</v-scale-transition>
						<!-- </v-row> -->
					</recipe-card>
				</v-slide-item>
			</v-slide-group>
			</v-container>
            <add-recipe />
		</div>
	
</template>

<script>
import RecipeCard from './RecipeCard.vue';
import AppService from '../services/AppService';
import AddRecipe from '../components/AddRecipe.vue';

export default {
	data() {
		return {
			filter: '',
			recipes: [],
			model: null,
		};
	},

	components: {
		RecipeCard,
        AddRecipe,
	},

	methods: {
		searchRecipes() {
			AppService.getRecipes(this.filter).then((response) => {
				this.recipes = response.data;
			});
		},
	},

	created() {
		this.searchRecipes;
	},
};
</script>

<style>
.search-bar {
	border: 5px;
}
</style>
