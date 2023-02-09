# URI & MIME

### URI(Uniform Resource Identifier)
- URI는 Uniform Resource Identifier라는 말의 줄임말에서 알 수 있듯이, 리소스를 식별할 수 있는 규격이며 방법이다. 
- URI를 통해 Resource를 식별하는 방법으로는 두 가지가 있는데, URL과 URN이다.
    1. URL(Uniform Resource Locator) -> 리소스의 위치. 위치 변경에 취약하다.
        - ex) http://www.example.com:80/path/to/myfile.html?key=1value&key2=value2
    2. URN(Uniform Resource Name) -> 리소스의 "유니크"한 이름. 사실상 쓰이지 않는다.
        - ex) urn:isbn:9780141036144
- 실제로 URI로서 URL이 많이 사용된다.

### MIME Type(Content Type, Media Type)
- 사실 MIME를 처음 들었을때 요즘 많이 쓰는 말인 MEME이랑 처음에 좀 헷갈렸다.
- 웹에서 정보를 전송 할 때 파일 확장자는 크게 의미가 없어진다. 왜냐하면 기본적으로 확장자를 포함한 파일 전체를 보내는 것이 아니라 그 파일의 내용들을 전송하기 때문이라고 생각한다. 예를 들어 웹에서 어떤 정보를 요청했을 때 응답으로 엑셀파일을 보내거나 한글파일을 보낼 일은 파일전송이 아닌 이상 거의 없기 때문이다. 
 많은 경우 문서를 주고받게 되는데, 이럴 경우 파일 내용의 정보가 어떤 형식인지 알려주는 것이 중요하다. 그래서 형식이 plain text인지, 아니면 html형식인지 xml 형식인지 json인지 알려주고 client에서는 적절히 해석을 하도록 하는 것이다. 
 - MIME Type은 쉽게 말하면 우리가 HTTP 헤더에 추가하는 Content Type이나 Media Type으로 이해하면 된다. 리소스의 표현방식이다. 
- MIME의 구조는 type/subtype의 형태를 띈다. 타입의 전체목록은 [여기](https://developer.mozilla.org/ko/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types)에서 볼 수 있다.
    - ex) 
    - text/plain : 이것은 text이면서 plain이라는 의미이다. email에서 자주 사용한다.
    - text/html : 이것은 text이면서 html 문서다.
    - text/css, text/javascript : text이면서 css, text이면서 html이다.
    - application/xml 
        - application이라고 해서 뭔가 프로그램이다 application을 말하는 건 아니고, 응용할 수 있다는 의미정도로 이해하면 된다. 범용적으로 쓰이지만, 상대적으로 자기서술적이기 어렵다. 가능은 하지만 xml 자체로 자기서술적으로 표현하려면 
    - application/atom+xml
    - application/json -> 범용. 자기서술적이기 어렵다.
    - application/dns+json 
