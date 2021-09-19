package com.nextLevel.hero.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class CommonController {
	
	@GetMapping("/403")
	public String deniedPage() {
		return "error/403";							//권한 없음
	}
	
}
