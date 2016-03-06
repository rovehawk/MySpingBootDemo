package com.example;

import java.io.Reader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;

import org.codehaus.jackson.map.annotate.JsonView;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.portlet.ModelAndView;

@SpringBootApplication
@RestController
public class DemoApplication {
	
	@Value("${project.user.name}")
	String name;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@RequestMapping("/t1")
	Map t3(Model m, @ModelAttribute("username") String m2, ModelMap m3){
		
		Map mm = new HashMap();
		mm.put("name","haoyongfeng");
		mm.put("age",39);
		return mm;
	}
	
	@RequestMapping("/t2")
	@ResponseBody
	String t4(String name, @ModelAttribute("name2") String name2,
			Model m){
		
		name = "hao";
		m.addAttribute("username","rovehawk");
		return "Hello, World!";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Callable<String> processUpload(final MultipartFile file) {

	    return new Callable<String>() {
	        public String call() throws Exception {
	            // ...
	            return "someView";
	        }
	    };

	}
	
	
	
	String getName(){
		return "haoyongfeng";
	}
	
}
