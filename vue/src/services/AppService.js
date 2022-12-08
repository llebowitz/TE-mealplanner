import axios from 'axios';

export default {

    //getrecipes that takes the filter. Google how to send a query param for an axios request.
    //axios.get('/recipes/', {params: {filter: filter}})

    getRecipes(filter) {
        return axios.get('/recipes/', {params: {searchWord: filter}});
    },

    getRecipe(recipeID) {
        return axios.get(`/recipes/${recipeID}`);
    },

    addRecipe(recipe) {
        return axios.post('/recipes', recipe);
    },

    updateRecipe(recipe) {
        return axios.put(`/recipes/${recipe.recipeID}`, recipe);
    },

    deleteRecipe(recipeID) {
        return axios.delete(`/recipes/${recipeID}`);
    },

    saveRecipe(recipeID) {
        return axios.post('/users/recipes', recipeID);
    },

    unsaveRecipe(recipeID) {
        return axios.delete(`/users/recipes/${recipeID}`)
    },

    getMyRecipes() {
        return axios.get()
    }
    
}