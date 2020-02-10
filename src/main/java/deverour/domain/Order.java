package deverour.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {

    private String id;
    private String sheng;
    private String shi;
    private String quyu;
    private String zhifudanhao;
    private String yongdianID;
    private String hexiaoID;
    private String fentanbianhao;
    private String fentanzhuangtai;
    private String fentanquerenzhuangtai;
    private String shfoucunzaiqueren;
    private String dabiaozhuangtai;
    private String shifoucunzaidabiao;
    private String fukuanwanchengshijian;
    private String shenqingren;
    private String fentanwanchengshijian;
    private String chexiaoshijian;
    private String chexiaoren;
    private String tuisongcaiwuzhuangtai;
    private String tuisongcaiwuriqi;
    private String chexiaotuisongcaiwuzhuangtai;
    private String chexiaotuisongcaiwuriqi;
    private String tuisongkehuzhuangtai;
    private String tuisongshijian;
    private String gongdianyonghuhao;
    private String dianbiaobianma;
    private String shifouyezhubaogan;
    private String dianbiaoleixing;

    private String zhanzhibianma;
    private String zhanzhimingc;
    private String shiqi;
    private String zhongqi;
    private String chaobiaoriqi;
    private String qidu;
    private String zhidu;
    private String shifoufuwei;
    private String fuweiqiandushu;
    private String fuweihoudushu;
    private String zengjiandianliang;
    private String beilv;
    private String dianliang;
    private String pingjundanjia;
    private String yongdianjine;
    private String qitajianmian;
    private String zhifujine;
    private String yongdiantianshu;
    private String rijundianliang;
    private String biaoganrijundianliang;
    private String pianlidianliang;
    private String pianlifudu;
    private String shifouyichang;
    private String yichangshuoming;
    private String jiaofeipiaoju;
    private String jiaofeihanshuijine;
    private String jiaofeishuie;
    private String jiaofeibuhanshuijine;
    private String fentanzhanzhi;
    private String zhanzhichaifenbili;
    private String chaifendaozhanjine;

    private String kehu;
    private String kuahangyebianma;
    private String fentanfangshi;
    private String chaifendaofentanfangshijine;
    private String fentanbili;
    private String chaifendaokehujine;

    private String jiesuanmoshi;
    private String chaifendaojiesuanmoshijine;
    private String weicha;
    private String fentanjinebuhanshui;
    private String kaipiaoleix;
    private String shuifujinzi;
    private String fentanjineshui;
    private String fentanjine;
    private  ArrayList<String> names;
    private  String times;
    public static ArrayList<String> getNamelist() {
        ArrayList<String> namelist = new ArrayList<String>() ;
        namelist.add("省");
        namelist.add("市");
        namelist.add("区域");
        namelist.add("支付单号");
        namelist.add("用电明细ID");
        namelist.add("核销明细ID");
        namelist.add("分摊编号");
        namelist.add("分摊状态");
        namelist.add("分摊确认状态");
        namelist.add("同一用电明细是否存在 （不）确认");
        namelist.add("打标状态");
        namelist.add("同一用电明细是否存在已打标");
        namelist.add("付款完成时间");
        namelist.add("申请人");
        namelist.add("分摊完成时间");
        namelist.add("撤销时间");
        namelist.add("撤销人");
        namelist.add("分摊推送财务状态");
        namelist.add("分摊推送财务日期");
        namelist.add("分摊撤销推送财务状态");
        namelist.add("分摊撤销推送财务日期");
        namelist.add("推送客户状态");
        namelist.add("推送时间");
        namelist.add("供电用户号");
        namelist.add("电表编码");
        namelist.add("是否业主包干");
        namelist.add("电表类型");
        namelist.add("站址编码");
        namelist.add("站址名称");
        namelist.add("购电起始日期");
        namelist.add("购电截止日期");
        namelist.add("购电抄表日期");
        namelist.add("购电起始读数");
        namelist.add("购电截止读数");
        namelist.add("是否复位");
        namelist.add("复位前读数");
        namelist.add("复位后读数");
        namelist.add("增减电量（线损或其他）");
        namelist.add("电表倍率");
        namelist.add("用电量");
        namelist.add("平均单价");
        namelist.add("用电金额");
        namelist.add("其他应付或减免金额");
        namelist.add("支付总金额");
        namelist.add("本次用电天数");
        namelist.add("本次日均用电量");
        namelist.add("标杆日均用电量");
        namelist.add("偏离电量");
        namelist.add("偏离幅度(%)");
        namelist.add("是否异常");
        namelist.add("异常说明");
        namelist.add("缴费票据类型");
        namelist.add("缴费含税金额");
        namelist.add("缴费税额");
        namelist.add("缴费不含税金额");
        namelist.add("分摊站址");
        namelist.add("站址拆分比例(%)");
        namelist.add("拆分到站金额");
        namelist.add("客户");
        namelist.add("跨行业业务编码");
        namelist.add("分摊方式");
        namelist.add("拆分到分摊方式金额");
        namelist.add("分摊比例(%)");
        namelist.add("拆分到客户金额");
        namelist.add("结算模式");
        namelist.add("拆分到结算模式金额");
        namelist.add("尾差");
        namelist.add("分摊金额（不含税）");
        namelist.add("开票类型");
        namelist.add("税负因子");
        namelist.add("分摊金额（税负）");
        namelist.add("分摊金额（含税）");


        return namelist;
    }

    public static HashMap<String,String> getNamemap(){
        HashMap<String,String> map =new  HashMap<String,String>();
        map.put("sheng","省");
        map.put("shi","市");
        map.put("quyu","区域");
        map.put("zhifudanhao","支付单号");
        map.put("yongdianID","用电明细ID");
        map.put("hexiaoID","核销明细ID");
        map.put("fentanbianhao","分摊编号");
        map.put("fentanzhuangtai","分摊状态");
        map.put("fentanquerenzhuangtai","分摊确认状态");
        map.put("shfoucunzaiqueren","同一用电明细是否存在 （不）确认");
        map.put("dabiaozhuangtai","打标状态");
        map.put("shifoucunzaidabiao","同一用电明细是否存在已打标");
        map.put("fukuanwanchengshijian","付款完成时间");
        map.put("shenqingren","申请人");
        map.put("fentanwanchengshijian","分摊完成时间");
        map.put("chexiaoshijian","撤销时间");
        map.put("chexiaoren","撤销人");
        map.put("tuisongcaiwuzhuangtai","分摊推送财务状态");
        map.put("tuisongcaiwuriqi","分摊推送财务日期");
        map.put("chexiaotuisongcaiwuzhuangtai","分摊撤销推送财务状态");
        map.put("chexiaotuisongcaiwuriqi","分摊撤销推送财务日期");
        map.put("tuisongkehuzhuangtai","推送客户状态");
        map.put("tuisongshijian","推送时间");
        map.put("gongdianyonghuhao","供电用户号");
        map.put("dianbiaobianma","电表编码");
        map.put("shifouyezhubaogan","是否业主包干");
        map.put("dianbiaoleixing","电表类型");
        map.put("zhanzhibianma","站址编码");
        map.put("zhanzhimingc","站址名称");
        map.put("shiqi","购电起始日期");
        map.put("zhongqi","购电截止日期");
        map.put("chaobiaoriqi","购电抄表日期");
        map.put("qidu","购电起始读数");
        map.put("zhidu","购电截止读数");
        map.put("shifoufuwei","是否复位");
        map.put("fuweiqiandushu","复位前读数");
        map.put("fuweihoudushu","复位后读数");
        map.put("zengjiandianliang","增减电量（线损或其他）");
        map.put("beilv","电表倍率");
        map.put("dianliang","用电量");
        map.put("pingjundanjia","平均单价");
        map.put("yongdianjine","用电金额");
        map.put("qitajianmian","其他应付或减免金额");
        map.put("zhifujine","支付总金额");
        map.put("yongdiantianshu","本次用电天数");
        map.put("rijundianliang","本次日均用电量");
        map.put("biaoganrijundianliang","标杆日均用电量");
        map.put("pianlidianliang","偏离电量");
        map.put("pianlifudu","偏离幅度(%)");
        map.put("shifouyichang","是否异常");
        map.put("yichangshuoming","异常说明");
        map.put("jiaofeipiaoju","缴费票据类型");
        map.put("jiaofeihanshuijine","缴费含税金额");
        map.put("jiaofeishuie","缴费税额");
        map.put("jiaofeibuhanshuijine","缴费不含税金额");
        map.put("fentanzhanzhi","分摊站址");
        map.put("zhanzhichaifenbili","站址拆分比例(%)");
        map.put("chaifendaozhanjine","拆分到站金额");
        map.put("kehu","客户");
        map.put("kuahangyebianma","跨行业业务编码");
        map.put("fentanfangshi","分摊方式");
        map.put("chaifendaofentanfangshijine","拆分到分摊方式金额");
        map.put("fentanbili","分摊比例(%)");
        map.put("chaifendaokehujine","拆分到客户金额");
        map.put("jiesuanmoshi","结算模式");
        map.put("chaifendaojiesuanmoshijine","拆分到结算模式金额");
        map.put("weicha","尾差");
        map.put("fentanjinebuhanshui","分摊金额（不含税）");
        map.put("kaipiaoleix","开票类型");
        map.put("shuifujinzi","税负因子");
        map.put("fentanjineshui","分摊金额（税负）");
        map.put("fentanjine","分摊金额（含税）");
        return map;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSheng() {
        return sheng;
    }

    public void setSheng(String sheng) {
        this.sheng = sheng;
    }

    public String getShi() {
        return shi;
    }

    public void setShi(String shi) {
        this.shi = shi;
    }

    public String getQuyu() {
        return quyu;
    }

    public void setQuyu(String quyu) {
        this.quyu = quyu;
    }

    public String getZhifudanhao() {
        return zhifudanhao;
    }

    public void setZhifudanhao(String zhifudanhao) {
        this.zhifudanhao = zhifudanhao;
    }

    public String getYongdianID() {
        return yongdianID;
    }

    public void setYongdianID(String yongdianID) {
        this.yongdianID = yongdianID;
    }

    public String getHexiaoID() {
        return hexiaoID;
    }

    public void setHexiaoID(String hexiaoID) {
        this.hexiaoID = hexiaoID;
    }

    public String getFentanbianhao() {
        return fentanbianhao;
    }

    public void setFentanbianhao(String fentanbianhao) {
        this.fentanbianhao = fentanbianhao;
    }

    public String getFentanzhuangtai() {
        return fentanzhuangtai;
    }

    public void setFentanzhuangtai(String fentanzhuangtai) {
        this.fentanzhuangtai = fentanzhuangtai;
    }

    public String getFentanquerenzhuangtai() {
        return fentanquerenzhuangtai;
    }

    public void setFentanquerenzhuangtai(String fentanquerenzhuangtai) {
        this.fentanquerenzhuangtai = fentanquerenzhuangtai;
    }

    public String getShfoucunzaiqueren() {
        return shfoucunzaiqueren;
    }

    public void setShfoucunzaiqueren(String shfoucunzaiqueren) {
        this.shfoucunzaiqueren = shfoucunzaiqueren;
    }

    public String getDabiaozhuangtai() {
        return dabiaozhuangtai;
    }

    public void setDabiaozhuangtai(String dabiaozhuangtai) {
        this.dabiaozhuangtai = dabiaozhuangtai;
    }

    public String getShifoucunzaidabiao() {
        return shifoucunzaidabiao;
    }

    public void setShifoucunzaidabiao(String shifoucunzaidabiao) {
        this.shifoucunzaidabiao = shifoucunzaidabiao;
    }

    public String getFukuanwanchengshijian() {
        return fukuanwanchengshijian;
    }

    public void setFukuanwanchengshijian(String fukuanwanchengshijian) {
        this.fukuanwanchengshijian = fukuanwanchengshijian;
    }

    public String getShenqingren() {
        return shenqingren;
    }

    public void setShenqingren(String shenqingren) {
        this.shenqingren = shenqingren;
    }

    public String getFentanwanchengshijian() {
        return fentanwanchengshijian;
    }

    public void setFentanwanchengshijian(String fentanwanchengshijian) {
        this.fentanwanchengshijian = fentanwanchengshijian;
    }

    public String getChexiaoshijian() {
        return chexiaoshijian;
    }

    public void setChexiaoshijian(String chexiaoshijian) {
        this.chexiaoshijian = chexiaoshijian;
    }

    public String getChexiaoren() {
        return chexiaoren;
    }

    public void setChexiaoren(String chexiaoren) {
        this.chexiaoren = chexiaoren;
    }

    public String getTuisongcaiwuzhuangtai() {
        return tuisongcaiwuzhuangtai;
    }

    public void setTuisongcaiwuzhuangtai(String tuisongcaiwuzhuangtai) {
        this.tuisongcaiwuzhuangtai = tuisongcaiwuzhuangtai;
    }

    public String getTuisongcaiwuriqi() {
        return tuisongcaiwuriqi;
    }

    public void setTuisongcaiwuriqi(String tuisongcaiwuriqi) {
        this.tuisongcaiwuriqi = tuisongcaiwuriqi;
    }

    public String getChexiaotuisongcaiwuzhuangtai() {
        return chexiaotuisongcaiwuzhuangtai;
    }

    public void setChexiaotuisongcaiwuzhuangtai(String chexiaotuisongcaiwuzhuangtai) {
        this.chexiaotuisongcaiwuzhuangtai = chexiaotuisongcaiwuzhuangtai;
    }

    public String getChexiaotuisongcaiwuriqi() {
        return chexiaotuisongcaiwuriqi;
    }

    public void setChexiaotuisongcaiwuriqi(String chexiaotuisongcaiwuriqi) {
        this.chexiaotuisongcaiwuriqi = chexiaotuisongcaiwuriqi;
    }

    public String getTuisongkehuzhuangtai() {
        return tuisongkehuzhuangtai;
    }

    public void setTuisongkehuzhuangtai(String tuisongkehuzhuangtai) {
        this.tuisongkehuzhuangtai = tuisongkehuzhuangtai;
    }

    public String getTuisongshijian() {
        return tuisongshijian;
    }

    public void setTuisongshijian(String tuisongshijian) {
        this.tuisongshijian = tuisongshijian;
    }

    public String getGongdianyonghuhao() {
        return gongdianyonghuhao;
    }

    public void setGongdianyonghuhao(String gongdianyonghuhao) {
        this.gongdianyonghuhao = gongdianyonghuhao;
    }

    public String getDianbiaobianma() {
        return dianbiaobianma;
    }

    public void setDianbiaobianma(String dianbiaobianma) {
        this.dianbiaobianma = dianbiaobianma;
    }

    public String getShifouyezhubaogan() {
        return shifouyezhubaogan;
    }

    public void setShifouyezhubaogan(String shifouyezhubaogan) {
        this.shifouyezhubaogan = shifouyezhubaogan;
    }

    public String getDianbiaoleixing() {
        return dianbiaoleixing;
    }

    public void setDianbiaoleixing(String dianbiaoleixing) {
        this.dianbiaoleixing = dianbiaoleixing;
    }

    public String getZhanzhibianma() {
        return zhanzhibianma;
    }

    public void setZhanzhibianma(String zhanzhibianma) {
        this.zhanzhibianma = zhanzhibianma;
    }

    public String getZhanzhimingc() {
        return zhanzhimingc;
    }

    public void setZhanzhimingc(String zhanzhimingc) {
        this.zhanzhimingc = zhanzhimingc;
    }

    public String getShiqi() {
        return shiqi;
    }

    public void setShiqi(String shiqi) {
        this.shiqi = shiqi;
    }

    public String getZhongqi() {
        return zhongqi;
    }

    public void setZhongqi(String zhongqi) {
        this.zhongqi = zhongqi;
    }

    public String getChaobiaoriqi() {
        return chaobiaoriqi;
    }

    public void setChaobiaoriqi(String chaobiaoriqi) {
        this.chaobiaoriqi = chaobiaoriqi;
    }

    public String getQidu() {
        return qidu;
    }

    public void setQidu(String qidu) {
        this.qidu = qidu;
    }

    public String getZhidu() {
        return zhidu;
    }

    public void setZhidu(String zhidu) {
        this.zhidu = zhidu;
    }

    public String getShifoufuwei() {
        return shifoufuwei;
    }

    public void setShifoufuwei(String shifoufuwei) {
        this.shifoufuwei = shifoufuwei;
    }

    public String getFuweiqiandushu() {
        return fuweiqiandushu;
    }

    public void setFuweiqiandushu(String fuweiqiandushu) {
        this.fuweiqiandushu = fuweiqiandushu;
    }

    public String getFuweihoudushu() {
        return fuweihoudushu;
    }

    public void setFuweihoudushu(String fuweihoudushu) {
        this.fuweihoudushu = fuweihoudushu;
    }

    public String getZengjiandianliang() {
        return zengjiandianliang;
    }

    public void setZengjiandianliang(String zengjiandianliang) {
        this.zengjiandianliang = zengjiandianliang;
    }

    public String getBeilv() {
        return beilv;
    }

    public void setBeilv(String beilv) {
        this.beilv = beilv;
    }

    public String getDianliang() {
        return dianliang;
    }

    public void setDianliang(String dianliang) {
        this.dianliang = dianliang;
    }

    public String getPingjundanjia() {
        return pingjundanjia;
    }

    public void setPingjundanjia(String pingjundanjia) {
        this.pingjundanjia = pingjundanjia;
    }

    public String getYongdianjine() {
        return yongdianjine;
    }

    public void setYongdianjine(String yongdianjine) {
        this.yongdianjine = yongdianjine;
    }

    public String getQitajianmian() {
        return qitajianmian;
    }

    public void setQitajianmian(String qitajianmian) {
        this.qitajianmian = qitajianmian;
    }

    public String getZhifujine() {
        return zhifujine;
    }

    public void setZhifujine(String zhifujine) {
        this.zhifujine = zhifujine;
    }

    public String getYongdiantianshu() {
        return yongdiantianshu;
    }

    public void setYongdiantianshu(String yongdiantianshu) {
        this.yongdiantianshu = yongdiantianshu;
    }

    public String getRijundianliang() {
        return rijundianliang;
    }

    public void setRijundianliang(String rijundianliang) {
        this.rijundianliang = rijundianliang;
    }

    public String getBiaoganrijundianliang() {
        return biaoganrijundianliang;
    }

    public void setBiaoganrijundianliang(String biaoganrijundianliang) {
        this.biaoganrijundianliang = biaoganrijundianliang;
    }

    public String getPianlidianliang() {
        return pianlidianliang;
    }

    public void setPianlidianliang(String pianlidianliang) {
        this.pianlidianliang = pianlidianliang;
    }

    public String getPianlifudu() {
        return pianlifudu;
    }

    public void setPianlifudu(String pianlifudu) {
        this.pianlifudu = pianlifudu;
    }

    public String getShifouyichang() {
        return shifouyichang;
    }

    public void setShifouyichang(String shifouyichang) {
        this.shifouyichang = shifouyichang;
    }

    public String getYichangshuoming() {
        return yichangshuoming;
    }

    public void setYichangshuoming(String yichangshuoming) {
        this.yichangshuoming = yichangshuoming;
    }

    public String getJiaofeipiaoju() {
        return jiaofeipiaoju;
    }

    public void setJiaofeipiaoju(String jiaofeipiaoju) {
        this.jiaofeipiaoju = jiaofeipiaoju;
    }

    public String getJiaofeihanshuijine() {
        return jiaofeihanshuijine;
    }

    public void setJiaofeihanshuijine(String jiaofeihanshuijine) {
        this.jiaofeihanshuijine = jiaofeihanshuijine;
    }

    public String getJiaofeishuie() {
        return jiaofeishuie;
    }

    public void setJiaofeishuie(String jiaofeishuie) {
        this.jiaofeishuie = jiaofeishuie;
    }

    public String getJiaofeibuhanshuijine() {
        return jiaofeibuhanshuijine;
    }

    public void setJiaofeibuhanshuijine(String jiaofeibuhanshuijine) {
        this.jiaofeibuhanshuijine = jiaofeibuhanshuijine;
    }

    public String getFentanzhanzhi() {
        return fentanzhanzhi;
    }

    public void setFentanzhanzhi(String fentanzhanzhi) {
        this.fentanzhanzhi = fentanzhanzhi;
    }

    public String getZhanzhichaifenbili() {
        return zhanzhichaifenbili;
    }

    public void setZhanzhichaifenbili(String zhanzhichaifenbili) {
        this.zhanzhichaifenbili = zhanzhichaifenbili;
    }

    public String getChaifendaozhanjine() {
        return chaifendaozhanjine;
    }

    public void setChaifendaozhanjine(String chaifendaozhanjine) {
        this.chaifendaozhanjine = chaifendaozhanjine;
    }

    public String getKehu() {
        return kehu;
    }

    public void setKehu(String kehu) {
        this.kehu = kehu;
    }

    public String getKuahangyebianma() {
        return kuahangyebianma;
    }

    public void setKuahangyebianma(String kuahangyebianma) {
        this.kuahangyebianma = kuahangyebianma;
    }

    public String getFentanfangshi() {
        return fentanfangshi;
    }

    public void setFentanfangshi(String fentanfangshi) {
        this.fentanfangshi = fentanfangshi;
    }

    public String getChaifendaofentanfangshijine() {
        return chaifendaofentanfangshijine;
    }

    public void setChaifendaofentanfangshijine(String chaifendaofentanfangshijine) {
        this.chaifendaofentanfangshijine = chaifendaofentanfangshijine;
    }

    public String getFentanbili() {
        return fentanbili;
    }

    public void setFentanbili(String fentanbili) {
        this.fentanbili = fentanbili;
    }

    public String getChaifendaokehujine() {
        return chaifendaokehujine;
    }

    public void setChaifendaokehujine(String chaifendaokehujine) {
        this.chaifendaokehujine = chaifendaokehujine;
    }

    public String getJiesuanmoshi() {
        return jiesuanmoshi;
    }

    public void setJiesuanmoshi(String jiesuanmoshi) {
        this.jiesuanmoshi = jiesuanmoshi;
    }

    public String getChaifendaojiesuanmoshijine() {
        return chaifendaojiesuanmoshijine;
    }

    public void setChaifendaojiesuanmoshijine(String chaifendaojiesuanmoshijine) {
        this.chaifendaojiesuanmoshijine = chaifendaojiesuanmoshijine;
    }

    public String getWeicha() {
        return weicha;
    }

    public void setWeicha(String weicha) {
        this.weicha = weicha;
    }

    public String getFentanjinebuhanshui() {
        return fentanjinebuhanshui;
    }

    public void setFentanjinebuhanshui(String fentanjinebuhanshui) {
        this.fentanjinebuhanshui = fentanjinebuhanshui;
    }

    public String getKaipiaoleix() {
        return kaipiaoleix;
    }

    public void setKaipiaoleix(String kaipiaoleix) {
        this.kaipiaoleix = kaipiaoleix;
    }

    public String getShuifujinzi() {
        return shuifujinzi;
    }

    public void setShuifujinzi(String shuifujinzi) {
        this.shuifujinzi = shuifujinzi;
    }

    public String getFentanjineshui() {
        return fentanjineshui;
    }

    public void setFentanjineshui(String fentanjineshui) {
        this.fentanjineshui = fentanjineshui;
    }

    public String getFentanjine() {
        return fentanjine;
    }

    public void setFentanjine(String fentanjine) {
        this.fentanjine = fentanjine;
    }


    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", sheng='" + sheng + '\'' +
                ", shi='" + shi + '\'' +
                ", quyu='" + quyu + '\'' +
                ", zhifudanhao='" + zhifudanhao + '\'' +
                ", yongdianID='" + yongdianID + '\'' +
                ", hexiaoID='" + hexiaoID + '\'' +
                ", fentanbianhao='" + fentanbianhao + '\'' +
                ", fentanzhuangtai='" + fentanzhuangtai + '\'' +
                ", fentanquerenzhuangtai='" + fentanquerenzhuangtai + '\'' +
                ", shfoucunzaiqueren='" + shfoucunzaiqueren + '\'' +
                ", dabiaozhuangtai='" + dabiaozhuangtai + '\'' +
                ", shifoucunzaidabiao='" + shifoucunzaidabiao + '\'' +
                ", fukuanwanchengshijian='" + fukuanwanchengshijian + '\'' +
                ", shenqingren='" + shenqingren + '\'' +
                ", fentanwanchengshijian='" + fentanwanchengshijian + '\'' +
                ", chexiaoshijian='" + chexiaoshijian + '\'' +
                ", chexiaoren='" + chexiaoren + '\'' +
                ", tuisongcaiwuzhuangtai='" + tuisongcaiwuzhuangtai + '\'' +
                ", tuisongcaiwuriqi='" + tuisongcaiwuriqi + '\'' +
                ", chexiaotuisongcaiwuzhuangtai='" + chexiaotuisongcaiwuzhuangtai + '\'' +
                ", chexiaotuisongcaiwuriqi='" + chexiaotuisongcaiwuriqi + '\'' +
                ", tuisongkehuzhuangtai='" + tuisongkehuzhuangtai + '\'' +
                ", tuisongshijian='" + tuisongshijian + '\'' +
                ", gongdianyonghuhao='" + gongdianyonghuhao + '\'' +
                ", dianbiaobianma='" + dianbiaobianma + '\'' +
                ", shifouyezhubaogan='" + shifouyezhubaogan + '\'' +
                ", dianbiaoleixing='" + dianbiaoleixing + '\'' +
                ", zhanzhibianma='" + zhanzhibianma + '\'' +
                ", zhanzhimingc='" + zhanzhimingc + '\'' +
                ", shiqi='" + shiqi + '\'' +
                ", zhongqi='" + zhongqi + '\'' +
                ", chaobiaoriqi='" + chaobiaoriqi + '\'' +
                ", qidu='" + qidu + '\'' +
                ", zhidu='" + zhidu + '\'' +
                ", shifoufuwei='" + shifoufuwei + '\'' +
                ", fuweiqiandushu='" + fuweiqiandushu + '\'' +
                ", fuweihoudushu='" + fuweihoudushu + '\'' +
                ", zengjiandianliang='" + zengjiandianliang + '\'' +
                ", beilv='" + beilv + '\'' +
                ", dianliang='" + dianliang + '\'' +
                ", pingjundanjia='" + pingjundanjia + '\'' +
                ", yongdianjine='" + yongdianjine + '\'' +
                ", qitajianmian='" + qitajianmian + '\'' +
                ", zhifujine='" + zhifujine + '\'' +
                ", yongdiantianshu='" + yongdiantianshu + '\'' +
                ", rijundianliang='" + rijundianliang + '\'' +
                ", biaoganrijundianliang='" + biaoganrijundianliang + '\'' +
                ", pianlidianliang='" + pianlidianliang + '\'' +
                ", pianlifudu='" + pianlifudu + '\'' +
                ", shifouyichang='" + shifouyichang + '\'' +
                ", yichangshuoming='" + yichangshuoming + '\'' +
                ", jiaofeipiaoju='" + jiaofeipiaoju + '\'' +
                ", jiaofeihanshuijine='" + jiaofeihanshuijine + '\'' +
                ", jiaofeishuie='" + jiaofeishuie + '\'' +
                ", jiaofeibuhanshuijine='" + jiaofeibuhanshuijine + '\'' +
                ", fentanzhanzhi='" + fentanzhanzhi + '\'' +
                ", zhanzhichaifenbili='" + zhanzhichaifenbili + '\'' +
                ", chaifendaozhanjine='" + chaifendaozhanjine + '\'' +
                ", kehu='" + kehu + '\'' +
                ", kuahangyebianma='" + kuahangyebianma + '\'' +
                ", fentanfangshi='" + fentanfangshi + '\'' +
                ", chaifendaofentanfangshijine='" + chaifendaofentanfangshijine + '\'' +
                ", fentanbili='" + fentanbili + '\'' +
                ", chaifendaokehujine='" + chaifendaokehujine + '\'' +
                ", jiesuanmoshi='" + jiesuanmoshi + '\'' +
                ", chaifendaojiesuanmoshijine='" + chaifendaojiesuanmoshijine + '\'' +
                ", weicha='" + weicha + '\'' +
                ", fentanjinebuhanshui='" + fentanjinebuhanshui + '\'' +
                ", kaipiaoleix='" + kaipiaoleix + '\'' +
                ", shuifujinzi='" + shuifujinzi + '\'' +
                ", fentanjineshui='" + fentanjineshui + '\'' +
                ", fentanjine='" + fentanjine + '\'' +
                ", names=" + names +
                '}';
    }
}
