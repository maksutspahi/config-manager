package com.ty.configmanager.repository;

import com.ty.configmanager.model.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepository extends MongoRepository<Configuration, String> {
}
