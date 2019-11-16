package com.javafullstacktraining.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/publish")
public class Sender {

  @Value("${spring.jms.template.default-destination}")
  private String topicDestination;

  private static final Logger LOGGER =
      LoggerFactory.getLogger(Sender.class);

  @Autowired
  private JmsTemplate jmsTemplate;

  @GetMapping("/{message}")
  public String send(@PathVariable String message) {
    LOGGER.info("sending message='{}' to destination='{}'", message,
        topicDestination);
    jmsTemplate.convertAndSend(topicDestination, message);
    return "Published message to Topic successfully.";
  }
}
