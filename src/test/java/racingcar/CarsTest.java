package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/01
 * Time : 1:25 AM
 */

class CarsTest {
	private Car[] carArray;

	@BeforeEach
	void setup() {
		carArray = new Car[3];
		for (int i = 0; i < carArray.length; ++i) {
			carArray[i] = new Car();
		}
	}

	@Test
	@DisplayName("경주할 자동차가 잘 추가되는지 확인")
	void addRacingCar() {
		Cars cars = new Cars();
		for (Car car : carArray) {
			cars.addCar(car);
		}
		Assertions.assertThat(cars.getCars().size()).isEqualTo(carArray.length);
	}
}
