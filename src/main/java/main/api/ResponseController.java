package main.api;

import hello.Greeting;
import main.brain.MnistLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.atomic.AtomicLong;

/**
 * //TODO: Fill this in.
 */
@RestController
public class ResponseController {
    private static final String template = "The neural network predicted your character as: $s";
    private final AtomicLong counter = new AtomicLong();
    private static MnistLogicService mnistLogicService;

    @Autowired
    ResponseController(MnistLogicService mnistLogicService) {
        this.mnistLogicService = mnistLogicService;
    }

    @RequestMapping(value = "/mnist", method = RequestMethod.POST, produces = "application/json")
    public Response predict(@RequestParam(value = "file", defaultValue = "") MultipartFile file) {
        return null;
    }
}
