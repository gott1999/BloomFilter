package edu.nytdc.xww.bloomFilter;

public class Function {
    /**
     * The size of bitmap
     */
    private final int size;

    /**
     * The seed of this hash
     */
    private final int seed;

    /**
     * new a hash function.
     *
     * @param size size of bitmap
     * @param seed seed of this function
     */
    public Function(int size, int seed) {
        this.size = size;
        this.seed = seed;
    }

    /**
     * Hash function
     *
     * @param element element
     * @return locate of bit map
     */
    public int hash(String element) {
        if (element == null) {
            return 0;
        }
        // default returns 0
        int result = 0;
        for (int i = 0; i < element.length(); i++) {
            result = seed * result + element.charAt(i);
        }
        return (size - 1) & result;
    }
}
