package racingcar;

import java.util.*;

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
			start(carNames, tryRunCount);

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void start(String[] carNames, int tryRunCount) {
		Cars cars = new Cars();
		for (String carName : carNames) {
			cars.addCar(new Car(carName));
		}
		for (int i = 0; i < tryRunCount; ++i) {
			cars.run();
		}
		List<Car> winners = getWinners(cars.getCars());
		printGameResult(winners);
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

	public static List<Car> getWinners(List<Car> racingCars) {
		List<Car> winners = new ArrayList<>();
		Collections.sort(racingCars, Comparator.comparing(car -> car.getPosition() * -1));
		Car bestRacingCar = racingCars.get(0);
		winners.add(bestRacingCar);
		int i = 1;
		while (i < racingCars.size() && bestRacingCar.getPosition() == racingCars.get(i).getPosition()) {
			winners.add(racingCars.get(i));
			++i;
		}
		return winners;
	}

	public static void printGameResult(List<Car> winners) {
		StringBuilder sb = new StringBuilder();
		for (Car car : winners) {
			sb.append(car.getName()).append(",");
		}
		sb.delete(sb.length() - 1, sb.length());
		sb.append("가 최종 우승했습니다.");
		System.out.println(sb.toString());
	}
}
