import axios from 'axios';

export default {

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
    
}