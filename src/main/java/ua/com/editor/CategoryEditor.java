package ua.com.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.entity.Category;
import ua.com.service.CategoryService;

import java.beans.PropertyEditorSupport;

@Component
public class CategoryEditor extends PropertyEditorSupport {
    @Autowired
    private CategoryService categoryService;

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(CategoryService categoryService) {

        this.categoryService = categoryService;
    }

    @Override
    public void setAsText(String id) throws IllegalArgumentException {
        System.out.println(id);
        Category blog = categoryService.findOne(Integer.parseInt(id));
        setValue(blog);
    }
}
