package edu.aed.maximumheap;
/**
 * A Binary Heap is a Binary Tree with following properties: 
 * 1) Es un árbol completo (Todos los niveles están completamente llenos excepto posiblemente el último nivel 
 * y el último nivel tiene todas las claves lo más a la izquierda posible). Esta propiedad de Binary Heap 
 * los hace aptos para almacenarse en una matriz. 
 * 2)In a Max Binary Heap, la clave en la raíz debe ser máxima entre todas las claves presentes en el Binary Heap. 
 */
public class MaximumHeap {
    // To store array of elements in heap
    protected final int[] heapArray;

    // max size of the heap
    protected final int capacity;

    // Current number of elements in the heap
    protected int currentHeapSize;

    // Constructor
    public MaximumHeap(int n) {
        capacity = n;
        heapArray = new int[capacity];
        currentHeapSize = 0;
    }

    // Changes value on a key
    public void changeValueOnAKey(int index, int newVal) {
        if (heapArray[index] == newVal) {
            return;
        }
        if (heapArray[index] < newVal) {
            increaseKey(index, newVal);
        } else {
            decreaseKey(index, newVal);
        }
    }

    // Disminuye el valor de la clave dada a new_val.
    // It is assumed that new_val is smaller than heapArray[key].
    //Se supone que new_val es menor que heapArray[key]
    public void decreaseKey(int index, int newValue) {

        if(newValue >= heapArray[index])
            return;

        heapArray[index] = newValue;

        while (index != 0 && heapArray[index] > heapArray[parent(index)]) {
            int temp = heapArray[index];
            heapArray[index] = heapArray[parent(index)];
            heapArray[parent(index)] = temp;
            index = parent(index);
        }
    }

    // This function deletes key at the given index. 
    //It first reduced value to max infinite, then calls extractMax()
    //Primero redujo el valor a un máximo infinito, luego llama a extractMax()
    public void deleteKey(int index) {        
        decreaseKey(index, Integer.MAX_VALUE);
        int result = extractMax();
        System.out.println("Element removed: " + result);        
    }

    // Method to remove maximum element
    // (or root) from max heap
    public int extractMax() {
        if (currentHeapSize <= 0) {
            return Integer.MIN_VALUE;
        }

        if (currentHeapSize == 1) {
            currentHeapSize--;
            return heapArray[0];
        }

        // Store the maximum value,
        // and remove it from heap
        int root = heapArray[0];

        heapArray[0] = heapArray[currentHeapSize - 1];
        currentHeapSize--;
        maxHeapify(0);

        return root;
    }

    // Returns the maximum key (key at root) from min heap
    public int getMax() {
        return heapArray[0];
    }

    // Increases value of given key to new_val.
    // It is assumed that new_val is greater than heapArray[key].
    // Heapify from the given key
    public void increaseKey(int index, int newValue) {

        if(newValue <= heapArray[index])
            return;

        heapArray[index] = newValue;
        maxHeapify(index);
    }

    // Inserts a new key
    public boolean insertKey(int key) {
        if (currentHeapSize == capacity) {
            // heap is full
            return false;
        }

        // First insert the new key at the end
        int i = currentHeapSize;
        heapArray[i] = key;
        currentHeapSize++;

        // Fix the max heap property if it is violated
        while (i != 0 && heapArray[i] >
                heapArray[parent(i)]) {
            // swap elements
            int temp = heapArray[i];
            heapArray[i] = heapArray[parent(i)];
            heapArray[parent(i)] = temp;

            i = parent(i);
        }
        return true;
    }

    // Get the Left Child index for the given index
    private int left(int key) {
        return 2 * key + 1;
    }

    // A recursive method to heapify a subtree with the root at given index
    // This method assumes that the subtrees are already heapified
    private void maxHeapify(int index) {
        int l = left(index);
        int r = right(index);

        int greatest = index;
        if (l < currentHeapSize &&
                heapArray[l] > heapArray[greatest]) {
            greatest = l;
        }
        if (r < currentHeapSize &&
                heapArray[r] > heapArray[greatest]) {
            greatest = r;
        }

        if (greatest != index) {
            int temp = heapArray[index];
            heapArray[index] = heapArray[greatest];
            heapArray[greatest] = temp;
            maxHeapify(greatest);
        }
    }

    // Get the Parent index for the given index
    private int parent(int key) {
        return (key - 1) / 2;
    }

    // Get the Right Child index for the given index
    private int right(int key) {
        return 2 * key + 2;
    }

    @Override
    public String toString(){
        StringBuilder array = new StringBuilder();
        array.append("[");

        for (int j=0; j<heapArray.length;j++) {
            array.append(heapArray[j]);

            if(j != heapArray.length-1){
                array.append(", ");
            }
        }

        array.append("]");
        return array.toString();
    }
}
