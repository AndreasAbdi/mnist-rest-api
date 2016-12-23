package main.brain;

import main.brain.converters.ImageToDl4JConverter;
import main.brain.neuralnetworks.MnistNeuralNetwork;
import main.datatypes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * //TODO: Fill this in.
 */
@Service
public class MnistLogicService {

    MnistNeuralNetwork neuralNetwork;
    ImageToDl4JConverter converter;

    @Autowired
    MnistLogicService(MnistNeuralNetwork neuralNetwork, ImageToDl4JConverter converter) {
        this.neuralNetwork = neuralNetwork;
        this.converter = converter;
    }

    //TODO: predict in the neural network
    public char checkCharacterInImage(Image image) {
        return 'a';
    }

    //TODO: train some data into the model
    public void train(Image image, char actual) {
    }
}
