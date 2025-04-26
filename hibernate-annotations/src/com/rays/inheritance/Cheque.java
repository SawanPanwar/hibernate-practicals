package com.rays.inheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CHEQUE")
public class Cheque extends Payment {

	@Column(name = "CHQ_NUMBER")
	private String chqNumber;

	@Column(name = "BANK_NAME")
	private String bankName;

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