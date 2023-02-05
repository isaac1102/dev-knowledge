# Java HTTP Server

- Java HTTP Server
- Java NIO
- Java Lambda expression(람다식)
    - Java Functional interface(함수형 인터페이스)



```
package http.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.List; 
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange; 
import com.sun.net.httpserver.HttpServer;
 

public class App {  
    public static void main(String[] args) throws IOException { 
    	App app = new App();
    	app.run();
    }
    
    private void run() throws IOException {
    	InetSocketAddress address = new InetSocketAddress(8080);
    	HttpServer httpServer = HttpServer.create(address, 0);
    	
    	httpServer.createContext("/", (exchange ->{
    		// 1. request 
    		displayRequest(exchange);
    		
    		// 2. response
    		String content = "Hello world"; 
    		sendContent(exchange, content); 
    	}));
    	
    	httpServer.createContext("/hi", (exchange ->{
    		displayRequest(exchange);
    		String content = "Hi world!";
    		sendContent(exchange, content); 
    	}));
    	
    	httpServer.start();
    } 
    
    private void sendContent(HttpExchange exchange, String content) throws IOException { 
		byte[] bytes = content.getBytes(); 
		exchange.sendResponseHeaders(200, bytes.length);

		OutputStream outputStream = exchange.getResponseBody();
		outputStream.write(bytes);
		outputStream.flush();
    }
    
    
    private void displayRequest(HttpExchange exchange) throws IOException {
    	String method = exchange.getRequestMethod();
		System.out.println("Method : " + method);
		
		URI uri = exchange.getRequestURI();
		System.out.println("Path : " + uri.getPath());
		
		Headers headers = exchange.getRequestHeaders();
		for(String key : headers.keySet()) {
			List<String> values = headers.get(key);
			System.out.println(key  + " : " + values);
		}
		
		InputStream inputStream = exchange.getRequestBody();  
		String body = new String(inputStream.readAllBytes());
		
		System.out.println(body);
    }
}

```
