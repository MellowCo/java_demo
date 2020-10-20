package com.li;

public class MyList {
    Object[] list = new Object[10];

    public void add(Object ob) {
        int index = -1;
        for (Object o : list) {
            index++;
            if (o == null) {
                list[index] = ob;
                break;
            }
        }
    }

    public Object remove() {
        int index = -1;

        for (Object o : list) {
            index++;
            if (o == null) {
                Object ob = list[index - 1];
                list[index - 1] = null;
                return ob;
            }
        }
        return null;
    }

    public void show() {
        int max = list.length - 1;

        StringBuilder sb = new StringBuilder();

        sb.append("[");
        int index = -1;

        for (Object o : list) {
            index++;
            if (list[index+1] == null) {
                sb.append(o);
                break;
            } else {
                sb.append(o + ", ");
            }

        }

        sb.append("]");
        System.out.println(sb.toString());
    }


    public static void main(String[] args) {
        MyList ml = new MyList();
        ml.add(1);
        ml.add(2);
        ml.add(3);
        ml.add(4);
        ml.add("hello");
        ml.add("w");
        ml.add(3.434);
        ml.show();
        System.out.println(ml.remove());
        ml.show();
    }

}
