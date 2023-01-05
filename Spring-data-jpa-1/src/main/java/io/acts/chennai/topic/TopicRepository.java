package io.acts.chennai.topic;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TopicRepository extends CrudRepository<Topic,String> {

	List<Topic> findByName(String name);
	List<Topic> findByDescription(String description);
	
	//JPA Query
	@Query("Select t from Topic t where t.name like %?1%")
	List<Topic> findByNameLike(String name);

	//OR
	
//	@Query("Select t from Topic t where t.name like %:name%")
//	List<Topic> findByNameLike(@Param("name")String name);
	
}
