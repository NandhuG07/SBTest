package com.example.emsFordSBFinalTest.repo;

import com.example.emsFordSBFinalTest.model.Ems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmsRepo extends JpaRepository<Ems,Long> {
}
