package com.ecom.productCatalog.config;

import com.ecom.productCatalog.model.Category;
import com.ecom.productCatalog.model.Product;
import com.ecom.productCatalog.repository.CategoryRepository;
import com.ecom.productCatalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
            //clear all existing data
        productRepository.deleteAll();;
        categoryRepository.deleteAll();

        // Create Categories
        Category clothing = new Category();
        clothing.setName("Clothing");

        Category electronics = new Category();
        electronics.setName("Electronics");

        Category home = new Category();
        home.setName("Home & Kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics,clothing,home));

        //Create Products
        Product phone=new Product();
        phone.setName("Nothing 3(a)");
        phone.setDescription("Latest smartphone, with 50 megapixel camera");
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setPrice(27000.00);
        phone.setCategory(electronics);

        Product laptop=new Product();
        laptop.setName("Laptop");
        laptop.setDescription("High Performance Laptop for coding and gaming");
        laptop.setImageUrl("https://placehold.co/600x400");
        laptop.setPrice(60000.00);
        laptop.setCategory(electronics);

        Product jacket=new Product();
        jacket.setName("Winter Jacket");
        jacket.setDescription("Warm and cozy jacket for winter, style your way ");
        jacket.setImageUrl("https://placehold.co/600x400");
        jacket.setPrice(600.00);
        jacket.setCategory(clothing);

        Product blender=new Product();
        blender.setName("Blender");
        blender.setDescription("Let everything mix together ");
        blender.setImageUrl("https://placehold.co/600x400");
        blender.setPrice(835.00);
        blender.setCategory(home);

        productRepository.saveAll(Arrays.asList(phone,laptop,jacket,blender));

    }
}
