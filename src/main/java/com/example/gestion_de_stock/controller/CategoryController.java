package com.example.gestion_de_stock.controller;

import com.example.gestion_de_stock.controller.api.CategoryApi;
import com.example.gestion_de_stock.dto.CategoryDto;
import com.example.gestion_de_stock.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.gestion_de_stock.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT)
@RestController
public class CategoryController implements CategoryApi {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        return categoryService.save(dto);
    }

    @Override
    public CategoryDto findById(Integer id) {
        return categoryService.findById(id);
    }

    public CategoryDto findByCode(String code) {
        return categoryService.findByCode(code);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public void delete(Integer id) {
        categoryService.delete(id);
    }
}
