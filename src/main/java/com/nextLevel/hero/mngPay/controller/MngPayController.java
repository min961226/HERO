package com.nextLevel.hero.mngPay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nextLevel.hero.member.model.dto.UserImpl;
import com.nextLevel.hero.mngPay.model.dto.MngPayDTO;
import com.nextLevel.hero.mngPay.model.dto.MngPayListDTO;
import com.nextLevel.hero.mngPay.model.service.MngPayService;
import com.nextLevel.hero.mngSalary.model.dto.SalaryAndBonusDTO;

@Controller
@RequestMapping("/mngPay")
public class MngPayController {

	private final MngPayService mngPayService;
	
	@Autowired
	public MngPayController(MngPayService mngPayService) {
		this.mngPayService = mngPayService;
	}
	
	
	/* 급상여 지급 리스트 조회 */
	@GetMapping("/paySalaryAndBonus")
	public ModelAndView mngPaySalaryAndBonus (ModelAndView mv, @AuthenticationPrincipal UserImpl user, MngPayDTO search) {
		
		search.setCompanyNo(user.getCompanyNo());
		
		List<MngPayDTO> confirmPayList = mngPayService.selectPayList(search);
		
		mv.addObject("confirmPayList", confirmPayList);
		mv.setViewName("mngPay/paySalaryAndBonus");
		
		System.out.println("controller 완 : "+confirmPayList);
		return mv;
	}
	
	/* 급상여 지급 승인 */
	@PostMapping(value="paySalAndBonusConfirm", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String updateSalAndBonusConfirm(@AuthenticationPrincipal UserImpl user, SalaryAndBonusDTO update) {
		
		update.setCompanyNo(user.getCompanyNo());
		
		String result = mngPayService.updateSalAndBonusConfirm(update);
		
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd")
				.setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
				.serializeNulls()
				.disableHtmlEscaping()
				.create();

		
		return gson.toJson(result);
		
	}
	
	/* 급상여 지급 세부 내역 조회 */
	@PostMapping(value="payListDetail", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String selectPayListDetail(@AuthenticationPrincipal UserImpl user, MngPayListDTO search) {
		
		search.setCompanyNo(user.getCompanyNo());
		
		List<MngPayListDTO> detailList = mngPayService.selectPayListDetail(search);
		
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd")
				.setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
				.serializeNulls()
				.disableHtmlEscaping()
				.create();
		
		return gson.toJson(detailList);
	}
}
