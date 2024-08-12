package com.wu.ecommerce.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.exception.DataNotFoundException;
import com.wu.ecommerce.exception.IdNotFoundException;
import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;
import com.wu.ecommerce.repo.ProductRepository;
import com.wu.ecommerce.repo.ProductRepositoryImpl;

public class ProductServiceImpl implements ProductService {

	private ProductServiceImpl()
	{
		
	}
	private static ProductService productService;
	public static ProductService getInstance()
	{
		if(productService==null)
			productService=new ProductServiceImpl();
		return productService;
		
	}
	private ProductRepository productRepository = ProductRepositoryImpl.getInstance(); 
	@Override
	public Product addProduct(Product product) throws SQLException {
		// TODO Auto-generated method stub
		return productRepository.addProduct(product);
	}

	@Override
	public Product getEmployeeByProductId(String id) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.getEmployeeByProductId(id);
	}

	@Override
	public List<Product> getProducts() throws DataNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
		return productRepository.getProducts();
	}

	@Override
	public List<Product> getAllProductByCatgory(String cat) throws DataNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
		return productRepository.getAllProductByCatgory(cat);
	}

	@Override
	public String removeProductByProductId(String id) throws IdNotFoundException, SQLException, InvalidIdException, InvalidPriceException{
		// TODO Auto-generated method stub
		
		return productRepository.removeProductByProductId(id);
	}

	@Override
	public Product updateProductByProjectId(String id, Product product) throws SQLException {
		// TODO Auto-generated method stub
		return productRepository.updateProductByProjectId(id, product);
	}

}
