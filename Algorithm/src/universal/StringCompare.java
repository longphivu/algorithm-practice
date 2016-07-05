package universal;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StringCompare{

	public static boolean stringCompare(String t,String s){
	    if(t.length()==0){
	        return true;
	    }
//	    if(t.length()==0 && s.length()==0){
//	        return true;
//	    }
	    if(s.length()==0){
	        return false;
	    }
	    if(t.charAt(0)==s.charAt(0)){
	         stringCompare(t.substring(1), s.substring(1));
	    }
	    else{
	         stringCompare(t,s.substring(1));
	    }
	    return false;
	}

	public static void main(String[] args) {
	    // TODO Auto-generated method stub
	    String s="gagbgcgd";
	    String t="codin";
	    System.out.println(stringCompare(t,s));
	    
	    System.out.println(getName("long-2"));
	    System.out.println(getQuality("Long-3"));
	    List<String> l1 = new LinkedList();
	    l1.add("long-1");
	    l1.add("joe-1");
	    
	    List<String> l2 = new LinkedList();
	    l2.add("joe-3");
	    l2.add("x-1");
	    
	    List<String> l3 = merge(l1,l2);
	    System.out.println(l3);
	}
	
private static List<String> merge(List<String> list1, List<String> list2){
	Collections.sort(list1);
	Collections.sort(list2);
	//ensure list always has 1 element
	list1.add(null);
	list2.add(null);
	
	List<String> list3 = new LinkedList<String>();
	
    Iterator<String> l1 = list1.iterator();
    Iterator<String> l2 = list2.iterator();
    
    String item1 = l1.next();
    String item2 = l2.next();
    while(item1 != null && item2 != null){
    	String name1 = getName(item1);
    	String name2 = getName(item2);
    	if(name1.compareTo(name2) < 0){
    		list3.add(item1);
    		item1 = l1.next();
        }
        else if(name1.compareTo(name2) > 0){
        	list3.add(item2);
        	item2 = l2.next();
        }
        else if(name1.compareTo(name2) == 0){
        	//sum up the quality then add to the list
        	int totalQty = getQuality(item1) + getQuality(item2);
        	list3.add(name1 + "-" + totalQty);
        	item1 = l1.next();
        	item2 = l2.next();
        }
    }

    //add the rest of the list, in case one of two lists still has items
    while(item1 != null){
    	list3.add(item1);
    	item1 = l2.next();
    }
    while(item2 != null){
    	list3.add(item2);
    	item2 = l2.next();
    }
    
    return list3;
}
private static String getName(String s){
	return s.substring(0, s.indexOf('-'));
}
private static int getQuality(String s){
	return Integer.valueOf(s.substring(s.indexOf('-')+1));
}
}