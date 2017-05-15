package com.niit.EcommerceBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.EcommerceBackend.dao.ProductDAO;
import com.niit.EcommerceBackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product getProductID(int productID) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productID));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getListProduct() {
		return sessionFactory.getCurrentSession().createQuery("FROM Product",Product.class).getResultList();
	}

	@Override
	public boolean addProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product product) {
		try {
			product.setProductIsActive(false);
			return this.updateProduct(product);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE productIsActive = :active";
		return sessionFactory.getCurrentSession()
				.createQuery(selectActiveProducts, Product.class)
				.setParameter("active", true)
				.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryID) {
		String selectActiveProductsByCategory = "FROM Product WHERE productIsActive = :active AND categoryID = :categoryID";
		return sessionFactory.getCurrentSession()
				.createQuery(selectActiveProductsByCategory, Product.class)
				.setParameter("active", true)
				.setParameter("categoryID", categoryID)
				.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Product WHERE active = :active ORDER BY productID", Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

}
