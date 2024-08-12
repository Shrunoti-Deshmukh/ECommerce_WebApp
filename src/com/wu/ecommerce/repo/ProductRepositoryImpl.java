package com.wu.ecommerce.repo;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.naming.spi.DirStateFactory.Result;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.exception.DataNotFoundException;
import com.wu.ecommerce.exception.IdNotFoundException;
import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;
import com.wu.ecommerce.utils.DBUtils;

public class ProductRepositoryImpl implements ProductRepository {
	private ProductRepositoryImpl() {

	}

	private ArrayList<Product> products = new ArrayList<Product>();
//	private Treeset<Product> products=new TreeSet<Product>((o1,o2)->o1.getProductName().compareTo(o2.getProductName()));
	private static ProductRepository productRepository;

	private static int counter = -1;

	public static ProductRepository getInstance() {
		if (productRepository == null) {
			// Create object
			productRepository = new ProductRepositoryImpl();

		}

		return productRepository;
	}

	@Override
	public Product addProduct(Product product) throws SQLException {
		// TODO Auto-generated method stub
		String insertStatement="insert into Product(PRODUCTID,PRODUCTNAME,PRICE,CATEGORYNAME) values(?,?,?,?)";
		Connection connection=DBUtils.getInstance().getConnection();
		
		//Prepared Statement:
		PreparedStatement preparedStatement=connection.
				prepareStatement(insertStatement);
		
		
		preparedStatement.setString(1,product.getProductId());
		preparedStatement.setString(2, product.getProductName());
		preparedStatement.setFloat(3, product.getPrice());
		preparedStatement.setString(4,product.getCategoryName());
		
		
//		boolean result = products.add(product);
//		if (result)
//			return product;
//		else
//			return null;
		
		int result=preparedStatement.executeUpdate();
		if(result>0)
			return product;
		else
			return null;

	}

	@Override
	public Product getEmployeeByProductId(String id) throws IdNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
//		Product p = null;
		String query="select * from product";
		Connection connection=DBUtils.getInstance().getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		ResultSet resultSet=preparedStatement.executeQuery();
		
	Product products = null;
		while(resultSet.next())
		{
			Product product=new Product();
			if(!resultSet.getString("PRODUCTID").equals(id))continue;
			product.setProductId(resultSet.getString("PRODUCTID"));
			product.setProductName(resultSet.getString("PRODUCTNAME"));
			product.setPrice(resultSet.getFloat("PRICE"));
			product.setCategoryName(resultSet.getString("CATEGORYNAME"));
			
			products= (product);
		}
		return products;
		
		
		//return products.stream().filter(e -> e.getProductId().equals(id)).findFirst()
		//		.orElseThrow(() -> new IdNotFoundException("id not found"));
		
		
	}

	@Override
	public List<Product> getProducts() throws DataNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
		String query="select * from product";
		Connection connection=DBUtils.getInstance().getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		ResultSet resultSet=preparedStatement.executeQuery();
		
	List<Product> products=new ArrayList<Product>();
	
		while(resultSet.next())
		{
			 Product product=new Product();
			product.setProductId(resultSet.getString("PRODUCTID"));
			product.setProductName(resultSet.getString("PRODUCTNAME"));
			product.setPrice(resultSet.getFloat("PRICE"));
			product.setCategoryName(resultSet.getString("CATEGORYNAME"));
			
			products.add(product);
		}
		return products;
		

		
		
//		return Optional.ofNullable(products).filter(l -> !l.isEmpty())
//				.orElseThrow(() -> new DataNotFoundException("Data Not Found"));

	}

	@Override
	public List<Product> getAllProductByCatgory(String cat) throws DataNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
		
		String query="select * from product where CATEGORYNAME=?";
		Connection connection=DBUtils.getInstance().getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		ResultSet resultSet=preparedStatement.executeQuery();
		List<Product> products=new ArrayList<Product>();
		
		while(resultSet.next())
		{
			 Product product=new Product();
			product.setProductId(resultSet.getString("PRODUCTID"));
			product.setProductName(resultSet.getString("PRODUCTNAME"));
			product.setPrice(resultSet.getFloat("PRICE"));
			product.setCategoryName(resultSet.getString("CATEGORYNAME"));
			
			products.add(product);
		}
		return products;
//		List<Product> temp = products.stream().filter(e -> e.getCategoryName().equals(cat))
//				.collect(Collectors.toList());
//
//		return Optional.ofNullable(temp).filter(l -> !l.isEmpty())
//				.orElseThrow(() -> new DataNotFoundException("Data Not Available"));
	}

	@Override
	public String removeProductByProductId(String id) throws IdNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
//		Product product = this.getEmployeeByProductId(id);
//		boolean result = products.remove(product);
//		if (result)
//			return "Success";
//		else
//			return "Fail";
		
		
		
Connection connection = DBUtils.getInstance().getConnection();
        
        String sql = "delete from product where PRODUCTID = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setString(1, id);
        
        int res = preparedStatement.executeUpdate();
        
        if(res > 0)
        {
            System.out.println("Deleted Brother");
        }

        return "Falied";

	}

	@Override
	public Product updateProductByProjectId(String id, Product product) throws SQLException {
		// TODO Auto-generated method stub
		
Connection connection = DBUtils.getInstance().getConnection();
		
		String sql = "update Product set PRODUCTNAME = ? , PRICE = ?, CATEGORYNAME = ? where PRODUCTID = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1,product.getProductName());
		preparedStatement.setFloat(2, product.getPrice());
		preparedStatement.setString(3, product.getCategoryName());
		preparedStatement.setString(4,id);
		
		
		int result = preparedStatement.executeUpdate();
		
		if(result > 0)
		{
			System.out.println("Updated Brother");
		}
		else
		{
			System.out.println("Dard bhai");
		}
		
		return null;
		
	}

}



