package io.acts.chennai.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Optional<Topic> getAllTopics(String id){
		return topicRepository.findById(id);
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, String id) {
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}

	public List<Topic> findByName(String name) {
		return topicRepository.findByName(name);
	}

	public List<Topic> findByDescription(String description) {
		return topicRepository.findByDescription(description);
	}
	
	public List<Topic> findByNameLike(String name) {
		return topicRepository.findByNameLike(name);
	}
	
}
