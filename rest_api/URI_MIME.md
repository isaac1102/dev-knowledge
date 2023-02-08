# URI & MIME

### URI(Uniform Resource Indentifier)
- 리소스를 식별하는 방법
- 식별할 때는 식별자를 사용한다.(Identifier = ID)
- URI는 크게 둘로 나뉜다
    1. URL(Uniform Resource Locator) -> 리소스의 위치. 위치 변경에 취약하다.
        - ex) http://www.example.com:80/path/to/myfile.html?key=1value&key2=value2
    2. URN(Uniform Resource Name) -> 리소스의 "유니크"한 이름. 사실상 쓰이지 않는다.
        - ex) urn:isbn:9780141036144
- 실제로 URI로서 URL이 많이 사용된다.

### MIME Type(Content Type, Media Type)
- 리소스의 표현방식
- type/subtype의 구조
    - ex) 
    - text/plain -> email에서 자주 사용한다.
    - text/html -> 일반적인 웹 문서. HTML 문서
    - text/css, text/javascript
    - application/xml -> 범용. 상대적으로 자기서술적이기 어렵다. 
    - application/atom+xml
    - application/json -> 범용. 자기서술적이기 어렵다.
    - application/dns+json 
