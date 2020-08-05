/**
 * @author : jiangzhengliang
 * @Data : 2020-08-01
 * @Direction : be used to complete the array's sort by quick sort
 */
public class QuickSort {

    private static int getPartition(int[] obj, int s, int t){
        int pivot = obj[s];
        while(s < t){
            while(s < t && pivot <= obj[t]){
                t--;
            }
            if(s < t){
                obj[s] = obj[t];
            }
            while(s < t && pivot >= obj[s]){
                s++;
            }
            if(s < t){
                obj[t] = obj[s];
            }
        }
        obj[s] = pivot;
        return s;
    }

    private static void implementSort(int[] obj, int s, int t){
        if(s >= t){
            return;
        }
        int mid = getPartition(obj, s, t);
        implementSort(obj, s, mid - 1);
        implementSort(obj, mid + 1, t);
    }

    public static void quickSort(int[] array, int n){
        implementSort(array, 0, n - 1);
    }

    public static void main(String[] args){
        int[] a = {10, 8, 9, 7, 6, 5, 4, 3, 2, 1};
        quickSort(a, 10);
        for(int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
