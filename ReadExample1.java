package ex09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import lombok.extern.log4j.Log4j;


@Log4j
public class ReadExample1 {

	
	public static void main(String[] args) throws Exception {
		// 지정된 경로에 파일에 대하여, 바이트기반의 입력스트림 생성
		InputStream is = new FileInputStream("C:/Temp/Temp.sql");
		
		// 파일에서 한번 Read할 때 마다
		// 읽어낸 바이트 수를 저장하는 지역변수 선언
		int readByte;
		
		// 위에서 지정한 파일의 처음부터 끝까지 읽음
		// (파일의 끝을 특히, EOF - End Of File라고 함)
		while(true) {
			// 이 매개변수 없는 read() 메소드는, 파일로부터 1바이트를 읽음
			readByte = is.read();	// 파일을 읽음(매 반복시마다)
			
			// 파일을 read해서 반환된, 읽은 바이트 수가 -1이면
			// 이는 파일의 끝을 의미(즉, EOF)
			if(readByte == -1) {	// if EOF
				break;			// 반복문을 빠져나감(더이상 읽을 내용 X)						
			} // if
			
			// 파일에서 읽은 1바이트를 문자로 강제 형변환하여 콘솔에 출력
			System.out.print((char)readByte);	
		} // while
		
		// 입/출력 스트림은 모두 자원객체로, 사용이 끝나면
		// 반드시 닫아서(close) 자원을 해제(resource release) 해줌
		is.close();
		
	} // main
	
} // end class
