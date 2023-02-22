# Jackson ObjectMapper

- `Jackson ObjectMapper` 란
    - 단어 뜻풀이를 해보면, `ObjectMapper`란 객체를 매핑(연결)한다로 볼 수 있겠다. 매핑이 왜 필요할까? 질문을 바꿔서, 매핑이 필요한 상황은 어떤 상황일까? 
    - 매핑이 필요한 상황 : 두 프로그램 간에 서로 통신해야 할 상황이 있다고 하자. 그리고 그 양자 간에 Tier혹 layer가 다른 상황이라면 서로 다른 데이터 타입을 사용할 일이 있을 것이다. 그런 예 중의 하나가 F/E와 B/E간의 통신상황일 것이고.
    F/E에서 많이 사용하는 언어로는 `Javascript`가 있고, B/E는 `Java`나 `Python`, `PHP` 등등이 있을 것이다. 
    - 그렇다면 결국 사용하는 데이터 타입은 언어차이에 의한 것일까? 물론 그렇게 단정지을 수는 없을 것이다. 다만 각 언어별 자주 사용되고 선호되는 데이터 타입이 다를 것이다. 언어별로 지향하는 철학이 다르고, 구현된 방식도 다르기 때문일 것이라고 생각한다. 아무튼, 이런 상황에서 다시 F/E와 B/E로 돌아가서, F/E는 JS, B/E는 `Java`를 사용한다고 하자. 
    - `Javascript`의 경우 가장 흔히 사용하는 데이터타입으로 json이 있고, java에서는 Map이나 클래스 기반으로 작성된 DTO를 많이 사용한다. 그리고 Jasckson은 Json과 dto(혹은 map)간의 매핑을 도와주게 된다. 
    - 그 전에, HTTP 통신을 기반으로 데이터를 주고받을 때에는 직렬화/ 역직렬화의 과정을 거치게 된다. 이 때 사용되는 타입 중의 하나가 json이기도 하다. HTTP를 통해서는 결국 String 데이터들이 왔다갔다 할텐데, F/E에서 B/E로 데이터를 보내게 되면 단순 String인 데이터를 Java에 객체화를 시켜줘야 할 것이다. 그리고 반대로 Java에서 객체화되어 메모리에 저장된 데이터를 HTTP로 보내려면 String화해서 JSON으로 만들어 보내야 할 것이다. 이 작업을 Jackson의 `ObjectMapper`가 아주 많이 도와준다.
    - 예를 들어 Java에서 클래스로 작성한 DTO객체를 JSON 기반의 문자열로 바꾸려는 작업을 직접 하려면, 불가능한 것은 아니지만 데이터가 커질수록 휴먼에러의 가능성이 커진다. double quote 지옥에 빠져서 허우적거릴 확률이 높다... 하지만 우리의 `ObjectMapper`는 그것을 자동화해줬다(누군가의 피땀어린 노력의 결과일 것이다.). 그리고 당연히 반대의 경우로 JSON(문자열)을 Java의 DTO(객체)로 변환해주기도 한다. 
    - 여기까지만 보더라도 굉장히 활용성이 높고 사용할 확률이 높기 때문에, Spring Web 의존성에 Jackson을 포함시켰다. Web을 사용하는 application이라면 기본적으로 필요할 것이라고 생각했을 것이다. 아무튼 Spring web의존성을 추가했다면 따로 Jackson을 추가할 필요가 없으니 꼭 기억하자. 
    - 참고로 Jackson은 JSON뿐만 아니라, XML/YAML/CSV 등 다양한 형식의 데이터를 지원한다. 
    
- `ObjectMapper`
    - `ObjectMapper`의 역할은 다시한번 말하지만 직렬화/역직렬화를 돕는 것이다. 
    - 전송할 수 있는 형태로 직렬화하고, 전송받은 데이터를 알맞은 형태로 다시 역직렬화하여 복원하는 것이다. 

- `@JsonProperty`
    - jackson을 사용해서 layer 간 통신을 하다보면, json의 키값이 애매할 때가 있다. F/E에서는 a라는 이름으로 사용하기 때문에 a라는 이름으로 보내지만, B/E에서는 a라는 이름이 이미 다른 곳에서 사용 중이기 때문에 aa라는 이름으로 바꿔서 매핑을 해야할 때도 있을 것이다.
    - 아니면 B/E에서도 비즈니스 레이어와 데이터베이스 레이어와 데이터를 주고받을 경우에도, 데이터베이스 테이블 컬럼 명이 맘에 들지 않거나, 컬럼명을 그대로 사용하기 어려운 경우가 있을 수 있다. 
    - 위와 같은 경우에 `@JsonProperty`가 유용하다.
    - 서론이 길었지만 기능에 대해서 간단하게 말하자면, Java 기준으로 Dto의 필드명이 a이더라도 `@JsonProperty`를 사용해서 a-1으로 매핑할 수 있도록 해주는 역할을 한다.
    - 이 외에 유용한 옵션으로 `@JsonInclude`도 있다. jackson은 값의 유무와 상관없이 모든 property를 serialize하는 게 기본동작 방식인데, 이 annotation을 통해서 serialize조건을 지정할 수 있다. 예를 들어 `@JsonInclude(JsonInclude.Include.NON_NULL)`의 경우 값이 있는 경우에만 serialize하겠다는 의미가 되겠다. 자세한 것은 [여기](https://fasterxml.github.io/jackson-annotations/javadoc/2.9/com/fasterxml/jackson/annotation/JsonInclude.html)를 참고하자