package fr.tdd.bankaccount;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TransactionStoreShould {

	private static final String TODAY = "13/10/2022";

	private TransactionStore transactionStore;
	 @Mock private Clock dateHelper;

	@Before
	public void initialise() {
		transactionStore = new TransactionStore(dateHelper);
		given(dateHelper.getTodayAsString()).willReturn(TODAY);
	}

	@Test
	public void create_a_deposit_transaction() {
		transactionStore.addDepositTransaction(100);
		List<Transaction> transactions = transactionStore.getTransactions();
		assertThat(transactions.size(), is(1));
		assertThat(transactions.get(0), is(transaction(TODAY, 100)));
	}

	@Test
	public void create_a_withdraw_transaction() {
		transactionStore.addWithdrawTransaction(100);
		List<Transaction> transactions = transactionStore.getTransactions();
		assertThat(transactions.size(), is(1));
		assertThat(transactions.get(0), is(transaction(TODAY, -100)));
	}

	private Transaction transaction(String date, int amount) {
		return new Transaction(date, amount);
	}

}
