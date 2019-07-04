package com.eksad.latihanspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	@ResponseBody
	public String sayHello() {
		return "Halo Dunia java";
	}
	
	@RequestMapping("/myName")
	@ResponseBody
	public String myName(@RequestParam String myName) {
		return "HAAAII  "+ myName ;
	}
	
	@RequestMapping("/namaku/{myName}")
	@ResponseBody
	public String namaku(@PathVariable String myName) {
		return "HAAAII  "+ myName ;
	}
	
	@RequestMapping("/toGoogle")
	@ResponseBody
	public String toGoogle() {
		return "<a href='https://www.google.com'> Klik disini menuju Google ya Boss </a> ";
	}
	
	@RequestMapping("/toHiburan")
	@ResponseBody
	public String toHiburan() {
		return "<a href='https://www.youtube.com/watch?v=ojhZOKQnREM&t=0s' target='_blank'> Klik disini menuju Pengen Siaran ya Boss </a> "
				+ "</br> <a href='https://www.youtube.com/watch?v=vUFhOszhc1U\r\n'  target='_blank'> Klik Disini untuk liat mobil </a>"  
				;
	}

	
}
