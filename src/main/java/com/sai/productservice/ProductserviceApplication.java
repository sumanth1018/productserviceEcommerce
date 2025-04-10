package com.sai.productservice;

import com.sai.productservice.inheritancedemo.joinedtable.Mentor;
import com.sai.productservice.inheritancedemo.joinedtable.MentorRepository;
import com.sai.productservice.inheritancedemo.joinedtable.User;
import com.sai.productservice.inheritancedemo.joinedtable.UserRepository;
import com.sai.productservice.models.Category;
import com.sai.productservice.models.Price;
import com.sai.productservice.models.Product;
import com.sai.productservice.repositories.PriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.sai.productservice.repositories.CategoryRepository;  // **Added missing repository import**
import com.sai.productservice.repositories.ProductRepository;

import java.util.List;
import java.util.UUID;

@SpringBootApplication

public class ProductserviceApplication {//implements CommandLineRunner {

/*
    private MentorRepository mentorRepository;

    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProductserviceApplication.class, args);
    }

    public ProductserviceApplication(@Qualifier("jt_mr") MentorRepository mentorRepository, @Qualifier("jt_ur") UserRepository userRepository) {
        this.mentorRepository = mentorRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Mentor mentor = new Mentor();
        mentor.setName("Sai");
        mentor.setEmail("sai@gmail.com");
        mentor.setAverageRating(4.6);
        mentorRepository.save(mentor);

        User user = new User();
        user.setName("Sri");
        user.setEmail("sri@gmail.com");
        userRepository.save(user);

        List<User> users = userRepository.findAll();
        for (User user1 : users) {
            System.out.println(user1);
        }

 */
    /*
private final MentorRepository mentorRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;  // **Added missing repository**
    private final ProductRepository productRepository;    // **Added missing repository**
    private final PriceRepository priceRepository;
*/
    public static void main(String[] args) {
        SpringApplication.run(ProductserviceApplication.class, args);
    }

    /*
    public ProductserviceApplication(
            @Qualifier("jt_mr") MentorRepository mentorRepository,
            @Qualifier("jt_ur") UserRepository userRepository,
            CategoryRepository categoryRepository,  // **Injected CategoryRepository**
            ProductRepository productRepository, PriceRepository priceRepository) {  // **Injected ProductRepository**
        this.mentorRepository = mentorRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;  // **Assigned the injected repository**
        this.productRepository = productRepository;    // **Assigned the injected repository**
        this.priceRepository = priceRepository;
    }
    /*
    @Override
    public void run(String... args) throws Exception {
        Mentor mentor = new Mentor();
        mentor.setName("Sai");
        mentor.setEmail("sai@gmail.com");
        mentor.setAverageRating(4.6);
        mentorRepository.save(mentor);

        User user = new User();
        user.setName("Sri");
        user.setEmail("sri@gmail.com");
        userRepository.save(user);

        List<User> users = userRepository.findAll();
        for (User user1 : users) {
            System.out.println(user1);
        }






        Category category = new Category();
        category.setName("Apple Devices");

        // Category savedCategory = categoryRepository.save(category);  // commented because i used persist in Cardinality

        Price price = new Price("Rupee", 10);
        // Price savedPrice =  priceRepository.save(price);         // commented because i used persist in Cardinality
    Product product = new Product();
    product.setTitle("i phone 15 pro");
    product.setDescription("The best i phone ever");
    product.setCategory(category);
    product.setPrice(price);

    productRepository.save(product);

    productRepository.deleteById(UUID.fromString("e440fc4a-6ec1-4ce5-bcb3-4c27d6e5b09b"));

    List<Product> products = productRepository.findAllByPrice_Currency("Rupee");

        /*
    Category category1 = categoryRepository.findById(UUID.fromString("172a224f-accd-4826-be25-a12925819bc2")).get();
    System.out.println("Category 1: " + category1.getName());
    System.out.println("Printing all products in  category 1: ");
    Thread.sleep(1000);

    category1.getProducts().forEach(
            product1 -> System.out.println(getTitle()));
    */
    /*
    for (Product p :category1.getProducts()) {
        System.out.println(p.getTitle());
    }
    */


    }

