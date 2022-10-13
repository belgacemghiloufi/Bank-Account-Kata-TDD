package fr.tdd.bankaccount;

import java.util.Objects;

public class Transaction {

	private String date;
	private int amount;

	public String date() {
		return date;
	}

	public int amount() {
		return amount;
	}

	public Transaction(String date, int amount) {
		this.date = date;
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, date);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return amount == other.amount && Objects.equals(date, other.date);
	}
}
