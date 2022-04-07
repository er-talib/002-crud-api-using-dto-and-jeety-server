package com.product.service;

import java.util.List;
import java.util.Optional;

import com.product.entityes.dto.ProductDto;

public interface ProductService {
	
	public ProductDto addProductDetails(ProductDto productDto);
	public ProductDto updateProductDetails(ProductDto productDto);
	public List<ProductDto> getAllProductDetails();
	public ProductDto getOneProductDetails(long id );
	public void deleteDetails(long id);

}
