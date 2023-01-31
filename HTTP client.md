---
description: HTTP client의 개념과 간단한 구현을 해보았습니다.
---

# HTTP client

## TCP/IP 통신
- 인터넷 프로토콜 스위트 중의 하나로서 가장 많이 사용되는 통신방법이다.
    - [https://ko.wikipedia.org/wiki/%EC%9D%B8%ED%84%B0%EB%84%B7_%ED%94%84%EB%A1%9C%ED%86%A0%EC%BD%9C_%EC%8A%A4%EC%9C%84%ED%8A%B8](https://ko.wikipedia.org/wiki/%EC%9D%B8%ED%84%B0%EB%84%B7_%ED%94%84%EB%A1%9C%ED%86%A0%EC%BD%9C_%EC%8A%A4%EC%9C%84%ED%8A%B8)
    - 인터넷 프로토콜 스위트(영어: Internet Protocol Suite)는 인터넷에서 컴퓨터들이 서로 정보를 주고받는 데 쓰이는 통신규약(프로토콜)의 모음이다. 인터넷 프로토콜 슈트 중 TCP와 IP가 가장 많이 쓰이기 때문에 TCP/IP 프로토콜 슈트라고도 불린다.
- TCP/IP에서 TCP는 TCP프로토콜을 의미하진 않는다. 

## TCP와 UDP
- TCP
    - 연결이 필요하다.
    - 전달성공 여부 및 순서가 보장된다. (전화, 등기우편)
    - 데이터 유실 가능성이 낮다.
- UDP
    - 연결이 필요하지 않고 데이터를 보낸다. 
    - 전달성공 여부와 순서를 보장하지 않는다. (편지)   
    - 데이터 유실 가능성이 비교적 높다.
    - 최근에는 UDP를 활용하여 전달여부와 순서를 보장하는 방법도 사용한다고 한다. (QUIC)

## Socket과 Socket API 구분
- Socket 

- Socket API
## URI와 URL
## 호스트(host)
  - IP 주소
  - Domain name
  - DNS
## 포트(port)
## path(경로)
## Java text blocks
## Java InputStream과 OutputStream
## Java try-with-resources
