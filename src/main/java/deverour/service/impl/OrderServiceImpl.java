package deverour.service.impl;


import deverour.domain.Order;
import deverour.mapper.OrderMapper;
import deverour.poi.ExcelRead;
import deverour.poi.ExcelWrite;
import deverour.service.OrderService;

import deverour.myutils.Utils;
//import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service("OrderService")
public class OrderServiceImpl  implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public InputStream findAll() throws Exception {
        System.out.println("业务层：查询所有信息");
        List<Order> list = orderMapper.findAll();
        InputStream is= ExcelWrite.WriteAll(list);
        return is;
    }

    public InputStream findByList(String[] checklist,String timeList) throws Exception {

        HashMap<String,String> checkmap = new HashMap<String,String>();
        ArrayList<String>checkindexlist =new ArrayList<String>();
        ArrayList<String> checknamelist =new ArrayList<String>();
        for (String str:checklist){
            String[] sp=str.split("-");
            checkmap.put(sp[0],sp[1]);
            checkindexlist.add(sp[0]);
            //System.out.println(str);
        }

        Collections.sort(checkindexlist);
        for (String ss:checkindexlist){
            System.out.println("****"+ss);
        }
        for(int checkindex=0;checkindex<checkindexlist.size();checkindex++){
            checknamelist.add(checkmap.get(checkindexlist.get(checkindex)));
            //System.out.println(checkmap.get(checkindexlist.get(checkindex)));

        }



        Order order = new Order();
        order.setNames(checknamelist);
        order.setTimes(timeList);

        List<Order> list = orderMapper.findByList(order);
        InputStream is= ExcelWrite.WriteByList(list,checknamelist);
        return is;
    }

    public void saveOrder(String filepath) throws Exception {
        System.out.println("业务层:保存明细");
        File file = new File(filepath);
        System.out.println(filepath);
        List<Order> Orders= null;
        ExcelRead excelRead = new ExcelRead(file.getPath(),2,60);

        long t1=System.currentTimeMillis();
        int index=1;
        System.out.println("index:"+index);
        Order order = new Order();
        HashMap<String,Integer> map =Utils.getTitle(filepath);
        int counts=0;
        for (List<String> orderList:excelRead.getMyDataList()){
            //System.out.println(orderList);
            order = Utils.getOrder(orderList,map);

            //System.out.println(order);
            counts =orderMapper.saveOrder(order)+counts;

            index++;
            //System.out.println("index:"+index);


        }
        System.out.println("index:"+index);
        System.out.println("新增数据："+counts);
       /* long t2=System.currentTimeMillis();
        System.out.println("保存完成,耗时：");
        System.out.println((t2-t1));
        session.commit();
        long t3=System.currentTimeMillis();
        System.out.println("提交事务,耗时：");

        System.out.println((t3-t2));*/


    }

    @Override
    public void updataOrder(String filepath) throws Exception {
        System.out.println("业务层:更新明细");
        File file = new File(filepath);
        System.out.println(filepath);
        List<Order> Orders= null;
        ExcelRead excelRead = new ExcelRead(file.getPath(),2,60);

        long t1=System.currentTimeMillis();
        int index=1;
        System.out.println("index:"+index);
        Order order = new Order();
        HashMap<String,Integer> map =Utils.getTitle(filepath);
        int counts=0;
        for (List<String> orderList:excelRead.getMyDataList()){
            //System.out.println(orderList);
            order = Utils.getOrder(orderList,map);

            //System.out.println(order);
            orderMapper.updataOrder(order);
            index++;
            //System.out.println("index:"+index);


        }
        System.out.println("更新数据："+index);

    }


}
