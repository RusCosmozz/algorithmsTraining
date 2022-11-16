package otus.hw2_algebraic;

public class AlgebraicAlgs {

  public static void main(String[] args) {
    System.out.println(powIterate(2,8));

    long startTimeI = System.nanoTime();
    System.out.println(fibIterate(20));
    long endTimeI = System.nanoTime();
    System.out.println("итеративно: "+ (endTimeI-startTimeI));

    long startTimeR = System.nanoTime();
    System.out.println(fibRecursive(20));
    long endTimeR = System.nanoTime();
    System.out.println("рекурсивно: "+ (endTimeR-startTimeR));

    System.out.println(isPrime(11));
  }

  public static long powIterate(long base, int degree){
    long res = 1;
    for (int i = 0; i < degree; i++) {
      res *= base;
    }
    return res;
  }

  public static long fibRecursive(int n){
    if (n == 0 || n == 1){
      return n;
    } else {
      return fibRecursive(n-1)+fibRecursive(n-2);
    }
  }

  public static long fibIterate(int n){
    long[] fibs = new long[n];
    fibs[0]=1;
    fibs[1]=1;
    for (int i = 2; i < n; i++) {
      fibs[i] = fibs[i-1]+fibs[i-2];
    }
    return fibs[n-1];
  }

  public static boolean isPrime(long n){
    for (int i = 2; i < Math.sqrt(n); i++) {
      if (n % i == 0){
        return false;
      }
    }
    return true;
  }

}
