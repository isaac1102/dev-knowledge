# CORS
- CORS 란
    - `Cross-Origin Resource Sharing`의 줄임말이다. 단어 그대로 보면 교차 출처 자원 공유라는 의미인데, 좀 더 풀어보면 출처가 다른 자원을 공유한다는 걸로 이해할 수 있다. 
    - `CORS`는 동일 출처정책(Same-origin policy, 이하 SOP) 때문에 나왔다. 그럼 먼저 동일 출처 정책에 대해서 먼저 알아보자.
    - `동일출처 정책(Same-origin policy)`
        - >한 출처 에서 로드한 문서 또는 스크립트가 다른 출처의 리소스와 상호 작용할 수 있는 방법을 제한하는 중요한 보안 메커니즘입니다.
        - 라고 [이곳](https://developer.mozilla.org/en-US/docs/Web/Security/Same-origin_policy)에 서술돼 있다.
        - 위의 문장을 보면, 한 출처에서 로드된 리소스는 다른 출처의 리소스와 상호작용 할 수 없게 했다고 한다. 왜 그랬을까? 보안 때문이라는 것을 쉽게 유추할 수 있다. 
        - 예를 들어서 나는 A라는 치킨집에 전화해서 양념 1마리를 시켰는데, A가 B라는 가게에 하청을 주어서(redirect?) B치킨집에서 양념치킨을 보내온 것이다. 이렇게 된 경우, 결국에는 내가 원하던 치킨맛이 아닐 수도 있고 나아가 B에서 내 치킨에 무슨 짓을 하는지 나는 전혀 모른 채로 치킨을 먹어야 할 수도 있는 것이다.(물론 치킨은 항상 맛있을 거라 생각한다.) 
        - 잠재적인 악성 문서를 격리하고 공격을 예방한다는 취지인 것이다. 좀 더 진지한 예로, 인터넷의 악의적인 웹사이트가 브라우저에서 JS를 실행하여 타사 웹메일 서비스(사용자가 로그인한 서비스) 또는 회사 인트라넷의 데이터를 읽는 일이 있을 수도 있는 것이다. 이런 경우 동일출처가 아니기 때문에 client에서 거부할 수 있다. 
        - 동일 출처를 구분하는 기준은 host url을 기준으로 하는데, 프로토콜, 포트, 호스트가 모두 동일해야 같은 url이라고 인정한다.
    - `CORS`의 필요성
        - 인터넷이 발달하면서 각 application의 비즈니스가 복잡해지고, 타 프로그램과의 연관성이 높아지면서 서로 간에 데이터를 요청해야 할 일이 많아졌다. 
        - F/E와 B/E의 분리로 인해서 서버가 나뉘게 된다. Front 서버는 렌더링에 사용되고, Backend 서버는 데이터를 요청하는 데 사용됐다. 클라이언트는 이 두 가지 서버에 각기 다른 요청을 보내야했기 때문에 처리에 한계가 생겼다. 
    - 이러한 필요성에 따라 CORS를 허용하게 됐는데, 이 작업은 HTTP 헤더를 조작함으로 이뤄진다. 
        - `Access-Control-Allow-Origin`
            - 직역해보면 이 출처의 접근 허용을 통제한다는 뜻이겠다. HTTP 헤더에 위의 요소를 추가하고, 그 값으로 url을 넣으면 해당 url은 client에서 출처가 다르더라도 허용하게 된다. 

    - JSONP
        - 브라우저에서 SOP문제를 회피하기 위해서 `<script>`태그를 이용해 꼼수를 사용해서 JSON 타입의 데이터를 가져오기 위한 방법이다. HTML의 `<script>` 요소로부터 요청되는 호출에는 보안상 정책이 적용되지 않는다는 점을 이용한 우회 방법이다. 
        - JSONP는 `GET`방식만 사용이 가능하며 서버에서 함께 `JSONP`를 지원해줘야 사용이 가능하다는 제약이 있다.

- `@CrossOrigin`
    - Java의 Servlet기반 HTTP통신에 사용되는 `HttpServletResponse`클래스를 통해 헤더값에 `Access-Control-Allow-Origin`를 설정해주면 적용이 가능하다. 
    - `Spring`에서는 사용자가 더 편리하게 `@CrossOrigin`을 메서드나 클래스(상황에 맞는 스코프)에 추가하게 되면, CORS를 허용하게 처리해준다. 
    - `@CrossOrigin`만 붙이면 기본적으로 모든 도메인과, 모든 요청방식에 대해 허용한다는 뜻이다.
    - `@CrossOrigin`의 요소 중의 origins의 값으로 url을 추가하면, 허용할 도메인을 화이트리스트 방식으로 관리할 수 있다.
    ```
    @CrossOrigin
    @GetMapping
    public List<PostDto> list() {
        return List.of(
                new PostDto("1", "title1", "body1"),
                new PostDto("2", "title2", "body2"),
                new PostDto("3", "title3", "body3")
        );
    }

    @CrossOrigin(origins = "http://example.com/", "http://localhost:8080)
    @GetMapping
    public List<PostDto> list() {
        return List.of(
                new PostDto("1", "title1", "body1"),
                new PostDto("2", "title2", "body2"),
                new PostDto("3", "title3", "body3")
        );
    }
    ```