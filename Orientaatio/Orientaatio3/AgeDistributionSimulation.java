import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class AgeDistributionSimulation {

    public static void main(String[] args) {
        // Define the predefined age distribution data
        int[] ageData = {18, 22, 21, 19, 24, 20, 23, 21, 22, 19, 20, 22, 24, 23, 21, 19, 20, 21, 22, 23};

        // Calculate mean and standard deviation
        double meanAge = calculateMean(ageData);
        double stdDevAge = calculateStdDev(ageData, meanAge);

        // Generate 1000 synthetic age values
        int numSamples = 1000;
        double[] syntheticAges = new double[numSamples];
        Random random = new Random();
        for (int i = 0; i < numSamples; i++) {
            syntheticAges[i] = meanAge + stdDevAge * random.nextGaussian();
        }

        // Create and display histograms
        JFrame frame = new JFrame("Age Distribution Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLayout(new GridLayout(1, 2));

        // Original Data Histogram
        BufferedImage originalHistogram = createHistogram(ageData, 10);
        JPanel originalPanel = new ImagePanel(originalHistogram);
        frame.add(originalPanel);

        // Synthetic Data Histogram
        BufferedImage syntheticHistogram = createHistogram(convertToIntArray(syntheticAges), 30);
        JPanel syntheticPanel = new ImagePanel(syntheticHistogram);
        frame.add(syntheticPanel);

        frame.setVisible(true);
    }

    // Method to create a histogram image
    private static BufferedImage createHistogram(int[] data, int bins) {
        int width = 400;
        int height = 300;
        BufferedImage histogram = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = histogram.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        int[] counts = new int[bins];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int value : data) {
            if (value < min) min = value;
            if (value > max) max = value;
        }
        for (int value : data) {
            int binIndex = (int) ((double) (value - min) / (max - min) * bins);
            if (binIndex >= bins) binIndex = bins - 1;
            counts[binIndex]++;
        }

        int binWidth = width / bins;
        int maxCount = 0;
        for (int count : counts) {
            if (count > maxCount) maxCount = count;
        }
        for (int i = 0; i < bins; i++) {
            int barHeight = (int) ((double) counts[i] / maxCount * height);
            g2d.setColor(Color.BLUE);
            g2d.fillRect(i * binWidth, height - barHeight, binWidth, barHeight);
        }

        g2d.dispose();
        return histogram;
    }

    // Method to create a histogram image from double array
    private static BufferedImage createHistogram(double[] data, int bins) {
        return createHistogram(convertToIntArray(data), bins);
    }

    // Helper method to convert Integer array to double array
    private static double[] convertToPrimitive(int[] data) {
        double[] result = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[i];
        }
        return result;
    }

    // Helper method to convert double array to int array
    private static int[] convertToIntArray(double[] data) {
        int[] result = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = (int) Math.round(data[i]);
        }
        return result;
    }

    // Method to calculate mean
    private static double calculateMean(int[] data) {
        double sum = 0;
        for (int age : data) {
            sum += age;
        }
        return sum / data.length;
    }

    // Method to calculate standard deviation
    private static double calculateStdDev(int[] data, double mean) {
        double sumSquaredDiffs = 0;
        for (int age : data) {
            double diff = age - mean;
            sumSquaredDiffs += diff * diff;
        }
        return Math.sqrt(sumSquaredDiffs / data.length);
    }

    // JPanel for displaying images
    static class ImagePanel extends JPanel {
        private final BufferedImage image;

        ImagePanel(BufferedImage image) {
            this.image = image;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
        }
    }
}
