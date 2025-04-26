package com.rays.subclass.discriminator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CREDIT_PAYMENT")
@PrimaryKeyJoinColumn(name = "PAYMENT_ID")
public class CreditCardPayment extends Payment {

	@Column(name = "CC_TYPE")
	private String ccType;

	public CreditCardPayment() {
		this.setDiscriminatorValue("CREDIT");
	}

	public String getCcType() {
		return ccType;
	}

	public void setCcType(String ccType) {
		this.ccType = ccType;
	}
}