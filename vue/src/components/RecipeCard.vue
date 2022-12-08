<template>
	<v-card class="mx-auto my-12" max-width="374">
		<v-img height="250" v-bind:src="`${recipe.imgLink}`" lazy-src="https://i.pinimg.com/originals/f9/98/0f/f9980fdb73ff0acc69d70a8997acb5fa.gif"
			><template v-slot:placeholder>
				<v-row class="fill-height ma-0" align="center" justify="center"><v-progress-circular indeterminate color="grey lighten-5"></v-progress-circular> </v-row></template
		></v-img>
		<v-card-title class="card-title">{{ recipe.name }}</v-card-title>

		<v-card-text>
			<v-row align="center" class="mx-0">
				<!-- <v-rating
          :value="4.5"
          color="amber"
          dense
          half-increments
          readonly
          size="14"
        ></v-rating> -->

				<div class="grey--text ms-4">Cook Time: {{ recipe.cookTime }}</div>
			</v-row>

			<div class="my-4 text-subtitle-1">
				{{ recipe.ingredients }}
			</div>

			<div>{{ recipe.blurb }}</div>
		</v-card-text>

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
export default {
	name: 'recipe-card',
	props: ['recipe'],
	data: () => ({
		show: false,
	}),
};

// export default {

//     data() {
//         return{
//              recipe: {
//                 recipeID: "",
//                 recipeName: "",
//                  imageURL: "",
//                 cookTime: 0,
//                 ingredients: [],
//                 blurb: "",
//                 instructions: "",
//                 isSaved: false,
//             },
//     }
// }

// }

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
