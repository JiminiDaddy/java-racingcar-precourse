package racingcar;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/30
 * Time : 11:49 PM
 */

public class RacingCarGame {

	public static void main(String[] args) {
		try {
			String[] carNames = getValidCarNames(selectRacingCarNames());

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public static String selectRacingCarNames() {
		return "";
	}


	public static String[] getValidCarNames(String names) {
		String[] carNames = names.split(",");
		for (String carName : carNames) {
			validCarNameLengthBetween1And5(carName);
		}
		return carNames;
	}

	private static void validCarNameLengthBetween1And5(String name) {
		if (name.isEmpty() || name.length() > 5) {
			throw new IllegalArgumentException("자동차이름의 길이를 1~5자사이로 입력해주세요.");
		}
	}
}
