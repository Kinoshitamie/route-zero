package com.example.kinop_bss;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	@Autowired
	private MessageService messageService;

	@RequestMapping(value = "/")
	public String index(ModelMap modelMap) {
		List<Message> messages = messageService.findAll(new Sort(Sort.Direction.DESC, "id"));
		modelMap.addAttribute("messages", messages);
		return "kinop_bbs";
	}

	/*
	 * @RequestMapping(value = "messages/{id}")
	 * public String kinopedit(@ModelAttribute MessageForm messageForm,@RequestParam("id")Long
	 * id,ModelMap modelMap) {
	 * Message message = new Message();
	 * messageService.findOne(id);
	 * message.title = messageForm.getTitle();
	 * return "kinop_edit"; }
	 */
// 編集画面に行く時はaタグ、buttonタグ等を使ってGETでリクエストしてい
	@PostMapping("/kinop_edit")
	public String kinopedit(@ModelAttribute MessageForm messageForm, @RequestParam("id") Long id) {
		Message message = new Message();
		messageService.findOne(id);
		// message.id = messageForm.getId();
		message.title = messageForm.getTitle();
		return "kinop_edit";
	}

	@RequestMapping(value = "messages/{id}", method = RequestMethod.DELETE)
	public String destroy(@PathVariable Long id, ModelMap modelMap) {
		messageService.delete(id);
		modelMap.addAttribute("errMess", "削除しました");
		return "kinop_mess";
	}

	@RequestMapping(value = "/kinop_mess")
	public String mess(ModelMap modelMap) {
		List<Message> messages = messageService.findAll(new Sort(Sort.Direction.DESC, "id"));
		modelMap.addAttribute("messages", messages);
		return "kinop_mess";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String create(@ModelAttribute MessageForm messageForm, ModelMap modelMap) {
		Message message = new Message();
		message.name = messageForm.getName();
		if (message.name == null || message.name.isEmpty()) {
			modelMap.addAttribute("errMess", "name入力エラー");
			return "kinop_mess";
		} else {
			message.title = messageForm.getTitle();
			message.comment = messageForm.getComment();
			messageService.save(message);
			return "redirect:/"; // RequestMappingに移動する
		}
	}

	/*@RequestMapping(value = "/", params = "b_edit", method = RequestMethod.POST)
	void getOne(String id) {
	}*/
}