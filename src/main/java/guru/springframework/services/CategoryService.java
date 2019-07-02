package guru.springframework.services;

import guru.springframework.Domain.Category;
import guru.springframework.api.v1.model.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);
}
