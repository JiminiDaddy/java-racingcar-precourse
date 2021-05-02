package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/30
 * Time : 11:46 PM
 */

class RacingCarGameTest {

	@DisplayName("자동차이름이 5문자 이하인지 검증")
	@ParameterizedTest
	@ValueSource(strings = {"aaa,bb,c", "aaa,bbbbb,cc", "aa,b,ccc,d", "cc"})
	void validCarNameLengthLimit5(String names) {
		String[] carNames = RacingCarGame.getValidCarNames(names);
		assertThat(carNames).isNotNull();
		assertThat(carNames).isEqualTo(names.split(","));
	}

	@DisplayName("자동차이름이 5문자를 초과하거나 빈문자이면 안되는지 검증")
	@ParameterizedTest
	@ValueSource(strings = {"aaaaaaa,bbbbbbbb,ccccccccc", "aa,bbbbbbbb,c", "aaaaaa,bbbbbb,cccccccccccccc", ""})
	void validCarNameLengthOver5(String names) {
		assertThatThrownBy(() -> RacingCarGame.getValidCarNames(names))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("가장 멀리간 자동차가 승자가 되는지 확인")
	void getWinnerOfRacingCars() {
		Car car1 = new Car("car1");	// position = 2
		Car car2 = new Car("car2");	// position = 1
		Car car3 = new Car("car3");	// position = 0
		car1.run(9);
		car1.run(9);
		car2.run(9);
		car2.run(1);
		car3.run(0);
		car3.run(3);
		List<Car> winners = RacingCarGame.getWinners(Arrays.asList(car1, car2, car3));
		Assertions.assertThat(winners).isNotNull();
		Assertions.assertThat(winners.get(0)).isEqualTo(car1);
	}
}
