## Spring Web MVC  
### Model-View-Controller 아키텍처 패턴
MVC 패턴이라고 부르는 패턴이다.

- View는 GUI에 관련된 표현계층.
- Controller는 클라이언트에서 들어오는 입력에 관한 처리를 하는 계층이다.
- Model은 그 외의 모든 처리를 하는 계층이다.  

굳이 M, V, C로 레이어를 나누는 이유가 뭘까?
이유는 Model에 대한 2가지 의미가 있기 때문이다.
1.  관심사의 분리의 차원. MVC에서 추구하는 부분이다.
    - Model은 핵심 비즈니스만 다룰 수 있도록 하기 위해 분리했다.
    - 예시) View계층에서 사용자가 어떤 버튼을 눌러 on/off 기능을 사용했다.
    - Controller에서는 클라이언트에서 들어온 입력을 통해 toggle.onOff()라는 메서드를 호출한다.
    - Model계층에서는 비즈니스 처리를 한다. 
2. (주로 웹에서) View에서 참조하는 데이터나 표현으로서 Model
    - MVC를 사용하는 Rails의 경우는 Active Record아키텍쳐 패턴이라는 것을 사용한다.
    - [Active Record](https://martinfowler.com/eaaCatalog/activeRecord.html)라는 것 자체가 DB테이블 자체를 1:1로 매핑하여 사용한다.
        - DB에 직접 명령을 내리거나 조작없이 어플리케이션 레벨에서 DB를 조작할 수 있다.
        - 하지만 Active Record가 마냥 좋지많은 않다. [Active Record considered harmful](https://steveklabnik.com/writing/active-record-considered-harmful)하다는 의견도 있다고 한다. 다익스트라님이 goto의 hamful함을 적은 글을 패러디 한 형식이라고 한다ㅋ
    - Spring Web  MVC에서는 Map과 유사한 ModelMap이라는 형태를 사용하여 인터페이스를 제공한다.
        - [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/ui/package-summary.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/ui/package-summary.html)
        - Spring web MVC에서는 애플리케이션 전체에 걸쳐서 이 개념을 사용하지 않고, 클라이언트(웹, UI Layer)와 관련된 Layer까지만 이 MVC 개념을 사용한다. 그 밑의 Domain Layer에서는 그 비즈니스에만 집중하도록 분리한다.
    - 결론은 Model이 꼭 DB와 연결되는 개념은 아니라는 것이다.

 최근에는 UI Layer를 아예 Front로 분리하고, Backend는 api만 제공하는 형식을 많이 사용한다. 그러다보니 UI Layer가 애플리케이션에 없이 Controller만으로 충분히 구성할 수 있게 됐다. 그리고 나아가 Spring5부터 생긴 WebFlux의 경우 Controller가 아닌 handler라는 개념으로 접근할 수도 있다. Hexagonal 아키텍쳐의 경우에는 Adapter를 사용한다.(Hexagonal은 나중에...)

```
package com.example.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomController {
	@GetMapping("/")
	public String home() {
		return "Hello world.";
	}
	
	@GetMapping("/hi")
	public String hi() {
		return "Hi, world.";
	}
}

```


Annotation 기록

- [@RestController](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html)
    - [@Controller](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Controller.html)
    - [@ResponseBody](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/ResponseBody.html)
- [@GetMapping](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/GetMapping.html)
    - [@RequestMapping](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestMapping.html)