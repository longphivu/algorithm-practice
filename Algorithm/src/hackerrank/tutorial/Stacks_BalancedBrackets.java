package hackerrank.tutorial;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Stacks_BalancedBrackets {
     public static boolean isBalanced(String expression) {
         if (expression == null) return true;
         
         boolean isOpen[] = new boolean[256];
         isOpen['['] = true;
         isOpen['{'] = true;
         isOpen['('] = true;
         
         char[] map = new char[256];
         map[']'] = '[';
         map['}'] = '{';
         map[')'] = '(';
         
         Stack<Character> stack = new Stack<>();
         for (int i = 0; i < expression.length(); i++) {
             char c = expression.charAt(i);
             if (isOpen[c]){
                 stack.push(c);
             } else if (stack.isEmpty() || (map[c] != '\0' && map[c] != stack.pop())) {
                     return false;
             }
         }
         
         return stack.isEmpty() ? true : false;
     }
  
   public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
             boolean answer = isBalanced(expression);
             if(answer)
              System.out.println("YES");
             else System.out.println("NO");
        }
    }
}
