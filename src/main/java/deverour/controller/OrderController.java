package deverour.controller;

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
@RequestMapping("/bills")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/fileupload")
    public String fileupload(HttpServletRequest request, MultipartFile upload, HttpSession httpSession) throws Exception {
        System.out.println("------------------------");
        System.out.println("fileupload.run");
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
        orderService.saveOrder(filepath);
        System.out.println("上传成功");
        System.out.println();
        return "<a href=\"/bills/list.html\">上传成功,点击返回菜单列表</a>";

    }

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

    @RequestMapping("/findbychecklist")
    public ResponseEntity<byte[]> findByList(HttpServletRequest request, HttpSession httpSession) throws Exception {
        System.out.println("------------------------");
        System.out.println("表现层：自定义查询");
        String[] checklist = request.getParameterValues("checkbox");
        String startTime=request.getParameter("startyear")+"-"+request.getParameter("startmonth");
        String endTime=request.getParameter("endyear")+"-"+request.getParameter("endmonth");
        System.out.println("startTime:"+startTime);
        System.out.println("endTime:"+endTime);
        String timeList = Utils.getTimeList(startTime,endTime);
        InputStream is = orderService.findByList(checklist,timeList);
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
