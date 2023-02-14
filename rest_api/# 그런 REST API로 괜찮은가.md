# 그런 REST API로 괜찮은가

&nbsp;REST의 정의는 REpresentational State Transfer이다. 
이것만 봐서는 의미 유추가 어렵다.   
wiki백과에는 "a way of providing interoperability between computer systems on the internet."이라고 나와있다.   
interoperability은 상호운용성을 말하는데, 곧 인터넷에서 컴퓨터 시스템 간의 상호운영성을 제공하는 방법이라고 해석된다.   
그러나 여전히 어렵다.    
rest의 역사를 보면 이해가 더 쉽지 않을까?   
<br>
## 시작은 WEB(1991)이다. 
&nbsp;91년에 WWW이 팀 버너스리에 의해 탄생할 때, 주목한 문제는 인터넷으로 정보공유를 어떻게 잘 할 수 있을까에 대한 고민이었다.   
어떻게 인터넷에서 정보를 공유할 것인가?  
팀 : 정보들을 하이퍼텍스트로 연결한다.   
이를 표현하는 형식은 HTML, 정보들에 대한 식별자는 URI, 정보들을 전송하는 방법은 HTTP라는 프로토콜을 통해 이뤄졌다.  
<br>
이를 시작으로 HTTP 프로토콜을 설계하기 시작했다.  
<br>
## HTTP/1.0(1994-1996)  
&nbsp;94년부터 HTTP 설계자 중의 한 명이었던 Roy T.Fielding이라는 분은 이런 고민이 있었다.  
HTTP/1.0 명세가 나오기 전부터 HTTP는 이미 WWW의 프로토콜로서 사용이 되고 있었다.  
WEB은 급속도로 성장 중이었다. 이 시점에서 그는 HTTP를 정립하고, 기능을 더하고, 기존의 기능을 고쳐야 할 상황에 놓였다.  
만약 그가 기존의 HTTP를 고치게 된다면 기존에 HTTP를 사용하던 여러 웹들과 호환성 문제가 생길 수 있었다.  
그래서 그는 고민했다. '어떻게 하면 기존의 웹을 망가뜨리지 않으면서 HTTP를 진보시킬 수 있을까?'. 이에 대한 해답으로 HTTP Object Model을 만든다.(이것은 4년 후에 rest로 발표되게 된다.)  
<br>
## REST(1998) - Roy T. Fielding이 Microsoft Research에서 발표  
- "Representational State Transfer: An Architectural Style for Distributed Hypermedia Interaction"  
## REST(2000) - 박사논문으로 발표  
- "Architectural Styles and the Design of Network-based Software Architectures"  
<br><br>

