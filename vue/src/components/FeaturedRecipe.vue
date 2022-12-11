<template>
	<div class="text-center fill-height">
		<h1>Featured Recipe:</h1>
		<router-link v-bind:to="{ name: 'singleRecipe', params: { recipeId: recipe.id } }">
			<v-img height="250" max-width="250" v-bind:src="`${recipe.imgLink}`" lazy-src="https://i.pinimg.com/originals/f9/98/0f/f9980fdb73ff0acc69d70a8997acb5fa.gif">
				<template v-slot:placeholder>
					<v-row class="fill-height ma-0" align="center" justify="center"><v-progress-circular indeterminate color="grey lighten-5"></v-progress-circular> </v-row></template></v-img
		></router-link>
	</div>
</template>

<script>
import AppService from '../services/AppService.js';
export default {
	name: 'featured-recipe',
	components: {},
	props: ['recipe'],
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

<style></style>
