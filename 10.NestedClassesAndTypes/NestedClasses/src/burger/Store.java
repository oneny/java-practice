package burger;

public class Store {
  public static void main(String[] args) {
    Meal regurMeal = new Meal();
    regurMeal.addToppings("Ketchup", "Mayo", "Bacon", "Cheddar");
    System.out.println(regurMeal);

    Meal USRegularMeal = new Meal(0.68);
    System.out.println(USRegularMeal);
  }
}
