<template>
	<div id="app">
		<v-app id="inspire">
			<v-row justify="center">
				<v-dialog class="recipe-form" v-model="dialog" fullscreen hide-overlay transition="dialog-bottom-transition">
					<template v-slot:activator="{ on, attrs }">
						<v-btn color="primary" dark v-bind="attrs" v-on="on"> Add Recipe </v-btn>
					</template>
					<v-card>
						<v-toolbar dark color="primary">
							<v-btn icon dark @click="dialog = false">
								<v-icon>mdi-close</v-icon>
							</v-btn>

							<v-toolbar-title>New Recipe</v-toolbar-title>
							<v-spacer></v-spacer>
							<v-toolbar-items>
								<!-- Save button -->
								<v-btn dark text v-on:click="resetRecipeForm"> Save </v-btn>
							</v-toolbar-items>
						</v-toolbar>
						<v-list three-line subheader>
							<v-subheader>This will be added to your saved recipes.</v-subheader>

							<v-card-text>
								<v-form  id="recipeForm">
									<v-row>
										<v-col cols="12" sm="6">
											<v-text-field v-model="newRecipe.recipeName" label="Recipe Name*" required></v-text-field>
										</v-col>
									</v-row>
									<v-row>
										<v-container v-for='(ingredient, index) in arrOfIngredients' v-bind:key="index">
											<v-col cols="3">
												<!-- <v-autocomplete :items="[]" label="Ingredient" multiple></v-autocomplete> -->
												<v-text-field v-model="newRecipe.ingredients.name" label="Ingredient*" required multiple></v-text-field>
											</v-col>

											<v-col cols="3">
												<v-text-field v-model="newRecipe.ingredients.amount" label="Amount*" required multiple placeholder="1"></v-text-field>
											</v-col>

											<v-col cols="2">
												<v-select :items="items" v-model="newRecipe.ingredients.measurement" item-text="state" item-value="abbr" label="Unit of Measurement" persistent-hint return-object single-line></v-select>
											</v-col>
										</v-container>
										<v-col cols="4">
											<v-btn class="mx-2" fab dark color="indigo">
												<v-icon dark @click="addItem"> mdi-hamburger-plus </v-icon>
											</v-btn>
										</v-col>
									</v-row>

									<v-row>
										<v-col>
											<v-textarea v-model="newRecipe.instructions" name="input-7-1" filled label="Cooking Instructions" auto-grow value=""></v-textarea>
										</v-col>
									</v-row>
								</v-form>
								<small class="text-right">* indicates required field</small>
							</v-card-text>
							<v-card-actions />
							<!-- <v-spacer></v-spacer> -->
						</v-list>
					</v-card>
				</v-dialog>
			</v-row>
		</v-app>
	</div>
</template>

<script>
import AppService from '../services/AppService';

export default {
	data() {
		return {
			dialog: false,
			notifications: false,
			sound: true,
			widgets: false,
			items: [{ state: 'g' }, { state: 'oz' }, { state: 'item' }, { state: 'lb' }, { state: 'cups' }, { state: 'tablespoons' }, { state: 'teaspoons' }],
			newRecipe: {
				recipeName: '',
				ingredients: [
					
					{
						name: '',
						amount: 0,
				measurement: '',
					}
				],
				instructions: ''
			},
			arrOfIngredients: []
		};
	},
	methods: {
		addRecipe() {
			AppService.addRecipe(this.newRecipe).then((response) => {
				if (response.status === 201) {
					this.resetRecipeForm();
				}
			});
		},

		resetRecipeForm() {
			this.newRecipe = {
				recipeName: '',
				ingredients: [],
				instructions: ''
			};
			document.getElementById('recipeForm').reset();
			this.dialog = false;

		},
		addItem() {
			this.arrOfIngredients.push({value: ''});
		}

	},
};
</script>
