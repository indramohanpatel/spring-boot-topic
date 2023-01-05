package io.acts.chennai.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
//	@RequestMapping("/topicJson")
//	public List<Topic> getAllTopicsJson(){
//		return Arrays.asList(
//				new Topic("Spring","Spring Framework","Spring Framework Description"),
//				new Topic("java","Core Java","Core java Description"),
//				new Topic("html","html tag","html Description")
//				);
//	}
	
	
	@RequestMapping("/topic")
	public List<Topic> getAllTopics(){
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topic/{id}")
	public Optional<Topic> getAllTopics(@PathVariable("id") String id){
		return topicService.getAllTopics(id);
	}
	
//	@RequestMapping(method=RequestMethod.POST,value="/topics")
//	OR
//	@PostMapping("/topic")
	
	@PostMapping("/topic")
	public void addTopic(@RequestBody Topic topic){
//		System.out.println(topic);
		topicService.addTopic(topic);
	}
	
	@PutMapping("/topic/{id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable("id") String id){
		topicService.updateTopic(topic,id);
	}
	
	@DeleteMapping("/topic/{id}")
	public void deleteTopic(@PathVariable("id") String id)
	{
		 topicService.deleteTopic(id);
	}
	
	@RequestMapping("/topic/name/{name}")
	public List<Topic> findByName(@PathVariable("name") String name){
		return topicService.findByName(name);
	}
	
	@RequestMapping("/topic/description/{description}")
	public List<Topic> findByDescription(@PathVariable("description") String description){
		return topicService.findByDescription(description);
	}
	
	@RequestMapping("/topic/nameLike/{name}")
	public List<Topic> findByNameLike(@PathVariable("name") String name){
		return topicService.findByNameLike(name);
	}
	
}
