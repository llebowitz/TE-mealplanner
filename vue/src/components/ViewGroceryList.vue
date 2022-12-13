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
  border: 1px black solid,
  
}

</style>