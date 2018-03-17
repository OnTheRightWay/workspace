package com.nys.dao;

import com.nys.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface PersonRepository extends JpaRepository<Person,Long>{

    /**
     * 将该方法，也暴露为REST资源
     * @param name
     * @return
     */
    @RestResource(path = "nameStartsWith",rel = "nameStartsWith")
    Person findByNameStartsWith(@Param("name") String name);
}
