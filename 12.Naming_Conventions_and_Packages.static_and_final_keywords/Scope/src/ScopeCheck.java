public class ScopeCheck {
  public int publicVar = 0;
  private int privateVar = 1;

  public ScopeCheck() {
    System.out.println("ScopeCheck craeted, publicVar = " + publicVar + ": privateVar =  " + privateVar);
  }

  public int getPrivateVar() {
    return privateVar;
  }

  public void timesTwo() {
    int privateVar = 2;
    for (int i = 0; i < 10; i++) {
      System.out.println(i + " times two is " + i * privateVar);
    }
  }

  public void useInner() {
    InnerClas innerClass = new InnerClas();
    System.out.println("privateVar from outer class: " + innerClass.privateVar);
  }

  public class InnerClas {
    private int privateVar = 3;
     public InnerClas() {
       System.out.println("InnerClass created, privatedVar is " + privateVar);
     }

    public void timesTwo() {
      for (int i = 0; i < 10; i++) {
        System.out.println(i + " times two is " + i * privateVar);
        System.out.println(i + " times two is " + i * ScopeCheck.this.privateVar);
      }
    }
  }
}
