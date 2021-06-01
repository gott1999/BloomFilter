package edu.nytdc.xww.bloomFilter;

import java.util.BitSet;

public class SimpleFilter {

    private final BitSet bitSet;
    private final Function[] functions;

    public SimpleFilter(int size, int[] seeds) {
        size = size == 0 ? (1 << 20) : (1 << size);
        seeds = seeds.length == 0 ? new int[]{3, 7, 13, 23, 31, 67, 101, 187} : seeds;
        this.bitSet = new BitSet(size);
        this.functions = new Function[seeds.length];
        for (int i = 0; i < seeds.length; i++) {
            functions[i] = new Function(size, seeds[i]);
        }
    }

    /**
     * Add to bitmap.
     *
     * @param element element
     */
    public void add(String element) {
        if (element != null) {
            for (Function f : functions) {
                bitSet.set(f.hash(element), true);
            }
        }
    }

    /**
     * Check for the existence of element.
     *
     * @param element element
     * @return result: boolean
     */
    public boolean contains(String element) {
        if (element == null) {
            return false;
        }
        boolean result = false;
        for (Function f : functions) {
            result = bitSet.get(f.hash(element));
            if (!result) {
                break;
            }
        }
        return result;
    }
}
