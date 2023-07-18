package edu.hreyes.patito.entities;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "Vehicles")
public class Vehicle {
	
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private Double price;
    
    @Column(name = "discount")
    private Integer discount;

    @Column(name = "available")
    private Integer available;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "modification_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    
	@PrePersist
	public void prepersist() {
		this.modificationDate = new Date();
		this.enabled = true;
	}
    
}
