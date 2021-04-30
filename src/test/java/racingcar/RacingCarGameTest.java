package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
}
