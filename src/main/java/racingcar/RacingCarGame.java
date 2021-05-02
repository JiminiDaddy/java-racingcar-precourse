package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.ui.RacingCarGameUI;

import java.util.*;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/30
 * Time : 11:49 PM
 */

public class RacingCarGame {
	private static final int MAX_LENGTH_CAR_NAME = 5;
	private static final String SEPARATOR_CAR_NAME = ",";

	public static void main(String[] args) {
		try {
			String[] carNames = getValidCarNames(RacingCarGameUI.selectRacingCarNames());
			int tryRunCount = RacingCarGameUI.selectTryRunCount();
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
		RacingCarGameUI.printGameResult(winners);
	}

	static String[] getValidCarNames(String names) {
		String[] carNames = names.split(SEPARATOR_CAR_NAME);
		for (String carName : carNames) {
			validCarNameLengthBetween1And5(carName);
		}
		return carNames;
	}

	private static void validCarNameLengthBetween1And5(String name) {
		if (name.isEmpty() || name.length() > MAX_LENGTH_CAR_NAME) {
			throw new IllegalArgumentException("자동차이름의 길이를 1~5자사이로 입력해주세요.");
		}
	}

	static List<Car> getWinners(List<Car> racingCars) {
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


}
