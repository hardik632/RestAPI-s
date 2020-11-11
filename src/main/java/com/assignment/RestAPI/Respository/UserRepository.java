package com.assignment.RestAPI.Respository;

import com.assignment.RestAPI.Model.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
}
