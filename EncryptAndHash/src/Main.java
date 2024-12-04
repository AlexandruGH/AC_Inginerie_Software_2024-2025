public class Main {
    public static void main(String[] args){
        int[] arr = {5, 2, 7, 2, 5};
        int result = arr[0];

        for (int i=1; i< arr.length; i++){
            result = result ^ arr[i];
        }
        System.out.println(result);
    }
}
