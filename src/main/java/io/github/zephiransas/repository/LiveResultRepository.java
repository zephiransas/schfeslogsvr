package io.github.zephiransas.repository;

import io.github.zephiransas.model.LiveResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LiveResultRepository extends JpaRepository<LiveResult, Integer> {
    List<LiveResult> findAllByOrderByCreatedAtDesc();
}
