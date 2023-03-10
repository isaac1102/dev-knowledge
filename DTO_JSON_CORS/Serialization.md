## Serialization(직렬화) 
    - 직렬화란 뭘까? serialize한다는 것인데, 컴퓨터 프로그래밍의 세계(?)에서는 주로 데이터를 어딘가에 저장하거나 어딘가로 전송하는 경우에 직렬화를 하게 된다. 좀 더 간단히 말해보면 어딘가로 보내기 위해서 구조나 형식을 변형하는 것이라고 볼 수 있다. 
    - 그렇다면 이 작업이 왜 필요한 것일까? 만약 온 세상의 프로그래밍 언어와 시스템이 한가지로만 구성되어 있다면 직렬화는 필요가 없을지도 모르겠다.(나의 짧은 생각이다.) 하지만 세상에는 다양한 OS와 시스템 환경, 그리고 꽤나 많은 프로그래밍 언어들이 있다. 하지만 서로 다른 구성요소들끼리도 통신을 하고 데이터를 주고 받아야 할 일이 많아졌고, 이에 따라 서로 이해할 수 있고 사용할 수 있는 데이터의 규격을 맞춰서 주고받고자 했을 것이다. 서로가 보내고 받아서 해석할 수 있고 사용할 수 있도록 규격을 맞춰 변형하는 것이 직렬화이며, 그 반대로 데이터를 원래의 형태로 복원하는 것이 역직렬화이다.
    - 한 예로, Java에서는 클래스 기반으로 Dto라는 데이터타입을 사용한다. 이 Dto에 담긴 값들을 F/E에 json으로 전송해야 한다고 가정하자. 한 Dto 클래스에는 여러 타입의 필드들이 존재한다. 이 Dto 타입의 객체는 jvm에 있을 때에는 어딘가 메모리에 저장되어 있을 것이고, dto 변수는 메모리의 주소만을 가지고 있을 것이다. 이것을 전송하고자 dto변수 자체를 전송하게 되면, 엉뚱한 메모리 주소값만(사람이 알아보기 힘든) 전송하는 상황일 것이다. 내가 원하는 것은 무의미한 메모리 주소값이 아니라, 유의미한 필드들의 값일텐데 말이다. 결국 이 때 필요한 작업은 HTTP통신으로 보내기 전에 객체 데이터를 String기반의 json 포맷데이터로 변환하는 작업이다. 이러한 변환하는 작업을 직렬화라고 한다.
## 마샬링
    - 사실 위에서 말한 직렬화(serialization)은 마샬링의 일종이다. 마샬링도 직렬화와 맥락은 비슷한데, 메모리에 저장된 객체의 정보를 저장이나 전송가능한 형식으로 변환하는 것이다.
    - 직렬화와 무엇이 다른가? 마샬링의 경우 직렬화된 오브젝트로 멀리 떨어진 오브젝트와 통신하기 위해서 사용된다고 한다. 이 말은 단순히 데이터를 옮긴다는 차원이 아니라 상태와 코드베이스를 복제하는 것이다. 다른 말로 해보면, 클래스 정보까지 함께 로딩하기 때문에 원본 오브젝트의 사본을 얻는 방식이라고 할 수 있다. (음 사실 크게 와닿는 설명이 아니다.)
    - >여기에서 사용되는 '코드베이스'의 의미는 소스 코드를 일컫는 더 일반적인 의미의 코드베이스가 아니라, 자바에 국한되어 오브젝트 코드가 로드되는 URL의 목록을 참조하기 위한 것이라는 의미로 사용된다. 
    - > 오브젝트를 "직렬화한다"는 것은 오브젝트의 상태를 오브젝트의 사본으로 다시 변환할 수 있는 바이트 스트림으로 변환하는 것을 의미한다.
    - 라고 나와있다. 출처 [https://ko.wikipedia.org/wiki/%EB%A7%88%EC%83%AC%EB%A7%81_(%EC%BB%B4%ED%93%A8%ED%84%B0_%EA%B3%BC%ED%95%99)](https://ko.wikipedia.org/wiki/%EB%A7%88%EC%83%AC%EB%A7%81_(%EC%BB%B4%ED%93%A8%ED%84%B0_%EA%B3%BC%ED%95%99))


## JSON
    - `JSON`은 `Javascript Object Notation`의 줄임말이다. 풀어보면 자바스크립트 객체를 표기하는 방법이라는 것이다. 이것은 데이터를 표현하기 위한 구조체이며 규격이라고 할 수 있다. 이름 자체에 `Javascript`가 들어간 걸로 알 수 있듯이 `Javascript`진영에서 엄청 쓰인다. 물론 다른 언어에서도 사용할 수 있다.
    - HTTP에서 사용할 수 있다는 것은 MIME TYPE이 선언돼 있다는 뜻일 것이다. 그래서 HTTP 요청 시에 MIME Type으로 application/json으로 추가해주면, 이 규격에 맞게 해석할 수 있다. 
    - `JSON`은 문자 기반이다. 그래서 HTTP 통신에도 그대로 사용이 가능한 것 같다. 
    - 가독성이 매우 좋고 구조 자체가 매우 단조롭기 때문에 사용성도 매우 좋다. 
    - JS의 아버지와 다름 없는 `Douglas Crockford`님께서 널리 퍼뜨리셨다고 한다. 
    - `JSON`에는 프로퍼티만 담을 수 있다. 메서드는 담을 수 없다. 
    - `13일의 금요일`의 금요일에 나왔던 빌런 이름이 jason인데, 겁나 무서운 사람이었다... 
    - 자세한 내용은 [이곳](https://developer.mozilla.org/ko/docs/Learn/JavaScript/Objects/JSON)에 친절히 잘 나와있다.