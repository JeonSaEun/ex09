package ex09;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.extern.log4j.Log4j;


@Log4j
public class ToListExample {

	
	public static void main(String[] args) {
		List<Student1> totalList = Arrays.asList(
			new Student1("홍길동", 10, Student1.Gender.MALE),
			new Student1("김수애", 6, Student1.Gender.FEMALE),
			new Student1("신용권", 10, Student1.Gender.MALE),
			new Student1("박수미", 6, Student1.Gender.FEMALE)
			);
		
		//-------------------------//
		// 1. 남학생들만 필터링하여,
		//	별도의 List 컬렉션에 수집
		//-------------------------//
		
		//-------------------------//
		// 1-1. STREAM pipeline: 
		// 전체 학생중에, 남학생만 필터링하여
		// 별도의 List<Student1> 객체로 수집
		List<Student1> maleList =
			totalList.
					stream().
					filter(s -> (s.getGender() == Student1.Gender.MALE) ).
					collect(
					// *** 중요 ***
						Collectors.toList()
					); // collect
		
//		Set<Student1> maleList2 =
//				totalList.
//					stream().
//					filter(s -> (s.getGender() == Student1.Gender.MALE) ).
//					collect(
//						Collectors.toSet()
//					); // collect
		
		
		//-------------------------//
		// 1-2. STREAM pipeline:
		// 제대로 남학생만 수집되었는지 확인
		maleList.
			stream().
			forEach(log::info);
		
		log.info("\n");
		
		//-------------------------//
		// 1-3. STREAM pipeline:
		// 전체 학생중에, 여학생만 필터링하여
		// 별도의 Set<Student1> 객체로 수집
		Set<Student1> femaleSet =
			totalList.
				stream().
				filter(s -> s.getGender() == Student1.Gender.FEMALE).
				collect(
					Collectors.toCollection(
						HashSet :: new // 생성자 참조
//						HashSet<Student>::new));
//						() -> new HashSet<>));
//						() -> new HashSet<Student1>()));
					) // toCollection
				);	// collect
						
		//-------------------------//
		// 1-4. STREAM pipeline:
		// 제대로 여학생만 수집되었는지 확인(콘솔출력
		femaleSet.
			stream().
			forEach(log::info);
	} // main
	
} // end class