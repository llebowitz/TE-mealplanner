<template>
  <div>
 <button v-on:click="flipStatus(savedRecipe)">{{ savedRecipe.status === 'saved' ? 'Unsaved' : 'Saved' }}</button>
  </div>

</template>

<script>
import AppService from '../services/AppService.js'

export default {
 name: "add-recipe",
 data() {
     return {
         savedRecipe: {
             id: 0,
             status: ''
         }
     };
 },
 methods: {
     saveRecipe(){
        
        
     }
 },

    unsaveRecipe(){

        
       
    },
    
    
    flipStatus(savedRecipe){
        if(savedRecipe.status === 'saved') {
           AppService.unsaveRecipe(this.$route.params.id).then((response) => {
             if(response.status === 200)
             this.savedRecipe.status == 'unsaved';
        })
        } 
        else if (savedRecipe.status === 'unsaved') {
            AppService.saveRecipe(this.$route.params.id).then((response) => {
            if (response.status === 201){
                this.savedRecipe.status = 'saved';
            } 
        })
        }
    }
}
</script>

<style>

</style>