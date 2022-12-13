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
				<v-tab class="hide-slider" v-for="link in links" :key="link.title" router-link v-bind:to="{ name: `${link.routeName}` }">
					{{ link.title }}
				</v-tab>
			</v-tabs>
			<router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
			<router-link v-bind:to="{ name: 'login' }" v-else>Login</router-link>
			<v-avatar class="hidden-sm-and-down" color="grey darken-1 shrink" size="32"><img src="./assets/crossed-utensils.jpg" /></v-avatar>
		</v-app-bar>

		<!-- <v-main class="grey lighten-3"> -->
		<v-main class="stuff">
			<v-container>
				<v-row>
					<v-col cols="12" sm="3" class="" v-if="isHome()">
						<v-sheet id="featured-recipe-parent" rounded="lg" min-height="268">
							<featured-recipe />

							<!--  -->
							<!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
							<!-- <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->
							<!-- <router-link v-bind:to="{ name: 'recipes' }"> Display Recipes</router-link> -->
						</v-sheet>
						<v-img src="./assets/cartoonfood1.jpg"></v-img>
					</v-col>

					<v-col cols="12" sm="6" class="mx-auto" v-if="isHome()">
						<v-sheet min-height="70vh" rounded="lg" class="fill-height">
							<!--  -->

							<router-view :key="$route.fullPath" />
						</v-sheet>
					</v-col>
					<v-col v-else grow>
						<v-sheet min-height="70vh" rounded="lg" class="fill-height">
							<!--  -->

							<router-view :key="$route.fullPath" />
						</v-sheet>
					</v-col>

					<v-col cols="12" sm="3" class="d-none d-md-block" v-if="isHome()">
						<v-sheet rounded="lg" min-height="268">
							<h4>Helpful links to up your cooking game:</h4>
							<a href="https://www.seriouseats.com/">Serious Eats</a>
							<v-spacer></v-spacer>
							<a href="https://nymag.com/strategist/article/best-cookware-sets.html">Cookware Recommendations</a>
							<v-spacer></v-spacer>

							<a
								href="https://www.masterclass.com/?campaignid=16375017014&adgroupid=135152788313&adid=634414682315&utm_term=masterclass%20cooking&utm_campaign=%5BMC%5C+%7C+Search+%7C+Brand+%7C+Topic+%7C+USA+%7C+EN+%7C+MAX+%7C+EG%7CPP+%7C+BRD+%7C+US&utm_source=google&utm_medium=cpc&utm_content=634414682315&hsa_acc=9801000675&hsa_cam=16375017014&hsa_grp=135152788313&hsa_ad=634414682315&hsa_src=g&hsa_tgt=kwd-306566196910&hsa_kw=masterclass%20cooking&hsa_mt=e&hsa_net=adwords&hsa_ver=3&gclid=CjwKCAiAv9ucBhBXEiwA6N8nYAScvo90J4NKfu1F-oFm-tPqhz9kmfP5Z0BUp-er79W4tcuizq5g9BoCeB0QAvD_BwE"
								>Master Class</a
							>
							<v-spacer></v-spacer>

							<a href="https://www.fox.com/masterchef/">Master Chef</a>

							<!--  -->
						</v-sheet>
					</v-col>
				</v-row>
			</v-container>
		</v-main>
	</v-app>
</template>

<script>
import FeaturedRecipe from './components/FeaturedRecipe.vue';

export default {
	name: 'App',
	components: {
		FeaturedRecipe,
	},
	methods: {
		isHome() {
			let routeName = this.$route.name;
			let isHome = routeName == 'home';
			return isHome;
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

.stuff {
	background-color: #cad97a;
}
</style>
