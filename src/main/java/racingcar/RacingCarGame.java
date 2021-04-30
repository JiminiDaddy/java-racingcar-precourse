package racingcar;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/30
 * Time : 11:49 PM
 */

public class RacingCarGame {
	public boolean validCarNameLength(String name) {
		return !name.isEmpty() && name.length() <= 5;
	}
}
