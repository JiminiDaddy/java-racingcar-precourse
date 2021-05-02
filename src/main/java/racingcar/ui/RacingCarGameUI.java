package racingcar.ui;

import java.util.Scanner;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/03
 * Time : 12:22 AM
 */

public class RacingCarGameUI {
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

	public static void printMessage(String message) {
		System.out.println(message);
	}
}
