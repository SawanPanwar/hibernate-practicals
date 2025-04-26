package com.rays.subclass.discriminator;

public class Cheque extends Payment {

	private String chqNumber;

	private String bankName;

	public String getChqNumber() {
		return chqNumber;
	}

	public void setChqNumber(String chqNumber) {
		this.chqNumber = chqNumber;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankName() {
		return bankName;
	}
}