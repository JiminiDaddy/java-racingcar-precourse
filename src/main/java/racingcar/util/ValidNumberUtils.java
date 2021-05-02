package racingcar.util;

import java.util.Random;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/30
 * Time : 1:38 PM
 */

public class ValidNumberUtils {
	private static final int UPPER_BOUND = 10;

	public static int selectNumber() {
		Random random = new Random();
		random.setSeed(System.nanoTime());
		return random.nextInt(UPPER_BOUND);
	}
}
