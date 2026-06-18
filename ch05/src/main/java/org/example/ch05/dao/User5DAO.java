package org.example.ch05.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.ch05.dto.User5DTO;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Mapper는 MyBatis API 호출 컴포넌트 선언
@Mapper
@Repository
public interface User5DAO {
    // 기본 CRUD 메서드
    public void insert(User5DTO dto);

    public User5DTO select(int seq);

    public List<User5DTO> selectAll();

    public void update(User5DTO dto);

    public void delete(int seq);

}
