package fr.tdd.bankaccount.features;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import fr.tdd.bankaccount.Account;
import fr.tdd.bankaccount.Clock;
import fr.tdd.bankaccount.Console;
import fr.tdd.bankaccount.StatementPrinter;
import fr.tdd.bankaccount.TransactionStore;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeature {

	@Mock private Console console;
	@Mock private Clock clock;
	private Account account;

	@Before
	public void initialise() {
		TransactionStore transactionRepository = new TransactionStore(clock);
		StatementPrinter statementPrinter = new StatementPrinter(console);
		account = new Account(transactionRepository, statementPrinter);
	}

	@Test
	public void should_print_statement_containing_all_transactions() {
		given(clock.getTodayAsString()).willReturn("01/04/2014", "02/04/2014", "10/04/2014");
		account.deposit(1000);
		account.withdraw(100);
		account.deposit(500);
		account.printStatement();
		verify(console).printLine("DATE | AMOUNT | BALANCE");
		verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
		verify(console).printLine("02/04/2014 | -100.00 | 900.00");
		verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
	}

}
