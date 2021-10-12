package com.nextLevel.hero.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/error")
public class CommonController {
	
	@GetMapping("/403")
	public String deniedPage() {
		return "error/403";							//권한 없음
	}
	
	@GetMapping("/loginError")
	public ModelAndView loginError(ModelAndView mv, RedirectAttributes rttr) {
		
		rttr.addFlashAttribute("failedMessage", "아이디가 존재하지 않거나 비밀번호가 일치하지 않습니다.");
		
		mv.setViewName("redirect:/member/login");
		return mv;							//권한 없음
	}
	
}
