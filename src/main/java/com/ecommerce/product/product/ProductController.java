package com.ecommerce.product.product;

import com.ecommerce.product.product.dto.ProductRequest;
import com.ecommerce.product.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ResponseUtil responseUtil;

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        try {
            return responseUtil.success(productService.getAll());
        } catch (Exception e) {
            return responseUtil.failed(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        try {
            return responseUtil.success(productService.getById(id));
        } catch (Exception e) {
            return responseUtil.failed(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductRequest request) {
        try {
            return responseUtil.success(productService.create(request));
        } catch (Exception e) {
            return responseUtil.failed(e.getMessage());
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateById(@RequestBody ProductRequest request, @PathVariable("id") Integer id) {
        try {
            return responseUtil.success(productService.updateById(request, id));
        } catch (Exception e) {
            return responseUtil.failed(e.getMessage());
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        try {
            productService.deleteById(id);
            return responseUtil.success("Success delete data");
        } catch (Exception e) {
            return responseUtil.failed(e.getMessage());
        }
    }

}
