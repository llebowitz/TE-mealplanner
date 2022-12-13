<template>
	<!-- <div class="home">
		<h1>{{ $store.state.token != '' ? `Hello, ${$store.state.user.username}!` : 'Welcome to Unnamed App!' }}</h1>
		<p>You must be authenticated to see this</p>
	</div> -->
	<v-container>
		<v-sheet class="d-flex flex-column align-center">
			<h1>{{ $store.state.token != '' ? `Hello, ${$store.state.user.username}!` : 'Welcome to [logo for Too Many Cooks]!' }}</h1>
			<!-- Possible animation for title if time Wed -->
			<h2>Version 1.0 of Too Many Cooks is live! We've got all kinds of features:</h2>
			<ul>
				<li v-if="$store.state.token != ''">Click in the top right corner to logout, or <router-link v-bind:to="{ name: 'logout' }">click here.</router-link></li>
				<li v-else>Click in the top right corner to login, or <router-link v-bind:to="{ name: 'login' }">click here.</router-link></li>
				<li>Check out the box to the left for a <strong>Featured Recipe</strong>!</li>
				<li>Check out the box to the right for links to help <strong>up your cooking game</strong>!</li>
				<li>Click the <strong>Search Recipes</strong> tab above to browse our full collection of recipes, filter by keywords, save recipes with the click of a button, and more!</li>
				<li>
					Click the <strong>User Portal</strong> tab above to browse your saved recipes, add them to a 7 day meal plan, view and print a grocery list, add a new recipe or modify an existing one, and
					more!
				</li>
				<li>Don't forget that you can open a more <strong>detailed view</strong> of any recipe on our site by clicking the picture wherever you find it.</li>
			</ul>

			<h3 class="my-4">Changelog from previous version:</h3>
			<ul>
				<li>Steve's think-aloud frequency increased by 22%.</li>
				<li>Rolling pin easter egg added by Liora. Probably.</li>
				<li>Man bites dog, Zac bites backend.</li>
				<li>Accuracy of Katy's assertion "It'll all be fine!" still awaiting testing.</li>
				<li>More updates to follow; follow Q's Queue on Twitter for the latest.</li>
			</ul>
		</v-sheet>
		<v-spacer></v-spacer>
		<p class="my-10 text-left">
			<strong>Did you know?</strong> <span class="font-italic">{{ foodFacts[generateRandomFact()] }}</span>
		</p>
		<!-- <p>Jokes about our team, bullet pointed. // Man bites dog, Zac bites backend // Katy commits grand theft auto and terrorizes the city; </p> -->
	</v-container>
</template>

<script>
// import AppService from '../services/AppService';

export default {
	name: 'home',
	data: () => ({
		foodFacts: [
			'Until 2011, Russia classified beer and any other alcoholic beverages under 10% ABV as soft drinks.',
			'Cheese is the most stolen food in the world.',
			'Bananas are classified as berries, but strawberries are not.',
			'Lobsters and oysters used to be considered working class food.',
			'You can hear rhubarb grow.',
			'Large groups of pistachios can spontaneously combust.',
			'The stickers on fruit are edible.',
			'Calorie for calorie, healthy foods cost up to ten times as much as junk foods.',
			"The sandwich is said to have been invented by the Earl of Sandwich, a gambling addict who didn't want to leave the table to eat.",
			'Mushrooms cannot be overcooked.',
			'In the Middle Ages black pepper was a luxury, and was so expensive it was sometimes used to pay rent and taxes.',
			"Nutella uses 25% of the world's hazelnuts.",
			'In 1965 a corned beef sandwich was smuggled into space by Astronaut John Young.',
			'Loud music can make you drink more, and drink faster.',
			'There would be no chocolate if there were no flies',
			"McDonald's burgers don't rot. They have low moisture content which basically leaves the burgers dehydrated.",
			'In 16th Century England the upper classes served Surprise Pie. When the pie was cut, a live animal would jump out.',
			'Peanut butter can be used to make diamonds.',
			"McDonald's chicken nuggets come in four shapes, and they all have names: the boot, the ball, the bone, and the bell.",
			'In America on the 4th of July, the number of hot dogs consumed could stretch from Washington D.C. to Los Angeles 5 times over.',
			'',
		],
		//
	}),
	methods: {
		generateRandomFact() {
			let randomFactNumber = Math.floor(Math.random() * this.foodFacts.length);
			return randomFactNumber;
		},
	},
};
</script>

<style scoped>
ul {
	list-style-image: url(../assets/carrot.png);
}
</style>
