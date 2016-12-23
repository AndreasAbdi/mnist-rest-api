package main.brain.neuralnetworks;

import main.brain.neuralnetworks.MnistNeuralNetwork;
import org.deeplearning4j.datasets.iterator.impl.MnistDataSetIterator;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.Updater;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.lossfunctions.LossFunctions;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * //TODO: Fill this in.
 */
@Service
public class MnistNeuralNetworkSingleLayer implements MnistNeuralNetwork {
    final int numRows = 28;
    final int numColumns = 28;

    private DataSetIterator mnistTrain = null;
    private DataSetIterator mnistTest = null;
    private int outputNum = 10; // number of output classes
    private int batchSize = 128; // batch size for each epoch
    private int rngSeed = 123; // random number seed for reproducibility
    private int numEpochs = 15; // number of epochs to perform
    private MultiLayerNetwork model;

    public MnistNeuralNetworkSingleLayer() {
        this.init();
    }

    //TODO
    @Override
    public char predict(INDArray image) {
        Evaluation eval = new Evaluation(1);

        INDArray output = model.output(image);
        eval.eval(image, output);
        return 0;
    }

    @Override
    public void evaluate(DataSetIterator dataToTrain) {
        model.fit(dataToTrain);
    }

    private boolean init() {
        if(!getDataSets()) {
            return false;
        }
        buildModel();
        trainModel();
        doEvaluation();
        return true;
    }

    private boolean getDataSets() {
        try {
            mnistTrain = new MnistDataSetIterator(batchSize, true, rngSeed);
            mnistTest = new MnistDataSetIterator(batchSize, false, rngSeed);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void buildModel() {
        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
                .seed(rngSeed)
                .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
                .iterations(1)
                .learningRate(0.006)
                .updater(Updater.NESTEROVS).momentum(0.9)
                .regularization(true).l2(1e-4)
                .list()
                .layer(0, new DenseLayer.Builder()
                        .nIn(numRows * numColumns)
                        .nOut(1000)
                        .activation("relu")
                        .weightInit(WeightInit.XAVIER)
                        .build())
                .layer(1, new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
                        .nIn(1000)
                        .nOut(outputNum)
                        .activation("softmax")
                        .weightInit(WeightInit.XAVIER)
                        .build())
                .pretrain(false).backprop(true)
                .build();

       model = new MultiLayerNetwork(conf);
       model.init();
    }

    private void trainModel() {
        for( int i=0; i<numEpochs; i++ ){
            model.fit(mnistTrain);
        }
    }

    private void doEvaluation() {
        Evaluation eval = new Evaluation(outputNum);
        while(mnistTest.hasNext()){
            DataSet next = mnistTest.next();
            INDArray output = model.output(next.getFeatureMatrix());
            eval.eval(next.getLabels(), output);
        }
    }


}
