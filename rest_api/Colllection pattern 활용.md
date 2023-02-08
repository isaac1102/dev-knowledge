# Colllection pattern의 적용

## CRUD
데이터에 대해 취하는 모든 기능은 다음 4개로 정리 가능하다.
- Create : 게시글 생성
- Read : 게시글 조회
- Update : 게시글 수정
- Delete : 게시물 삭제



## CQS
데이터의 상태를 변화시키는가에 따라서 Command 와 Query를 separate한 개념이다. 
CUD는 데이터 자체를 조작하기 때문에 상태를 보장하지 못한다. 데이터가 중복될 수도 있고, 삭제되거나 손상될 수도 있다. 
하지만 Read의 경우에는 아무리 호출하더라도 데이터가 보장된다. (멱등성?) 이러한 안정성 때문에 분산에 용이하고 캐시를 통해 응답속도 향상에 유리하다.


## HTTP Method with Collection Pattern
HTTP method는 총 9개의 method가 있다. (GET / POST / PUT / PATCH / DELETE / OPTIONS / HEAD / CONNECT / TRACE)
rest api에서 Collection Pattern과 함께 주로 사용하는 method는 4개이다.
아래와 같이 정리할 수 있다.
   
|HTTP|용도|path|설명|
|----|----|----|---|
|GET|READ|/posts|게시물 목록(Collection), 보통 List형태이다.|
|GET|READ|/posts{id}|게시물 상세(Element)|    
|POST|Create|/posts|게시물 생성, Post Id는 서버에서 생성한다.|
|PUT / PATCH|Update|/posts/{id}|게시물 수정 (Element)|
|DELETE|Delete|/posts/{id}|게시글 삭제(Element)|

comment의 경우 직접적으로 comment에 접근하는 path를 사용할 수도 있다. 
GET /comments
GET /comments?post_id={post_id}
GET /comments/{id}
POST /comments (postId를 어떻게든 담아 줘야 한다.)
POST /comments?post_id={post_id}
PUST or PATCH /comments{id}
DELETE /comments/{id}


post와 comment의 관계는 일반적으로 comment가 있으려면 post의 존재가 선행돼야하기 때문에 
comment는 post의 하위요소로 볼 수도 있다. 
|method|path|설명|
|--|--|--|
|GET| /posts/{post_id}/comments|   특정 게시글의 댓글목록|
|GET| /posts/{post_id}/comments/{id}|  특정 댓글 |
|POST| /posts/{post_id}/comments|  특정 게시글에 대한 댓글 생성|
|PUT or PATCH| /posts/{post_id}/comments/{id}| 특정 게시글의 특정 댓글에 대한 수정|
|DELETE| /posts/{post_id}/comments/{id}|       특정 게시글의 특정댓글을 삭제|
