package com.petshop.core.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petshop.core.dao.CategoryDao;
import com.petshop.core.exception.BusinessException;
import com.petshop.core.model.ProductCatagory;
import com.petshop.core.service.CategoryService;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	public List<ProductCatagory> getAllCategory() throws BusinessException {
		return categoryDao.getAllCategory();

	}

	public void addCategory(ProductCatagory pCatagory) throws BusinessException {
		categoryDao.addCategory(pCatagory);

	}

	public int editCategory(ProductCatagory pCatagory) throws BusinessException {
		categoryDao.editCategory(pCatagory);
		return 0;
	}

	public void deleteCategory(Long id) throws BusinessException {
		categoryDao.deleteCategory(id);

	}

}
