public class InClass_11_16_Matrix {
    public static void main(String[] args) {
        int[][] adjMatrix = {
                {0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0}, // Seattle
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, // San Francisco
                {0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0}, // Los Angeles
                {1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0}, // Denver
                {0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0}, // Kansas City
                {1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0}, // Chicago
                {0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, // Boston
                {0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0}, // New York
                {0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1}, // Atlanta
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1}, // Miami
                {0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1}, // Dallas
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0}  // Houston
        };
        int size = adjMatrix.length;
        System.out.printf("\nSize:%s", size);

        String[] nodeNames = setNodeNames( size );
        // ToDo: Ask the user for a node-
        // ToDo: Show all the nodes connected to their input


    }

    private static String[] setNodeNames( int size) {
        String[] nodeNames = {"Seattle", "San Francisco", "Los Angeles",
                "Denver", "Kansas City", "Chicago", "Boston",
                "New York", "Atlanta", "Miami", "Dallas", "Houston"
        };
        return nodeNames;
    }
}
