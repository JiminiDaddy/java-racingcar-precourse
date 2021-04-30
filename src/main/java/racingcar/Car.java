package racingcar;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/30
 * Time : 11:31 PM
 */

public class Car {
	private int position;

	private String name;

	public Car(String name) {
		this.position = 0;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void run(int number) {
		if (number >= 4) {
			++position;
		}
	}
}