## 웹상에서 사용되던 API라는 게 만들어졌다.  
&nbsp;98년에 MS가 XML-RPC(1998)라는 프로토콜을 만들었다. 이것은 원격으로 다른 시스템의 메서드를 호출할 수 있게 해줬다.  
훗날 이것은 SOAP으로 명칭이 바뀌게 된다.   
&nbsp;2000년 2월 Salesforce라는 회사에서 API를 공개하는데, 인터넷에서 공개된 거의 최초의 API였다. 당시에 SOAP을 사용하여 API를 만들었다.   
이것은 아이디로 오브젝트 하나의 정보를 가져오는 정도의 기능이었던 것에 비해 좀 복잡했다.  
4년 뒤에 flikr라는 회사에서 API를 만들었는데, SOAP으로도 만들었고 REST로도 만들었다. SOAP에 비해서 REST가 코드가 짧고 간단해 보이는 느낌이 든다.  
결국 SOAP의 인기는 갈수록 추락했고, REST의 인기는 갈수록 높아져갔다.    
2006년에는 AWS가 자사 API의 사용량의 85%가 REST임을 밝혔고, 2010년에는 Salesforce.com조차도 REST API를 추가했습니다.   
REST의 승리로 끝난 것 같았습니다.   
<br>
## 그러나.  
<br>
&nbsp;2008년에 CMS를 위한 표준으로 CMIS가 나왔고 EMC, IBM, MS 등의 큰 기업이 참여했다. <br>  
CMIS에는 REST 바인딩을 지원했다. 그러나 이를 살펴본 Roy Fielding은 "No REST in CMIS(CMIS에 rest는 없다.)"고 말했다고 합니다.  
&nbsp;2016년에는 Microsoft가 REST API 가이드라인을 발표했다.   
- uri는 https://{serviceRoot, 도메인네임의 개념}/{collection}/{id}형식이어야 한다.  
- GET, PUT, DELETE, POST, HEAD, PATCH, OPTIONS를 지원해야 한다.  
- API 버저닝은 Major, minor로 하고 uri에 버전 정보를 포함시킨다
- 등등..
<br>
&nbsp;사람들이 보기에는 합리적이고 좋은 REST API로 보였다. 흔히 우리가 알고있는 좋은 REST API에 부합해 보였다.  
그러나 Roy좌께서는 트위터를 통해 "s/REST API/HTTP API/ (이것도 REST API가 아니다. 이것은 HTTP API라고 불러야 한다.)"라고 적었고,  
블로그에는 "REST APIs must be hypertext-driven(rest api는 반드시 hypertext-driven이어야 한다.)", "REST API를 위한 최고의 버저닝 전략은 버저닝을 안 하는 것"이라고 적었다.  
Roy Fielding이 생각하는 REST API와 일반 사람들이 생각하는 REST API가 너무나 달랐다.  
<br>  
## 무엇이 문제일까요?   REST API가 뭐길래?  
- REST API : REST 아키텍쳐 스타일을 따르는 API 
<br>
REST는 분산 하이퍼미디어 시스템(예: 웹)을 위한 아키텍쳐 스타일이라고 합니다. (출처 : Roy Fielding의 박사논문)  
<br>
아키텍쳐 스타일은 뭘까?    
아키텍쳐 스타일은 제약조건들의 집합이다. 이는 곧 제약조건들을 모두 지켜야 REST를 따른다고 말할 수 있는 것이다.   
  
## REST는 어떤 스타일(제약조건)을 가지고 있는가?  
&nbsp;사실 REST는 아키텍쳐 스타일이면서 하이브리드 아키텍쳐 스타일이라고 말한다. 그 이유는 아키텍쳐 스타일인데 동시에 아키텍쳐 스타일의 집합이기 때문이다.
그래서 여섯가지의 아키텍쳐 스타일로 구성되어 있다.   
- client-server
- stateless
- cache
- uniform interface : 잘 만족시키기 어려운 조건이다.  
- layered system
- code-on-demand(optional) 
    - server에서 코드를 client로 보내서 실행할 수 있어야 한다는 조건. 
    - 예로 javascript가 있다.
<br>
&nbsp;HTTP만 잘 따르더라도 client-server, stateless, cache, layered system 정도는 잘 지킬 수 있다.  
하지만, uniform interface은 만족시키기가 쉽지 않았다.  
<br>
uniform interface 제약조건은 무엇이길래?  
4가지 제약조건으로 이뤄져 있다.   
- identification of resource : 리소스가 uri로 식별돼야하는 조건
- manipulation of resource through representations : 리소스를 만들거나 업데이트 하거나 삭제할 때, http 메세지에 그 표현을 담아 전송해야 한다는 조건
- self-descriptive messages
- Hypermedia as the engine of application state(HATEOAS)
<br>
identification of resource와 manipulation of resource through representations 제약조건은 비교적 잘 지켜진다.   
하지만 self-descriptive messages와 Hypermedia as the engine of application state(HATEOAS)의 경우는 잘 지켜지지 않았다.  
요즘 흔히 말하는 REST API의 대부분은 이 두가지를 지키지 못하고 있다. 
하나씩 살펴보면,

## self-descriptive messages

