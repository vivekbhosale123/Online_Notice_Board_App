package org.techhuub.Service;
import java.util.List;
import org.techhub.Module.CategoryModule;
public interface AddCategoryService {
	public boolean isAddNewCategory(CategoryModule cm);
	public List<CategoryModule> getAllCategories();
	public boolean isDisable(int id);
	public List<CategoryModule> getAllDisableCategory();
	public boolean isEnable(int id);
	public boolean isUpdate(CategoryModule cm);
	public List<CategoryModule> getAllCategoriesByName(String name);
}
