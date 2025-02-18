import java.util.List;
// MealPlan Interface 
interface MealPlan {
    String getMealType();
}
// Specific Meal Types
class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian Meal";
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan Meal";
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto Meal";
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High Protein Meal";
    }
}
// Generic meal class which handles different meal plans)
class Meal<T extends MealPlan> {
    private String mealName;
    private List<String> ingredients;
    private T mealType;

    public Meal(String mealName, List<String> ingredients, T mealType) {
        this.mealName = mealName;
        this.ingredients = ingredients;
        this.mealType = mealType;
    }

    public String getMealName() {
        return mealName;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public T getMealType() {
        return mealType;
    }

    @Override
    public String toString() {
        return mealName + " [" + mealType.getMealType() + "] - Ingredients: " + ingredients;
    }
}
// Meal plan generator which includes Generic Method for validation)
class MealPlanGenerator {
    // Generic method to validate and generate a personalized meal plan
    public static <T extends MealPlan> void generateMealPlan(Meal<T> meal) {
        if (meal.getIngredients().isEmpty()) {
            System.out.println("Error: " + meal.getMealName() + " has no ingredients.");
        } else {
            System.out.println("Generated Meal Plan: " + meal);
        }
    }
}
public class PersonalizedMealPlan {
    public static void main(String[] args) {
        // Creating different meal types
        VegetarianMeal vegMealType = new VegetarianMeal();
        VeganMeal veganMealType = new VeganMeal();
        KetoMeal ketoMealType = new KetoMeal();
        HighProteinMeal highProteinMealType = new HighProteinMeal();

        // Creating meal instances
        Meal<VegetarianMeal> vegMeal = new Meal<>("Paneer Salad", List.of("Paneer", "Lettuce", "Olive Oil"), vegMealType);
        Meal<VeganMeal> veganMeal = new Meal<>("Tofu Stir-Fry", List.of("Tofu", "Bell Peppers", "Soy Sauce"), veganMealType);
        Meal<KetoMeal> ketoMeal = new Meal<>("Grilled Chicken", List.of("Chicken", "Olive Oil", "Herbs"), ketoMealType);
        Meal<HighProteinMeal> highProteinMeal = new Meal<>("Protein Smoothie", List.of("Whey Protein", "Banana", "Milk"), highProteinMealType);

        // Generating personalized meal plans
        MealPlanGenerator.generateMealPlan(vegMeal);
        MealPlanGenerator.generateMealPlan(veganMeal);
        MealPlanGenerator.generateMealPlan(ketoMeal);
        MealPlanGenerator.generateMealPlan(highProteinMeal);
    }
}
