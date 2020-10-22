package utils;

import java.security.SecureRandom;

public class TestUtils {

	public static void sleep(final long millis) throws IllegalArgumentException {
		try {
			Thread.sleep(millis);
		} catch (final InterruptedException e) {
		}
	}

	public static String randomString() {
		final String AB = "abcdefghijklmnopqrstuvwxyz";
		SecureRandom rnd = new SecureRandom();
		StringBuilder sb = new StringBuilder(8);
		for( int i = 0; i < 8; i++ )
			sb.append(AB.charAt( rnd.nextInt(AB.length())));
		return sb.toString();
	}
}