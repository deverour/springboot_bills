package deverour.controller;

import deverour.domain.RequestData;
import deverour.domain.User;
import deverour.myutils.Utils;
import deverour.service.OrderService;
import deverour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.InputStream;
import java.util.UUID;

@Controller
@ResponseBody
@RequestMapping("/order")
public class OrderController {

    public static final String UPLOAD_PATH = "D:\\SystemInfo\\logs\\order_upload";

    @Autowired
    private OrderService orderService;

    @RequestMapping("/fileupload")
    public String fileupload(HttpServletRequest request, MultipartFile upload, HttpSession httpSession) throws Exception {
        System.out.println("------------------------");
        System.out.println("fileupload.run");
        //String path = request.getSession().getServletContext().getRealPath("/uploads");
        File file = new File(UPLOAD_PATH);
        if(!file.exists()){
            file.mkdir();
        }
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid+"-"+filename;
        upload.transferTo(new File(UPLOAD_PATH,filename));
        String filepath = file.getPath()+"\\"+filename;
        orderService.saveOrder(filepath);
        System.out.println("上传成功");
        System.out.println();
        return "<a href=\"/bills/list.html\">上传成功,点击返回菜单列表</a>";

    }

  /*  public Message updatesaomiaoname(HttpServletRequest request,@RequestParam("file") MultipartFile upload,String kaipiaobianhao) throws Exception {
        System.out.println("------------------------");
        System.out.println("BillController.updatesaomiaoname.run()");
        Reback reback=new Reback();
        Message message = new Message();
        String saomiaoname = Utils.getRealName(upload.getOriginalFilename());
        saomiaoname = Utils.addUUID(saomiaoname,kaipiaobianhao);
        upload.transferTo(new File(SCANPATH,saomiaoname));
        reback.setKaipiaobianhao(kaipiaobianhao);
        reback.setIssaomiao("是");
        reback.setSaomiaoname(saomiaoname);
        billService.updatesaomiaoname(reback);
        message.setMsg("上传成功");

        return message;
    }*/

    @RequestMapping("/fileupdata")
    public String v(HttpServletRequest request, MultipartFile upload, HttpSession httpSession) throws Exception {
        System.out.println("------------------------");
        System.out.println("fileupdata.run");
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid+"-"+filename;
        upload.transferTo(new File(path,filename));
        String filepath = file.getPath()+"\\"+filename;
        orderService.updataOrder(filepath);
        System.out.println("更新成功");

        System.out.println();
        return "<a href=\"/bills/list.html\">更新成功,点击返回菜单列表</a>";

    }

    @RequestMapping("/export")
    public ResponseEntity<byte[]> findByList(HttpServletRequest request) throws Exception {
        System.out.println("------------------------");
        System.out.println("表现层：自定义查询");

        RequestData requestData = new RequestData();
        String[] titles = request.getParameterValues("checkbox");
        String paystartyear = request.getParameter("paystartyear");
        String paystartmonth = request.getParameter("paystartmonth");
        String payendyear = request.getParameter("payendyear");
        String payendmonth = request.getParameter("payendmonth");
        String fentanstartyear = request.getParameter("fentanstartyear");
        String fentanstartmonth = request.getParameter("fentanstartmonth");
        String fentanendyear = request.getParameter("fentanendyear");
        String fentanendmonth = request.getParameter("fentanendmonth");
        String fengongsi = request.getParameter("fengongsi");
        String kehu = request.getParameter("kehu");
        String jiesuanmoshi = request.getParameter("jiesuanmoshi");
        requestData.setTitles(titles);

        requestData.setPaystartyear(paystartyear);
        requestData.setPaystartmonth(paystartmonth);
        requestData.setPayendyear(payendyear);
        requestData.setPayendmonth(payendmonth);

        requestData.setFentanstartyear(fentanstartyear);
        requestData.setFentanstartmonth(fentanstartmonth);
        requestData.setFentanendyear(fentanendyear);
        requestData.setFentanendmonth(fentanendmonth);

        requestData.setFengongsi(fengongsi);
        requestData.setKehu(kehu);
        requestData.setJiesuanmoshi(jiesuanmoshi);
        System.out.println(requestData);
        InputStream is = orderService.findByConditions(requestData);



        //InputStream is = orderService.findByList(checklist,timeList);
        byte[] body = null;
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + "fentanzhangdan.xlsx");
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<>(body, headers, statusCode);
        System.out.println("查询成功,开始下载");

        System.out.println();
        return entity;

    }




}
