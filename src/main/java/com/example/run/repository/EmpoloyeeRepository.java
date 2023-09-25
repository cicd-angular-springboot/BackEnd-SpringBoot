package com.example.run.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.run.model.Employee;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface EmpoloyeeRepository extends JpaRepository<Employee, Long>{

}
