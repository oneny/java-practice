import java.util.ArrayList;

record OrderItem(int qty, ProductForSale product) {}

public class Store {

  private static ArrayList<ProductForSale> storedProducts = new ArrayList<>();

  public static void main(String[] args) {
    storedProducts.add(new ArtObject("Oil Painting", 1350, "Impressionistic work by ABF painted in 2010"));
    storedProducts.add(new ArtObject("Sculpture", 2000, "Bronze work by JKF, produced in 1950"));

    listProducts();

    var order1 = new ArrayList<OrderItem>();
    addItemToOrder(order1, 1, 2);
    addItemToOrder(order1, 0, 1);
    printOrder(order1  );
  }

  public static void listProducts() {
    for (var item : storedProducts) {
      System.out.println("-".repeat(30));
      item.showDetails();
    }
  }

  public static void addItemToOrder(ArrayList<OrderItem> order, int orderIndex, int qty) {
    order.add(new OrderItem(qty, storedProducts.get(orderIndex)));
  }

  public static void printOrder(ArrayList<OrderItem> order) {
    double salesTotal = 0;
    for (OrderItem item : order) {
      item.product().printPricedItem(item.qty());
      salesTotal += item.product().getSalesPrice(item.qty());
    }
    System.out.printf("Sales Total = $%6.2f %n", salesTotal);
  }
}
