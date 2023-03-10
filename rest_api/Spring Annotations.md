# Spring's Annotations

## Composed Annotation
- Spring에서 제공하는 많은 주석은 자신의 코드에서 메타 주석으로 사용할 수 있습니다. 메타 주석은 다른 주석에 적용할 수 있는 주석입니다. 예를 들어 앞에서@Service 언급한 주석은 다음 예제 와 같이 로 메타 주석이 추가됩니다 .@Component
- Spring에서는 Annotation을 사용하여 
## @RequestMapping 
- request의 메서드에 매핑하기 위한 역할을 한다.
- 매핑을 공유하기 위해서 클래스 레벨에서 사용할 수도 있고, 조금더 좁은 범위에서 사용하도록 메서드 레벨에서 사용할 수도 있다. 
- Spring mvc는 composed annotations(annotation 조합이라고 이해하고 있다.)을 지원하는데, RequestMapping은 하위 annotation을 재선언하기 위해서도 사용된다. RequestMapping annotation을 사용하여 HTTP method별로 매핑되도록 생성한 annotation들은 아래와 같다. 
- @GetMapping
- @PostMapping
- @PatchMapping
- @DeleteMapping
- @PutMapping

- @PathVariable
- @RequestBody
- @ExceptionHandler
- @ResponseStatus