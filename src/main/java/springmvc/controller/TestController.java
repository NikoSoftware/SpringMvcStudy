package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springmvc.model.Person;
import springmvc.service.PersonService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/Test/*")
public class TestController {

    @Resource
    private PersonService personService;

    //访问地址：http://localhost:8080/Test/returnSuccess
    @RequestMapping(value = "returnSuccess")    //实际访问的url地址
    public String returnSuccess() {
        System.out.println("进入");
        return "success";    //返回Views文件夹下的success.jsp页面
    }

    //访问地址：http://localhost:8080/Test/returnString
    @RequestMapping(value = "returnString", produces = {"text/plain;charset=UTF-8"},method = {RequestMethod.GET})
    //produces用于解决返回中文乱码问题，application/json;为json解决中文乱码
    @ResponseBody       //用于返回字符串,不写即返回视图
    public String returnString(@RequestParam("code") String code) {
        return "hello return string 这是中文，并没有乱码"+code;
    }


    //访问地址：http://localhost:8080/Test/foreachmodel
    @RequestMapping(value = "foreachmodel" ,method = {RequestMethod.GET})
    public ModelAndView returnModelData(){

        List<Person> persons = this.personService.selectAllPerson();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("persons",persons);
        modelAndView.setViewName("foreachitem");

        return modelAndView;
    }




}
