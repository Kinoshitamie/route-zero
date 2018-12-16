package com.example.kinop_bss;

	import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
@Controller
public class HomeController {
	@Autowired
    private MessageService messageService;
	private String  str;

  @RequestMapping(value="/")
  public String index(ModelMap modelMap) {

	  List<Message> messages = messageService.findAll();
	  modelMap.addAttribute("messages", messages);
	  return "kinop_bbs";
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public String create(@ModelAttribute MessageForm messageForm, ModelMap modelMap) {

    Message message = new Message();
    message.name = messageForm.getName();
   if(message.name=="aaa") {//ここで判定しない・・・
	   str="bb";
	    modelMap.addAttribute("errMess", str);
	   return "kinop_bbs";

    }else {

    message.title = messageForm.getTitle();
    message.comment = messageForm.getComment();
    messageService.save(message);

    return "redirect:/";  //RequestMappingに移動する
    }

}
  @RequestMapping(value="/",params="b_edit",method=RequestMethod.POST)
  String b_edit(){
	  //更新処理
	  return "kinop_bbs";
  }
  @RequestMapping(value="/",params= "b_delete",method=RequestMethod.POST)
  String b_delete(){
	  	//削除処理
	  return "kinop_bbs";
  }
  @GetMapping("/kinop_bbs")
  public String errMess(ModelMap modelMap) {
	  //エラー処理
	  modelMap.addAttribute("errMess", "err");
	  return "kinop_bbs";
  }

}