
# 1. Controller

## Annotation

### 1. @Controller
- 예시 소스코드 : MainController
- 일반적인 Spring MVC 컨트롤러
- 주로 view 를 반환하기 위하여 사용됨

#### View 반환
1. Client 에서 URI 형식으로 요청
2. DispatcherServlet 에서 요청을 처리할 대상 조회
3. HandlerAdapter 를 통해 요청을 Controller 로 위임
4. Controller 에서 서비스로직 실행 후 **view** 반환
5. DispatcherServlet 은 ViewResolver 를 통해 View 를 찾아 반환

#### View + Data 반환
1. Client 에서 URI 형식으로 요청
2. DispatcherServlet 에서 요청을 처리할 대상 조회
3. HandlerAdapter 를 통해 요청을 Controller 로 위임
4. Controller 에서 서비스로직 실행 후 **view** 와 **Data** 를 함께 반환

### 2. @RestController
- 예시 소스코드 : MainRestController
- RestFul 웹서비스의 컨트롤러
- @Controller + @RequestBody 의 기능을 한다
- ResponseEntity 형식으로 return
  - HttpStatus, data 를 Json 객체로 반환

1. Client 에서 URI 형식으로 요청
2. DispatcherServlet 이 요청을 처리
3. HandlerAdapter 를 통해 요청을 Controller로 위임
4. Controller 에서 서비스로직 실행 후 **객체** 반환
5. 반환 시 Json 으로 Serialize 되어 Client 로 반환

### 3. @RequestMapping
- 예시 소스코드 : MainController, MainRestController
- Client 에서 요청한 RI와 Controller 의 Method 매핑을 설정하는 어노테이션
- @RequestMapping GET == GetMapping
- 단독으로 사용되기보단 prefix 개념으로 class 전체 어노테이션으로 사용되는 경우가 많음

- 아래 소스코드는 동일함
  ```java
  @RequestMapping(value = "/main", method = RequestMethod.GET)
  public String index() {
      return "";
  }    
  
  @GetMapping(value = "/main")
  public String index2() {
      return "";
  }
  ```

# 2. Utils

## 용도

#### 1. ApiResponseEntity
- ResponseEntity 커스텀 객체
- Controller 에서 데이터 반환 시 Pagination, list, map, String, HttpStatus 등 다양한 데이터를 반환하기 위하여 사용되는 공통 객체
