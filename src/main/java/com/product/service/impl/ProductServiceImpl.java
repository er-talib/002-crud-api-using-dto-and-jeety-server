package com.product.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.converter.ProductConverter;
import com.product.entityes.Product;
import com.product.entityes.dto.ProductDto;
import com.product.repository.ProductRepository;
import com.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductConverter converter;
	@Autowired
	private ProductRepository repository;

	@Override
	public ProductDto addProductDetails(ProductDto productDto) {
		Product product = this.converter.dtoToProduct(productDto);
		Product save = this.repository.save(product);
		return this.converter.productToDto(product);

	}

	@Override
	public ProductDto updateProductDetails(ProductDto productDto) {

		Product product = this.converter.dtoToProduct(productDto);
		Product save = this.repository.save(product);
		ProductDto productToDto = this.converter.productToDto(save);
		return productToDto;
	}

	@Override
	public List<ProductDto> getAllProductDetails() {
		List<Product> findAllProducts = this.repository.findAll();
		List<ProductDto> list = findAllProducts.stream().map(product -> this.converter.productToDto(product))
				.collect(Collectors.toList());

		return list;
	}

	@Override
	public ProductDto getOneProductDetails(long id) {
		Product byId = this.repository.getById(id);
		return this.converter.productToDto(byId);
	}

	@Override
	public void deleteDetails(long id) {
		this.repository.deleteById(id);

	}

}
