package racingcar;

import java.util.Random;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/30
 * Time : 1:38 PM
 */

public class ValidNumberUtils {
	public static int selectNumber() {
		Random random = new Random();
		random.setSeed(System.nanoTime());
		return random.nextInt(10);
	}
}
