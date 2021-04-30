package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/01
 * Time : 1:25 AM
 */

class CarsTest {
	private Car[] carArray;
	private Cars cars = new Cars();

	@BeforeEach
	void setup() {
		carArray = new Car[3];
		for (int i = 0; i < carArray.length; ++i) {
			carArray[i] = new Car("car" + (i + 1));
		}
		for (Car car : carArray) {
			cars.addCar(car);
		}
	}

	@Test
	@DisplayName("경주할 자동차가 잘 추가되는지 확인")
	void addRacingCar() {
		assertThat(cars.getCars().size()).isEqualTo(carArray.length);
	}

	@Test
	@DisplayName("경주에 참가한 자동차들이 달리는지 확인")
	void runRacingCar() {
		final int RUN_COUNT = 10;
		for (int i = 0; i < RUN_COUNT; ++i) {
			cars.run();
		}
	}
}
