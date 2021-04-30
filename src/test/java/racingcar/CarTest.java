package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/30
 * Time : 11:28 PM
 */

class CarTest {
	@Test
	@DisplayName("입력값이 4이상이면 자동차가 전진한다")
	void goCar() {
		Car car = new Car();
		car.run(9);
		Assertions.assertThat(car.getPosition()).isEqualTo(1);
		car.run(3);
		Assertions.assertThat(car.getPosition()).isEqualTo(1);
		car.run(4);
		Assertions.assertThat(car.getPosition()).isEqualTo(2);
		car.run(0);
		Assertions.assertThat(car.getPosition()).isEqualTo(2);
	}
}
