<template>
	<!-- <div class="home">
		<h1>{{ $store.state.token != '' ? `Hello, ${$store.state.user.username}!` : 'Welcome to Unnamed App!' }}</h1>
		<p>You must be authenticated to see this</p>
	</div> -->
	<v-container fluid>
		<v-sheet class="d-flex justify-center">
			<h1>{{ $store.state.token != '' ? `Hello, ${$store.state.user.username}!` : 'Welcome to Unnamed App!' }}</h1>
			<!-- Possible animation for title if time Wed -->
		</v-sheet>
		<v-sheet class="d-flex justify-center">
			<p>Version 1.0 of Unnamed App is live! We've got all kinds of features:</p>
		</v-sheet>
		<v-sheet class="d-flex justify-center">
			<p>Features, and navigation tips, bullet pointed</p>
		</v-sheet>
		<v-sheet class="d-flex justify-center">
			<p>Changelog from previous version:</p>
		</v-sheet>
		<!-- <p>Jokes about our team, bullet pointed. // Man bites dog, Zac bites backend // Katy commits grand theft auto and terrorizes the city; </p> -->
	</v-container>
</template>

<script>
// import AppService from '../services/AppService';

export default {
	name: 'home',
};
</script>
