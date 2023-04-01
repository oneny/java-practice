import java.net.PasswordAuthentication;

public class Main {

  public static int multiplier = 7;
  public static void main(String[] args) {

    Account timsAccount = new Account("Tim");
    timsAccount.deposit(1000);
    timsAccount.withdraw(500);
    timsAccount.withdraw(-200);
    timsAccount.deposit(-20);
    timsAccount.calculateBalance();

    System.out.println("Balance on account is " + timsAccount.getBalance());

    System.out.println("--------------------------------------------------------");

    StaticTest firstInstance = new StaticTest("1st Instance");
    System.out.println(firstInstance.getName() + " is instance number " + StaticTest.getNumInstance());

    StaticTest secondInstance = new StaticTest("1st Instance");
    System.out.println(secondInstance.getName() + " is instance number " + StaticTest.getNumInstance());

    int answer = multiply(5);
    System.out.println("The answer is" + answer);
    System.out.println("Multiplier is " + multiplier);

    System.out.println("--------------------------------------------------------");

    SomeClass one = new SomeClass("one");
    SomeClass two = new SomeClass("two");
    SomeClass three = new SomeClass("three");

    System.out.println(one.getInstanceNumber());

    System.out.println("--------------------------------------------------------");

    int pw = 12345;
    Password password = new ExtendedPassword(pw);
    password.storePassword();
    password.letMeIn(12341);
  }

  public static int multiply(int number) {
    return number * multiplier;
  }
}