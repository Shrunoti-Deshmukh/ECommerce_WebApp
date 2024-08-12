package com.wu.ecommerce;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.dto.User;
import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;
import com.wu.ecommerce.service.ProductService;
import com.wu.ecommerce.service.ProductServiceImpl;
import com.wu.ecommerce.service.UserService;
import com.wu.ecommerce.service.UserServiceImpl;

public class Main {

	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
		Product product=new Product("ab01","abc",1,"Cat1");
//		ProductService productService=ProductServiceImpl.getInstance();
////		Product products[]=new Product[10];
////		System.out.println(products.length);
////		for (Product product : products) {
////			System.out.println(product);
////		}
//		Product[] products=new Product[15];
//		for(int i=0;i<11;i++)
//		products[i]=productService.addProduct(new Product("1","Product",686,"Cricket"));
//		
//		for(int i=0;i<products.length;i++)
//			System.out.println(products[i]);
//		
//		
//		System.out.println(productService.getEmployeeByProductId("1"));
//		
//		System.out.println(productService.getProducts());
////		System.out.println(productService.getAllProductByCatgory("Cricket"));
//		
//		Optional<Product[]> optionalResult1=productService.getAllProductByCatgory("Cricket");
//		if(optionalResult1.isPresent())
//		{
//			Product [] returnProduct=optionalResult1.get();
//			for(Product pro:returnProduct)
//			{
//				System.out.println(pro);
//			}
//				
//		}
//		int b[]=new int[10];
//		int a=0;
//		try
//		{
//			a=10/2;
//			b[11]=0;
//			System.out.println("Inside the catch");
//		}
//
//		catch(ArrayIndexOutOfBoundsException e)
//		{
//			System.out.println(e.getMessage());
//		}
//		catch(ArithmeticException e)
//		{
//			a=10/2;
//			System.out.println("Inside the catch");
//		
//		}
//		
//		catch(RuntimeException e) //From the runtime exception->exception->throwable it is the hierarchy
//		{
//			
//		}
//		catch(Exception e)
//		{
//			System.out.println("Hello");
//		}
//		catch(Throwable e)
//		{
//			
//		}
//		//Last hierarchy is object which is not allow 
//			finally
//			
//			{
//				System.out.println("hello");
//					
//			}
			
//		try {
//			Product product=new Product("abcd","abc",8,"cat1");
//			System.out.println("Product"+product.toString());
//			System.out.println(product.hashCode());
//			System.out.println(Integer.toHexString(product.hashCode()));
//		} catch (InvalidIdException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		catch(InvalidPriceException e1)
//		{
//			e1.printStackTrace();
//		}
		
//		Product optional=productService.getEmployeeByProductId("ab01");
//	 
//			System.out.println(optional);
			
//		try {
//			List<Product> l=productService.getProducts();
//			for (Product product2 : l) {
//				System.out.println(product2);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e.getStackTrace());
//		}
//		try {
//			List<Product> l=productService.getAllProductByCatgory("Cat1");
//			for (Product product2 : l) {
//				System.out.println(product2);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e.getStackTrace());
//		}
//		
//		
//		Scanner sc=new Scanner (System.in);
//		int choice=0;
//		while(true)
//		{
//			System.out.println("Enter choice");
//			choice=sc.nextInt();
//			switch(choice)
//			{
//				case 1:
//					//add new Product
//					productService.addProduct(product);
//					break;
//				case 2:
//					//getEmployeeByProductId
//					System.out.println("Enter the Id:");
//					String id=sc.next();
//					List<Product> l=(List<Product>) productService.getEmployeeByProductId(id);
//					for (Product product2 : l) {
//						System.out.println(product2);
//					}
//					break;
//				default:
//					break;
//				
//					
//					
//			}
//		}
//		
	     ProductService productService = ProductServiceImpl.getInstance();
//			try {
//				productService.addProduct(new Product("00002","car",450,"carr"));
//			} catch (InvalidIdException | InvalidPriceException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//		
		
//		
//		UserService userService = UserServiceImpl.getInstance();
//		userService.addUser(new User("User1", "aaba", "aababa"));
		
//		Product p= productService.getEmployeeByProductId("carr");
//		System.out.println(p.getPrice());
//	     List<Product> l =(productService.getAllProductByCatgory("carr"));
//	     for (Product product1 : l) {
//			System.out.println(product1);
//		}
		Scanner sc=new Scanner(System.in);
		
	     System.out.println("ENTER THE PRODUCT ID Which u want to update");

	        String id = sc.next();

	        

	        System.out.println("Enter the details");

	        System.out.println("-------------------");

	        System.out.println("Enter the product Name");

	        String name = sc.next();

	        System.out.println("Enter the Product Price");

	        float price = sc.nextFloat();

	        System.out.println("Enter the Category");

	        String cat = sc.next();

	        

	        Product pr = new Product(id, name, price, cat);

	        

	        productService.updateProductByProjectId(id, pr);
		
		
	}
		

}

