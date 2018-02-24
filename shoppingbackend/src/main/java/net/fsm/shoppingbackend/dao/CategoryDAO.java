package net.fsm.shoppingbackend.dao;

import java.util.List;

import net.fsm.shoppingbackend.dto.Category;

public interface CategoryDAO {

	// Method to list out categories
	List<Category> list();
	
	Category get(int id);
}
