package com.starter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.starter.entity.Employee;

public interface AppRepository extends CrudRepository<Employee,Integer> {

}
