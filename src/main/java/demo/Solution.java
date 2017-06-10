package demo;

import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on 10/06/17 9:53 AM by bhgupta.
 */
class Prime {

  public void checkPrime(int... numbers) {
    String result = "";
    for (int n : numbers) {
      if (isPrime(n)) {
        result += n + " ";
      }
    }
    System.out.println(result.trim());
  }

  private boolean isPrime(int n) {
    for (int i = 2; i <= n / 2; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return n >= 2;
  }
}

public class Solution {

  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      int n1 = Integer.parseInt(br.readLine());
      int n2 = Integer.parseInt(br.readLine());
      int n3 = Integer.parseInt(br.readLine());
      int n4 = Integer.parseInt(br.readLine());
      int n5 = Integer.parseInt(br.readLine());
      Prime ob = new Prime();
      ob.checkPrime(n1);
      ob.checkPrime(n1, n2);
      ob.checkPrime(n1, n2, n3);
      ob.checkPrime(n1, n2, n3, n4, n5);
      Method[] methods = Prime.class.getDeclaredMethods();
      Set<String> set = new HashSet<>();
      boolean overload = false;
      for (Method method : methods) {
        if (set.contains(method.getName())) {
          overload = true;
          break;
        }
        set.add(method.getName());

      }
      if (overload) {
        throw new Exception("Overloading not allowed");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}

