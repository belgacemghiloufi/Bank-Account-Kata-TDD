package fr.tdd.bankaccount;

public class Account {

	private TransactionStore transactionStore;
	private StatementPrinter statementPrinter;

	public Account(TransactionStore transactionRepository, StatementPrinter statementPrinter) {
		this.transactionStore = transactionRepository;
		this.statementPrinter = statementPrinter;
	}

	public void deposit(int amount) {
		transactionStore.addDepositTransaction(amount);
	}

	public void withdraw(int amount) {
		transactionStore.addWithdrawTransaction(amount);
	}

	public void printStatement() {
		statementPrinter.print(transactionStore.getTransactions());
	}

}
