# Rest API의 Collection Pattern

## Collection pattern
rest-api에서 리소스를 표현하는 데 있어서 중요한 패턴이다. 흔히 말하는 restful하다는 것을 가르는 요소 중의 하나로 COllection Pattern을 얼마나 준수하는가로 판단할 정도이다. Collection이라는 단어로 추정해보면 일단 무언가의 모음집이라는 의미로 볼 수 있는데 리소스들을 한 묶음으로 모아서 마치 디렉토리처럼 표현한다고 보면 이해하기 좋을 것 같다. 

 post라고 불리는 게시글들이 있다고 가정해보자. posts라는 복수형으로 표기한다면 게시글의 복수로 표현이 된다. /posts라고 적는다면 여러 post들을 지칭할 수 있다. 여기서 특정 post를 지칭하고자 한다면 /posts/{post의 id} 혹은 /posts/:id의 형식으로 표현할 수 있다.   

여기서 id라는 개념에 주의해야 한다. 위에서 언급한 id는 post의 id이지 resource의 id는 아니다. posts라는 폴더 내에서 post를 식별하는 id의 개념이지, 전체를 아우르며 resource를 식별하는 uri가 되지는 않는다는 의미이다. 다만 resource Id를 구성하는 요소 중의 하나로서 post id가 사용된다고 볼 수 있겠다. 

 예를 들어 보겠다.   
post라는 디렉토리가 있고, image라는 디렉토리가 있다. 각 디렉토리에는 10개 이상의 파일들이 각각 들어고, 순차적으로 증가하는 숫자값의 id를 각각 가지고 있다. 이 상황에서 /posts/1이라고 post id를 표현하고, /images/1이라고 image id를 표현한다고 하자. post id와 image id가 모두 같은 1이라는 값을 가지게 되지만, 이것은 각 디렉토리라는 범주 내에서 통용되는 id값이기 때문에 식별가능한 값으로서 사용된다. 위에서 지적한 resource id로 사용될 수 없는 이유가 여기에 있다. 각 디렉토리 내부에서만 유일값이기 때문에, resource id로는 식별자로서 사용할 수 없는 것이다. Collection pattern에서 사용되는 id값과 resource id는 그런 의미에서 구분되어야 하겠다.   

위에서 디렉토리로 비유한 그룹명은 대부분 복수형으로 사용된다.  
item들의 모음이기 때문에 items와 같은 복수형으로 사용하는 것이 옳다.   
따라서 /post/1보다는 /posts/1가 더 맥락상 적당하고, 배운티를 내기 좋다.   
  
특정 리소스를 나타내는 형식
```
/posts/{id}  : 특정 게시물
/posts/{id}/comments : 특정 게시물의 댓글들
/posts/{id}/comments/{comment_id} : 특성 게시물의 특정 댓글
```

물론 절대적으로 고정된 방식은 아닐 수 있다.    
/posts/{id}/comments의 경우, /comments?post_id={id}같이 쿼리를 사용하여 표현할 수도 있다.    

rest를 관통하는 철학 중의 하나가 uri를 통해 얼마나 자기서술적으로 resource를 드러내고 설명할 수 있느냐라고 생각한다. Collection pattern로 결국 resource의 관점에서 본다면 이해가 빠를 것 같다. 주의해야 할 점은, uri에 resource에 대한 표현이 아닌 동작이나 행위에 대해 서술하고 싶은 욕구를 참는 것이다. restful한 설계는 모든 동작이나 행위를 HTTP method를 통해서 드러내고, uri는 resource 위주로 표현하는 것이다. 




