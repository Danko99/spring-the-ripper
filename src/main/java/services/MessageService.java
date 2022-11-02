package services;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.logging.Logger;

@Service
public class MessageService implements Serializable {
    Logger logger = Logger.getLogger("MessageService.class");

    public void publishMessage(String message) {
        logger.info("Message: " + message);
    }
}
