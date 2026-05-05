package com.travelagent.api.repository;

import com.travelagent.api.domain.SearchCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SearchCriteriaRepository extends JpaRepository<SearchCriteria, Long> {
    List<SearchCriteria> findByUserIdAndActiveTrue(String userId);
    List<SearchCriteria> findByActiveTrue();
}
