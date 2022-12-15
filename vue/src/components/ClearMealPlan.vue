<template>
  <div>
    <button class="clear-btn" v-on:click="clearMealPlan()">Clear Meal Plan</button>

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

<style scoped>
.clear-btn{
    padding: 2px;
    border-radius: 5px;
    background-color: #1976D2;
    font-size: 12pt;
}

</style>