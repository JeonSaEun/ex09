package ex09;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@ToString
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class Student1 {
	// 열거상수 정의
	public enum Gender { MALE, FEMALE }
	public enum City { SEOUL, BUSAN }
	
	// 필드 선언
	@NonNull private String name;
	@NonNull private Integer score;
	@NonNull private Gender gender;
	private City city;

} // end class