package com.cg.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
//@Table(name="Products")
@Table(name="Products")
public class Product {
	
	@Id
	@GeneratedValue
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="quantity")
	private int quantity;
	@Column(name="price")
	private double price;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	//@Transient[that feild will be ignored while serialization]
	@Temporal(TemporalType.DATE)
	@Column(name="expiry_date")
	private Date expiryDate;
	
	public Product() {
		
	}
	
	public Product(int productId, String productName, int quantity, double price, Date expiryDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.expiryDate = expiryDate;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity
				+ ", price=" + price + ", expiryDate=" + expiryDate + "]";
	}
	
	
	

}
