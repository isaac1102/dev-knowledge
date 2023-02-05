package http_server;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.CharBuffer;
  
public class App { 
	int port = 8080;
	public static void main(String[] args) throws IOException {
		App app = new App();
		app.run();
	}
	
	/* 
	 * java에서넌 Server용으로 ServerSocket이라는 클래스를 별도로 사용한다.
	 * Socket을 상속한 것이 아니라는 점에 유의
	 */
	private void run() throws IOException {
		// 1. Listen
		ServerSocket listener= new ServerSocket(8080, 0); // port, backlog count
		System.out.println("Listen!"); 
		
		// 2. Accept
		/*
		 * I/O에서 기다리는 것을 Blocking이라고 한다. 파일 읽기, 쓰기 등도 모두 Blocking이지만, 
		 * TCP통신에서 네트워크 상태 요인에 따라 지연될 수 있고, 상대방의 요청이 없다면 끝없이 기다릴 수 있다.
		 * 때문에 멀티스레드나, 비동기, 이벤트 기반 처리 등이 필요하다.
		 */
		
		while(true) { 
			Socket socket = listener.accept();
			System.out.println("Accept!");
			
			// 3. Request 
			Readable reader = new java.io.InputStreamReader(socket.getInputStream());
			CharBuffer charBuffer = CharBuffer.allocate(1_000_000);
			reader.read(charBuffer);
			
			charBuffer.flip();
			System.out.println(charBuffer.toString()); 
			
			// 4. Response
			String body = "Hello world!";
			byte[] bytes = body.getBytes();
			String message = ""
					+ "HTTP/1.1 200 OK\n"
					+ "Content-type: text/html; charset=UTF-8\n"
					+ "Content-Length: " + bytes.length + "\n\n" + body;
			 
			Writer writer = new OutputStreamWriter(socket.getOutputStream());
			writer.write(message);
			writer.flush();
			
			// 5. close
			socket.close();
		} 
	}
}
