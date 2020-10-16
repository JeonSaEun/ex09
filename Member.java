package ex09;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public class Member {

	// 불변의 진리(상수) 정의
	public static final int MALE = 0;
	public static final int FEMALE = 1;
	
	// 필드 선언
	private String name;
	@Getter private int gender;
	@Getter private int age;
	
} // end class
