<template>
	<v-card class="ma-1 rounded-xl flex-column align-items-center justify-start flex-nowrap" max-width="417" max-height="85%" outlined elevation="3">
		<router-link v-bind:to="{ name: 'singleRecipe', params: { recipeId: recipe.id } }">
			<v-img height="250" max-width="325" v-bind:src="`${recipe.imgLink}`" lazy-src="https://i.pinimg.com/originals/f9/98/0f/f9980fdb73ff0acc69d70a8997acb5fa.gif">
				<template v-slot:placeholder>
					<v-row class="fill-height ma-0" align="center" justify="center"><v-progress-circular indeterminate color="grey lighten-5"></v-progress-circular> </v-row></template></v-img
		></router-link>
		<div>
			<save-recipe v-bind:recipe="recipe" />
		</div>
		<router-link v-bind:to="{ name: 'singleRecipe', params: { recipeId: recipe.id } }"
			><v-card-title class="card-title mb-n5 align-self-start">{{ recipe.name }}</v-card-title></router-link
		>
		<div class="grey--text ms-4" v-if="recipe.yield != ''">
			<p>{{ recipe.yield }}</p>
		</div>

		<div class="tags mt-n3">
			<p v-for="(tag, index) in recipe.tags" :key="index" class="mx-1 my-2" @click="$emit('tagClicked', tag.name)">
				<strong>{{ tag.name }}</strong>
			</p>
		</div>

		<v-divider class="mx-4"></v-divider>
		<v-card-actions>
			<v-btn color="orange lighten-2" text> Preview:</v-btn>

			<v-spacer></v-spacer>

			<v-btn icon @click="show = !show">
				<v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
			</v-btn>
		</v-card-actions>

		<v-expand-transition>
			<div v-show="show">
				<v-divider></v-divider>

				<v-card-text>
					<div class="font-italic align-self-start">{{ recipe.blurb }}</div>
				</v-card-text>
			</div>
		</v-expand-transition>
	</v-card>
</template>

<script>
import SaveRecipe from '../components/SaveRecipe.vue';


export default {
	name: 'recipe-card',
	components: {
		SaveRecipe,
	},
	props: ['recipe'],
	data: () => ({
		show: false,
	}),
	methods:{
		searchByTag(tagWord){
			this.$router.push({name: 'recipes', params: {passedSearch: tagWord}});
		}
	}
};

</script>

<style scoped>
.card-title {
	word-break: break-word;
}

.tags {
	display: flex;
	/* flex-direction: row; */
	justify-content: space-around;
	align-items: center;
	flex-wrap: wrap;
	/* flex-basis: 300px; */
	/* padding: 10px;
	margin: 10px; */
}

.tags p {
	flex-shrink: 1;
	border: solid;
	border-color: darkseagreen;
	border-radius: 10%;
	background-color: darkseagreen;
	font-size: 10pt;
	color: darkslategray;
}

.tags p:hover{
	background-color: lightseagreen;
	border-color: lightseagreen;
	cursor: pointer;
}
</style>
