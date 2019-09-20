package org.springframework.samples.petclinic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ofertas")
public class Ofertas extends BaseEntity{
	@NotEmpty
    @Column(name = "title")
	private String Title;
	
	@NotEmpty
    @Column(name = "description")
	private String description;
	
	@Column(name = "discount")
	private Double Discount;
	
	@Column(name = "expire_date")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date expireDate;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getDiscount() {
		return Discount;
	}

	public void setDiscount(Double discount) {
		Discount = discount;
	}

	public Date getExpireDate() {
		return expireDate;
	}
	
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Override
	public String toString() {
		return "Ofertas [Title=" + Title + ", description=" + description + ", Discount=" + Discount + ", ExpireDate="
				+ expireDate + "]";
	}	
}
