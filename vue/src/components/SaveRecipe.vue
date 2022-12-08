<template>
  <div>
    <button id="save-button" v-on:click="flipStatus(savedRecipe)">
      {{ savedRecipe.status === "saved" ? "Unsave" : "Save" }}
    </button>
  </div>
</template>

<script>
import AppService from "../services/AppService.js";

export default {
  name: "add-recipe",
  data() {
    return {
      savedRecipe: {
        id: 0,
        status: "unsaved",
      },
    };
  },
  methods: {
    flipStatus(savedRecipe) {
      if (savedRecipe.status == "saved") {
        AppService.unsaveRecipe(this.$route.params.id).then((response) => {
          if (response.status === 200) {
              this.savedRecipe.status == "unsaved";
          }
        });
      } else if (savedRecipe.status == "unsaved") {
        AppService.saveRecipe(this.$route.params.id).then((response) => {
          if (response.status === 201) {
            this.savedRecipe.status = "saved";
          }
        });
      }
    },
  },
};
</script>

<style>
#save-button {
    border: 2px;
    border-color: black;
    border-style: solid;
}
</style>