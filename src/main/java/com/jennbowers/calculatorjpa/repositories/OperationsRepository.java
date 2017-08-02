package com.jennbowers.calculatorjpa.repositories;

import com.jennbowers.calculatorjpa.models.Operations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationsRepository extends CrudRepository<Operations, Long>{}
