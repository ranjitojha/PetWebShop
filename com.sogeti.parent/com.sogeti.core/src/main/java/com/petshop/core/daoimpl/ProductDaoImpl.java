package com.petshop.core.daoimpl;

/**
 * ProductDaoImpl
 * @author ranjit
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.petshop.core.dao.ProductDao;
import com.petshop.core.exception.BusinessException;
import com.petshop.core.model.Product;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	private EntityManager manager;

	

	/**
	 * This method is to delete product
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public void deleteProduct(int productId) throws BusinessException {
		Product product = (Product)manager.find(Product.class, Integer.valueOf(productId));
		manager.remove(product);
		
	}

	/**
	 * This method is to search product by product name
	 * 
	 * @param productName
	 * @return
	 * @throws Exception
	 */
	public List<Product> searchByProduct(String productName) throws BusinessException {
		return null;
	}

	/**
	 * This method is to search product by category
	 * 
	 * @param categoryName
	 * @return
	 * @throws Exception
	 */
	public List<Product> searchByCategory(String categoryName) throws BusinessException {
		return null;
	}

	/**
	 * This method is to get all products.
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Product> getAllProduct() throws BusinessException {

		List<Product> productList = manager.createQuery("from Product",
				Product.class).getResultList();
		
		return productList;
	}

	public void addProduct(Product product) throws BusinessException {
		
		manager.persist(product);
		manager.flush();
		

	}

	public int updateProduct(Product product) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

}
