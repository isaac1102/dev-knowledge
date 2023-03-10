## JdbcTemplate
- jdbcTemplate은 스프링 프레임워크에서 제공하는 JDBC 추상화 라이브러리이다. 
- jdbcTemplate은 sql문을 실행한 결과를 반환할 때 자바 객체로 변환하여 반환해 준다. 이런 반환작업을 개발자가 직접할 필요가 없다는 것은 큰 장점이다.
- sql injection을 방지하기 위해 preparedStatement를 사용할 수 있다. 
- jdbc도 자바에서 데이터베이스를 쉽게 연결하도록 추상화해주는 역할을 했지만, 그럼에도 복잡성과 반복적인 코드들이 있을 수밖에 없었다. jdbcTemplate은 이러한 작업 간에 코드를 간결하게 해준다. 