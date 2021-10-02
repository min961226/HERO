package com.nextLevel.hero.mngBasicInformation.controller;

import java.lang.ProcessBuilder.Redirect;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nextLevel.hero.main.model.service.MainService;
import com.nextLevel.hero.member.model.dto.MemberDTO;
import com.nextLevel.hero.member.model.dto.UserImpl;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngBasicInformationDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngDepartmentHistoryDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngInsuranceRateDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngMemberDepartmentDTO;
import com.nextLevel.hero.mngBasicInformation.model.service.MngBasicInformationService;

@Controller
@RequestMapping("/mngBasicInformation")
public class MngBasicInformationController {
	
	private final MngBasicInformationService mngBasicInformationService;
	
	@Autowired
	public MngBasicInformationController(MngBasicInformationService mngBasicInformationService) {
		this.mngBasicInformationService = mngBasicInformationService;
	}

	
	@GetMapping("/company")
	public ModelAndView mngCompany(@AuthenticationPrincipal UserImpl user,ModelAndView mv) {
		
		MngBasicInformationDTO companyInfo = mngBasicInformationService.selectCompanyInformationByCompanyNo(user.getCompanyNo());
		mv.addObject("companyInfo", companyInfo);
		mv.setViewName("mngBasicInformation/company");
		return mv;
	}
	
	@PostMapping("/company")
	public ModelAndView updateCompany(ModelAndView mv,RedirectAttributes rttr, MngBasicInformationDTO basicInformation,@AuthenticationPrincipal UserImpl user) {
		
		basicInformation.setCompanyRegistrationNo(basicInformation.getCompanyRegistrationNo1()+"-"+basicInformation.getCompanyRegistrationNo2()+"-"+basicInformation.getCompanyRegistrationNo3());
		basicInformation.setIdentificationNo(basicInformation.getIdentificationNo1()+"-"+basicInformation.getIdentificationNo2());
		basicInformation.setCompanyNo(user.getCompanyNo());
		
		System.out.println(basicInformation);
		
		mngBasicInformationService.updateCompanyInformation(basicInformation);
		mngBasicInformationService.insertLogCompanyInformation(basicInformation);
		
		rttr.addFlashAttribute("successMessage", "회사 정보 수정에 성공하였습니다!");
		mv.setViewName("redirect:/mngBasicInformation/company");
		
		return mv;
	}
	
	@GetMapping("/department")
	public ModelAndView mngDepartment(ModelAndView mv,@AuthenticationPrincipal UserImpl user) {
		List<MngDepartmentHistoryDTO> departmentList = mngBasicInformationService.selectDepartment(user.getCompanyNo());
		System.out.println(departmentList);
		System.out.println("부서 목록 조회");

		mv.addObject("departmentList",departmentList);
		mv.setViewName("mngBasicInformation/department");
		
		return mv;
	}
	
