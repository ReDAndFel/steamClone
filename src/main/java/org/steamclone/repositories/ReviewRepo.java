package org.steamclone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ReviewRepo extends JpaRepository<ReviewRepo, Integer> {
}
