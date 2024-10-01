public class HealthyEating { // What does Javadoc comment mean!? 7 Potential points off for that...

    public static Food[] mealPrep(int numFoods) {
        Food[] foodArray = new Food[numFoods];
        for (int i = 0; i < numFoods; i++) {
            foodArray[i] = Food.values()[generateRandom(0, 5)];
        }
        return foodArray;
    }

    public static Food[] followRecipe(String recipe) {
        String[] tempStringArray = recipe.split(" ");
        Food[] arrayReturn = new Food[tempStringArray.length];
        for (int i = 0; i < tempStringArray.length; i++) {
            arrayReturn[i] = Food.valueOf(tempStringArray[i]);
        }
        return arrayReturn;
    }

    public static void mealAnalyzer(Food[] foodArray) {
        System.out.println("The following types of food are in your meal:");

        int[] foodCount = new int[6];
        Food[] foodNames = new Food[6];

        for (int i = 0; i < 6; i++) {
            foodCount[i] = 0;
        }

        for (int i = 0; i < foodArray.length; i++) {
            for (int j = 0; j < 6; j++) {
                if (foodArray[i] == Food.values()[j]) {
                    foodCount[j]++;
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            System.out.printf("%s %d\n", Food.values()[i], foodCount[i]);
        }

        // String[][] foodDistribution = new String[6][2]; // pseudo hash table // didn't work
        // for (int i = 0; i < Food.values().length; i++) {
        //     foodDistribution[i][0] = String.valueOf(Food.values()[i]);
        //     foodDistribution[i][1] = "0";
        // }

        // for (int i = 0; i < foodArray.length; i++) {
        //     int foodCount = Integer.parseInt(foodDistribution[i][1]);
        //     System.out.println(foodCount + "----");
        //     System.out.println(foodArray[i].ordinal() + "++++");

        //     foodDistribution[foodArray[i].ordinal()][1] = String.valueOf(foodCount + 1);
        // }

        // for (int i = 0; i < Food.values().length; i++) {
        //     System.out.print(Food.values()[i]);
        //     System.out.printf(" %d\n", Integer.parseInt(foodDistribution[i][1]));
        // }


        // Hashtable<Food, Integer> foodDistribution = new Hashtable<>();  // Works

        // for (int i = 0; i < Food.values().length; i++) {
        //     foodDistribution.put(Food.values()[i], 0);
        // }

        // for (int i = 0; i < foodArray.length; i++) {
        //     int foodCount = foodDistribution.get(foodArray[i]);
        //     foodDistribution.put(foodArray[i], foodCount + 1);
        // }

        // for (int i = 0; i < Food.values().length; i++) {
        //     System.out.print(Food.values()[i]);
        //     System.out.printf(" %d\n", foodDistribution.get(Food.values()[i]));
        // }
    }

    public static void healthyChoice(Food[] meal1, Food[] meal2) {
        int meal1Count = 0;
        int meal2Count = 0;

        for (int i = 0; i < meal1.length; i++) {
            meal1Count += meal1[i].ordinal();
        }
        for (int i = 0; i < meal2.length; i++) {
            meal2Count += meal2[i].ordinal();
        }

        if (meal1Count == meal2Count) {
            System.out.printf("The two meals are equally healthy with scores of %d\n", meal1Count);
        }

        if (meal1Count > meal2Count) {
            System.out.printf("The first meal is the healthier choice with a score of %d\n", meal1Count);
        } else {
            System.out.printf("The second meal is the healthier choice with a score of %d\n", meal2Count);
        }
    }

//////////////// Main method ////////////////

    public static void main(String[] args) {
        // --- 6.A --- //


        Food[] meal1;
        Food[] meal2;

        // --- 6.B.1 --- //

        meal1 = HealthyEating.mealPrep(generateRandom(5, 20));
        meal2 = HealthyEating.mealPrep(generateRandom(5, 20));

        System.out.printf("--- 6.B.2 ---\n");

        HealthyEating.mealAnalyzer(meal1);
        HealthyEating.mealAnalyzer(meal2);

        System.out.printf("--- 6.B.3 ---\n");

        HealthyEating.healthyChoice(meal1, meal2);

        System.out.printf("--- 6.B.4 ---\n");

        meal1 = HealthyEating.followRecipe("FRUIT VEGETABLE PROTEIN JUNK_FOOD DAIRY");
        meal2 = HealthyEating.followRecipe("FRUIT JUNK_FOOD PROTEIN JUNK_FOOD DAIRY");

        HealthyEating.healthyChoice(meal1, meal2);

        meal1 = HealthyEating.followRecipe("FRUIT JUNK_FOOD PROTEIN JUNK_FOOD DAIRY");
        meal2 = HealthyEating.followRecipe("FRUIT VEGETABLE PROTEIN JUNK_FOOD DAIRY");

        HealthyEating.healthyChoice(meal1, meal2);

        meal1 = HealthyEating.followRecipe("FRUIT VEGETABLE PROTEIN JUNK_FOOD DAIRY");
        meal2 = HealthyEating.followRecipe("FRUIT VEGETABLE PROTEIN JUNK_FOOD DAIRY");

        HealthyEating.healthyChoice(meal1, meal2);
    }


////// Personal methods for further abstraction //////

    //Inclusive of upperEnd in int form.
    public static int generateRandom(int lowerEnd, int upperEnd) {
        return (int) (lowerEnd + (Math.random() * (upperEnd + 1 - lowerEnd)));
    }
}