package ca.sheridancollege.beans;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false, length = 45)
	private Integer id;
	@Column(name = "price")
	private double price;
	@Column(name = "description")
	private String description;
	@Column(name = "image")
	private Blob image;
	@Column(name="style")
	private String style;
	
	private String[] styles;
	
	public Product() {
		//super();
		this.styles = new String[]{"Bridal Lehengas", "Party Wear", "Casual"};
	}

	public Product(Integer id, double price, String description, Blob image, String style) {
		//super();
		this.id = id;
		this.price = price;
		this.description = description;
		this.image = image;
		this.style = style;
		this.styles = new String[]{"Bridal Lehengas", "Party Wear", "Casual"};
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public String[] getStyles() {
		return styles;
	}

	public void setStyles(String[] styles) {
		this.styles = styles;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
	
	
	
}
