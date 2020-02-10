package deverour.myutils;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import deverour.domain.Order;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utils {
    public static int getsum(int a ,int b){
        return a+b;
    }
    public static List<String> getClassList(Class cls){
        List<String> classList = new ArrayList<String>();

        Field[] fields = cls.getDeclaredFields();
        System.out.println("fields.length"+fields.length);
        for(int i=0; i<fields.length; i++){
            Field f = fields[i];
            f.setAccessible(true);
            System.out.println("属性名:" + f.getName());
            classList.add(f.getName());
        }

        return classList;


    }
    public static HashMap getTitle(String filepath) throws Exception {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        FileInputStream inp = new FileInputStream(filepath);
        XSSFWorkbook wb = new XSSFWorkbook(inp);
        XSSFSheet sheet = wb.getSheetAt(0); //
        int coloumNum=sheet.getRow(0).getPhysicalNumberOfCells();
        XSSFRow row = sheet.getRow(0);
        for (int colindex=0;colindex<=coloumNum;colindex++){
            XSSFCell cell =row.getCell(colindex);
            map.put(getString(cell),colindex);
        }



        return map;
    }

    public static Order getOrder(List<String> stringList,HashMap<String,Integer>  map) throws Exception{


        Order order = new Order();
        order.setId(stringList.get( map.get("分摊编号")));
        order.setSheng("重庆");
        String shi =stringList.get( map.get("市"));
        shi=shi.replace("中国铁塔股份有限公司","");
        shi=shi.replace("分公司","");
        order.setShi(shi);
        order.setQuyu(stringList.get( map.get("区域")));
        order.setZhifudanhao(stringList.get( map.get("支付单号")));
        order.setYongdianID(stringList.get( map.get("用电明细ID")));
        order.setHexiaoID(stringList.get( map.get("核销明细ID")));
        order.setFentanbianhao(stringList.get( map.get("分摊编号")));
        order.setFentanzhuangtai(stringList.get( map.get("分摊状态")));
        order.setFentanquerenzhuangtai(stringList.get( map.get("分摊确认状态")));
        order.setShfoucunzaiqueren(stringList.get( map.get("同一用电明细是否存在 （不）确认")));
        order.setDabiaozhuangtai(stringList.get( map.get("打标状态")));
        order.setShifoucunzaidabiao(stringList.get( map.get("同一用电明细是否存在已打标")));
        order.setFukuanwanchengshijian(stringList.get( map.get("付款完成时间")));
        order.setShenqingren(stringList.get( map.get("申请人")));
        order.setFentanwanchengshijian(stringList.get( map.get("分摊完成时间")));
        order.setChexiaoshijian(stringList.get( map.get("撤销时间")));
        order.setChexiaoren(stringList.get( map.get("撤销人")));
        order.setTuisongcaiwuzhuangtai(stringList.get( map.get("分摊推送财务状态")));
        order.setTuisongcaiwuriqi(stringList.get( map.get("分摊推送财务日期")));
        order.setChexiaotuisongcaiwuzhuangtai(stringList.get( map.get("分摊撤销推送财务状态")));
        order.setChexiaotuisongcaiwuriqi(stringList.get( map.get("分摊撤销推送财务日期")));
        order.setTuisongkehuzhuangtai(stringList.get( map.get("推送客户状态")));
        order.setTuisongshijian(stringList.get( map.get("推送时间")));
        order.setGongdianyonghuhao(stringList.get( map.get("供电用户号")));
        order.setDianbiaobianma(stringList.get( map.get("电表编码")));
        order.setShifouyezhubaogan(stringList.get( map.get("是否业主包干")));
        order.setDianbiaoleixing(stringList.get( map.get("电表类型")));
        order.setZhanzhibianma(stringList.get( map.get("站址编码")));
        order.setZhanzhimingc(stringList.get( map.get("站址名称")));
        order.setShiqi(stringList.get( map.get("购电起始日期")));
        order.setZhongqi(stringList.get( map.get("购电截止日期")));
        order.setChaobiaoriqi(stringList.get( map.get("购电抄表日期")));
        order.setQidu(stringList.get( map.get("购电起始读数")));
        order.setZhidu(stringList.get( map.get("购电截止读数")));
        order.setShifoufuwei(stringList.get( map.get("是否复位")));
        order.setFuweiqiandushu(stringList.get( map.get("复位前读数")));
        order.setFuweihoudushu(stringList.get( map.get("复位后读数")));
        order.setZengjiandianliang(stringList.get( map.get("增减电量（线损或其他）")));
        order.setBeilv(stringList.get( map.get("电表倍率")));
        order.setDianliang(stringList.get( map.get("用电量")));
        order.setPingjundanjia(stringList.get( map.get("平均单价")));
        order.setYongdianjine(stringList.get( map.get("用电金额")));
        order.setQitajianmian(stringList.get( map.get("其他应付或减免金额")));
        order.setZhifujine(stringList.get( map.get("支付总金额")));
        order.setYongdiantianshu(stringList.get( map.get("本次用电天数")));
        order.setRijundianliang(stringList.get( map.get("本次日均用电量")));
        order.setBiaoganrijundianliang(stringList.get( map.get("标杆日均用电量")));
        order.setPianlidianliang(stringList.get( map.get("偏离电量")));
        order.setPianlifudu(stringList.get( map.get("偏离幅度(%)")));
        order.setShifouyichang(stringList.get( map.get("是否异常")));
        order.setYichangshuoming(stringList.get( map.get("异常说明")));
        order.setJiaofeipiaoju(stringList.get( map.get("缴费票据类型")));
        order.setJiaofeihanshuijine(stringList.get( map.get("缴费含税金额")));
        order.setJiaofeishuie(stringList.get( map.get("缴费税额")));
        order.setJiaofeibuhanshuijine(stringList.get( map.get("缴费不含税金额")));
        order.setFentanzhanzhi(stringList.get( map.get("分摊站址")));
        order.setZhanzhichaifenbili(stringList.get( map.get("站址拆分比例(%)")));
        order.setChaifendaozhanjine(stringList.get( map.get("拆分到站金额")));
        order.setKehu(stringList.get( map.get("客户")));
        order.setKuahangyebianma(stringList.get( map.get("跨行业业务编码")));
        order.setFentanfangshi(stringList.get( map.get("分摊方式")));
        order.setChaifendaofentanfangshijine(stringList.get( map.get("拆分到分摊方式金额")));
        order.setFentanbili(stringList.get( map.get("分摊比例(%)")));
        order.setChaifendaokehujine(stringList.get( map.get("拆分到客户金额")));
        order.setJiesuanmoshi(stringList.get( map.get("结算模式")));
        order.setChaifendaojiesuanmoshijine(stringList.get( map.get("拆分到结算模式金额")));
        order.setWeicha(stringList.get( map.get("尾差")));
        order.setFentanjinebuhanshui(stringList.get( map.get("分摊金额（不含税）")));
        order.setKaipiaoleix(stringList.get( map.get("开票类型")));
        order.setShuifujinzi(stringList.get( map.get("税负因子")));
        order.setFentanjineshui(stringList.get( map.get("分摊金额（税负）")));
        order.setFentanjine(stringList.get( map.get("分摊金额（含税）")));

        return order;


    }

    public static ArrayList<String> getList( Order order){
        ArrayList<String> list=new ArrayList<String>();
        list.add(order.getId());
        list.add(order.getSheng());
        list.add(order.getShi());
        list.add(order.getQuyu());
        list.add(order.getZhifudanhao());
        list.add(order.getYongdianID());
        list.add(order.getHexiaoID());
        list.add(order.getFentanbianhao());
        list.add(order.getFentanzhuangtai());
        list.add(order.getFentanquerenzhuangtai());
        list.add(order.getShfoucunzaiqueren());
        list.add(order.getDabiaozhuangtai());
        list.add(order.getShifoucunzaidabiao());
        list.add(order.getFukuanwanchengshijian());
        list.add(order.getShenqingren());
        list.add(order.getFentanwanchengshijian());
        list.add(order.getChexiaoshijian());
        list.add(order.getChexiaoren());
        list.add(order.getTuisongcaiwuzhuangtai());
        list.add(order.getTuisongcaiwuriqi());
        list.add(order.getChexiaotuisongcaiwuzhuangtai());
        list.add(order.getChexiaotuisongcaiwuriqi());
        list.add(order.getTuisongkehuzhuangtai());
        list.add(order.getTuisongshijian());
        list.add(order.getGongdianyonghuhao());
        list.add(order.getDianbiaobianma());
        list.add(order.getShifouyezhubaogan());
        list.add(order.getDianbiaoleixing());
        list.add(order.getZhanzhibianma());
        list.add(order.getZhanzhimingc());
        list.add(order.getShiqi());
        list.add(order.getZhongqi());
        list.add(order.getChaobiaoriqi());
        list.add(order.getQidu());
        list.add(order.getZhidu());
        list.add(order.getShifoufuwei());
        list.add(order.getFuweiqiandushu());
        list.add(order.getFuweihoudushu());
        list.add(order.getZengjiandianliang());
        list.add(order.getBeilv());
        list.add(order.getDianliang());
        list.add(order.getPingjundanjia());
        list.add(order.getYongdianjine());
        list.add(order.getQitajianmian());
        list.add(order.getZhifujine());
        list.add(order.getYongdiantianshu());
        list.add(order.getRijundianliang());
        list.add(order.getBiaoganrijundianliang());
        list.add(order.getPianlidianliang());
        list.add(order.getPianlifudu());
        list.add(order.getShifouyichang());
        list.add(order.getYichangshuoming());
        list.add(order.getJiaofeipiaoju());
        list.add(order.getJiaofeihanshuijine());
        list.add(order.getJiaofeishuie());
        list.add(order.getJiaofeibuhanshuijine());
        list.add(order.getFentanzhanzhi());
        list.add(order.getZhanzhichaifenbili());
        list.add(order.getChaifendaozhanjine());
        list.add(order.getKehu());
        list.add(order.getKuahangyebianma());
        list.add(order.getFentanfangshi());
        list.add(order.getChaifendaofentanfangshijine());
        list.add(order.getFentanbili());
        list.add(order.getChaifendaokehujine());
        list.add(order.getJiesuanmoshi());
        list.add(order.getChaifendaojiesuanmoshijine());
        list.add(order.getWeicha());
        list.add(order.getFentanjinebuhanshui());
        list.add(order.getKaipiaoleix());
        list.add(order.getShuifujinzi());
        list.add(order.getFentanjineshui());
        list.add(order.getFentanjine());


        return list;

    }

    public static ArrayList<String> getCheckList( Order order,ArrayList<String> checknamelist) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, IntrospectionException {

        ArrayList<String> list=new ArrayList<String>();

        Class clazz = order.getClass();


        //System.out.println("************************************");
        for(String str:checknamelist){

            //System.out.println(str+"+");
            Field field = order.getClass().getDeclaredField(str);//获得属性
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(),
                    clazz);
            Method getMethod = pd.getReadMethod();//获得get方法

            Object o = getMethod.invoke(order);//执行get方法返回一个Object
            //System.out.println("o:"+o);
            //System.out.println("----");
            list.add((String) o);
        }



        return list;

    }

    public static String getString(XSSFCell xssfCell) {
        if (xssfCell == null) {
            return "";
        }

        if (xssfCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            return String.valueOf(xssfCell.getNumericCellValue());
        } else if (xssfCell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfCell.getBooleanCellValue());
        } else {
            return xssfCell.getStringCellValue();
        }
    }

    public static String getTimeList(String startTime,String endTime) throws ParseException {
        System.out.println("getTimeList");
        String timeList ="" ;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yyyy-MM");
        Date startDate =simpleDateFormat.parse(startTime);
        Date endtDate =simpleDateFormat.parse(endTime);

        Calendar calendar = Calendar.getInstance();
        for (Date indexDate =startDate;!indexDate.after(endtDate);){

            String indexTime= simpleDateFormat.format(indexDate);
            timeList=timeList+"|"+indexTime;
            calendar.setTime(indexDate);
            calendar.add(Calendar.MONTH, 1);
            indexDate=calendar.getTime();
        }
        timeList=timeList.substring(1);
        System.out.println("timeList:"+timeList);
        return timeList;
    }


}
