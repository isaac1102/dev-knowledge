## ORM
Object-Relational Mapping의 줄임말이다. 객체-관계형-매핑(연결) 정도로 직역할 수 있겠다. ORM은 어플리케이션과 관계형 데이터 베이스를 연결하는 역할을 한다. ORM을 사용하면 객체를 통해 데이터를 조회하거나 조작할 수 있고, SQL을 사용하지 않을 수 있다. 대부분의 ORM은 여러 데이터를 지원하며 비교적 적은 노력으로 DB를 전환할 수 있도록 지원한다. 그리고 개발자는 기본적인 DB정보를 제공함으로 DB의 연결을 ORM에게 맡길 수 있다. 

아무래도 가장 큰 장점은 데이터를 객체지향적으로 접근할 수 있다는 점이다. SQL문을 작성하여 데이터를 다루려면 application 차원과 DB차원의 사고방식을 오가며 작업해야 하지만 application 관점(객체지향)을 유지하며 개발할 수 있다는 것이 큰 장점이다. 

물론 ORM이 마법의 도구는 아니기 때문에 단점도 있다. 복잡하고 규모가 큰 쿼리의 경우에는 ORM을 통하게 되면 성능적으로 손해를 볼 수 있다. ORM을 통해 SQL을 생성하는 것이기 때문에 직접 SQL을 세세하게 작성하는 것에 비해서 효율적이지 않을 수도 있다. 

## JPA(Jakarta Persistence API)
Jakarta(Oracle이 java에 대한 소유권을 가지게 되면서 Jakarta로 변경되었다.) Persistence API의 줄임말이다.
ORM 중의 하나로 Java를 통해서 RDB 데이터를 관리하는 기술이다. ORM의 장점 중의 하나인 RDB와 OOP간의 패러다임 불일치를 해소할 수 있게 해준다.
JPA는 

## Jakarta EE
## Entity