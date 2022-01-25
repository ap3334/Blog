package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    @Autowired // 의존성 주입
    private UserRepository userRepository;

    @DeleteMapping("/dummy/user/{id}")
    public  String delete(@PathVariable int id) {

        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) { // Exception으로 걸어도 됨
            return "삭제에 실패하였습니다. 해당 id는 DB에 없습니다.";
        }

        return "삭제 되었습니다. id : " + id;
    }

    /**
     * save 함수는 id를 전달하지 않으면 insert를 하고,
     * id를 전달하면 해당 id에 대한 데이터가 있으면 update를 하고,
     * 해당 id에 대한 데이터가 없으면 insert를 함
     *
     */

    @Transactional // 함수 종료 시에 자동 commit이 됨
    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
        System.out.println("id = " + id);
        System.out.println(" password = " + requestUser.getPassword()) ;
        System.out.println(" email = " + requestUser.getEmail());

        User user = userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("수정에 실패하였습니다.");
        });

        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());

        // userRepository.save(user);


        return user;
    }

    @GetMapping("/dummy/users")
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<User> pagingUser = userRepository.findAll(pageable);
        return pagingUser.getContent();

    }

    /**
     * {id} 주소로 파라미터를 전달 받을 수 있음
     * http://localhost:8000/blog/dummy/user/3
     */
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id) {

        // 데이터가 없을 때 null이 return 하면 문제 발생할 수 있으므로 null인지 아닌지 판단해서 return
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 없습니다. id : " + id);
            }
        });
        return user;
    }

    @PostMapping("/dummy/join")
    public String join(User user) {

        System.out.println("id = " + user.getId());
        System.out.println("userName = " + user.getUserName());
        System.out.println("password = " + user.getPassword());
        System.out.println("email = " + user.getEmail());
        System.out.println("roll = " + user.getRole());
        System.out.println("createDate = " + user.getCreateDate());

        user.setRole(RoleType.USER);
        userRepository.save(user);

        return "회원가입이 완료되었습니다.";

    }
}
