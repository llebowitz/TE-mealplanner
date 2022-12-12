<template>
  <div>
      
      <div class="flex-box"><!-- <button v-on:click="getGroceryList"> Get Grocery List</button> -->
      
      <h1>Grocery List</h1>

        <button v-on:click="printGroceryList">Print List <img src="../assets/printer.png" height="20px" width="auto"> </button>
        <br>
      
        <label v-for="ingredient in groceryList" v-bind:key="ingredient.id"> <input type="checkbox"> {{ingredient.name}} <br> </label>



             
   </div>
  </div>
</template>

<script>
import AppService from '../services/AppService'



export default {

    data() {
        return{
            groceryList:[],
        }
    },

    created() {
        this.getGroceryList();
    },

   methods: {

        getGroceryList(){
            AppService.getGroceryList().then( (response) => {
                if(response.status === 200) {
                    this.groceryList = response.data;
                }
            })
        },

        printGroceryList(){
            window.print();
        }


      
    }
  

}
</script>

<style scoped>



.flex-box {
     column-count: 4;
     
}

button{
    font-weight: bold;
    border: 1px black solid
}



</style>