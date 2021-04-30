package racingcar;

import java.util.Arrays;
import java.util.Scanner;

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
			int tryRunCount = selectTryRunCount();
			System.out.println("cars:" + Arrays.toString(carNames) + " , count:" + tryRunCount);

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public static String selectRacingCarNames() {
		System.out.println("경주할 자동차 입력을 입력하세요.(이름은 쉽표(,) 기준으로 구분");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public static int selectTryRunCount() {
		System.out.println("시도할 회수는 몇번인가요?");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
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
