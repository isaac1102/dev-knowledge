## Database
- 구조화된 정보 or 데이터의 조직화된 모음(organized collection of data stored and accessed)
## DBMS(Database Management System)
- 데이터베이스를 관리하는 시스템이다.
- 데이터를 효율적으로 조작하고 찾기 쉽게 해주는 시스템이다. 
- DDL, DML, DCL 언어를 제공한다.
## RDBMS(Relational Database Management System)
- 관계형 데이터베이스 관리 시스템이다.
- MySQL, MariaDB, PostgreSQL, MS SQL Server, Oracle 등
## 데이터베이스 언어
- DDL (Data Definition Language) -> Schema
- DML (Data Manipulation Language) -> Query & Command
- DCL (Data Control Language) -> Grant, Revoke, Commit, Rollback
## SQL
- 1970년대 만들어진 SEQUEL이 이름을 바꾼 것이다.
- SQL을 Structured Query Language의 약어라고 소개하는 사람도 있다. 
## 데이터 모델(Data Model)
- 데이터의 요소를 구성하고, 그 요소 간의 관계를 및 실제 엔티티의 속성과의 관계를 표준화하는 추상모델이다. (몬말이지?)
- 표현하고자 하는 특정 대상을 나타내는 속성을 나타내고 구성하는 추상화된 모델이라고 생각한다.
1. Conceptual Data Model
    - 비즈니스 요구사항을 반영한 개념적인 모델이다. 
    - 비즈니스 프로세스에 관련된 주요 엔티티와 관계성을 나타낸다. 
    - 엔티티의 특성과 속성만 포함하고 구체적인 테이블 구조나 키의 정의는 고려하지 않는다. 
    - 주로 설계 초기 단계에서 중요한 역할을 한다. 
2. Logical Data Model
    - Conceptual Data Model에 기반하여 구체적인 테이블 정보와 열, 제약조건, 관계 등의 논리구조를 정의한 모델이다.
3. Physical Data Model
    - 데이터베이스 디자인의 최종단계에 해당하는 모델이다.
    - 데이터를 저장하고 검색하기 위한 물리적 구조이다.
    - 데이터 구조, 저장장치, 접근방식 등을 명세한다.
    - 테이블의 물리적 저장 위치, 인덱스 생성, 파티셔닝, 클러스터링, 레플리케이션 등의 고려사항이 있다.
    - 데이터베이스 디자인의 최종 결과물이다. 
## 튜플
- 튜플은 릴레이션의 행(row)를 나타낸다고 볼 수 있다. 


## Relation
- Relation은 튜플의 집합이다.
- 릴레이션은 테이블이라고 생각하면 된다. 릴레이션과 테이블은 개념적으로는 동일하지만 릴레이션은 관계형 데이터베이스에서 데이터를 구성하는 기본적인 단위 중 하나이고, 속성과 튜플로 구성된다. 반면에 테이블은 데이터를 저장하는 방식 중 하나이며 열과 행으로 구성된다.  