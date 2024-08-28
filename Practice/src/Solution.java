/*
Complete this program with necessary implementation

- FoodFactory class should have a method named getFactory which return new instance of FoodFactory
- serveFood should return Cuisine if it is available with sample format (check sample output)
- If any cuisine is not available it should return UnservableCuisineRequestException with sample format (check sample output)

Sample Input:
Chinese Chowmin
Japanease Sushi
American Burger

Sample Output:
Serving Chowmin(Chinese)
Serving Sushi(Japanease)
Unservable cuisine American for dish Burger
*/

import java.util.HashMap;
import java.util.Scanner;

abstract class Cuisine {
    public abstract Cuisine serveFood(String dish);
}

class UnservableCuisineRequestException extends Exception {
    public UnservableCuisineRequestException(String message) {
        super(message);
    }
}

// implement necessary classes here
class Chinese extends Cuisine {
    String cuisineDish;

    @Override
    public Cuisine serveFood(String dish) {
        cuisineDish = dish;
        return this;
    }

    public String getDish() {
        return cuisineDish;
    }
}

class Italian extends Cuisine {
    String cuisineDish;

    @Override
    public Cuisine serveFood(String dish) {
        cuisineDish = dish;
        return this;
    }

    public String getDish() {
        return cuisineDish;
    }
}

class Japanese extends Cuisine {
    String cuisineDish;

    @Override
    public Cuisine serveFood(String dish) {
        cuisineDish = dish;
        return this;
    }

    public String getDish() {
        return cuisineDish;
    }
}

class Mexican extends Cuisine {
    String cuisineDish;

    @Override
    public Cuisine serveFood(String dish) {
        cuisineDish = dish;
        return this;
    }

    public String getDish() {
        return cuisineDish;
    }
}


class FoodFactory {
    private static FoodFactory instance;
    private HashMap<String, Cuisine> allCuisines;

    public static FoodFactory getFactory() {
        if (instance == null)
            instance = new FoodFactory();
        return instance;
    }

    public void registerCuisine(String cuisine, Cuisine c) {
        if (allCuisines == null)
            allCuisines = new HashMap<>();

        allCuisines.put(cuisine, c);
    }

    public Cuisine serveCuisine(String cuisine, String dish) throws UnservableCuisineRequestException {
        Cuisine c = allCuisines.get(cuisine);
        if (c == null)
            throw new UnservableCuisineRequestException("Unservable cuisine " + cuisine + " for dish " + dish);
        c = c.serveFood(dish);
        return c;
    }

}


public class Solution {
    private static final Scanner INPUT_READER = new Scanner(System.in);
    private static final FoodFactory FOOD_FACTORY = FoodFactory.getFactory();

    static {
        FoodFactory.getFactory().registerCuisine("Chinese", new Chinese());
        FoodFactory.getFactory().registerCuisine("Italian", new Italian());
        FoodFactory.getFactory().registerCuisine("Japanese", new Japanese());
        FoodFactory.getFactory().registerCuisine("Mexican", new Mexican());
    }

    public static void main(String[] args) {
        int totalNumberOfOrders = Integer.parseInt(INPUT_READER.nextLine());
        while (totalNumberOfOrders-- > 0) {
            String[] food = INPUT_READER.nextLine().split(" ");
            String cuisine = food[0];
            String dish = food[1];

            try {
                if (FOOD_FACTORY.equals(FoodFactory.getFactory())) {
                    Cuisine servedFood = FOOD_FACTORY.serveCuisine(cuisine, dish);

                    switch (cuisine) {
                        case "Chinese":
                            Chinese chineseDish = (Chinese) servedFood;
                            System.out.println("Serving " + chineseDish.getDish() + "(Chinese)");
                            break;
                        case "Italian":
                            Italian italianDish = (Italian) servedFood;
                            System.out.println("Serving " + italianDish.getDish() + "(Italian)");
                            break;
                        case "Japanese":
                            Japanese japaneseDish = (Japanese) servedFood;
                            System.out.println("Serving " + japaneseDish.getDish() + "(Japanese)");
                            break;
                        case "Mexican":
                            Mexican mexicanDish = (Mexican) servedFood;
                            System.out.println("Serving " + mexicanDish.getDish() + "(Mexican)");
                            break;
                        default:
                            break;
                    }
                }
            } catch (UnservableCuisineRequestException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
