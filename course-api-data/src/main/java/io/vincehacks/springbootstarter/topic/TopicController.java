// Created by Vince Chang

package io.vincehacks.springbootstarter.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// Created by Vince Chang

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

  @Autowired
  private TopicService topicService;

  // Get request to get all topics
  @RequestMapping("/topics")
  public List<Topic> getAllTopics() {
    return topicService.getAllTopics();
  }

  // Get request to see a specific topic
  @RequestMapping("/topics/{id}")
  public Optional<Topic> getTopic(@PathVariable String id) {
    return topicService.getTopic(id);
  }

  // Post request to add a topic
  @RequestMapping(method = RequestMethod.POST, value = "/topics")
  public void addTopic(@RequestBody Topic topic) {
    topicService.addTopic(topic);
  }

  // Put request to update a topic
  @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
  public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
    topicService.updateTopic(topic, id);
  }

  // Delete request to delete a topic
  @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
  public void deleteTopic(@PathVariable String id) {
    topicService.deleteTopic(id);
  }
}
