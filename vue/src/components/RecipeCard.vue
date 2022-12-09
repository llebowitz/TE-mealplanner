<template>
	<v-card class="ma-12 pa-12" max-width="374" outlined tile>
		<v-img height="250" v-bind:src="`${recipe.imgLink}`" lazy-src="https://i.pinimg.com/originals/f9/98/0f/f9980fdb73ff0acc69d70a8997acb5fa.gif" router-link v-bind:to="{ name: `${singleRecipe}` }"
			><template v-slot:placeholder>
				<v-row class="fill-height ma-0" align="center" justify="center"><v-progress-circular indeterminate color="grey lighten-5"></v-progress-circular> </v-row></template
		></v-img>

		<save-recipe v-bind:recipe="recipe" />
		<v-card-title class="card-title" router-link v-bind:to="{ name: `${singleRecipe}` }">{{ recipe.name }}</v-card-title>
		<div class="grey--text ms-4" v-if="recipe.yield != ''">{{ recipe.yield }}</div>

		<v-card-text>
			<!-- <v-row align="center" class="mx-0"> -->
			<!-- <v-rating
          :value="4.5"
          color="amber"
          dense
          half-increments
          readonly
          size="14"
        ></v-rating> -->

			<!-- </v-row> -->
			<div class="font-italic">{{ recipe.blurb }}</div>
		</v-card-text>

		<!-- <v-card-text>
		</v-card-text> -->

		<v-divider class="mx-4"></v-divider>
		<v-card-actions>
			<v-btn color="orange lighten-2" text> Ingredients</v-btn>

			<v-spacer></v-spacer>

			<v-btn icon @click="show = !show">
				<v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
			</v-btn>
		</v-card-actions>

		<v-expand-transition>
			<div v-show="show">
				<v-divider></v-divider>

				<v-card-text>
					<div class="my-4 text-subtitle-1" v-for="ingredient in recipe.ingredients" v-bind:key="ingredient.id" v-bind:ingredient="ingredient">
						<span v-if="ingredient.quantity !== 0">{{ ingredient.quantity }}</span> {{ ingredient.measurement }} {{ ingredient.name }}
					</div>
				</v-card-text>
			</div>
		</v-expand-transition>

		<v-divider class="mx-4"></v-divider>
		<v-card-actions>
			<v-btn color="orange lighten-2" text> Instructions </v-btn>

			<v-spacer></v-spacer>

			<v-btn icon @click="show = !show">
				<v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
			</v-btn>
		</v-card-actions>

		<v-expand-transition>
			<div v-show="show">
				<v-divider></v-divider>

				<v-card-text>
					{{ recipe.instructions }}
				</v-card-text>
			</div>
		</v-expand-transition>
	</v-card>

	<!-- <div>
      <h3>{{ recipe.recipeName}} </h3>
      add image 
        <body> 
            <div>{{ recipe.instructions }}</div>
            <div>{{ recipe.ingredients }}</div>
        </body>
        add event: on click, save to user recipes 
        <button>Save Recipe</button>
        add event: on click, save to user meal plan 

</div> -->
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
};

//  methods: {
// saveRecipe()
// Should we set it up to automatically save a copy of the recipe here?

// unSaveRecipe()

// addToMealPlan()
//             'if Monday, add to ""'
// deleteFromMealPlan()

// toggleSave()
// }
</script>

<style>
.card-title {
	word-break: break-word;
}
</style>
