class PetrolCircularTour {
    static int findStartingPoint(int[] petrol, int[] distance) {
        int totalPetrol = 0, totalDistance = 0;
        int start = 0, fuelBalance = 0;

        for (int i = 0; i < petrol.length; i++) {
            totalPetrol += petrol[i];
            totalDistance += distance[i];
            fuelBalance += petrol[i] - distance[i];
            // If balance goes negative, reset the starting point
            if (fuelBalance < 0) {
                start = i + 1;
                fuelBalance = 0; // Reset balance
            }
        }
        return (totalPetrol >= totalDistance) ? start : -1;
    }
    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int startPoint = findStartingPoint(petrol, distance);
        System.out.println(startPoint == -1 ? "No valid tour possible" : "Start at pump: " + startPoint);
    }
}
