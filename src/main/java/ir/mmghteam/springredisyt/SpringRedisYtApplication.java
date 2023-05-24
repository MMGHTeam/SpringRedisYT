package ir.mmghteam.springredisyt;

import ir.mmghteam.springredisyt.Entity.Product;
import ir.mmghteam.springredisyt.Repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class SpringRedisYtApplication {
    @Autowired
    private ProductDao dao;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return dao.save(product);
    }
    @GetMapping
    public List<Product> getAllProducts() {
        return dao.findAll();
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return dao.findProductById(id);
    }
    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id) {
        return dao.deleteProduct(id);
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringRedisYtApplication.class, args);
    }

}
