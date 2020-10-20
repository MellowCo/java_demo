package ThreadTest;
/**
 *
 *Lambda表达式只能针对函数式接口使用。
 *只有一个抽象方法，则默认是函数式接口
 *
 *
 */
public class Lamda extends ilike{




    public static void main(String[] args) {
        // 1
        like i = (a, b) -> {
            return b * a;
        };

        System.out.println(i.love(10, 8));

        //2
        like j = new like() {
            @Override
            public int love(int i, int j) {
                return i * 10;
            }

        };
        System.out.println(j.love(12, 1));

        //3
        like k = new ilike();
        System.out.println(k.love(12,31));

        //4
        like o =(a,b)->(a+b)*10;
        System.out.println(o.love(1,4));

        //5

        new ilike((a,b)->a+b).say();


    }



}


interface like {
    int love(int i, int j);
}


class ilike implements like {


    @Override
    public int love(int i, int j) {
        return (i + j);
    }

    void say(){
        System.out.println("i love you");
    }

    ilike (){


    }


    ilike(like l){

    }
}

