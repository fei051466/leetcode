public class RandomizedSet {

    private List<Integer> numList;
    private HashMap<Integer, Integer> valIndex;
    private int size;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        numList = new ArrayList<Integer>();
        valIndex = new HashMap<Integer, Integer>();
        size = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valIndex.containsKey(val)) {
            return false;
        }
        numList.add(size, val);
        valIndex.put(val, size);
        size++;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valIndex.containsKey(val)) {
            return false;
        }
        int index = valIndex.get(val);
        int last = numList.get(size - 1);
        System.out.println(last);
        numList.set(index, last);
        valIndex.put(last, index);
        valIndex.remove(val);
        size--;
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random rdm = new Random();
        return numList.get(rdm.nextInt(size));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */