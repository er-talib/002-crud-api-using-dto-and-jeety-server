package com.product.entityes;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "product_details")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long proId ;
	@NotNull
	private String proName ;
	private String proCompany ;
	@Temporal(TemporalType.TIMESTAMP)
	private Date proMfgDate ;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date productUpdateDate ;

}
