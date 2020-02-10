package deverour.poi;

import deverour.domain.Order;
import deverour.myutils.Utils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExcelWrite {
    final static int PAGE_COUNTS=1000000;

    public static InputStream  WriteAll(List<Order> list) throws Exception {
        //final int PAGE_COUNTS=10000;
        int pages= list.size()/PAGE_COUNTS+1;
        System.out.println("共： "+pages+"页");
        ArrayList<String> sheetName = new ArrayList<String>();
        for (int page=1;page<=pages;page++){
            sheetName.add("sheet"+page);
        }

        SXSSFWorkbook wb=new SXSSFWorkbook();
        ArrayList<String> namelist = Order.getNamelist();
        //long t0;
        //long t6;
        //long t6a=0;
        long ta =0;
        long tb =0;
        ta = System.currentTimeMillis();
        for (int page=1;page<=pages;page++){
           // System.out.println("page<=pages"+(page<=pages));
            //System.out.println("step1");
            wb.createSheet(sheetName.get(page-1));
           // System.out.println("step2");
            SXSSFSheet sheet = wb.getSheetAt(page-1);
            int rowindex = 0;
            //System.out.println("step3");
            SXSSFRow row = sheet.createRow(rowindex);
            int colindex = 0;
            //System.out.println("step4");
            for (String str:namelist){
                SXSSFCell cell = row.createCell(colindex);
                cell.setCellValue(str);
                colindex++;
            }

            rowindex++;
            int countanull=0;
            Cell cell;


            int start=(page-1)*(PAGE_COUNTS-1);
            int end=page*(PAGE_COUNTS-1)-1;
            if(page==pages){
                end=list.size()-1;
            }
           // System.out.println("page:"+page);
            //System.out.println("start"+start);
            //System.out.println("end"+end);

            for (int listindex=start;listindex<=end;listindex++){

                //t0 = System.currentTimeMillis();
                row = sheet.createRow(rowindex);
                //t6 = System.currentTimeMillis();

                List<String> orderlist = Utils.getList(list.get(listindex));

                //t6a =t6a+(t6-t0);

                for (int i=1;i<orderlist.size();i++){
                    //t1 = System.currentTimeMillis();
                    String str =orderlist.get(i);
                    // = System.currentTimeMillis();
               /* if(str==null){
                    countanull++;
                    continue;
                }*/
                    //t3 = System.currentTimeMillis();
                    cell = row.createCell(i-1);
                    //t4 = System.currentTimeMillis();


                    cell.setCellValue(str);
                    //t5 = System.currentTimeMillis();
               /* t2a =t2a+(t2-t1);
                t3a =t3a+(t3-t2);
                t4a =t4a+(t4-t3);
                t5a =t5a+(t5-t4);*/

                }

                rowindex++;


            }
            //System.out.println("rowindex:"+rowindex);
        }

        tb = System.currentTimeMillis();
        System.out.println("总耗时："+(tb-ta));

        //System.out.println("createRow耗时："+t6a);

        InputStream in = null;
        try{
            //临时缓冲区
            ByteArrayOutputStream baout = new ByteArrayOutputStream();
            //创建临时文件
            wb.write(baout);
            byte [] bookByteAry = baout.toByteArray();
            in = new ByteArrayInputStream(bookByteAry);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return in;
    }
    public static InputStream WriteByList(List<Order> list, ArrayList<String> checknamelist) throws Exception {

        int pages= list.size()/PAGE_COUNTS+1;
        System.out.println("共： "+pages+"页");
        ArrayList<String> sheetName = new ArrayList<String>();
        for (int page=1;page<=pages;page++){
            sheetName.add("sheet"+page);
        }
        SXSSFWorkbook wb=new SXSSFWorkbook();
        long ta = 0;
        long tb = 0;
        ta = System.currentTimeMillis();
        for (int page=1;page<=pages;page++) {
            SXSSFSheet sheet = wb.createSheet(sheetName.get(page-1));
            int rowindex = 0;
            SXSSFRow row = sheet.createRow(rowindex);
            // ArrayList<String> namelist = Order.getNamelist();
            int colindex = 0;
            HashMap<String, String> namemap = Order.getNamemap();
            for (String str : checknamelist) {
                SXSSFCell cell = row.createCell(colindex);
                cell.setCellValue(namemap.get(str));
                colindex++;
            }

            rowindex++;
            int countanull = 0;
            Cell cell;

            int start=(page-1)*(PAGE_COUNTS-1);
            int end=page*(PAGE_COUNTS-1)-1;
            if(page==pages){
                end=list.size()-1;
            }
            for (int listindex=start;listindex<=end;listindex++){


                row = sheet.createRow(rowindex);


                List<String> orderlist = Utils.getCheckList(list.get(listindex), checknamelist);

                //t6a =t6a+(t6-t0);

                for (int i = 0; i < orderlist.size(); i++) {
                    //t1 = System.currentTimeMillis();
                    String str = orderlist.get(i);
                    // = System.currentTimeMillis();
                    if (str == null) {
                        countanull++;
                        continue;
                    }
                    cell = row.createCell(i);
                    cell.setCellValue(str);
                }
                rowindex++;
            }

        }
        tb = System.currentTimeMillis();
        System.out.println("总耗时："+(tb-ta));
        //System.out.println("createRow耗时："+t6a);
/*        System.out.println("t01a："+t01a);
        System.out.println("t01："+t1a);*/
      /*  System.out.println("t2a："+t2a);
        System.out.println("t3a："+t3a);
        System.out.println("t4a："+t4a);
        System.out.println("t5a："+t5a);*/
        //System.out.println("t6a："+t6a);

        /*System.out.println("t3:"+t3);
        System.out.println("countanull:"+countanull);
        FileOutputStream out =  new FileOutputStream("d:\\out.xlsx");
        wb.write(out);
        out.close();*/

        InputStream in = null;
        try{
            //临时缓冲区
            ByteArrayOutputStream baout = new ByteArrayOutputStream();
            //创建临时文件
            wb.write(baout);
            byte [] bookByteAry = baout.toByteArray();
            in = new ByteArrayInputStream(bookByteAry);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return in;
    }

    /*public static InputStream  WriteByList(List<Order> list,ArrayList<String> checknamelist) throws Exception {
        SXSSFWorkbook wb=new SXSSFWorkbook();
        //SXSSFSheet sheet= wb.createSheet("sheet1");
        wb.createSheet("sheet1");
        SXSSFSheet sheet = wb.getSheetAt(0);
        int rowindex = 0;
        SXSSFRow row = sheet.createRow(rowindex);
        // ArrayList<String> namelist = Order.getNamelist();
        int colindex = 0;
        HashMap<String,String> namemap = Order.getNamemap();
        for (String str:checknamelist){
            SXSSFCell cell = row.createCell(colindex);
            cell.setCellValue(namemap.get(str));
            colindex++;
        }
        //long t0;
        //long t6;
        //long t6a=0;
        rowindex++;
        int countanull=0;
        Cell cell;
        long ta =0;
        long tb =0;
        ta = System.currentTimeMillis();
        for (Order order:list){
            // System.out.println(order);
            //t0 = System.currentTimeMillis();
            row = sheet.createRow(rowindex);
            //t6 = System.currentTimeMillis();

            List<String> orderlist = Utils.getCheckList(order,checknamelist);

            //t6a =t6a+(t6-t0);

            for (int i=0;i<orderlist.size();i++){
                //t1 = System.currentTimeMillis();
                String str =orderlist.get(i);
                // = System.currentTimeMillis();
                if(str==null){
                    countanull++;
                    continue;
                }
                cell = row.createCell(i);
                cell.setCellValue(str);
            }
            rowindex++;
        }
        tb = System.currentTimeMillis();
        System.out.println("总耗时："+(tb-ta));
//       System.out.println("t01a："+t01a);
        System.out.println("t01："+t1a);
      //  System.out.println("t2a："+t2a);
        System.out.println("t3a："+t3a);
        System.out.println("t4a："+t4a);
        System.out.println("t5a："+t5a);
        //System.out.println("t6a："+t6a);

        System.out.println("t3:"+t3);
        System.out.println("countanull:"+countanull);
        FileOutputStream out =  new FileOutputStream("d:\\out.xlsx");
        wb.write(out);
        out.close();

        InputStream in = null;
        try{
            //临时缓冲区
            ByteArrayOutputStream baout = new ByteArrayOutputStream();
            //创建临时文件
            wb.write(baout);
            byte [] bookByteAry = baout.toByteArray();
            in = new ByteArrayInputStream(bookByteAry);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return in;
    }*/

}
