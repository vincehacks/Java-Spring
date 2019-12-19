// Created by Vince Chang

package io.vincehacks.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	List<Topic> list = new ArrayList<>(Arrays.asList(
			new Topic("spring","Spring Framework","Spring Framework Description"),
			new Topic("java","Core Java","Core Java Description"),
			new Topic("javascript","JavaScript","JavaScript Description")			
				
		));
	
	List<Topic> getAllTopics(){
		return list;
	}
	
	Topic getTopic(String id) {
		//return list.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		for(Topic t : list) {
			if(t.getId().equals(id)) {
				return t;
			}
		}
		
		return new Topic();
	}
	
	void addTopic(Topic topic) {
		list.add(topic);
	}

	public void updateTopic(Topic topic, String id) {
		for(int i = 0; i < list.size(); i++) {
		  if(list.get(i).getId().equals(id)) {
			list.set(i, topic);
			return;
		  }
		}

	}

	public void deleteTopic(String id) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				list.remove(i);
				return;
			}
		}
	}
}
