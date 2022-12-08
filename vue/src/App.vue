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
		<v-navigation-drawer app>
			<router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
			<router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
			<router-link v-bind:to="{ name: 'recipes' }"> Display Recipes</router-link>
		</v-navigation-drawer>
		<v-app-bar app color="white" flat>
			<v-avatar :color="$vuetify.breakpoint.smAndDown ? 'grey darken-1' : 'transparent'" size="32"></v-avatar>

			<v-tabs centered class="ml-n9" color="grey darken-1">
				<v-tab v-for="link in links" :key="link">
					<router-link v-bind:to="{ name: '{links}' }">{{ link }}</router-link
					>&nbsp;|&nbsp;

					<!-- {{ link }} -->
				</v-tab>
			</v-tabs>
			<v-avatar class="hidden-sm-and-down" color="grey darken-1 shrink" size="32"></v-avatar>
		</v-app-bar>

		<v-main class="grey lighten-3">
			<v-container>
				<v-row>
					<v-col cols="12" sm="2">
						<v-sheet rounded="lg" min-height="268">
							<!--  -->
						</v-sheet>
					</v-col>

					<v-col cols="12" sm="8">
						<v-sheet min-height="70vh" rounded="lg">
							<!--  -->
						</v-sheet>
					</v-col>

					<v-col cols="12" sm="2">
						<v-sheet rounded="lg" min-height="268">
							<!--  -->
						</v-sheet>
					</v-col>
				</v-row>
				<router-view />
			</v-container>
		</v-main>
	</v-app>
</template>

<script>
export default {
	name: 'App',

	data: () => ({
		links: ['Home', 'Messages', 'Profile', 'Updates'],
		//
	}),
};
</script>
