<template>
  <div>
      <button v-on:click="getGroceryList" v-for="ingredient in ingredientList" v-bind:key="ingredient.id"> Get Grocery List</button>
  </div>
</template>

<script>
import AppService from '../services/AppService'

export default {
    data() {
        return {
            ingredientList: [],
        }
    },

    methods: {
        getGroceryList(){
            AppService.getGroceryList().then( (response) => {
                if(response.status === 200) {
                    this.ingredientList = response.data;
                }
            })
        }
    }


}
</script>

<style>

</style>