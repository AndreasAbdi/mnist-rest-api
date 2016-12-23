package main.brain.converters;

import main.brain.converters.ImageToDl4JConverter;
import main.datatypes.Image;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;

/**
 * //TODO: Fill this in.
 */
public class ImageToDl4JConverterImpl implements ImageToDl4JConverter {
    @Override
    public INDArray convertImageToINDArray(Image image) {
        return null;
    }

    @Override
    public DataSetIterator convertToDataSetIterator(Image image, char actual) {
        return null;
    }
}
