package com.niit.EcommerceBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.EcommerceBackend.dao.CategoryDAO;
import com.niit.EcommerceBackend.dto.Category;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

//	@Override
//	public List<Category> list() {
//		return null;
//	}

	// Getting single category based on ID!!
	@Override
	public Category getCategoryID(int categoryID) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(categoryID));
	}

	@Override
	public List<Category> getListCategory() {
		String activeCategory = "FROM Category WHERE categoryIsActive = :active";
		Query<Category> query = sessionFactory.getCurrentSession().createQuery(activeCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public boolean addCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	//Updating a single category!!
	@Override
	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		
		category.setCategoryIsActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
