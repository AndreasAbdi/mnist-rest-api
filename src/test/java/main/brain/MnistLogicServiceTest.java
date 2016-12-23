package main.brain;

import main.brain.converters.ImageToDl4JConverter;
import main.brain.neuralnetworks.MnistNeuralNetwork;
import main.datatypes.Image;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * //TODO: Fill this in.
 */
@RunWith(MockitoJUnitRunner.class)
public class MnistLogicServiceTest {

    @Mock
    MnistNeuralNetwork mockMnistNeuralNetwork;

    @Mock
    ImageToDl4JConverter mockConverter;

    @Mock
    Image image;


    MnistLogicService mnistLogicService;

    @Before
    public void setup() {
        mnistLogicService = new MnistLogicService(mockMnistNeuralNetwork, mockConverter);
    }

    @Test
    public void shouldBeAbleToHandleInput() {
        mnistLogicService.checkCharacterInImage(image);
        Mockito.verify(mockMnistNeuralNetwork).predict(Mockito.any());
    }


    @Test
    public void shouldBeAbleToParseAndCallTraining() {
        char targetResult = 'a';
        mnistLogicService.train(image, targetResult);
        Mockito.verify(mockMnistNeuralNetwork).evaluate(Mockito.any());
    }


}
