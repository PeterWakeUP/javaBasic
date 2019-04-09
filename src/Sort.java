public class Sort {

    /**
     * 冒泡排序
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length - 1 - i; j++)
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
        return array;
    }

    /**
     * 选择排序
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {
        if (array.length == 0)
            return array;
        for(int i = 0; i< array.length; i++){
            int min = i;
            for (int j = i; j < array.length; j++){
                if(array[i] > array[j]){
                    min = j;
                }
            }
            if(i != min){
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        return array;
    }

    public static void main(String[] args){

        /*int[] array = new int[]{3,2,1,7,6,9,0};
        bubbleSort(array);
        //selectionSort(array);
        for(int i : array){
            System.out.println(i);
        }*/
    }
}
