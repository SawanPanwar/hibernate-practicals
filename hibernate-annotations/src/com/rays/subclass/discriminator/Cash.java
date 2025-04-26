package com.rays.subclass.discriminator;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CASH")
@PrimaryKeyJoinColumn(name = "PAYMENT_ID")
public class Cash extends Payment {

	public Cash() {
		this.setDiscriminatorValue("CASH");
	}
}