package com.collections;

import java.util.*;  
class HashMapExample{  
 public static void main(String args[]){  
  TreeMap<Integer,String> map=new TreeMap<Integer,String>(); 
  map.put(100,"Amit");  
  map.put(105,"Vijay");  
  map.put(102,null);
  map.put(104,"Kumar");
  map.put(103,null);
  
  //Elements can traverse in any order  
  for(Map.Entry m:map.entrySet()){  
   System.out.println(m.getKey()+" "+m.getValue());  
  }  
 }  
}  