<template>
	<div>
		<recipe-search></recipe-search>
		<add-recipe></add-recipe>
	</div>
</template>

<script>
import RecipeSearch from '../components/RecipeSearch.vue';
import AddRecipe from '../components/AddRecipe.vue'; //Take out later; just for demo

export default {
	name: 'recipes',
	components: {
		RecipeSearch,
		AddRecipe, //Take out later, just for demo
	},
};
</script>

<style></style>
