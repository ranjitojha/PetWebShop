package com.petshop.core.dao;

import java.util.List;

import com.petshop.core.exception.BusinessException;
import com.petshop.core.model.ProductCatagory;

public interface CategoryDao {

	/**
	 * This method is to get all ProductCatagory.
	 * 
	 * @return
	 * @throws Exception
	 */
	
	public List<ProductCatagory> getAllCategory() throws BusinessException;

	/**
	 * This method is to add ProductCatagory
	 * 
	 * @param product
	 * @throws Exception
	 */
	public void addCategory(ProductCatagory pCatagory)
			throws BusinessException;

	/**
	 * This method is to edit ProductCatagory
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	
	public int editCategory(ProductCatagory pCatagory)
			throws BusinessException;

	/**
	 * This method is to delete ProductCatagory
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public void deleteCategory(Long id) throws BusinessException;

}
