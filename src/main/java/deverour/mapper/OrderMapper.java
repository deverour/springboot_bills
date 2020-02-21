package deverour.mapper;
import deverour.domain.Order;
import deverour.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    @Select("select * from orderinfo2")
    public List<Order> findAll();



  /*  @Select("<script> select <foreach item='item' collection='names' " +
            "open='' separator=',' close='from orderinfo2 WHERE fukuanwanchengshijian REGEXP #{times} '> ${item} </foreach> </script>")
    public List<Order> findByList(Order order);*/

    @Select("<script> select <foreach item='item' collection='names' open='' separator=',' close='from orderinfo2 WHERE  1=1 '> ${item} </foreach>" +
            "<if test='shi != \"all\"'>"+
            "and shi REGEXP #{shi} </if> "+
            "<if test='jiesuanmoshi != \"all\"'>"+
            "and jiesuanmoshi REGEXP #{jiesuanmoshi} </if> "+
            "<if test='kehu != \"all\"'>"+
            "and kehu REGEXP #{kehu} </if> "+
            "and fukuanwanchengshijian REGEXP #{paytimes} and fentanwanchengshijian REGEXP #{fentantimes} </script>")
    public List<Order> findByConditions(Order order);

    /*@Select("<script> select * from rebacks where 1=1" +
            "<if test='zhangtimes != null'>"+
            "and zhangqi REGEXP #{zhangtimes} </if> "+
            "<if test='startDate != null'>"+
            "and huikuanriqi >= #{startDate} and #{endDate}>= huikuanriqi </if> "+
            "<if test='kaipiaobianhao != null'>" +
            "and kaipiaobianhao REGEXP #{kaipiaobianhao} </if> "+
            "and quyu REGEXP #{quyus} and yunyingshang REGEXP #{kehus} and issaomiao REGEXP #{issaomiaos} and ishuikuan REGEXP #{ishuikuans}"+
            "</script>")
    public List<Reback> findrebacks(Reback reback);*/

    @Insert("insert IGNORE into orderinfo2 (id,sheng,shi,quyu,zhifudanhao,yongdianID,hexiaoID,fentanbianhao,fentanzhuangtai,fentanquerenzhuangtai,shfoucunzaiqueren,dabiaozhuangtai,shifoucunzaidabiao,fukuanwanchengshijian,shenqingren,fentanwanchengshijian,chexiaoshijian,chexiaoren,tuisongcaiwuzhuangtai,tuisongcaiwuriqi,chexiaotuisongcaiwuzhuangtai,chexiaotuisongcaiwuriqi,tuisongkehuzhuangtai,tuisongshijian,gongdianyonghuhao,dianbiaobianma,shifouyezhubaogan,dianbiaoleixing,zhanzhibianma,zhanzhimingc,shiqi,zhongqi,chaobiaoriqi,qidu,zhidu,shifoufuwei,fuweiqiandushu,fuweihoudushu,zengjiandianliang,beilv,dianliang,pingjundanjia,yongdianjine,qitajianmian,zhifujine,yongdiantianshu,rijundianliang,biaoganrijundianliang,pianlidianliang,pianlifudu,shifouyichang,yichangshuoming,jiaofeipiaoju,jiaofeihanshuijine,jiaofeishuie,jiaofeibuhanshuijine,fentanzhanzhi,zhanzhichaifenbili,chaifendaozhanjine,kehu,kuahangyebianma,fentanfangshi,chaifendaofentanfangshijine,fentanbili,chaifendaokehujine,jiesuanmoshi,chaifendaojiesuanmoshijine,weicha,fentanjinebuhanshui,kaipiaoleix,shuifujinzi,fentanjineshui,fentanjine) values (#{id},#{sheng},#{shi},#{quyu},#{zhifudanhao},#{yongdianID},#{hexiaoID},#{fentanbianhao},#{fentanzhuangtai},#{fentanquerenzhuangtai},#{shfoucunzaiqueren},#{dabiaozhuangtai},#{shifoucunzaidabiao},#{fukuanwanchengshijian},#{shenqingren},#{fentanwanchengshijian},#{chexiaoshijian},#{chexiaoren},#{tuisongcaiwuzhuangtai},#{tuisongcaiwuriqi},#{chexiaotuisongcaiwuzhuangtai},#{chexiaotuisongcaiwuriqi},#{tuisongkehuzhuangtai},#{tuisongshijian},#{gongdianyonghuhao},#{dianbiaobianma},#{shifouyezhubaogan},#{dianbiaoleixing},#{zhanzhibianma},#{zhanzhimingc},#{shiqi},#{zhongqi},#{chaobiaoriqi},#{qidu},#{zhidu},#{shifoufuwei},#{fuweiqiandushu},#{fuweihoudushu},#{zengjiandianliang},#{beilv},#{dianliang},#{pingjundanjia},#{yongdianjine},#{qitajianmian},#{zhifujine},#{yongdiantianshu},#{rijundianliang},#{biaoganrijundianliang},#{pianlidianliang},#{pianlifudu},#{shifouyichang},#{yichangshuoming},#{jiaofeipiaoju},#{jiaofeihanshuijine},#{jiaofeishuie},#{jiaofeibuhanshuijine},#{fentanzhanzhi},#{zhanzhichaifenbili},#{chaifendaozhanjine},#{kehu},#{kuahangyebianma},#{fentanfangshi},#{chaifendaofentanfangshijine},#{fentanbili},#{chaifendaokehujine},#{jiesuanmoshi},#{chaifendaojiesuanmoshijine},#{weicha},#{fentanjinebuhanshui},#{kaipiaoleix},#{shuifujinzi},#{fentanjineshui},#{fentanjine})")
    public int saveOrder(Order order);

    @Insert("update orderinfo2 set sheng=#{sheng},shi=#{shi},quyu=#{quyu},zhifudanhao=#{zhifudanhao},yongdianID=#{yongdianID},hexiaoID=#{hexiaoID},fentanbianhao=#{fentanbianhao},fentanzhuangtai=#{fentanzhuangtai},fentanquerenzhuangtai=#{fentanquerenzhuangtai},shfoucunzaiqueren=#{shfoucunzaiqueren},dabiaozhuangtai=#{dabiaozhuangtai},shifoucunzaidabiao=#{shifoucunzaidabiao},fukuanwanchengshijian=#{fukuanwanchengshijian},shenqingren=#{shenqingren},fentanwanchengshijian=#{fentanwanchengshijian},chexiaoshijian=#{chexiaoshijian},chexiaoren=#{chexiaoren},tuisongcaiwuzhuangtai=#{tuisongcaiwuzhuangtai},tuisongcaiwuriqi=#{tuisongcaiwuriqi},chexiaotuisongcaiwuzhuangtai=#{chexiaotuisongcaiwuzhuangtai},chexiaotuisongcaiwuriqi=#{chexiaotuisongcaiwuriqi},tuisongkehuzhuangtai=#{tuisongkehuzhuangtai},tuisongshijian=#{tuisongshijian},gongdianyonghuhao=#{gongdianyonghuhao},dianbiaobianma=#{dianbiaobianma},shifouyezhubaogan=#{shifouyezhubaogan},dianbiaoleixing=#{dianbiaoleixing},zhanzhibianma=#{zhanzhibianma},zhanzhimingc=#{zhanzhimingc},shiqi=#{shiqi},zhongqi=#{zhongqi},chaobiaoriqi=#{chaobiaoriqi},qidu=#{qidu},zhidu=#{zhidu},shifoufuwei=#{shifoufuwei},fuweiqiandushu=#{fuweiqiandushu},fuweihoudushu=#{fuweihoudushu},zengjiandianliang=#{zengjiandianliang},beilv=#{beilv},dianliang=#{dianliang},pingjundanjia=#{pingjundanjia},yongdianjine=#{yongdianjine},qitajianmian=#{qitajianmian},zhifujine=#{zhifujine},yongdiantianshu=#{yongdiantianshu},rijundianliang=#{rijundianliang},biaoganrijundianliang=#{biaoganrijundianliang},pianlidianliang=#{pianlidianliang},pianlifudu=#{pianlifudu},shifouyichang=#{shifouyichang},yichangshuoming=#{yichangshuoming},jiaofeipiaoju=#{jiaofeipiaoju},jiaofeihanshuijine=#{jiaofeihanshuijine},jiaofeishuie=#{jiaofeishuie},jiaofeibuhanshuijine=#{jiaofeibuhanshuijine},fentanzhanzhi=#{fentanzhanzhi},zhanzhichaifenbili=#{zhanzhichaifenbili},chaifendaozhanjine=#{chaifendaozhanjine},kehu=#{kehu},kuahangyebianma=#{kuahangyebianma},fentanfangshi=#{fentanfangshi},chaifendaofentanfangshijine=#{chaifendaofentanfangshijine},fentanbili=#{fentanbili},chaifendaokehujine=#{chaifendaokehujine},jiesuanmoshi=#{jiesuanmoshi},chaifendaojiesuanmoshijine=#{chaifendaojiesuanmoshijine},weicha=#{weicha},fentanjinebuhanshui=#{fentanjinebuhanshui},kaipiaoleix=#{kaipiaoleix},shuifujinzi=#{shuifujinzi},fentanjineshui=#{fentanjineshui},fentanjine=#{fentanjine} where id=#{id}")
    public int updataOrder(Order order);

    @Select("select * from user where username=${userName}")
    public List<User> findPassWord(User user);
}
