package com.brunojcamargo.crudspring.services;

import com.brunojcamargo.crudspring.domain.category.Category;
import com.brunojcamargo.crudspring.domain.category.exceptions.CategoryNotFoundException;
import com.brunojcamargo.crudspring.domain.product.Product;
import com.brunojcamargo.crudspring.domain.product.ProductDTO;
import com.brunojcamargo.crudspring.domain.product.exceptions.ProductNotFoundException;
import com.brunojcamargo.crudspring.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    public ProductService(ProductRepository productRepository, CategoryService categoryService){
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }
    public Product insert(ProductDTO productData){
        Category category = this.categoryService.getById(productData.categoryId())
                            .orElseThrow(CategoryNotFoundException::new);

        Product newProduct = new Product(productData);
        newProduct.setCategory(category);
        this.productRepository.save(newProduct);
        return newProduct;
    }
    public List<Product> getAll(){
        return this.productRepository.findAll();
    }
    public Product update(String id, ProductDTO productData){
        Product product = this.productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        if(!productData.title().isEmpty()) product.setTitle(productData.title());
        if(!productData.description().isEmpty()) product.setDescription(productData.description());
        if(!(productData.price() == null)) product.setPrice(productData.price());

        this.categoryService.getById(productData.categoryId())
                .ifPresent(product::setCategory);

        this.productRepository.save(product);

        return product;
    }

    public void delete(String id){
        Product product = this.productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        this.productRepository.delete(product);
    }
}
