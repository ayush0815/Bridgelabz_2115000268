public class TrigonometricFunctions {

    public double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        double[] result = new double[3];
        result[0] = Math.sin(radians);  // Sine
        result[1] = Math.cos(radians);  // Cosine
        result[2] = Math.tan(radians);  // Tangent
        return result;
    }

    public static void main(String[] args) {
        TrigonometricFunctions functions = new TrigonometricFunctions();
        double angle = 45; // Example angle
        
        double[] result = functions.calculateTrigonometricFunctions(angle);
        System.out.println("Sine: " + result[0]);
        System.out.println("Cosine: " + result[1]);
        System.out.println("Tangent: " + result[2]);
    }
}
