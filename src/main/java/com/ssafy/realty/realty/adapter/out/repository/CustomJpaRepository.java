package com.ssafy.realty.realty.adapter.out.repository;

import com.ssafy.realty.realty.adapter.out.entity.CustomJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomJpaRepository extends JpaRepository<CustomJpaEntity, Long> {


    @Query(value = "select count(*) from customs where users_id = :userId and is_tmp = 'true'", nativeQuery = true)
    Integer countByUserIdAndIsTmpTrue(Long userId);

    @Query("select c from CustomJpaEntity  c where c.user.id = :userId")
    CustomJpaEntity findByUserId(Long userId);
}
