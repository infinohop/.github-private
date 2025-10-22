package com.project.backend.dtos;

import com.project.backend.repository.CategoryRepository;
import com.project.backend.repository.SubCategoryRepository;
import com.project.backend.repository.VendorRepository;
import com.project.backend.entities.Category;
import com.project.backend.entities.Products;
import com.project.backend.entities.SubCategory;
import com.project.backend.entities.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EntityMapper {

    Products product = new Products();

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private VendorRepository vendorRepository;

    public ProductRespDTO productToProductRespDTO(Products products) {
        ProductRespDTO productRespDTO = new ProductRespDTO();
        productRespDTO.setName(products.getName());
        productRespDTO.setDescription(products.getDescription());
        productRespDTO.setPrice(products.getPrice());
        productRespDTO.setStock(products.getStock());
        return productRespDTO;
    }

    public Products productReqToProducts(ProductReqDTO productReqDTO) {
        product.setStatus("continue");
//        product.setVendorId(productReqDTO.getVendorId());
        product.setName(productReqDTO.getName());
        product.setDescription(productReqDTO.getDescription());
        product.setPrice(productReqDTO.getPrice());
        product.setStock(productReqDTO.getStock());
        Vendor vendor = vendorRepository.findById(productReqDTO.getVendorId())
                .orElseThrow(() -> new RuntimeException("Vendor not found"));
        Category category = categoryRepository.findById(productReqDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        SubCategory subCategory = subCategoryRepository.findById(productReqDTO.getSubCategoryId())
                .orElseThrow(() -> new RuntimeException("SubCategory not found"));
        product.setVendor(vendor);
        product.setCategory(category);
        product.setSubCategory(subCategory);
        return product;
    }

    public Products productReqDtoToUpdatedProduct(ProductReqDTO productReqDTO) {
        if(productReqDTO.getStock() == 0)
            product.setStatus("discontinue");
        else
            product.setStatus("continue");
//        product.setVendorId(productReqDTO.getVendorId());
        product.setName(productReqDTO.getName());
        product.setDescription(productReqDTO.getDescription());
        product.setPrice(productReqDTO.getPrice());
        product.setStock(productReqDTO.getStock());
        Vendor vendor = vendorRepository.findById(productReqDTO.getVendorId())
                .orElseThrow(() -> new RuntimeException("Vendor not found"));
        Category category = categoryRepository.findById(productReqDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        SubCategory subCategory = subCategoryRepository.findById(productReqDTO.getSubCategoryId())
                .orElseThrow(() -> new RuntimeException("SubCategory not found"));
        product.setVendor(vendor);
        product.setCategory(category);
        product.setSubCategory(subCategory);
        return product;
    }

    public List<CategoryReqRespDTO> categoriesToCategoriesRespDTO(List<Category> categories) {
        List<CategoryReqRespDTO> categoryReqRespDTOList = new ArrayList<>();
        for(Category category : categories) {
            CategoryReqRespDTO categoryReqRespDTO = new CategoryReqRespDTO();
            categoryReqRespDTO.setName(category.getName());
            categoryReqRespDTOList.add(categoryReqRespDTO);
        }
        return categoryReqRespDTOList;
    }

    public List<SubCategoryRespDTO> subCategoriesToSubCategoriesRespDTO(List<SubCategory> subCategories) {
        List<SubCategoryRespDTO> subCategoryRespDTOList = new ArrayList<>();
        for(SubCategory subCategory : subCategories) {
            SubCategoryRespDTO subCategoryRespDTO = new SubCategoryRespDTO();
            subCategoryRespDTO.setName(subCategory.getName());
            subCategoryRespDTOList.add(subCategoryRespDTO);
        }
        return subCategoryRespDTOList;
    }

}
