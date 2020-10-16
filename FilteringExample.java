package ex09;

import java.util.Arrays;
import java.util.List;

import lombok.extern.log4j.Log4j;


@Log4j
public class FilteringExample {

	
	public static void main(String[] args) {
	
		List<String> names =
			Arrays.asList("홍길동", "신용권", "김자바", "신용권", "신민철");
		
		//--------------------------//
		// Method Chaining을 이용하여,
		//	 STREAMS pipeline 구성
		//--------------------------//
		names.
			stream().			// 스트림 생성
			distinct().			// 중간처리(필터링)
			forEach(log::info);	// 최종처리(콘솔출력)
		
		log.info("\n");
		
		//--------------------------//
		// Method Chaining을 이용하여,
		//	 STREAMS pipeline 구성
		//--------------------------//
		names.
			stream().			// 스트림 생성
			filter(n -> n.startsWith("신")).		// 중간처리(필터링)
			forEach(log::info);	// 최종처리(콘솔출력)
		
		log.info("\n");
		
		//--------------------------//
		// Method Chaining을 이용하여,
		//	 STREAMS pipeline 구성
		//--------------------------//
		names.
			stream().			// 스트림 생성
			distinct().			// 중간처리(필터링)
			filter(n -> n.startsWith("신")).		// 중간처리(필터링)
//			firter(String :: startsWith("신")).	// 메소드 참조 불가
			forEach(log::info);
	} // main
	
} // end class
