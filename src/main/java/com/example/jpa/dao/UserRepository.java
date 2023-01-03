package com.example.jpa.dao;
import com.example.jpa.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    //默认提供了Optional<User> findById(Long id);

    User findByName(String name);

    @Query("select u from User u where u.id <= ?1")
    Page<User> findMore(Long maxId, Pageable pageable);

    @Modifying//修改
    @Transactional//回滚
    @Query("update User u set u.name = ?1 where u.id = ?2")
    int updateById(String name, Long id);


}