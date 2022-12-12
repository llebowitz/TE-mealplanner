<template>
  <div>
      <!-- <button v-on:click="getGroceryList"> Get Grocery List</button> -->
      <h1>Grocery List</h1>

     
              
              <label v-for="ingredient in groceryList" v-bind:key="ingredient.id"> <input type="checkbox"> {{ingredient.name}} <br>
              
              </label>

             
   
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
        }
      
    }
  

}
</script>

<style>


div{
    padding: 10px
}

</style>