package racingcar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/01
 * Time : 1:26 AM
 */

public class Cars {
	private List<Car> cars = new ArrayList<>();

	public final List<Car> getCars() {
		return cars;
	}

	public void addCar(Car car) {
		cars.add(car);
	}
}
