// Created by Vince Chang

package io.vincehacks.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
  @Autowired
  private TopicRepository topicRepository;
  
	List<Topic> list = new ArrayList<>(Arrays.asList(
			new Topic("spring","Spring Framework","Spring Framework Description"),
			new Topic("java","Core Java","Core Java Description"),
			new Topic("javascript","JavaScript","JavaScript Description")			
				
		));
	
	// Difference now is to use the methods from the CrudRepository interface
	List<Topic> getAllTopics(){
		//return list;
	  
	  List<Topic> list = new ArrayList<>();
	  topicRepository.findAll().forEach(list::add);
	  return list;
	  
//	  Iterable<Topic> itr = topicRepository.findAll();
//	  while(itr.iterator().hasNext()) {
//	    list.add((Topic)(itr.iterator().next()));
//	  }
//	  
//	  return list;
	}
	
	Optional<Topic> getTopic(String id) {	  
	  return topicRepository.findById(id);
	}
	
	void addTopic(Topic topic) {
	  topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, String id) {	  
	  topicRepository.save(topic);

	}

	public void deleteTopic(String id) {
	  topicRepository.deleteById(id);
	}
}
