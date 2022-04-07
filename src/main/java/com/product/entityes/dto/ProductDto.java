package com.product.entityes.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
	
	private long id ;
	private String name ;
	private String company ;
	private Date date ;
	private Date UpdateDate;
	

}
