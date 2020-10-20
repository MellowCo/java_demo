package TestCalendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestCalent {
    public static void main(String[] args) throws ParseException {
        System.out.println("请输入一个日期：");
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        Date d=df.parse(str);
        
        Calendar  c=new GregorianCalendar();
        c.setTime(d);
        
        int i;
        int MaxDay=c.getActualMaximum(Calendar.DATE);
        int today=c.get(Calendar.DAY_OF_MONTH);
        
        c.set(Calendar.DAY_OF_MONTH, 1);
        int week=c.get(Calendar.DAY_OF_WEEK);
        System.out.println("日\t 一\t二\t三\t 四\t 五\t六");
        
        for(i=1;i<=week-1;i++) {
            System.out.print(" \t");
        }
        
        for(i=1;i<=MaxDay;i++) {
            if(c.get(Calendar.DAY_OF_MONTH)==today) {
                System.out.print(" "+c.get(Calendar.DAY_OF_MONTH)+"*\t");
            }else {
                System.out.print(" "+c.get(Calendar.DAY_OF_MONTH)+"\t");
            }
            
            if(c.get(Calendar.DAY_OF_WEEK)==7) {
                System.out.println();
            }
            
            c.add(Calendar.DAY_OF_MONTH, 1);
        }
            
     scn.close();   
    }
}
