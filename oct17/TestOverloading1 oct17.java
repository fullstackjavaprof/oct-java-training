package com.javatraining.basics;

class Addition2{  
	
    static int add(int a,int b)
    {
    	return a+b;
    }  
    static int add(int a, int b,int c){
    	return a+b+c;
    }
	static double add(double a, int b){
		return a+b;
		}
	}

    class TestOverloading1{  
    public static void main(String[] args){ 
    	
    System.out.println(Addition2.add(11,11));  
    System.out.println(Addition2.add(10,11,12));
    System.out.println(Addition2.add(10.4,11));
    
    }
    }
  
