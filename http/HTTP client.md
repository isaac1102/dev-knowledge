---
description: HTTP client의 개념과 간단한 구현을 해보았습니다.
---

# HTTP client 
## TCP/IP 통신
- 인터넷 프로토콜 스위트 중의 하나로서 가장 많이 사용되는 통신방법이다.
    - [https://ko.wikipedia.org/wiki/%EC%9D%B8%ED%84%B0%EB%84%B7_%ED%94%84%EB%A1%9C%ED%86%A0%EC%BD%9C_%EC%8A%A4%EC%9C%84%ED%8A%B8](https://ko.wikipedia.org/wiki/%EC%9D%B8%ED%84%B0%EB%84%B7_%ED%94%84%EB%A1%9C%ED%86%A0%EC%BD%9C_%EC%8A%A4%EC%9C%84%ED%8A%B8)
    - 인터넷 프로토콜 스위트(영어: Internet Protocol Suite)는 인터넷에서 컴퓨터들이 서로 정보를 주고받는 데 쓰이는 통신규약(프로토콜)의 모음이다. 인터넷 프로토콜 슈트 중 TCP와 IP가 가장 많이 쓰이기 때문에 TCP/IP 프로토콜 슈트라고도 불린다.
- TCP/IP에서 TCP는 TCP프로토콜을 의미하진 않는다. 

## 전송계층 
- [https://ko.wikipedia.org/wiki/%EC%A0%84%EC%86%A1_%EA%B3%84%EC%B8%B5](https://ko.wikipedia.org/wiki/%EC%A0%84%EC%86%A1_%EA%B3%84%EC%B8%B5)
- 여러가지 프로토콜이 존재하지만, 가장 많이 쓰이는 TCP와 UDP에 대해 알아보았다.
- TCP
    - 연결이 필요하다.
    - 전달성공 여부 및 순서가 보장된다. (전화, 등기우편)
    - 데이터 유실 가능성이 낮다.
    - 통신순서
        1. Listen 
            - 서버는 접속 요청을 받기 위한 소켓을 연다. 
            - 클라이언트와의 통신을 위한 소켓은 아니다. 요청을 받기 위한 소켓 
        2. Connect 
            - 클라이언트는 소켓을 만들고, 서버에 접속을 요청한다.
        3. Accept : 서버는 접속 요청을 받아서 클라이언트와 통신할 소켓을 따로 만든다. 
        4. Send & Receive 반복 : 소켓을 통해 서로 데이터를 주고 받는다. 
        5. Close : 통신을 마치면 소켓을 닫는다. 상대방은 Receive로 인지할 수 있다. 
        
- UDP
    - 연결이 필요하지 않고 데이터를 보낸다. 
    - 전달성공 여부와 순서를 보장하지 않는다. (편지)   
    - 데이터 유실 가능성이 비교적 높다.
    - 최근에는 UDP를 활용하여 전달여부와 순서를 보장하는 방법도 사용한다고 한다. (QUIC)

## Socket과 Socket API 구분
- Socket과 Socket API는 다른 개념이다. Socket API는 Socket을 사용하기 위한 API이다.
- 예를 들어, [Berkeley sockets](https://en.wikipedia.org/wiki/Berkeley_sockets)은 internet sockets과 unix domain sockets를 사용하기 위한 socket api라고 할 수 있다.  
- Socket
    - [네트워크 소켓](https://ko.wikipedia.org/wiki/%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC_%EC%86%8C%EC%BC%93)의 하위범주이다. 
    - 오늘날 대부분의 컴퓨터 간 통신은 인터넷 프로토콜을 기반으로 하기 때문에, 대부분의 네트워크 소켓은 인터넷 소켓이다. 
    - 네트워크 소켓은 컴퓨터 네트워크를 경유하는 프로세스 간 통신의 종착점이다. 
    - 파일과 유사하게 다룰 수 있다. 
        - 유닉스에서는 파일 디스크립터의 일종과 유사하다.
        - 읽기, 쓰기 등의 동작이 있다. 
        - Java에서는 키보드 입력, 화면 출력, 파일 입출력 등과 마찬가지로 Stream(Java8의 Stream API가 아님)으로 다룰 수 있다. 
- Socket API
    - Socket을 사용하기 위한 API이다.
    - Berkeley Sockets
        - 버클리 소켓 은 IPC( 프로세스 간 통신 ) 에 사용되는 인터넷 소켓 및 Unix 도메인 소켓 용 애플리케이션 프로그래밍 인터페이스 (API)이다.
        - POSIX 소켓 혹은 BSD 소켓으로도 알려져 있다. 

## URI와 URL
- URL과 URI는 자주 혼용되어 사용되는 용어이지만 동일하지 않다. 
- URI는 리소스의 URL과 URN을 동시에 나타낼 수 있지만 URL은 인터넷에서 리소스의 주소만 지정할 수 있다. 
- URL(Uniform Resource Locator)
    - URL은 CSS 문서 또는 HTML 웹 페이지가 될 수 있는 고유한 리소스 
- URI(Uniform Source Identifier)
    - 문자열 식별자로 신택스 규칙에 따라 통일성을 확인한다. 
    - 이름 및 경로 정보로 인터넷에서 리소스를 식별하는 데 사용되는 문자열로 구성된다. 
    - URN 체계를 지정하는 인터넷 리소스로 리소스를 일관되게 식별할 수 있다.
    - URI는 URL과 URN을 모두 설명할 수 있다.
    - HTTP, HTTPs, ftp, Idap, telnet은 모두 URI 체계이다.
- URN(Uniform Resource Name)
    - URN은 URI의 표준 포맷 중 하나로, 이름으로 리소스를 특정하는 URI이다.
    - http와 같은 프로토콜을 제외하고 리소스의 name을 가리키는데 사용된다.
    - URN에는 리소스 접근방법과, 웹 상의 위치가 표기되지 않는다.
    - 실제 자원을 찾기 위해서는 URN을 URL로 변환하여 이용한다.
    - URN은 리소스를 어떻게 접근할 것인지 명시하지 않고 경로와 리소스 자체를 특정하는 것을 목표로하는 URI이다. 


## 호스트(host)
- 서버의 도메인 이름
- 포트가 주어지지 않으면, 요청된 서버의 기본 포트는 80이다.
- Host 헤더의 필드는 모든 HTTP/1.1 요청 메시지 내에 포함되어 전송되어야 한다.
    - IP 주소
        - IP 주소는 인터넷 또는 로컬 네트워크에서 장치를 식별하는 고유한 주소를 말한다. 
        - IP주소는 네트워크 장치 간에 서로를 식별하여 정보를 전달하게 해주는 식별자이다. 
    - Domain name
        - 영숫자 IP 주소에 매핑되는 영어 숫자로 구성된 텍스트 문자열이며, 클라이언트 소프트웨어에서 웹 사이트에 액세스하는 데 사용된다.
        - Domain name을 사용하는 이유는 IP주소를 문자열로 대체함으로 좀더 인간 친화적으로 웹 사이트에 접근하기 위함이다.
        - Domain name이 IP로 전환되는 프로세스를 DNS 조회라고 한다.
    - DNS
        - Domain Name System의 준말로 인터넷 전화번호부와 같다. 
        - 사용자가 google.com과같은 Domain name을 사용하여 브라우저에 입력하면, 브라우저는 인터넷 자원을 로드할 수 있도록 도메인 이름을 IP 주소로 변환한다.
        - DNS 서버를 사용하면 사람이 숫자로 구성된 IP주소나(IPv4) 혹은 IPv6의 주소에 접근하기 위해 복잡하게 암기하지 않아도 된다.  

## 포트(port)
- 서버가 리스닝하는 TCP 포트 번호
- 네트워크 연결이 시작되고 끝나는 가상 지점이다.
- 포트를 사용함으로 컴퓨터가 서로 다른 종류의 트래픽을 구분할 수 있다. 예를 들어 이메일과 웹 페이지가 동일한 연결을 통해 컴퓨터에 도달하더라도 이메일은 웹 페이지와 다른 포트를 사용하기 때문에 식별이 가능하다.
- 포트는 네트워크에 연결된 모든 장치에서 표준화되며 각 포트에는 번호가 사용된다. 
- HTTP 포트의 기본값은 80이다.
- IP주소를 사용하면 메시지가 특정 장치와 주고받을 수 있지만 포트 번호는 해당 장치 내의 특정 서비스나 응용 프로그램을 대상으로 지정할 수 있게 해준다. 
- IP주소는 네트워크 통신 간에 장치를 구분하게 해주지만, 포트 번호는 해당 장치 내의 특정 서비스나 응용 프로그램을 식별하고 지정하라 수 있게 해준다. 
 
## Java InputStream과 OutputStream
## Java try-with-resources

참고자료 : [https://developer.mozilla.org/ko](https://developer.mozilla.org/ko)