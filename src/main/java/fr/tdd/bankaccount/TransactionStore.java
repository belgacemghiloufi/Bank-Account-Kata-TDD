package fr.tdd.bankaccount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionStore {

	private List<Transaction> transactions = new ArrayList<>();
	private Clock clock;

	public TransactionStore(Clock clock) {
		this.clock = clock;
	}

	public void addDepositTransaction(int amount) {
		Transaction depositTransaction = new Transaction(clock.getTodayAsString(), amount);
		transactions.add(depositTransaction);
	}

	public void addWithdrawTransaction(int amount) {
		Transaction withdrawTransaction = new Transaction(clock.getTodayAsString(), -amount);
		transactions.add(withdrawTransaction);
	}

	public List<Transaction> getTransactions() {
		return Collections.unmodifiableList(transactions);
	}

}
