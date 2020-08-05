/**
 * @author : jiangzhengliang
 * @Data : 2020-08-01
 * @Direction : be used to complete the array's sort by merge sort
 */
public class MergeSort {

    private static void merge(int[] obj, int s, int m, int t){
        int p = s, q = m + 1, idx = s;
        int[] copyArray = new int[obj.length];
        while(p <= m && q <= t){
            if(obj[p] <= obj[q]){
                copyArray[idx++] = obj[p++];
            }
            else{
                copyArray[idx++] = obj[q++];
            }
        }
        while(p <= m){
            copyArray[idx++] = obj[p++];
        }
        while(q <= t){
            copyArray[idx++] = obj[q++];
        }
        System.arraycopy(copyArray, s, obj, s, t - s + 1);
    }

    private static void myMergeSort(int[] obj, int s, int t){
        if(s >= t){
            return;
        }
        // prevent the Integer over range
        int mid = (t - s) / 2 + s;
        // prevent the Integer over range
        myMergeSort(obj, s, mid);
        myMergeSort(obj, mid + 1, t);
        merge(obj, s, mid, t);
    }

    public static void mergeSort(int[] array, int n){
        myMergeSort(array, 0, n - 1);
    }

    public static void main(String[] args){
        int[] a = {10, 8, 9, 7, 6, 5, 4, 3, 2, 1};
        mergeSort(a, 10);
        for(int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
