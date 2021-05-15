package com.example.healthyfoodapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DatabaseRecipes  extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "database recipes";
    private static final String DB_NAME = "foodapp";
    private static final int DB_VERSION = 1;

    private Context ctx;


    DatabaseRecipes(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL("CREATE TABLE FOOD_RECIPES ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "IMAGE_RESOURCE_ID INTEGER, "
                + "INGREDIENTS TEXT, "
                + "INSTRUCTIONS TEXT, "
                + "FAVORITE NUMERIC);");


        db.execSQL("CREATE TABLE MY_FOOD_RECIPES ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "IMAGE_RESOURCE_ID INTEGER, "
                + "INGREDIENTS TEXT, "
                + "INSTRUCTIONS TEXT, "
                + "FAVORITE NUMERIC);");


        db.execSQL("CREATE TABLE SWEET ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "IMAGE_RESOURCE_ID INTEGER, "
                + "INGREDIENTS TEXT, "
                + "INSTRUCTIONS TEXT, "
                + "FAVORITE NUMERIC);");


        db.execSQL("CREATE TABLE FAVORITES ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "IMAGE_RESOURCE_ID INTEGER, "
                + "INGREDIENTS TEXT, "
                + "INSTRUCTIONS TEXT, "
                + "FAVORITE NUMERIC);");


        insertFoodRecipe(db, "Cauliflower Pizza", R.drawable.cauliflower_pizza_crust1,
                "Ingredients:\n" +
                        "\n" +
                        "Cauliflower: You will need a large head of cauliflower, 6″ – 7″ in diameter, about 2.5 – 3 lbs.\n" +
                        "Egg: Egg is part of “the glue” that holds cauliflower pizza dough together.\n" +
                        "Cheese: As cheese melts during baking, it helps to bind small pieces of cauliflower into a crust.\n" +
                        " Cheese is crucial! So is the egg. Sorry cannot be vegan.\n" +
                        "Spices: Simple dried herbs like oregano, basil or Italian mix plus salt and pepper add flavor\n" +
                        " to the crust. Cauliflower itself is pretty bland. Also you can add garlic powder.\n",
                "Preparation:\n" +
                        "\n" +
                        "Cut the cauliflower. Food processor: Place cauliflower florets in a food processor and process until\n" +
                        " “rice” texture. Some coarse chunks are fine. You will be baking and then squeezing the cauliflower,\n" +
                        " so chunks do not matter. Spread rice on same baking sheet. Bake in the oven for 15 minutes. Squeeze All Water Out.\n" +
                        " Transfer squeezed cauliflower to a bowl. Add egg, oregano or basil, cheese, salt and pepper, and mix well.\n" +
                        "Add Toppings and Bake. Load it up in this order: Add pizza sauce, toppings, cheese and bake again until cheese is melted.\n",
                false);

        insertFoodRecipe(db, "Pasta", R.drawable.pasta,
                "\n" +
                        "Ingredients:\n" +
                        "Pasta: You can use ANY pasta you want: Gluten-free, whole wheat, brown rice, quinoa, kamut pasta.\n" +
                        "Veggies: Broccoli florets, coarsely chopped. Sun-dried tomatoes (dry or packed in oil), thinly sliced. Grape tomatoes halved.\n" +
                        "Pesto sauce: Store-bought or homemade pesto, divided. Pasta water, reserved.\n" +
                        "Seasoning: Garlic cloves, minced. Salt. Red pepper flakes. Ground black pepper, to taste.\n" +
                        "Oil: Extra virgin olive oil.\n" +
                        "Cheese: Freshly grated Parmesan cheese.",
                "Instructions:\n" +
                        "Put pasta in a water for cooking and saute garlic in olive oil for a few seconds. Stir frequently. Add a bit of pesto and \n" +
                        "tomatoes and give it a stir. Continue cooking for a couple of minutes and stir again. Move ingredients\n" +
                        " to one side of the skillet, making sure the empty spot is right above the heat. Add a bit of pesto and\n" +
                        " broccoli to the empty spot in the skillet and cook stirring once. ",
                false);

        insertFoodRecipe(db, "Chilly chicken", R.drawable.chilly_chicken,
                "Ingredients:\n" +
                        "1 cup cooked quinoa\n" +
                        "1 cup cooked brown rice\n" +
                        "1 pound cooked Chili-Lime Chicken (see Associated recipe)\n" +
                        "1 cup julienned jicama\n" +
                        "1 cup frozen corn, thawed\n" +
                        "1 cup pico de gallo\n" +
                        "1 avocado, diced\n" +
                        "½ cup chopped fresh cilantro\n" +
                        "1 slice Lime wedges\n" +
                        "1 dash Hot sauce, such as Cholula",
                "DIRECTIONS\n" +
                        "1. Heat the oil in a nonstick skillet over medium-high heat. \n" +
                        "Throw in the tofu and break it up into very small pieces. \n" +
                        "Cook until much of the liquid cooks off and the tofu starts to turn golden, for several minutes.\n" +
                        "\n" +
                        "2. Add the chili powder and some salt and pepper, then stir.\n" +
                        " Throw in the green onions and corn and cook for a few minutes (the corn can remain crunchy).\n" +
                        " Add the soy sauce and cook until most of the liquid has been absorbed. \n" +
                        "Turn off the heat and stir in the balsamic vinegar.\n" +
                        "\n" +
                        "3. Pile the mixture into individual romaine lettuce leaves, then add slices of avocado. \n" +
                        "Fold up and chow down!\n",
                false);
        insertFoodRecipe(db, "Tofu wraps", R.drawable.tofu_wraps,
                "INGREDIENTS\n" +
                        "2 tsp peanut oil\n" +
                        "1 package firm tofu (12- to 14-oz size)\n" +
                        "¼ tsp chili powder, or more to taste\n" +
                        "Kosher salt and freshly ground black pepper\n" +
                        "3 green onions, sliced\n" +
                        "2 ears fresh corn, kernels cut off cobs\n" +
                        "¼ cup soy sauce\n" +
                        "1 tsp balsamic vinegar\n" +
                        "6 large inner leaves romaine lettuce (from romaine heart)\n" +
                        "2 avocados, sliced",
                "INSTRUCTIONS:\n" +
                        "1. Heat the oil in a nonstick skillet over medium-high heat. \n" +
                        "Throw in the tofu and break it up into very small pieces. \n" +
                        "Cook until much of the liquid cooks off and the tofu starts to turn golden, for several minutes.\n" +
                        "\n" +
                        "2. Add the chili powder and some salt and pepper, then stir.\n" +
                        " Throw in the green onions and corn and cook for a few minutes (the corn can remain crunchy).\n" +
                        " Add the soy sauce and cook until most of the liquid has been absorbed. \n" +
                        "Turn off the heat and stir in the balsamic vinegar.\n" +
                        "\n" +
                        "3. Pile the mixture into individual romaine lettuce leaves, then add slices of avocado. \n" +
                        "Fold up and chow down! ",
                false);
        insertFoodRecipe(db, "Egg White Muffin Breakfast Cups", R.drawable.egg_muffin_breakfast,
                "Ingredients:\n" +
                        "Egg whites\n" +
                        "Garlic and onions\n" +
                        "Cheese\n" +
                        "Mix and match veggies(zucchini, mushrooms,...)",
                " Skip wasting your perfectly good eggs and use the liquid egg whites in a carton for this. You can usually find them near the milk and heavy cream.\n" +
                        "Use garlic and onion powder, about 1/2 teaspoon per 12 muffins.\n" +
                        "Cheese is optional. Skip it if you want super healthy muffins. Otherwise, you can mix the cheese in with everything or use it as a topping before baking.\n" +
                        "Mix and match veggies: You’re not limited to the veggies in the recipe so feel free to try out other combinations of veggies like shredded zucchini, mushrooms,\n" +
                        " kale and broccoli. Check out the combo suggestions below for more combinations.\n" +
                        "Muffin pan: Use a nonstick muffin pan and grease it beforehand. If they still stick, try using cupcake liners.",
                false);
        insertFoodRecipe(db, "Healthy Burrito", R.drawable.burrito,
                "Ingredients:\n" +
                        "Dough:\n" +
                        "1 cup ground oats (oat flour) (100g)\n" +
                        "1 cup spelt flour (125g)\n" +
                        "2 tbsp tapioca or cornstarch\n" +
                        "1 tsp baking powder\n" +
                        "1 tsp salt\n" +
                        "1/2 cup hot water (120ml)\n" +
                        "1/4 cup unsweetened applesauce (65g)\n" +
                        "\n" +
                        "Toppings:\n" +
                        "2 tbsp sweet potato\n" +
                        "2 tbsp black beans\n" +
                        "2 tbsp homemade salsa\n" +
                        "1/2 scrambled egg\n" +
                        "2 slices avocado\n" +
                        "2 tbsp grated cheddar cheese",
                "Preparation:\n" +
                        "In a bowl, mix together ground oats, spelt flour, cornstarch, baking powder and salt. Mix well.\n" +
                        "Add the hot water and applesauce, and using a wooden spoon mix until dough starts to form.\n" +
                        "Transfer the dough to the floured surface and press couple of times. Wrap it up and let rest for 15 minutes.\n" +
                        "Cut the dough into 5 equal portions, roll them into balls, cover and let rest for 10 more minutes.\n" +
                        "Roll each ball with a rolling pin into a round shape tortilla.\n" +
                        "Cook on dry skillet over high heat for 1 minute per side. Cover your tortillas with clean kitchen towel to keep warm and soft.\n" +
                        "Wrap your burrito in a way you like the most, with your favorite toppings.\n",
                false);
        insertFoodRecipe(db, "Tuna Couscous Salad", R.drawable.tuna_cuscus,
                "Ingredients\n" +
                        "1 cup couscous\n" +
                        "1 cup boiling water\n" +
                        "420g can tuna in spring water, drained and flaked\n" +
                        "420g can reduced-salt corn kernels, drained\n" +
                        "2 cups frozen peas\n" +
                        "4 spring onions (including green tops), finely sliced\n" +
                        "1 cup fresh coriander, finely chopped\n" +
                        "2 tablespoons sweet chilli sauce\n" +
                        "1 tablespoon lemon juice\n" +
                        "2 teaspoons curry powder, optional",
                "Method:\n" +
                        "Place couscous in a small heatproof bowl, pour over boiling water; cover and set aside for 3 minutes.\n" +
                        "In a large bowl combine the tuna, corn, peas, spring onions and coriander.\n" +
                        "Fluff couscous with a fork to separate grains and stir through sweet chilli sauce, lemon juice and curry powder.\n" +
                        "Add couscous mixture to salad ingredients, mix well and serve.",
                false);
        insertFoodRecipe(db, "Potato and Cauliflower Salad", R.drawable.roasted_potao_cauliflower_salad,
                "Ingredients:\n" +
                        "For salad:\n" +
                        "1 head cauliflower, leaves removed, bottom stem trimmed\n" +
                        "1 pound sweet potatoes, peeled and cut into 1/2-inch dice\n" +
                        "1 tablespoon olive oil\n" +
                        "1/2 teaspoon kosher salt\n" +
                        "1/4 teaspoon black pepper\n" +
                        "1/4 cup farro\n" +
                        "2/3 cup water\n" +
                        "5 ounces spinach\n" +
                        "2 scallions, thinly sliced\n" +
                        "1 tablespoon chopped parsley\n" +
                        "1 ounce shaved pecorino cheese\n" +
                        "For vinaigrette:\n" +
                        "1 garlic clove, minced\n" +
                        "2 tablespoons sherry vinegar\n" +
                        "1/4 teaspoon kosher salt\n" +
                        "1/4 teaspoon black pepper\n" +
                        "1/4 cup olive oil",
                "Instructions:\n" +
                        "Preheat the oven to 400 degrees F.\n" +
                        "Cut the cauliflower lengthwise into 3/4-inch slices.\n" +
                        "Toss the cauliflower and sweet potatoes with 1 tablespoon olive oil, 1/2 teaspoon salt and 1/4 teaspoon pepper on a sheet pan and spread into a single layer.\n" +
                        " Roast for 30-35 minutes until the sweet potatoes are tender and the cauliflower is browned. Flip the cauliflower and toss around the potatoes about\n" +
                        " halfway through roasting.\n" +
                        "While the potatoes and cauliflower are roasting, cook the farro on the stove. In a small saucepan over high heat, combine the farro and water.\n" +
                        " Bring to a boil, reduce the heat, cover and simmer the farro for 20-25 minutes until the grains are tender. Drain any remaining water.\n" +
                        "In a large bowl, combine the sweet potatoes, cauliflower, farro, spinach, scallions, parsley and pecorino.\n" +
                        "For the vinaigrette, combine the garlic, sherry vinegar, salt and pepper in a small bowl. Whisk in the olive oil until fully combined. \n" +
                        "Drizzle the vinaigrette into the salad, tossing together.",
                false);

        insertFoodRecipe(db, "Fried Rice Salad", R.drawable.easy_fried_rice,
                "Ingredients\n" +
                        "Butter\n" +
                        "Eggs\n" +
                        "Veggies\n" +
                        "Rice\n" +
                        "Soy sauce\n" +
                        "Oyster sauce\n" +
                        "Sesame oil.\n",
                "Instructions:\n" +
                        "Start by heating 1 tablespoon of butter into a large skillet. Add the eggs and scramble until fully cooked.\n" +
                        " Remove them from the pan and set aside. Add the remaining tablespoon of butter into the pan. \n" +
                        "Add carrots and onion to the pan and cook until tender, 3-4 minutes. Stir in garlic and cook for\n" +
                        " an additional minute. Add in the cold rice and peas and sauté for 3-4 minutes. The rice should brown up a bit.\n" +
                        " Add the eggs back to the pan and stir in soy sauce, oyster sauce and sesame oil. Cook for 1-2 minutes to heat\n" +
                        " through. Serve immediately with green onions for garnish, if desired.",
                false);


        //Sweet
        insertSweet(db, "Healthy Granola Bar", R.drawable.granola1,
                "Ingredients:\n" +
                        "3 cups rolled oats (270g)\n" +
                        "1/2 cup chopped almonds (70g)\n" +
                        "1/2 cup chopped walnuts (60g)\n" +
                        "1/2 cup pumpkin seeds (70g)\n" +
                        "1/2 cup sunflower seeds (70g)\n" +
                        "2 tbsp flaxseed meal\n" +
                        "2 tsp ground cinnamon\n" +
                        "1/2 tsp salt\n" +
                        "1/2 cup unsweetened applesauce (130g)\n" +
                        "1/3 cup maple syrup, honey or agave (80ml)\n" +
                        "1 egg white\n" +
                        "1/2 cup dried cranberries (or other dried fruits) (70g)\n",
                "Preparation:\n" +
                        "In a bowl, combine all the dry ingredients, rolled oats, almonds, walnuts, pumpkin seeds, sunflower seeds,\n" +
                        " flaxseed meal, cinnamon and salt.\n" +
                        "In separate bowl, mix together applesauce and maple syrup.\n" +
                        "Pour the wet ingredients into the dry and stir well for a minute, to fully incorporate and turn sticky.\n" +
                        "Whisk egg white until foamy and add to the granola mixture, and mix well.\n" +
                        "Add the dried fruits, and mix one more time.\n" +
                        "Spread the granola mixture onto a lined baking tray (13x9 inch in size) and press it well using a spatula.\n" +
                        "Bake at 325F (160C) for 30 minutes.\n" +
                        "Let it cool complete, then break into larger or smaller chunks.\n" +
                        "Serve with yogurt or milk, and top with some fresh berries.",
                false);
        insertSweet(db, "Tres Leches Cake", R.drawable.tres_leches_cake,
                "Ingredients:\n" +
                        "Cake:\n" +
                        "1 cup ground oats or oat flour (100g)\n" +
                        "2 tbsp cornstarch or tapioca starch (20g)\n" +
                        "1.5 tsp baking powder\n" +
                        "1/4 tsp salt\n" +
                        "5 eggs\n" +
                        "For egg whites: 1.5 tbsp maple syrup, honey or agave, and 1 tbsp lemon juice\n" +
                        "For egg yolks: 1/4 cup maple syrup, honey or agave (60ml), 1 tsp vanilla extract\n" +
                        "1/4 cup milk (60ml)\n" +
                        "Milk mixture:\n" +
                        "1 cup unsweetened almond milk (240ml)\n" +
                        "1 cup coconut milk full fat or lite (240ml)\n" +
                        "1/4 cup heavy cream (60ml)\n" +
                        "1/4 cup maple syrup, honey or agave (60ml)\n" +
                        "Frosting: \n" +
                        "1 cup heavy cream (240ml) \n" +
                        "1 tbsp honey",
                "Preparation:\n" +
                        "In a bowl, add the ground oats, cornstarch, baking powder and salt. Set aside.\n" +
                        "Separate eggs in two different bowl.\n" +
                        "Add the sweetener and lemon juice to the egg whites and beat with a mixer for 3-4 minutes,\n" +
                        " until stiff peaks from.\n" +
                        "Add the sweetener and vanilla extract to the egg yolks and beat until pale and foamy.\n" +
                        "Sift the dry ingredients into the egg yolk mixture and stir until combined. Then add the milk and mix it in.\n" +
                        "Pour the egg whites into the egg yolk mixture and gently fold in with the spatula.\n" +
                        "Pour the cake batter into the greased baking dish and bake for 30 minutes at 340F (170C)\n" +
                        "Let it cool completely, then poke the holes using a fork.\n" +
                        "Combine the milks, heavy cream and maple syrup and pour over the cake.\n" +
                        "Let it soak and chill in the fridge overnight.\n" +
                        "Frost with a whipped cream and serve with fresh strawberries or dust with cinnamon and cocoa powder.",
                false);
        insertSweet(db, "Healthy Churros", R.drawable.churros,
                "Ingredients:\n" +
                        "2/3 cup water (150ml)\n" +
                        "1/4 cup butter (50g)\n" +
                        "1 tsp maple syrup or honey\n" +
                        "1/4 tsp salt\n" +
                        "1 1/3 cup ground oats or oat flour (120g)\n" +
                        "1 tsp tapioca starch or cornstarch\n" +
                        "2 eggs\n" +
                        "1/2 tsp vanilla extract\n",
                "Preparation:\n" +
                        "\n" +
                        "In a saucepan, add water, sliced butter, maple syrup and salt. Bring to boil and\n" +
                        " let the butter melts completely.\n" +
                        "Remove from heat and stir in the oats and starch, mix with the wooden spoon until\n" +
                        " the dough ball is formed.\n" +
                        "Let it cook over low heat for 2 minutes, stirring constantly.\n" +
                        "Bring off the heat, let it cool a bit, then add one egg (and vanilla) at a time, \n" +
                        "beating well after each addition, until it's fully incorporated into the dough.\n" +
                        "Transfer the dough into a piping bag, and pipe the churros onto a lined baking tray.\n" +
                        "Bake at 400F (200C) for 18-20 minutes.\n" +
                        "Serve coated in cinnamon sugar or dip into a chocolate sauce.",
                false);
        insertSweet(db, "Chocolate Cheesecake", R.drawable.chocolate_cheesecake,
                "Ingredients:\n" +
                        "For crust:\n" +
                        "1 1/4 cups ground oats or oat flour (125g)\n" +
                        "1 tbsp unsweetened cocoa powder\n" +
                        "1/4 tsp salt\n" +
                        "2 tbsp melted butter\n" +
                        "3 tbsp unsweetened applesauce\n" +
                        "1 tbsp maple syrup, honey or agave\n" +
                        "\n" +
                        "For filling:\n" +
                        "1 cup ricotta cheese (250g)\n" +
                        "1 cup cream cheese (225g)\n" +
                        "2/3 cup homemade Nutella (200g)\n" +
                        "1/4 cup dark chocolate chips (50g)\n" +
                        "\n" +
                        "For chocolate ganache:\n" +
                        "1/2 cup dark chocolate chips (100g)\n" +
                        "3 tbsp water (45ml)\n" +
                        "Homemade Nutella:\n" +
                        "1 cup roasted hazelnuts (130g)\n" +
                        "1/4 cup pitted dates or date paste (75g)\n" +
                        "1/4 cup dark chocolate chips (50g)\n" +
                        "1 tbsp unsweetened cocoa powder\n" +
                        "1 tbsp maple syrup or honey\n" +
                        "2-3 tbsp coconut cream, coconut milk or heavy-whipping cream",

                "It's super creamy and light in texture!\n" +
                        "It's rich in chocolate and hazelnut flavor!\n" +
                        "It's made from natural ingredients, all from scratch!\n" +
                        "It's made without gelatin or sweet condensed milk!",
                false);
        insertSweet(db, "Banana Oatmeal Cookies", R.drawable.banana_oatmeal_cookies,
                "Ingredients:\n" +
                        "2 ripe bananas\n" +
                        "1.5 cups old-fashioned oats (or quick oats) (135g)\n" +
                        "1/3 cup raisins (50g)",
                "Preparation:\n" +
                        "In a bowl, mash the bananas using a fork, add oats and mix well until combined.\n" +
                        " If the mixture is too wet (which depends on the size of the bananas), add some more oats.\n" +
                        "Add the raisins and give a final mix.\n" +
                        "Scoop about 2 tablespoons of cookie mixture and spread on a lined baking sheet.\n" +
                        "Spread the mixture and using your hands form into a cookie shape.\n" +
                        "For medium sized cookies bake for 12 minutes at 350 degrees.\n" +
                        "If making small cookies bake for 9 minutes, and for larger size cookies bake for\n" +
                        "15-20 minutes.\n" +
                        "When baked transfer to a wire rack to cool for 5 minutes, and they're ready to dig in.\n" +
                        "Cool completely before storing in the box.",
                false);
        insertSweet(db, "Peanut Butter Fudge", R.drawable.peanut_butte_fudge,
                "Ingredients:\n" +
                        "1 cup natural peanut butter (250g)\n" +
                        "1/3 cup melted coconut oil (80ml)\n" +
                        "1/2 cup date paste (150g)\n" +
                        "2 tbsp honey or maple syrup\n" +
                        "1/4 tsp salt\n" +
                        "1/4 cup ground oats or oat flour (25g)\n",
                "Preparation:\n" +
                        "In a bowl, add room temperature peanut butter, melted coconut oil, sweet date paste and salt, \n" +
                        "beat with the mixer for 1 minute.\n" +
                        "Add the oat flour, and mix until combined.\n" +
                        "Transfer the fudge mixture into a lined baking tray and smooth evenly.\n" +
                        "Let it chill in the fridge for 2-3 hours, or put it in the freezer for 30 minutes to an hour.\n" +
                        "Using an overhang parchment paper transfer the fudge onto a cutting board and cut into 20 small squares.\n" +
                        "Top with some extra flaky salt or melted dark chocolate.",
                false);
        insertSweet(db, "Coconut Macaroons", R.drawable.coconut_macaroons,
                "Ingredients:\n" +
                        "2 egg whites\n" +
                        "3 tbsp maple syrup, honey or agave\n" +
                        "1/2 tsp vanilla extract\n" +
                        "1/4 tsp salt\n" +
                        "2 cups shredded or desiccated coconut (150g)\n" +
                        "1/4 cup ground oats or oat flour (25g)\n" +
                        "2 tbsp dark chocolate chips (25g), optional\n",
                "Preparation:\n" +
                        "In a bowl, add room temperature egg whites, your sweetener, vanilla extract and salt. Beat with a fork until slightly foamy.\n" +
                        "Add the coconut and oats and mix it in, until the mixture is nice and sticky.\n" +
                        "Using a cookie scoop, scoop out the mixture onto a lined baking tray. If it's falling apart, form the cookie shape with your fingers.\n" +
                        "Bake at 325F (160C) for 20 minutes.\n" +
                        "Let it cool completely in a tray (or at least 30 minutes), to firm up.\n" +
                        "Drizzle with melted dark chocolate.",
                false);
        insertSweet(db, "Cream Puffs", R.drawable.cream_puffs,
                "Ingredients:\n" +
                        "Pastry:\n" +
                        "3/4 cup ground oats or oat flour (75g)\n" +
                        "1/4 cup tapioca starch or cornstarch (35g)\n" +
                        "1/4 tsp salt\n" +
                        "2/3 cup water (150ml)\n" +
                        "1/4 cup butter (50g)\n" +
                        "1 tsp maple syrup, honey or agave\n" +
                        "2 eggs\n" +
                        "\n" +
                        "Filling:\n" +
                        "2/3 cup heavy cream (150ml)\n" +
                        "2/3 cup ricotta cheese (150g)\n" +
                        "2 tbsp honey\n" +
                        "2 tsp vanilla paste or vanilla extract\n",
                "Preparation:\n" +
                        "In a bowl, add the ground oats, cornstarch, and salt. Mix and set aside.\n" +
                        "In a saucepan, add the water, butter and your sweetener. Heat over medium heat and \n" +
                        "when it starts to boil, remove and stir in the dry ingredients. Mix and after couple\n" +
                        " of seconds when the dough starts to form, cook constantly stirring over low heat for \n" +
                        "2 minutes.\n" +
                        "Remove from heat and let it cool for 5 minutes. Add one egg and using a wooden spoon \n" +
                        "or mixer work the egg into the dough. Beat the second egg into the small bowl and add\n" +
                        " slowly to the dough, add just enough to make your dough the right consistency.\n" +
                        "Transfer the dough into a pastry bag or any other freezer bag, and pipe onto a lined \n" +
                        "baking tray.\n" +
                        "Bake at 400F (200C) for 10 minutes, then lower the temperature to 325F (160C) and bake \n" +
                        "for another 20-25 minutes.\n" +
                        "When baked poke a tiny hole on the side of each puff and place back to the turned-off\n" +
                        " oven. Let it cool completely.\n" +
                        "For filling, add the cold cream into the bowl and whip until stif, add the riccota,\n" +
                        " honey and vanilla and mix until combined.\n" +
                        "Using a pastry bag fill your pastry shells.\n" +
                        "Dust with the coconut powdered sugar or drizzle with melted dark chocolate.",
                false);
        insertSweet(db, "Chocolate Banana Bread", R.drawable.chocolate_banana_bread,
                "Ingredients:\n" +
                        "1 1/4 cups ground oats or oat flour (125g)\n" +
                        "2 tbsp tapioca starch or cornstarch\n" +
                        "1/2 cup cocoa powder (50g)\n" +
                        "1 tsp baking soda\n" +
                        "1/2 tsp salt\n" +
                        "1.5 cups mashed bananas - 3 medium bananas (300g)\n" +
                        "2 tbps maple syrup or honey\n" +
                        "1/4 cup unsweetened applesauce (65g)\n" +
                        "1/2 cup Greek yogurt (120g)\n" +
                        "1 egg\n" +
                        "1/4 cup dark chocolate chips (50g) plus some for decoration\n",
                "\n" +
                        "Preparation:\n" +
                        "In a bowl, mix together the ground oats, cornstarch, cocoa powder, baking soda and salt. Mix it up and set aside.\n" +
                        "In another bowl, mash 3 bananas, add the liquid sweetener (maple syrup, honey or agave), applesauce and Greek yogurt, and whisk well until combined.\n" +
                        "Pour the dry ingredients into the wet ingredients and stir just until combined, no more than that.\n" +
                        "Gently fold in the dark chocolate chips.\n" +
                        "Grease your loaf pan with some butter or coconut oil, pour in the batter and smooth the top. Sprinkle with some extra chocolate chips on top.\n" +
                        "Bake for 60 minutes at 350F (180C), tent with aluminum foil to prevent excess browning.\n" +
                        "When baked let it cool in the pan for at least 10 minutes, then turn it onto a wire rack to cool completely.\n" +
                        "Slice and serve with fresh strawberries and spoonful of Greek yogurt",
                false);
        insertSweet(db, "Strawberry Shortcake", R.drawable.strawberry_shortcake,
                "Ingredients:\n" +
                        "Shortcakes:\n" +
                        "1.5 cups ground oats or oat flour (150g)\n" +
                        "1/2 cup spelt flour (65g)\n" +
                        "2 tbsp tapioca starch or cornstarch\n" +
                        "1 tbsp baking powder\n" +
                        "1/4 tsp salt\n" +
                        "3 tbsp butter (45g)\n" +
                        "1 cup (minus 2 tbsp) milk, dairy on non-dairy (210ml)\n" +
                        "1 tbsp maple syrup\n" +
                        "Strawberry filling:\n" +
                        "2 cups sliced strawberries (350g)\n" +
                        "1 tbsp honey or maple syrup\n" +
                        "1 tbsp lemon juice\n" +
                        "Whipped cream:\n" +
                        "3/4 cup heavy whipping cream (or coconut cream) (180ml)\n" +
                        "1 tsp honey\n" +
                        "1 tsp vanilla extract",
                "\n" +
                        "Preparation:\n" +
                        "Place a piece of butter in a freezer for 15 minutes.\n" +
                        "Hull the strawberries and cut into quarters or in slices, transfer to a bowl,\n" +
                        " add honey and lemon juice, stir well and place in the fridge to macerate, for at least 30 minutes.\n" +
                        "In a mixing bowl, add the dry ingredients, ground oats, spelt flour, cornstarch, \n" +
                        "baking powder and salt, mix to combine.\n" +
                        "Grate your cold butter using a box grater over the dry mixture, gently stir with a wooden spoon.\n" +
                        "Pour the milk and maple syrup over the oat mixture and genly stir until soft dough is formed,\n" +
                        " and there's no dry flour visible.\n" +
                        "Scoop out the dough using a cookie scoop and place on a lined baking tray, you'll get 8 drop biscuits.\n" +
                        "Bake at 400F (200C) for 15 minutes.\n" +
                        "Let it cool for 2-3 minutes transfer to a wire rack, and let cool completely.\n" +
                        "In a bowl, add cold heavy cream, honey and vanilla, and whisk until stif peaks form.\n" +
                        "Cut your shortcake in half and serve with a spoonful of strawberry filling and honey whipped cream.\n",
                false);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    private static void insertFoodRecipe(SQLiteDatabase db, String name,
                                         int resourceId, String ingredients,
                                         String instructions, boolean favorite) {
        ContentValues recipeValues = new ContentValues();
        recipeValues.put("NAME", name);
        recipeValues.put("IMAGE_RESOURCE_ID", resourceId);
        recipeValues.put("INGREDIENTS", ingredients);
        recipeValues.put("INSTRUCTIONS", instructions);
        recipeValues.put("FAVORITE", favorite);
        db.insert("FOOD_RECIPES", null, recipeValues);
    }

    public void makeMyRecipe(String myTitle,
                             String myIngredients, String myInstructions) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues myRecipe = new ContentValues();
        myRecipe.put("NAME", myTitle);
        myRecipe.put("IMAGE_RESOURCE_ID", R.drawable.empty_plate);
        myRecipe.put("INGREDIENTS", myIngredients);
        myRecipe.put("INSTRUCTIONS", myInstructions);
        myRecipe.put("FAVORITE", false);

        db.insert("MY_FOOD_RECIPES", null, myRecipe);
        db.close();

    }


    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("FOOD_RECIPES",
                new String[]{"_id", "NAME", "IMAGE_RESOURCE_ID", "INGREDIENTS"},
                null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                Recipe r = new Recipe();

                r.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                r.setDescription(cursor.getString(cursor.getColumnIndex("INGREDIENTS")));
                r.setImageResource(cursor.getInt(cursor.getColumnIndex("IMAGE_RESOURCE_ID")));
                r.setName(cursor.getString(cursor.getColumnIndex("NAME")));

                recipes.add(r);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return recipes;
    }

    public List<Recipe> getSweet() {
        List<Recipe> recipesSweet = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("SWEET",
                new String[]{"_id", "NAME", "IMAGE_RESOURCE_ID"},
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Recipe r = new Recipe();
                r.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                r.setName(cursor.getString(cursor.getColumnIndex("NAME")));
                r.setImageResource(cursor.getInt(cursor.getColumnIndex("IMAGE_RESOURCE_ID")));

                recipesSweet.add(r);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return recipesSweet;
    }

    private static void insertSweet(SQLiteDatabase db, String name,
                                    int resourceId, String ingredients,
                                    String instructions, boolean favorite) {
        ContentValues sweet = new ContentValues();
        sweet.put("NAME", name);
        sweet.put("IMAGE_RESOURCE_ID", resourceId);
        sweet.put("INGREDIENTS", ingredients);
        sweet.put("INSTRUCTIONS", instructions);
        sweet.put("FAVORITE", favorite);
        db.insert("SWEET", null, sweet);
    }

    public List<Recipe> getMyRec() {
        List<Recipe> recipesMyRec = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("MY_FOOD_RECIPES",
                new String[]{"_id", "NAME", "IMAGE_RESOURCE_ID"},
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Recipe r = new Recipe();
                r.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                r.setName(cursor.getString(cursor.getColumnIndex("NAME")));
                r.setImageResource(cursor.getInt(cursor.getColumnIndex("IMAGE_RESOURCE_ID")));

                recipesMyRec.add(r);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return recipesMyRec;
    }

    public void insertFavorites(SQLiteDatabase db, String name,
                                int resourceId, String ingredients,
                                String instructions, boolean favorite) {
        ContentValues favs = new ContentValues();
        favs.put("NAME", name);
        Log.v("DATABASE INSERTfAVE ", "name je: " + name);
        favs.put("IMAGE_RESOURCE_ID", resourceId);
        favs.put("INGREDIENTS", ingredients);
        favs.put("INSTRUCTIONS", instructions);
        favs.put("FAVORITE", favorite);
        db.insert("FAVORITES", null, favs);
    }

    public void deleteFavorite(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.delete("FAVORITES", "NAME=?", new String[]{name});
            Log.v("DATABASE poruka", "ime recpta je: " + name);
        } catch (SQLiteException e) {
            Log.v("DATABASE poruka", "Novi unos");
        }
    }

}