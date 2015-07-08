package com.petshop.core.service;

import java.util.List;

import com.petshop.core.exception.BusinessException;
import com.petshop.core.model.ProductCatagory;

public interface CategoryService {
	public List<ProductCatagory> getAllCategory() throws BusinessException;

	public void addCategory(ProductCatagory pCatagory)
			throws BusinessException;

	public int editCategory(ProductCatagory pCatagory)
			throws BusinessException;

	public void deleteCategory(Long id) throws BusinessException;
}
