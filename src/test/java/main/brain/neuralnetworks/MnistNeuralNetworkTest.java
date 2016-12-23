package main.brain.neuralnetworks;

import main.brain.neuralnetworks.MnistNeuralNetworkSingleLayer;
import main.datatypes.Image;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * //TODO: Fill this in.
 */
@RunWith(MockitoJUnitRunner.class)
public class MnistNeuralNetworkTest {


    MnistNeuralNetworkSingleLayer neuralNetwork;

    @Mock
    Image image;

    @Before
    public void setup() {
        neuralNetwork = new MnistNeuralNetworkSingleLayer();
    }

    @Test
    public void shouldBeAbleToHandleOnlineTraining1() {
    }

    @Test
    public void shouldBeAbleToHandleOnlineTraining2() {
    }

    @Test
    public void shouldAccuratelyPredictAlreadyTrainedData() {

    }
}
