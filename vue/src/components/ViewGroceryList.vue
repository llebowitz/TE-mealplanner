<template>
  <div>
      <!-- <button><router-link v-bind:to="{name: 'grocery-list'}"> Meal Plan Grocery List</router-link></button> -->

       <button class="button" @click="$router.push('grocerylist')"> Meal Plan Grocery List</button>
  
  </div>

</template>

<script>
export default {

}
</script>

<style scoped>
.button {
  border: 2px;
    padding: 2px;
    border-radius: 5px;
    background-color: #1976D2;
    font-size: 12pt;
    color: white;
    font-weight: bold;
}

</style>