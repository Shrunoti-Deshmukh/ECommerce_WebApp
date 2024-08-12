package com.wu.ecommerce;

@FunctionalInterface
public interface FunctionalInterfaceDemo {
	public int add(int a,int b);
	default void test()
	{
		System.out.println("test");
	}
	default void test2()
	{
		System.out.println("Test2");
	}
	default void test3()
	{
		System.out.println("Test3");
	}
}
class Test{
	public static void getResult(FunctionalInterfaceDemo demo)
	{
		int result=demo.add(10,2); 
		System.out.println(result);
	}
	
	public static void main(String args[])
	{
		getResult((a,b)->a+b);
		
	}
}

