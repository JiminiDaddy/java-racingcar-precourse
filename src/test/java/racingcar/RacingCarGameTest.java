package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/30
 * Time : 11:46 PM
 */

class RacingCarGameTest {
	private RacingCarGame racingCarGame;

	@BeforeEach
	void setup() {
		racingCarGame = new RacingCarGame();
	}

	@DisplayName("자동차이름이 5문자 이하인지 검증")
	@ParameterizedTest
	@ValueSource(strings = {"aaa", "aaaaa", "d"})
	void validCarNameLengthLimit5(String names) {
		assertThat(racingCarGame.validCarNameLength(names)).isTrue();
	}
	@DisplayName("자동차이름이 5문자를 초과하거나 빈문자이면 안되는지 검증")
	@ParameterizedTest
	@ValueSource(strings = {"bbbbbb", "bbbbbbbb", "bbbbbbbbb", ""})
	void validCarNameLengthOver5(String names) {
		assertThat(racingCarGame.validCarNameLength(names)).isFalse();
	}
}