	@GetMapping(value="departmentList", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String getDepartmentList(@AuthenticationPrincipal UserImpl user) {
		
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd hh:mm:ss:SSS")
				.setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
				.serializeNulls()
				.disableHtmlEscaping()
				.create();
		
		List<MngDepartmentHistoryDTO> departmentList = mngBasicInformationService.selectDepartment(user.getCompanyNo());
		System.out.println(departmentList);
		
		return gson.toJson(departmentList);
	}
	
	@GetMapping(value="editDepartment", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String getDepartment(@AuthenticationPrincipal UserImpl user, @RequestParam String seletedDepartmentNo) {
		
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd hh:mm:ss:SSS")
				.setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
				.serializeNulls()
				.disableHtmlEscaping()
				.create();
		
		int departmentNum = Integer.parseInt(seletedDepartmentNo);
		System.out.println(departmentNum);
		Map<String, Object> map = new HashMap<>();
		MngDepartmentHistoryDTO selectedDepartment = mngBasicInformationService.selectOneDepartment(user.getCompanyNo(),departmentNum);
		List<MngDepartmentHistoryDTO> departmentList = mngBasicInformationService.selectDepartment(user.getCompanyNo());
		if(selectedDepartment.getUpperDepartmentName() == null) {
			selectedDepartment.setUpperDepartmentName("없음");
		}
		System.out.println(selectedDepartment);
		System.out.println(departmentList);
		map.put("selectedDepartment", selectedDepartment);
		map.put("departmentList", departmentList);

		System.out.println(map);
		return gson.toJson(map);
	}
	
	@GetMapping(value="memberDepartment", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String memberDepartment(@AuthenticationPrincipal UserImpl user, @RequestParam String seletedDepartmentNo) {
		
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd hh:mm:ss:SSS")
				.setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
				.serializeNulls()
				.disableHtmlEscaping()
				.create();
		
		int departmentNum = Integer.parseInt(seletedDepartmentNo);
		MngMemberDepartmentDTO memberDepartment= new MngMemberDepartmentDTO();
		memberDepartment.setCompanyNo(user.getCompanyNo());
		memberDepartment.setDepartmentNo(departmentNum);
		
		List<MngMemberDepartmentDTO> memberDepartmentList = mngBasicInformationService.selectMemberDepartment(memberDepartment);
		
		System.out.println(memberDepartmentList);

		return gson.toJson(memberDepartmentList);
	}
	
	@GetMapping(value="deleteDepartment", produces="application/json; charset=UTF-8")
	@ResponseBody
	public ModelAndView deleteDepartment(ModelAndView mv,@AuthenticationPrincipal UserImpl user, @RequestParam String seletedDepartmentNo) {
		
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd hh:mm:ss:SSS")
				.setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
				.serializeNulls()
				.disableHtmlEscaping()
				.create();
		
		int departmentNum = Integer.parseInt(seletedDepartmentNo);
		MngDepartmentHistoryDTO departmentDTO = mngBasicInformationService.selectOneDepartment(user.getCompanyNo(), departmentNum);
		mngBasicInformationService.insertDeleteLogDepartment(departmentDTO);
		System.out.println(departmentDTO);
		mngBasicInformationService.deleteDepartment(departmentNum,user.getCompanyNo());
		
		mv.setViewName("mngBasicInformation/department");
		return mv;
	}
	
	
	@PostMapping("/department")
	public ModelAndView insertDepartment(ModelAndView mv,@AuthenticationPrincipal UserImpl user, MngDepartmentHistoryDTO departmentDTO,RedirectAttributes rttr) {
		
		departmentDTO.setCompanyNo(user.getCompanyNo());
		System.out.println(departmentDTO.getUpperDepartment());
		
		mngBasicInformationService.insertDepartment(departmentDTO);
		int departmentNo = mngBasicInformationService.selectDepartmentNo(departmentDTO);
		departmentDTO.setDepartmentNo(departmentNo);
		mngBasicInformationService.insertLogDepartment(departmentDTO);
		
		mv.setViewName("redirect:/mngBasicInformation/department");
		
		return mv;
	}
	
	@PostMapping("/updateDepartment")
	public ModelAndView updateDepartment(ModelAndView mv,@AuthenticationPrincipal UserImpl user, MngDepartmentHistoryDTO departmentDTO,RedirectAttributes rttr) {
		
		System.out.println("부서 수정");
		System.out.println(departmentDTO);
		departmentDTO.setCompanyNo(user.getCompanyNo());
		
		mngBasicInformationService.updateDepartment(departmentDTO);
		mngBasicInformationService.insertUpdateLogDepartment(departmentDTO);
		
		mv.setViewName("redirect:/mngBasicInformation/department");
		return mv;
	}
	
	@GetMapping("/departmentHistory")
	public ModelAndView mngDepartmentHistory(ModelAndView mv,@AuthenticationPrincipal UserImpl user) {
		
		List<MngDepartmentHistoryDTO> departmentHistory = mngBasicInformationService.selectDepartmentHistory(user.getCompanyNo());
		
		mv.addObject("departmentHistory",departmentHistory);
		mv.setViewName("mngBasicInformation/departmentHistory");
		
		return mv;
	}
	@GetMapping("/premiumRate")
	public ModelAndView mngPremiumRate(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		MngInsuranceRateDTO insuranceRate = mngBasicInformationService.selectInsurance(user.getCompanyNo());
		System.out.println(insuranceRate);
		System.out.println(insuranceRate.getAsbestosDamagechargeRate());
		mv.addObject("insuranceRate",insuranceRate);
		mv.setViewName("mngBasicInformation/premiumRate");
		return mv;
	}
	@PostMapping("/premiumRate")
	public ModelAndView updatePremiumRate(ModelAndView mv,RedirectAttributes rttr,MngInsuranceRateDTO insuranceRate) {
		
		mngBasicInformationService.insertPremiumRate(insuranceRate);
		rttr.addFlashAttribute("successMessage", "보험 요율 수정에 성공하였습니다!");
		mv.setViewName("redirect:/mngBasicInformation/premiumRate");
		return mv;
	}
	
	@GetMapping("/premiumRateHistory")
	public ModelAndView mngPremiumRateHistory(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
		List<MngInsuranceRateDTO> insuranceRateHistory = mngBasicInformationService.selectInsuranceHistory(user.getCompanyNo());
		System.out.println(insuranceRateHistory);
		mv.addObject("insuranceRateHistory",insuranceRateHistory);
		mv.setViewName("mngBasicInformation/premiumRateHistory");
		return mv;
	}
	@GetMapping("/vacationType")
	public String mngVacationType() {
		return "mngBasicInformation/vacationType";
	}
	@GetMapping("/salaryType")
	public String mngSalaryType() {
		return "mngBasicInformation/salaryType";
	}
	
	
	
}
