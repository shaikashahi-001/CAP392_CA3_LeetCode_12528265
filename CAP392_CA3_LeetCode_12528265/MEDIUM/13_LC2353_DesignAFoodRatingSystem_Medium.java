import java.util.*;

class FoodRatings {

    Map<String, String> foodCuisine = new HashMap<>();
    Map<String, Integer> foodRating = new HashMap<>();
    Map<String, TreeSet<String>> cuisineFoods = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

        for (int i = 0; i < foods.length; i++) {
            foodCuisine.put(foods[i], cuisines[i]);
            foodRating.put(foods[i], ratings[i]);

            cuisineFoods.putIfAbsent(cuisines[i], new TreeSet<>((a, b) -> {
                int ratingA = foodRating.get(a);
                int ratingB = foodRating.get(b);

                if (ratingA != ratingB) {
                    return ratingB - ratingA;
                }

                return a.compareTo(b);
            }));

            cuisineFoods.get(cuisines[i]).add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {

        String cuisine = foodCuisine.get(food);

        cuisineFoods.get(cuisine).remove(food);

        foodRating.put(food, newRating);

        cuisineFoods.get(cuisine).add(food);
    }

    public String highestRated(String cuisine) {
        return cuisineFoods.get(cuisine).first();
    }
}