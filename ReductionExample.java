package ex09;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

import lombok.extern.log4j.Log4j;


@Log4j
public class ReductionExample {

	
	public static void main(String[] args) {
		List<Student> studentList =
			Arrays.asList(
				new Student("홍길동", 92),
				new Student("신용권", 95),
				new Student("김자바", 88)
			);
		
		//-----------------------//
		// 1st. STREAM pipeline
		//-----------------------//
		int sum1 =
			studentList.
				stream().	// List 컬렉션에서 순차처리 스트림 얻기
				mapToInt(Student :: getScore).	// 중간처리(매핑)
//				average();
				sum();	// 최종처리(집계)
		
		//-----------------------//
		// 2nd. STREAM pipeline
		//-----------------------//
		int sum2 =
			studentList.
				stream().	// List 컬렉션에서 순차처리 스트림 얻기
				map(Student :: getScore).	// 중간처리(매핑)
				reduce((a, b) -> a+b).	// 최종처리
//				reduce(new BinaryOperator<Integer>() {
//
//					@Override
//					public Integer apply(Integer accumulator, Integer score) {
//						log.info("BinaryOperator::apply invoked.");
//						log.info("\t>>> accumulator: " + accumulator);
//						log.info("\t>>> score: " + score);
//						
//						return accumulator+score;
//					} // apply
//					
//				}).
				get();	// OptionalXXX 값 객체에서 값 얻기
		
		//-----------------------//
		// 3rd. STREAM pipeline
		//-----------------------//
		int sum3 =
			studentList.
				stream().	// List 컬렉션에서 순차처리 스트림 얻기
				map(Student :: getScore).	// 중간처리(매핑)
				// 최종처리(커스텀집계)
				// reduce 메소드의 리턴타입이 Integer임
				// Auto-Unboxing으로 기본 정수값으로 반환
				reduce(0, (a, b) -> a+b); 
//				reduce(0, new BinaryOperator<Integer>() {
//					int count = 0;
//					int avg = 0;
//					int size = studentList.size();
//					
//					@Override
//					public Integer apply(Integer accumulator, Integer value) {
//
//						accumulator += value;
//						avg = accumulator / ++count;
//						
//						return (count != size) ? accumulator : avg;
//					} // apply
//					
//				});
				
		//-----------------------//
		// 위 3개의 STREAM pipeline에서 구한 커스텀 집계값을 각각 출력
		//-----------------------//
		
		log.info("sum1: " + sum1);
		log.info("sum2: " + sum2);
		log.info("sum3: " + sum3);
	} // main
	
} // end class
