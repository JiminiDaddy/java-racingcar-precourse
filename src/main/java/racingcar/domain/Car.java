package racingcar.domain;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/30
 * Time : 11:31 PM
 */

public class Car {
	private static final int MIN_VALUE_RUNNABLE = 4;

	private RunDistance runDistance;

	private Name name;

	public Car(String name) {
		this.runDistance = new RunDistance();
		this.name = new Name(name);
	}

	public String getName() {
		return name.getValue();
	}

	public int getPosition() {
		return runDistance.getValue();
	}

	public void run(int number) {
		if (number >= MIN_VALUE_RUNNABLE) {
			runDistance.add();
		}
	}
}
