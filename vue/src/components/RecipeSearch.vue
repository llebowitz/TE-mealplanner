<template>
	<div>
		<div class="search-bar">
			<label>Search:</label>
			<input id="search" type="text" v-model="filter" v-on:change="searchRecipes" />
			<!-- can duplicate the event on a search button -->
		</div>

		<div class="recipe-container">
			<v-slide-group class="pa-4" show-arrows>
				<v-slide-item v-for="recipe in recipes" v-bind:key="recipe.recipeID">
					<recipe-card v-bind:recipe="recipe"
						><v-row class="fill-height" align="center" justify="center">
							<v-scale-transition>
								<v-icon v-if="active" color="white" size="48" v-text="'mdi-close-circle-outline'"></v-icon>
							</v-scale-transition>
						</v-row>
					</recipe-card>
				</v-slide-item>
			</v-slide-group>
		</div>
	</div>
</template>

<script>
import RecipeCard from './RecipeCard.vue';
import AppService from '../services/AppService';

export default {
	data() {
		return {
			filter: '',
			recipes: [],
		};
	},

	components: {
		RecipeCard,
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
