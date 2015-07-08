package com.petshop.core.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.petshop.core.dao.CategoryDao;
import com.petshop.core.exception.BusinessException;
import com.petshop.core.model.ProductCatagory;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	@PersistenceContext
	private EntityManager manager;

	public List<ProductCatagory> getAllCategory() throws BusinessException {

		String sql = "from ProductCatagory";
		Query query = manager.createQuery(sql);
		List<ProductCatagory> proCatList = query.getResultList();

		return proCatList;
	}

	public void addCategory(ProductCatagory pCatagory) throws BusinessException {
		manager.persist(pCatagory);
		manager.flush();

	}

	public int editCategory(ProductCatagory pCatagory) throws BusinessException {

		return 0;
	}

	public void deleteCategory(Long catagoryId) throws BusinessException {
		ProductCatagory cat = (ProductCatagory) manager.find(
				ProductCatagory.class, new Long(catagoryId));

		manager.remove(cat);
		manager.flush();

	}

}
