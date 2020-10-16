package ex09;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.extern.log4j.Log4j;


@Log4j
public class StreamPipelinesExample {

	
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
			new Member("홍길동", Member.MALE, 30),
			new Member("김나리", Member.FEMALE, 20),
			new Member("신용권", Member.MALE, 45),
			new Member("박수미", Member.FEMALE, 27));
		
		//--------------------------------//
		//		STREAMS pipeline 구성
		//--------------------------------//
		double ageAvg = list.stream().
			filter(m -> (m.getGender() == Member.MALE) ).
			mapToInt(Member::getAge).
			average().
			getAsDouble();
		
		//--------------------------------//
		// 		메소드 체이닝 없이 !!!
		//--------------------------------//
		Stream<Member> stream = list.stream();
		
		stream = stream.filter(
			member -> (member.getGender() == Member.FEMALE));
		
		IntStream intStream =
			stream.mapToInt(member -> member.getAge());
		
		OptionalDouble od = intStream.average();
		
		Double ageAvg2 = od.getAsDouble();
		
		log.info("남자 평균 나이: " + ageAvg);
		log.info("여자 평균 나이: " + ageAvg2);
	} // main
	
} // end class