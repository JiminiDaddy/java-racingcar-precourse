package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/30
 * Time : 1:35 PM
 */

class ValidNumberUtilsTest {
	@Test
	@DisplayName("0~9의 랜덤 정수를 가져오기")
	void validRandomNumberBetween0And9() {
		// 1회만 수행할경우 운좋게 될 수 있으니 모수를 크게 잡아 모두 유효범위에 있는지 테스트한다.
		final int TEST_COUNT = 100;
		for (int t = 1; t <= TEST_COUNT; ++t) {
			int number = ValidNumberUtils.selectNumber();
			Assertions.assertThat(number).isBetween(0, 9);
		}
	}
}
