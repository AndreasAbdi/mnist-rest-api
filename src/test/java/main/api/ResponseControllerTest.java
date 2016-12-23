package main.api;

import main.brain.MnistLogicService;
import main.datatypes.Image;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.multipart.MultipartFile;

/**
 * //TODO: Fill this in.
 */
@RunWith(MockitoJUnitRunner.class)
public class ResponseControllerTest {

    @Mock
    MultipartFile mockMultipartFile;

    @Mock
    MnistLogicService mockMnistLogicService;

    ResponseController responseController;

    @Before
    public void setup() {
        responseController = new ResponseController(mockMnistLogicService);
    }

    @Test
    public void shouldBeAbleToHandleNullImage() {
        responseController.predict(null);

        Mockito.verify(mockMnistLogicService, Mockito.never()).checkCharacterInImage(Mockito.any(Image.class));
    }

    @Test
    public void shouldBeAbleToHandleEmptyImage() {
        responseController.predict(mockMultipartFile);

        Mockito.verify(mockMnistLogicService, Mockito.never()).checkCharacterInImage(Mockito.any(Image.class));
    }

    // TODO
    @Test
    public void shouldBeAbleToHandleRealImage() {

        responseController.predict(mockMultipartFile);
    }
}
