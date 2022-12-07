<template>
  <div id="app">
  <v-app id="inspire">
    <v-row justify="center">
      <v-dialog class="recipe-form"
        v-model="dialog"
        fullscreen
        hide-overlay
        transition="dialog-bottom-transition"
      >
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            color="primary"
            dark
            v-bind="attrs"
            v-on="on"
          >
            Add Recipe
          </v-btn>
        </template>
        <v-card>
          <v-toolbar
            dark
            color="primary"
          >
            <v-btn
              icon
              dark
              @click="dialog = false"
            >
              <v-icon>mdi-close</v-icon>
            </v-btn>
            <v-toolbar-title>New Recipe:</v-toolbar-title>
            <v-spacer></v-spacer>
            <v-toolbar-items>
              <v-btn
                dark
                text
                @click="dialog = false"
              >
                Save
              </v-btn>
            </v-toolbar-items>
          </v-toolbar>
          <v-list
            three-line
            subheader
          >
            <v-subheader>This will be added to your saved recipes.</v-subheader>
          
       
        <v-card-text>
          <v-container>
            <v-row>
            <v-col
                cols="12"
                sm="6"
              >
                <v-text-field
                  label="Recipe Name*"
                  required
                ></v-text-field>
     
              </v-col>
               <v-col
                cols="12"
                sm="6"
              >
                <v-text-field
                  label="Email*"
                  required
                ></v-text-field>
              </v-col>
             <v-col cols="3">
          <v-autocomplete
                  :items="['Skiing', 'Ice hockey', 'Soccer', 'Basketball', 'Hockey', 'Reading', 'Writing', 'Coding', 'Basejump']"
                  label="Ingredient"
                  multiple
                ></v-autocomplete>
        </v-col>
           <v-col cols="3">
          <v-text-field
            label="Amount"
            placeholder="5"
          ></v-text-field>
        </v-col>
        <v-col cols="6">
          <v-select
            v-model="select"
            :hint="`${select.state}, ${select.abbr}`"
            :items="items"
            item-text="state"
            item-value="abbr"
            label="Unit of Measurement"
            persistent-hint
            return-object
            single-line
          ></v-select>
           <v-btn
      class="mx-2"
      fab
      dark
      color="indigo"
    >
      <v-icon dark>
        mdi-plus
      </v-icon>
    </v-btn>
        </v-col>
             <v-textarea
      name="input-7-1"
      filled
      label="Label"
      auto-grow
      value="The Woodman set to work at once, and so sharp was his axe that the tree was soon chopped nearly through."
    ></v-textarea>
            </v-row>
          </v-container>
          <small>*indicates required field</small>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
        
          </v-list>
        </v-card>
      </v-dialog>
    </v-row>
  </v-app>
</div>
</template>

<script>
import appService from "../services/AppService";

export default {
data () {
    return {
      dialog: false,
      notifications: false,
      sound: true,
      widgets: false,
      select: { state: 'Florida', abbr: 'FL' },
      items: [
        { state: 'g' },
        { state: 'oz' },
        { state: 'item' },
        { state: 'lb' },
        { state: 'cups'}
        ,]
    }
  },
	// methods: {
  //   saveNewRecipe() {
  //     appService.addRecipe(this.recipe).then(response => {

  //     })
  //   }

  // },
};
</script>
