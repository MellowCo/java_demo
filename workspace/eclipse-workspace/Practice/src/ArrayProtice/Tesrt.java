package ArrayProtice;

import java.util.Arrays;

public class Tesrt {
    public static void main(String[] args) {
        int a[]= {1,23,23423,123,46,23,54};
        Arrays.sort(a,3,6);
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        String b[]= {"a","b","c","d"};
        String c[]=new String[10];
               
        System.arraycopy(b, 1, c, 0, 2);
        System.out.println(Arrays.toString(c));
        
        for(String temp:b){
            System.out.println(temp);
        }
          
        for(int i:a) {
            System.out.println(i);
        }
    
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.binarySearch(a, 1));
        
      // deleteArrays(b,3);
        b=addArrays(b,1,"ss");
        System.out.println(Arrays.toString(b));
    }
    
    public static void deleteArrays(String str[],int index) {
        if(index>str.length) {
            System.out.println("false");
        }else {
            System.arraycopy(str, index, str, index-1, str.length-index);
            str[str.length-1]=null;
            System.out.println(Arrays.toString(str));
            
        }
    }
    
    public static String[] addArrays(String str[],int index,String b) {
        String a[]=new String[str.length+1];
        System.arraycopy(str, 0, a, 0, index-1);
        a[index-1]=b;
        System.arraycopy(str, index-1, a, index, str.length-index+1);
        System.out.println(Arrays.toString(a));
        return a;
    }
}
