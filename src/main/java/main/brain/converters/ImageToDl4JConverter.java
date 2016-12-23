package main.brain.converters;

import main.datatypes.Image;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;

/**
 * //TODO: Fill this in.
 */
public interface ImageToDl4JConverter {
    INDArray convertImageToINDArray(Image image);
    DataSetIterator convertToDataSetIterator(Image image, char actual);
}
