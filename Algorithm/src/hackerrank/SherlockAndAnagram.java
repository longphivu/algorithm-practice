package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import other.Anagram;

public class SherlockAndAnagram {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        in.nextLine();
        
        while(n-->0){
            String s = in.nextLine();
            solve(s);
        }
    }
    
    private static void solve(String s){
        int subLen = 1;
        int totalAnagram = 0;
        int[][] charCnt = new int[26][s.length()];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        buildCharFrequency(charCnt, s);
        
        int start, end = 0;
        while(subLen < s.length()){
            map.clear();
            for(int i = 0; i<=s.length()-subLen; i++){
                start = i;
                end = i+subLen-1;
                checkAnagram(s, map, charCnt, start, end);
            }
            for(int count : map.values()){
                totalAnagram += count*(count-1)/2;    
            }
            subLen++;
        }
        
        System.out.println(totalAnagram);
        System.out.println("map1 size: " +map.size());
        System.out.println("map2 size: " +map2.size());
        for(int key : map2.keySet()){
//        	if(map2.get(key).size()>2){
//        		System.out.println(key+"="+map2.get(key));
//        	}
        	String first = (String) map2.get(key).get(0);
        	
        	for(Object second : map2.get(key)){
        		if(!Anagram.isAnagram(first, (String) second)){
        			System.out.println(key+"= "+first+" "+ second);
        		}
        	}
        }
        totalAnagram=0;
        for(List d : map2.values()){
        	int count = d.size();
            totalAnagram += count*(count-1)/2;    
        }
        System.out.println(totalAnagram);
    }
    
    private static void buildCharFrequency(int[][] charCnt, String s){
        if(s.length() == 0) return;
        
        //increase count for first char
        charCnt[s.charAt(0)-97][0] += 1;
        
        //counting from second char to the rest
        for(int i = 1; i<s.length(); i++){
            char ch = s.charAt(i);
            for(int j = 0; j<26; j++){
                if((int)ch - 97 == j){
                    charCnt[j][i] = charCnt[j][i-1] + 1;
                } else {
                    charCnt[j][i] = charCnt[j][i-1];
                }
            }
        }
    }
    private static Map<Integer, List> map2 = new HashMap<Integer, List>();
    private static void checkAnagram(String st, Map<Integer, Integer> map, int[][] charCnt, int s, int e){
        int hash = simpleHash(st, charCnt, s, e);
        
        if(hash == 0) return;
        
        if(map.containsKey(hash)){
        	
            map.put(hash, map.get(hash)+1);
        }
        else{
            map.put(hash,1);
            
        }
        
        if(map2.containsKey(hash)){
        	map2.get(hash).add(st.substring(s, e+1));
        } else {
        	map2.put(hash, new ArrayList<String>());
            map2.get(hash).add(st.substring(s, e+1));
        }
    }
    private static int[] primes = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,101,103, 107,109};
    private static int simpleHash(String st, int[][] charCnt, int s, int e){
        int hash = 1;
        boolean a=false;
        if(st.substring(s,e+1).equals("mwocejbxfidpjfgrrkpowoxwggxaknmltjcpazgtnakcfcogzatyskqjyorcftwxjrtgayvllutrjxpbzggj")
        || st.substring(s, e+1).equals("mwocejbxfidpjfgrrkpowoxwggxaknmltjcpazgtnakcfcogzatyskqjyorcftwxjrtgayvllutrjxpbzggjx")){
        	a = true;
        }
        for(int i = 0; i<26; i++){
            int cnt = charCnt[i][e]-charCnt[i][s];
            
            if(st.charAt(s) == (char) (i+97)){
                cnt += 1;
            }
            if(a == true && cnt > 0) 
            	System.out.println((Character.valueOf((char)(i+97))) +" "+ cnt);
            if(cnt > 0)
            	hash *= (int) Math.pow(primes[i],cnt);   
        }
        return hash;
    }
}