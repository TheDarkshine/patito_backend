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
@Table(name = "Orders")
public class Order {
	
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "seller")
    private String seller;

    @Column(name = "client")
    private String client;
    
    @Column(name = "model")
    private String model;
    
    @Column(name = "units")
    private Integer units;
    
    @Column(name = "discount")
    private Double discount;
    
    @Column(name = "total")
    private Double total;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    
	@PrePersist
	public void prepersist() {
		this.creationDate = new Date();
	}

}
