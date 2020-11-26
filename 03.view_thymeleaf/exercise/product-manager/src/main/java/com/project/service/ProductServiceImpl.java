package com.project.service;

import com.project.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "I-Phone 12", "2020/12/12", "VietNam"));
        products.put(2, new Product(2, "I-Phone 11", "2020/12/12", "VietNam"));
        products.put(3, new Product(3, "I-Phone X", "2020/12/12", "VietNam"));
        products.put(4, new Product(4, "I-Phone 8", "2020/12/12", "VietNam"));
        products.put(5, new Product(5, "I-Phone 7", "2020/12/12", "VietNam"));
        products.put(6, new Product(6, "I-Phone 6", "2020/12/12", "VietNam"));
        products.put(7, new Product(7, "I-Phone 5", "2020/12/12", "VietNam"));

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
