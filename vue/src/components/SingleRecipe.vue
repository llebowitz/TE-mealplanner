<template>
<div class="container">
    <header><h1>{{recipe.name}}</h1></header>

    <nav>
        <ul>
            <li v-for="(ingredient, index) in recipe.ingredients" :key="index">{{ingredient.quantity}} {{ingredient.measurement}} {{ingredient.name}}</li>
        </ul>
    </nav>

    <main>
        <div><img v-bind:src="`${recipe.imgLink}`"  alt=""></div>
        {{recipe.instructions}}
    </main>
</div>
  
</template>

<script>
import AppService from '../services/AppService'

export default {
    data(){
        return{
            recipe:{}
        }
    },
    created(){
        AppService.getRecipe(this.$route.params.recipeId).then((response) => {
            this.recipe = response.data;
        })
    },
}
</script>

<style>
.container{
    display: grid;
    grid-template-areas: 
    "head head" 
    "nav main";
}

.container header{
    grid-area: head;
}

.container nav{
    grid-area: nav;
    position:sticky;
}

.container main{
    grid-area: main;
}

</style>