package com.product.converter;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.entityes.Product;
import com.product.entityes.dto.ProductDto;

@Component
public class ProductConverter {

	public Product dtoToProduct(ProductDto productDto) {
		Product pro = new Product();
		pro.setProId(productDto.getId());
		pro.setProName(productDto.getName());
		pro.setProCompany(productDto.getCompany());
		pro.setProMfgDate(new Date());
		pro.setProductUpdateDate(new Date());
		return pro;
	}

	public ProductDto productToDto(Product product) {
		ProductDto dto = new ProductDto();
		dto.setId(product.getProId());
		dto.setName(product.getProName());
		dto.setCompany(product.getProCompany());
		dto.setDate(product.getProMfgDate());
		dto.setUpdateDate(product.getProductUpdateDate());
		return dto;
	}

//	@Autowired
//	public ModelMapper modelMapper;
//
//
//	public ProductDto userDto(Product product) {
//		ProductDto dtoToProduct = new ProductDto();
//		dtoToProduct = modelMapper.map(product	, ProductDto.class);
//		return dtoToProduct;
//	}

}
