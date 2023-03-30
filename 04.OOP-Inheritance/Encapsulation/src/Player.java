public class Player {
  private String fullName;
  private int health;
  private String weapon;

  public Player(String fullName) {
    this(fullName, 100, "Sword");
  }

  public Player(String fullName, int health, String weapon) {
    this.fullName = fullName;
    if (health <= 0) this.health = 1;
    else this.health = Math.min(health, 100);
    this.weapon = weapon;
  }

  public void loseHealth(int damage) {
    health = health - damage;
    if (health <= 0) System.out.println("Player knocked out of game");
  }

  public int healthRemaining() {
    return health;
  }

  public void restoreHealth(int extraHealth) {
    health += extraHealth;
    if (health > 100) {
      System.out.println("Player restored to 100%");
      health = 100;
    }
  }
}
