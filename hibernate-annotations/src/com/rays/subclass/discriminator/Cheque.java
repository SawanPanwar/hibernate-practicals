package com.rays.subclass.discriminator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CHEQUE")
@PrimaryKeyJoinColumn(name = "PAYMENT_ID")
public class Cheque extends Payment {

	@Column(name = "CHQ_NUMBER")
	private String chqNumber;

	@Column(name = "BANK_NAME")
	private String bankName;

	public Cheque() {
		this.setDiscriminatorValue("CHEQUE");
	}

	public String getChqNumber() {
		return chqNumber;
	}

	public void setChqNumber(String chqNumber) {
		this.chqNumber = chqNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
}