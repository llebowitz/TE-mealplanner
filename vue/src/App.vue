<template>
	<!-- <v-app>
		<v-navigation-drawer app>
			<router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
			<router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
			<router-link v-bind:to="{ name: 'recipes' }"> Display Recipes</router-link>
		</v-navigation-drawer>
		<router-view />
	</v-app> -->

	<v-app id="inspire">
		<v-app-bar app color="white" flat>
			<v-avatar :color="$vuetify.breakpoint.smAndDown ? 'grey darken-1' : 'transparent'" size="32"></v-avatar>
			<v-tabs centered class="ml-n9" color="grey darken-1">
				<v-tab v-for="link in links" :key="link.title" router-link v-bind:to="{ name: `${link.routeName}` }">
					{{ link.title }}
				</v-tab>
			</v-tabs>
			<router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
			<router-link v-bind:to="{ name: 'login' }" v-else>Login</router-link>
			<v-avatar class="hidden-sm-and-down" color="grey darken-1 shrink" size="32"><img src="./assets/cartoonfood1.jpg" /></v-avatar>
		</v-app-bar>

		<v-main class="grey lighten-3">
			<v-container>
				<v-row>
					<v-col cols="12" sm="2">
						<v-sheet id="featured-recipe-parent" rounded="lg" min-height="268">
							<h1 v-if="isNotHomeOrUserPortal()">Featured Recipe</h1>
							<!-- <featured-recipe /> -->

							<!--  -->
							<!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
							<!-- <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->
							<!-- <router-link v-bind:to="{ name: 'recipes' }"> Display Recipes</router-link> -->
						</v-sheet>
					</v-col>

					<v-col cols="12" sm="8">
						<v-sheet min-height="70vh" rounded="lg" class="fill-height">
							<!--  -->

							<router-view :key="$route.fullPath" />
						</v-sheet>
					</v-col>

					<v-col cols="12" sm="2">
						<v-sheet rounded="lg" min-height="268">
							<!--  -->
						</v-sheet>
					</v-col>
				</v-row>
			</v-container>
		</v-main>
	</v-app>
</template>

<script>
// import FeaturedRecipe from './components/FeaturedRecipe.vue';

export default {
	name: 'App',
	components: {
		// FeaturedRecipe,
	},
	methods: {
		isNotHomeOrUserPortal() {
			let routeName = this.$route.name;
			let homeRoute = routeName !== 'home' && routeName !== 'user-portal';
			return homeRoute;
		},
	},
	data: () => ({
		links: [
			{
				title: 'Home',
				routeName: 'home',
			},
			{
				title: 'Search Recipes',
				routeName: 'recipes',
			},
			{
				title: 'User Portal',
				routeName: 'user-portal',
			},
		],
		//
	}),
};
</script>

<style scoped>
/* #inspire {
	background-color: #c8e6c9;
} */
.hidden-sm-and-down {
	margin-left: 12px;
}
#featured-recipe-parent {
	display: flex;
	justify-content: space-evenly;
	flex-wrap: wrap;
}
/* v-avatar {
	background-color: white;
	background-image: url('./assets/cartoonfood1.jpg');
	background-position: 10px 10px;
	background-repeat: no-repeat;
} */
</style>
