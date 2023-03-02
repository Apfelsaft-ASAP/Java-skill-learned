package com.sparta.hanghaeboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HanghaeBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HanghaeBoardApplication.class, args);
    }

}

//
//1. 수정, 삭제 API의 request를 어떤 방식으로 사용하셨나요? (param, query, body)
// 수정에서는 @PathVariable을 사용하여 id값을 가져오고, @Requestbody를 사용하여 수정된 내용을 body에 담아 전송한다.
// 삭제에서는 @PathVariable을 사용하여 id값을 가져오고, @RequestParam을 사용하여 비밀번호를 query로 담아 전송한다.
//
//2. 어떤 상황에 어떤 방식의 request를 써야하나요?
//Path parameter: URL 경로에서 값을 추출할 때 사용하는 방식.
//예) /api/users/{userId}
//Query parameter: URL의 쿼리스트링에 값을 전달할 때 사용하는 방식.
//예) /api/users?userId=1
//Request body: 요청 데이터를 보낼 때 사용하는 방식.
//주로 POST, PUT, PATCH 메소드에서 사용합니다.
//URL 경로에 필수적인 값을 전달할 경우에는 Path parameter를 사용하고,
//선택적인 값을 전달할 경우에는 Query parameter를 사용합니다.
//Request body는 복잡한 구조의 데이터를 전송할 때 사용합니다.
//
//3. RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?
//   @GetMapping, @PostMapping, @PutMapping, @DeletsMapping을
//   사용하여 구현하였다.
//
//4. 적절한 관심사 분리를 적용하였나요? (Controller, Repository, Service)
//   Contolller에서는 request를 처리하고
//   Service에서는 비즈니스 로직을 처리하고,
//   Repository에서는 데이터베이스 처리를 하고있다.
//
//5. API 명세서 작성 가이드라인을 검색하여 직접 작성한 API 명세서와 비교해보세요!
//삭제 기능 완료시 success 구현을 못하는중,,,
