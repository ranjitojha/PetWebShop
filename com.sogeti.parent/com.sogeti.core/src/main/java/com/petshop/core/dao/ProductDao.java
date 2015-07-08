package com.petshop.core.dao;

import java.util.List;

import com.petshop.core.exception.BusinessException;
/**
 * Product DAO 
 * 
 * @author ranjit
 *
 */
import com.petshop.core.model.Product;

public interface ProductDao {
	/**
	 * This method is to add product
	 * 
	 * @param product
	 * @throws Exception
	 */
	public void addProduct(Product product) throws BusinessException;

	/**
	 * This method is to delete product
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public void deleteProduct(int id) throws BusinessException;

	/**
	 * This method is to update products
	 * 
	 * @param product
	 * @return
	 * @throws Exception
	 */
	public int updateProduct(Product product) throws BusinessException;

	/**
	 * This method is to search product by product name
	 * 
	 * @param productName
	 * @return
	 * @throws Exception
	 */
	public List<Product> searchByProduct(String productName) throws BusinessException;

	/**
	 * This method is to search product by category
	 * 
	 * @param categoryName
	 * @return
	 * @throws Exception
	 */
	public List<Product> searchByCategory(String categoryName) throws BusinessException;

	/**
	 * This method is to get all products.
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Product> getAllProduct() throws BusinessException;

}
