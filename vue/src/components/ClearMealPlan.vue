<template>
  <div>
    <button v-on:click="clearMealPlan()">Clear Meal Plan</button>

  </div>
</template>

<script>
import AppService from '../services/AppService'


export default {
    
    methods: {
    clearMealPlan(){
        AppService.deleteMealPlan().then((response) => {
            if(response.status === 204) {
                this.$emit("cleared");
           }
          
        })
    }
}
}
</script>

<style>

</style>