package springmvc.controller;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import springmvc.model.ImageData;
import springmvc.model.Person;
import springmvc.model.PersonInfo;
import springmvc.service.ImageDataService;
import springmvc.service.PersonInfoService;
import springmvc.service.PersonService;
import springmvc.serviceimpl.ImageDataServiceImpl;
import springmvc.zxing.ZxingManager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/Test/*")
public class TestController {

    @Autowired
    private  HttpServletRequest request;

    @Resource
    private PersonService personService;

    @Resource
    private PersonInfoService personInfoService;

    @Resource
    private ImageDataService imageDataService;

    //访问地址：http://localhost:8080/Test/returnSuccess
    @RequestMapping(value = "returnSuccess")    //实际访问的url地址
    public String returnSuccess() {
        System.out.println("进入");
        return "success";    //返回Views文件夹下的success.jsp页面
    }

    //访问地址：http://localhost:8080/Test/returnString
    @RequestMapping(value = "returnString", produces = {"text/plain;charset=UTF-8"}, method = {RequestMethod.GET})
    //produces用于解决返回中文乱码问题，application/json;为json解决中文乱码
    @ResponseBody       //用于返回字符串,不写即返回视图
    public String returnString(@RequestParam("code") String code) {
        return "hello return string 这是中文，并没有乱码" + code;
    }


    //访问地址：http://localhost:8080/Test/foreachmodel
    @RequestMapping(value = "foreachmodel", method = {RequestMethod.GET})
    public ModelAndView returnModelData() {

        List<Person> persons = this.personService.selectAllPerson();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("persons", persons);
        modelAndView.setViewName("foreachitem");

        return modelAndView;
    }


    //访问地址：http://localhost:8080/Test/getPersonInfo?id=1
    @RequestMapping(value = "getPersonInfo")
    public ModelAndView getPersonInfo(@RequestParam("id") int id) {

        PersonInfo personInfo = personInfoService.getPersonInfo(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("personInfo", personInfo);
        modelAndView.setViewName("personInfoView");

        return modelAndView;
    }


    //文件上传地址:http://localhost:8080/Test/updateImage
    @RequestMapping(value = "updateImage", method = {RequestMethod.POST})
    public ModelAndView updateImage(@RequestParam("imageFile") MultipartFile imageFile, HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();

        if (!imageFile.isEmpty()) {
            String relativePath = "/img/" + imageFile.getOriginalFilename();
            String imagePath = request.getSession().getServletContext().getRealPath("/") + "WEB-INF" + relativePath;

            try {
                imageFile.transferTo(new File(imagePath));
            } catch (IOException e) {
                e.printStackTrace();
            }

            ImageData imageData = new ImageData();
            imageData.setImagepath(relativePath);

            imageDataService.insertSelective(imageData);

            List<ImageData> imageDatas = imageDataService.selectAllImage();
           // String basePath = "http://localhost:8080";
            for (ImageData data : imageDatas) {
                System.out.println(data.getImagepath());
            }

            modelAndView.addObject("imageDatas", imageDatas);
          //  modelAndView.addObject("basePath", basePath);
            modelAndView.setViewName("imagesDisplay");
            return modelAndView;
        } else {
            modelAndView.setViewName("error");
            return modelAndView;
        }

    }

    //获取所有图片:http://localhost:8080/Test/getAllPhotos
    @RequestMapping(value = "getAllPhotos", method = {RequestMethod.GET})
    public ModelAndView getAllPhotos(@ModelAttribute("person") Person person) {

        ModelAndView modelAndView = new ModelAndView();
        System.out.println(person.toString());

        List<ImageData> imageDatas = imageDataService.selectAllImage();
       // String basePath = "http://localhost:8080";
        for (ImageData data : imageDatas) {
            System.out.println(data.getImagepath());
        }

        modelAndView.addObject("imageDatas", imageDatas);
        modelAndView.setViewName("imagesDisplay");
        return modelAndView;
    }


    //获取所有图片:http://localhost:8080/Test/getMusic
    @RequestMapping(value = "getMusic", method = {RequestMethod.GET})
    public ModelAndView getMusic() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("musicPath", "/img/张雨生-最爱的人伤我最深.mp3");
        modelAndView.setViewName("musicPlay");

        return modelAndView;
    }

    //获取所有图片:http://localhost:8080/Test/getZxing?imageInfo=123456
    @RequestMapping(value = "getZxing", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView getZxing(@RequestParam("imageInfo") String imageInfo) {

        ModelAndView modelAndView = new ModelAndView();
        String realPath = request.getSession().getServletContext().getRealPath("/");
        String imagePath = realPath+"/WEB-INF/img/zxing.png";
        modelAndView.addObject("imagePath",  ZxingManager.createQRcode(imageInfo,imagePath));
        modelAndView.setViewName("ImagePlay");

        return modelAndView;
    }


    //获取所有图片:http://localhost:8080/Test/getZxingImage?imageInfo=123456
    @ResponseBody
    @RequestMapping(value = "getZxingImage", method = {RequestMethod.POST,RequestMethod.GET})
    public String getZxingImage(@RequestParam("imageInfo") String imageInfo) {

        String path = null;
        String realPath = request.getSession().getServletContext().getRealPath("/");
        String imagePath = realPath+"/WEB-INF/img/zxing.png";

        path = ZxingManager.createQRcode(imageInfo,imagePath);

        return path;
    }


}
