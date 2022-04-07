package com.product.Controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entityes.Product;
import com.product.entityes.dto.ProductDto;
import com.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/details")
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto dto) {
		dto.setDate(new Date());
		ProductDto addProductDetails = this.productService.addProductDetails(dto);
		return new ResponseEntity<ProductDto>(addProductDetails, HttpStatus.CREATED);
	}

	@PutMapping("/details")
	public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto dto) {
//		dto.setUpdateDate(new Date());
//		dto.setDate(new Date());

		if (dto.getDate() == null) {
			dto.setDate(new Date());
		} else {
			dto.setUpdateDate(new Date());
		}
		ProductDto updateProductDetails = this.productService.updateProductDetails(dto);
		return new ResponseEntity<ProductDto>(updateProductDetails, HttpStatus.OK);
	}

	@GetMapping("/details")
	public ResponseEntity<List<ProductDto>> getAllProductDetails() {
		List<ProductDto> productDetails = this.productService.getAllProductDetails();

		if (productDetails != null) {
			return new ResponseEntity<List<ProductDto>>(productDetails, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<ProductDto>>(HttpStatus.NO_CONTENT);
		}

	}

	@GetMapping("/details/{id}")
	public ResponseEntity<ProductDto> getOneProductDetails(@PathVariable Integer id) {
		ProductDto oneProductDetails = this.productService.getOneProductDetails(id.longValue());
		if (oneProductDetails.getId() != id) {
			return new ResponseEntity<ProductDto>(oneProductDetails, HttpStatus.OK);
		} else {

			return new ResponseEntity<ProductDto>(HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping("/details/{id}")
	public ResponseEntity<?> deleteProductDetails(@PathVariable long id) {
		this.productService.deleteDetails(id);
		return new ResponseEntity(Map.of("message", "Prosuct details delete successfully..!!"), HttpStatus.OK);
	}

}
