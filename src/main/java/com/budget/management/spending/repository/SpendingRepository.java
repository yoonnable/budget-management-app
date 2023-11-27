package com.budget.management.spending.repository;

import com.budget.management.spending.entity.Spending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpendingRepository extends JpaRepository<Spending, Long> {
    @Query(value = """
            SELECT s.*,
            c.name
            FROM spending s
            LEFT JOIN category c
            ON s.category_id = c.id
            WHERE s.date >= :startDt
            AND s.date <= :endDt
            AND money >= :min
            AND money <= :max
            AND category_id = :categoryId
            """, nativeQuery = true)
    List<Spending> findByCategoryId(@Param("startDt") String startDt
                                  , @Param("endDt") String endDt
                                  , @Param("min") int min
                                  , @Param("max") int max
                                  , @Param("categoryId") long categoryId);

    @Query(value = """
            SELECT s.*,
            c.name
            FROM spending s
            LEFT JOIN category c
            ON s.category_id = c.id
            WHERE s.date >= :startDt
            AND s.date <= :endDt
            AND money >= :min
            AND money <= :max
            """, nativeQuery = true)
    List<Spending> findByBasic(@Param("startDt") String startDt
            , @Param("endDt") String endDt
            , @Param("min") int min
            , @Param("max") int max);
}
