package com.eugene.Alcoholic_Library.repository;

import com.eugene.Alcoholic_Library.model.categories.Cognac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CognacRepo extends JpaRepository<Cognac, Long> {
}
