<template>
<div class="container">
    <header><h1>{{recipe.name}}</h1></header>

    <nav>
        <ul>
            <li v-for="(ingredient, index) in recipe.ingredients" :key="index"><span v-if="ingredient.quantity != 0">{{ingredient.quantity}}</span> {{ingredient.measurement}} {{ingredient.name}}</li>
        </ul>
    </nav>

    <main>
        <div><img class="image" v-bind:src="`${recipe.imgLink}`" alt=""></div>
        <div class="instructions">{{recipe.instructions}}</div>
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
    methods:{
        fixSpacing(instructions){
            return instructions.replace('\n', '<br>');
        }
    }
}
</script>

<style scoped>
.container{
    display: grid;
    grid-template-areas: 
    "head head" 
    "nav main";
}

.container header{
    grid-area: head;
    position: sticky;
}

.container nav{
    grid-area: nav;
}

.container main{
    grid-area: main;
    overflow: auto;
}

.instructions{
    white-space: pre-wrap;
}

.image{
    padding-left: 25%;
    max-width: 60%;
    max-height: 60%;
    min-width: 40%;
    min-height: 40%;
}

</style>