```
package com.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader; 
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.CharBuffer;  

public class App { 
	String message = """
			GET / HTTP/1.1
			Host: example.com
			
			""";
    public static void main(String[] args) { 
    	App app = new App();
    	app.run();
    }
    
    private void run() {
		System.out.println("Hello World"); 
		
		try(Socket socket = new Socket("example.com", 80)) {  
			Writer writer = new OutputStreamWriter(socket.getOutputStream());
			writer.write(this.message);
			writer.flush(); 
			System.out.println("Request!");
			
			InputStream input = socket.getInputStream();
			Reader reader = new InputStreamReader(input);
			
			CharBuffer charBuffer = CharBuffer.allocate(1_000_000);
			reader.read(charBuffer);
			charBuffer.flip(); 
			
//			byte[] bytes = new byte[1_000_000];
//			int size = input.read(bytes);
//			byte[] data = Arrays.copyOf(bytes, size);
//			String text = new String(data);
			
			String text = charBuffer.toString(); 
			System.out.println(text); 
			System.out.println("Completed!");
			
		} catch (UnknownHostException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		} 
	}
}

```