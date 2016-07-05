package HackerRank;

import java.util.HashMap;
import java.util.Scanner;

public class BearAndSteadyGene {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        String s = in.nextLine();
        
        
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        count.put('A', 0);
        count.put('C', 0);
        count.put('G', 0);
        count.put('T', 0);
        
        for(int i = 0; i < N; i++)
            count.put(s.charAt(i), count.get(s.charAt(i)) + 1);
        
        if(hasAll(count, N)){
            System.out.println(0);
            return;
        }
        
        int left = 0;
        int right = 0;
        
        int min = N;
        while(left < N){            
            while(right<N && !hasAll(count, N)){
            	char cRight = s.charAt(right);
            	count.put(cRight, count.get(cRight) - 1);
            	right++;
            }
            	if(hasAll(count, N)){
            		min = Math.min(min, right-left);
            	}
            	char cLeft = s.charAt(left);
            	count.put(cLeft, count.get(cLeft) + 1);
            	left++;
            	
        }
        
        System.out.println(min);
    }
    
    private static boolean hasAll(HashMap<Character, Integer> count, int n){
        for(char c : count.keySet()){
        	if(count.get(c) > n/4)
        		return false;
        }
        return true;
    }
}
