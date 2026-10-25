package Week7;

import java.util.Scanner;

public class Bai02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        sc.close();

        boolean isPalindrome = true;
        int length = A.length();

        for (int i = 0; i < length / 2; i++) {
            if (A.charAt(i) != A.charAt(length - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}


