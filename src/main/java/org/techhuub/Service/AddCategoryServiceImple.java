package org.techhuub.Service;
import java.util.List;

import org.techhub.Module.CategoryModule;
import org.techhub.Repository.AddCategoryRepository;
import org.techhub.Repository.AddCategoryReposotoryImple;
public class AddCategoryServiceImple implements AddCategoryService{
	AddCategoryRepository acRepo=new AddCategoryReposotoryImple();
	public boolean isAddNewCategory(CategoryModule cm) {
		return acRepo.isAddNewCategory(cm);
	}
	public List<CategoryModule> getAllCategories() {
		
		return acRepo.getAllCategories();
	}
	@Override
	public boolean isDisable(int id) {
		return acRepo.isDisable(id);
	}
	@Override
	public List<CategoryModule> getAllDisableCategory() {
		
		return acRepo.getAllDisableCategory();
	}
	@Override
	public boolean isEnable(int id) {
		
		return acRepo.isEnable(id);
	}
	@Override
	public boolean isUpdate(CategoryModule cm) {
	
		return acRepo.isUpdate(cm);
	}
	@Override
	public List<CategoryModule> getAllCategoriesByName(String name) 
	{
		return acRepo.getAllCategoriesByName(name);
	}

}
