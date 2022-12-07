BEGIN TRANSACTION;

--Inserting users into database
INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('bigFoody', '$2a$10$TdHW3cUNn0FMa3U2kR22Vu28C72TPjDE/9pOaYdMehgANPNeaFWLa', 'ROLE_USER');

--Inserting ingredients, recipe and correlation into database for fennel salad
INSERT INTO ingredients (ingredient_name) VALUES ('shallot');
INSERT INTO ingredients (ingredient_name) VALUES ('cider vinegar');
INSERT INTO ingredients (ingredient_name) VALUES ('horseradish');
INSERT INTO ingredients (ingredient_name) VALUES ('extra-virgin olive oil');
INSERT INTO ingredients (ingredient_name) VALUES ('honey');
INSERT INTO ingredients (ingredient_name) VALUES ('Granny Smith apple');
INSERT INTO ingredients (ingredient_name) VALUES ('celery root');
INSERT INTO ingredients (ingredient_name) VALUES ('fennel bulb');
INSERT INTO ingredients (ingredient_name) VALUES ('parsley');
INSERT INTO ingredients (ingredient_name) VALUES ('mint');
INSERT INTO ingredients (ingredient_name) VALUES ('hazelnuts');
INSERT INTO ingredients (ingredient_name) VALUES ('salt');
INSERT INTO ingredients (ingredient_name) VALUES ('black pepper');

INSERT INTO recipes (recipe_name, cook_time, blurb, instructions) VALUES ('Apple, Celery Root and Fennel Salad with Hazelnuts',
20, 'A winter salad with bold and bright flavors', 'In a large bowl, combine the shallot and vinegar. Let sit for 10 minutes.  Whisk in the horseradish, oil and honey. 1 teaspoon salt and 1/2 teaspoon pepper.  Add the apple, celery root and fennel and toss. Stir in the parsley and mint then sprinkle with hazelnuts');

INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (1, 1, '1 small, grated');
INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (1, 2, '1.5 tablespoons');
INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (1, 3, '3 tablespoons, grated, lightly packed');
INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (1, 4, '3 tablespoons');
INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (1, 5, '1 teaspoon');
INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (1, 6, '1 medium size, cored and cut into matchsticks');
INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (1, 7, '1/2 small root, peeled, cut into matchsticks');
INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (1, 8, '1 medium bulb trimmed, thinly sliced');
INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (1, 9, '1/2 cup, chopped');
INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (1, 10, '1/4 cup, chopped');
INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (1, 11, '1/2 cup, toasted and rough chopped');
INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (1, 12, '1 teaspoon');
INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (1, 13, '1/2 teaspoon');

--Inserting ingredients, recipe and correlation into database for Welsh Rarebit
INSERT INTO ingredients (ingredient_name) VALUES ('sharp cheddar cheese');
INSERT INTO ingredients (ingredient_name) VALUES ('all-purpose flour');
INSERT INTO ingredients (ingredient_name) VALUES ('butter, salted');
INSERT INTO ingredients (ingredient_name) VALUES ('cayenne pepper');
INSERT INTO ingredients (ingredient_name) VALUES ('dijon mustard');
INSERT INTO ingredients (ingredient_name) VALUES ('Worcestershire sauce');
INSERT INTO ingredients (ingredient_name) VALUES ('brown ale');
INSERT INTO ingredients (ingredient_name) VALUES ('bread');
INSERT INTO ingredients (ingredient_name) VALUES ('chives');

INSERT INTO recipes (recipe_name, cook_time, blurb, instructions) VALUES ('Welsh Rarebit', 15, 'A traditional British supper of bread and beer cheese',
'1. In a bowl, toss the cheese with 1 tablespoon of the flour.  In a medium saucepan over medium heat, melt the butter. Add the remaining 1 tablespoon of flour, 1/2 teaspoon black pepper and the cayenne.  Cook, whisking constantly, for 1 minute.  Stir in the mustard and Worcestershire then slowly stir in the beer.  Bring to a simmer and cook over medium-low, stirring, until thickened, about 3 minutes.\n\n 2. Reduce the heat to low and add the cheese a handful at a time, whisking until smooth after each addition.  Off heat, season with salt and pepper. To serve, spoon the sauce over the toast and sprinkle with the chives.');

INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (2, 14, '8 ounces, grated');
INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (2, 15, '2 tablespoons');
INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (2, 16, '2 tablespoons');
INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (2, 13, '1/2 teaspoon');
INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (2, 17, '1/4 teaspoon');
INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (2, 18, '1 teaspoon');
INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (2, 19, '1 teaspoon');
INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (2, 20, '1 cup');
INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (2, 21, '4 slices, cut thick');
INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (2, 22, '2 tablespoons, minced');

--Adding recipes to user bigFoody
INSERT INTO users_recipes (user_id, recipe_id) VALUES (3, 1);
INSERT INTO users_recipes (user_id, recipe_id) VALUES (3, 2);

--Adding a meal plan to user bigFoody
INSERT INTO meal_plan (user_id, plan_name) VALUES (3, 'Dinner and a side, 3 nights a week');

COMMIT TRANSACTION;
