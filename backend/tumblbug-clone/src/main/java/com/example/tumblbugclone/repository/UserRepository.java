package com.example.tumblbugclone.repository;

import com.example.tumblbugclone.Exception.userexception.*;
import com.example.tumblbugclone.model.dao.UserDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    /*
    * Refactoring :
    *   1. EntityManager em 사용
    *   2. 반환 객체 수정  User -> UserDAO
    *   3. 사용하지 않는 메서드 삭제
    *       - public void unregister(long userIdx)
    *           -> modify()와 같은 값 수정이므로 service에서 해당 기능 분리
    *       - private boolean isDuplicatedId(String userId), private boolean isDuplicatedEmail(String userEmail)
    *           -> DB에서 Exception을 발생시켜 주기 때문에 구현 필요성 X
    *       - public void clear()
    *           -> DB를 초기화 하는 함수는 구현이 힘들 뿐더러, 비즈니스 로직에서 거의 필요하지 않다.
    *           -> 추후 필요성이 생긴다면 다시 구현
    * */

    @PersistenceContext
    EntityManager em;

    public long save(UserDAO user) throws Exception{
        em.persist(user);
        return user.getUserIdx();
    }

    public UserDAO findUserByIdx(long idx) throws Exception{

        UserDAO findUser = em.find(UserDAO.class, idx);
        return findUser;
    }

    public long modify(UserDAO modifiedUser) throws Exception {

        UserDAO resultUser = em.merge(modifiedUser);
        return resultUser.getUserIdx();
    }


    //== 리팩토링 완료 ==//
}