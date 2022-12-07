<template>
	<v-app>
		<div id="app">
			<div id="nav">
				<router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
				<router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
				<router-link v-bind:to="{ name: 'recipes' }">Go to Recipes Display</router-link>&nbsp;|&nbsp;
				<router-link v-bind:to="{ name: 'add-recipe' }">Add a Recipe</router-link>
			</div>

			<v-main>
				<router-view />
			</v-main>
		</div>
	</v-app>
</template>

<script>
// <template>
//   <div id="app">
//     <div id="nav">
//       <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
//       <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
//     </div>
//     <router-view />
//   </div>
// </template>

export default {
	name: 'App',

	data: () => ({
		//
	}),
};
</script>
