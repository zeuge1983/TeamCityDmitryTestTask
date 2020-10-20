package utils;

import java.util.Random;

public class TestUtils {

	public static void sleep(final long millis) throws IllegalArgumentException {
		try {
			Thread.sleep(millis);
		} catch (final InterruptedException e) {
		}
	}

	public static int randomBetween(final int min, final int max) {
		if (min > max) {
			throw new IllegalArgumentException("The minimum number is greater than the maximal number!");
		}
		final Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}
}