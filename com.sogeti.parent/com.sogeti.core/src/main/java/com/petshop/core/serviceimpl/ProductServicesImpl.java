package com.petshop.core.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petshop.core.dao.ProductDao;
import com.petshop.core.exception.BusinessException;
import com.petshop.core.model.Product;
import com.petshop.core.service.ProductService;

/**
 * Product Service impl
 * 
 * @author ranjit
 *
 */
@Service("productService")
@Transactional
public class ProductServicesImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	/**
	 * This method is to delete product
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public void deleteProduct(int id) throws BusinessException {

		productDao.deleteProduct(id);
	}

	/**
	 * This method is to search product by product name
	 * 
	 * @param productName
	 * @return
	 * @throws Exception
	 */
	public List<Product> searchByProduct(String productName)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method is to search product by category
	 * 
	 * @param categoryName
	 * @return
	 * @throws Exception
	 */
	public List<Product> searchByCategory(String categoryName)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method is to get all products.
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Product> getAllProduct() throws BusinessException {
		return productDao.getAllProduct();
	}

	/**
	 * This method is to get all products.
	 * 
	 * @return
	 * @throws Exception
	 */

	public void addProduct(Product product) throws BusinessException {
		productDao.addProduct(product);

	}

	/**
	 * This method is to get all products.
	 * 
	 * @return
	 * @throws Exception
	 */

	public int updateProduct(Product product) throws BusinessException {
		productDao.updateProduct(product);
		return 0;
	}

}
