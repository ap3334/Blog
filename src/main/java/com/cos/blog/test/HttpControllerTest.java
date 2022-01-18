package com.cos.blog.test;

import org.springframework.web.bind.annotation.*;

/**
 * RestController : 사용자가 요청 -> Data를 응답
 * Controller : 사용자가 요청 -> HTML 파일 응답
 */

@RestController
public class HttpControllerTest {

    private static  final String TAG = "HttpControllerTest : ";

    @GetMapping("/http/lombok")
    public String lombokTest() {

//        Member m = new Member(1, "ssar", "1234", "email");
        Member m = Member.builder().userName("ssar").password("1234").email("ssar@nate.com").build();

        /*System.out.println(TAG + "getter : " + m.getId());
        m.setId(5000);
        System.out.println(TAG + "setter : "  + m.getId());*/

        System.out.println(TAG + "getter : " + m.getUserName());
        m.setUserName("cos");
        System.out.println(TAG + "setter : "  + m.getUserName());

        return "lombok test 완료";
    }

    // 인터넷 브라우저 요청은 무조건 get 요청밖에 할 수 없음
    // http://localhost:8080/http/get (select)
    @GetMapping("/http/get")
    public String getTest(Member m) {

        return "get 요청 : " + m.getId() + ", " + m.getUserName() + ", " + m.getPassword() + ", " + m.getEmail();

    }

    // http://localhost:8080/http/post (insert)
    @PostMapping("/http/post")
    public String postTest(@RequestBody  Member m) {

        return "post 요청 : " + m.getId() + ", " + m.getUserName() + ", " + m.getPassword() + ", " + m.getEmail();

    }

    // http://localhost:8080/http/put (update)
    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m) {

        return "put 요청 : " + m.getId() + ", " + m.getUserName() + ", " + m.getPassword() + ", " + m.getEmail();

    }

    // http://localhost:8080/http/delete (delete)
    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }
}
