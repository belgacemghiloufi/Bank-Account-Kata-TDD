package fr.tdd.bankaccount;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import org.junit.Test;

public class ClockShould {

	private static final String TODAY = "13/10/2022";

	@Test
	public void return_todays_date_in_dd_MM_YYY_format() {
		Clock clock = new TestableClock();
		String today = clock.getTodayAsString();
		assertThat(today, is(TODAY));
	}

	private class TestableClock extends Clock {
		@Override
		public LocalDate today() {
			return LocalDate.of(2022, 10, 13);
		}
	}

}
