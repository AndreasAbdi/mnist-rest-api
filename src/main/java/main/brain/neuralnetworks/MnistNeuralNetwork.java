package main.brain.neuralnetworks;

import main.datatypes.Image;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;

/**
 * //TODO: Fill this in.
 */
public interface MnistNeuralNetwork {
    char predict(INDArray image);
    void evaluate(DataSetIterator dataSetIterator);
}
