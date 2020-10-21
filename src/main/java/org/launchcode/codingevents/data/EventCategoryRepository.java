package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.EventCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository  //ORM is implementing this interface behind the scenes creating object
public interface EventCategoryRepository extends CrudRepository<EventCategory, Integer> {  //integer represents primary key
//if all you want is basic inserts and updates leave this blank,
    //if you need a specific query you can write it here
}
