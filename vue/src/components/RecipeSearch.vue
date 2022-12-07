<template>
    <div>
        
        <div>
            <label>Search:</label>
            <input id="search" type="text" v-model="filter" v-on:change="searchRecipes"  />
            <!-- can duplicate the event on a search button -->
        </div>

        <div class="recipe-container">
        <recipe-card v-for="recipe in recipes"
                     v-bind:key="recipe.recipeID"
                     v-bind:recipe="recipe" />
        </div>
        
    </div>
</template>

<script>
import RecipeCard from './RecipeCard.vue';
import AppService from '../services/AppService';

export default {

    data() {
        return {
            filter : '',
            recipes : [],
        }
    },

    components: {
        RecipeCard
    },

    methods: {
        searchRecipes() {
            AppService.getRecipes(this.filter).then( (response) => {
                this.recipes = response.data;
            })
        }
    },

    created() {
        this.searchRecipes;
    }

}

</script>

<style>

</style>