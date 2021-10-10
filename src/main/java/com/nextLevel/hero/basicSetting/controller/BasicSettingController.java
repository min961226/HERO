package com.nextLevel.hero.basicSetting.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
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
import com.nextLevel.hero.basicSetting.model.service.BasicSettingService;
import com.nextLevel.hero.member.model.dto.UserImpl;
import com.nextLevel.hero.mngBasicInformation.model.dto.BusinessDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngBasicInformationDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngDepartmentHistoryDTO;
import com.nextLevel.hero.mngBasicInformation.model.service.MngBasicInformationService;


@Controller
@RequestMapping("/basicSetting")
public class BasicSettingController {
	
	private final BasicSettingService basicSettingService;
	private final MngBasicInformationService mngBasicInformationService;

	
	@Autowired
	public BasicSettingController(BasicSettingService basicSettingService,MngBasicInformationService mngBasicInformationService) {
		this.basicSettingService = basicSettingService; 
		this.mngBasicInformationService = mngBasicInformationService;

	}
	
	@GetMapping("/basicSetting")
	public ModelAndView mngCompany(@AuthenticationPrincipal UserImpl user,ModelAndView mv) {
		MngBasicInformationDTO companyInfo = mngBasicInformationService.selectCompanyInformationByCompanyNo(user.getCompanyNo());
		MngDepartmentHistoryDTO upperDepartment = basicSettingService.selectOneUpperDepartment(user.getCompanyNo());
		System.out.println(companyInfo);
		System.out.println(upperDepartment);
		if(companyInfo==null) {
			MngBasicInformationDTO newCompanyInfo = new MngBasicInformationDTO(user.getCompanyNo(), "", "", "",
					"", "", "", "", "",	"", "", "","", "", "", "", null,'N', 0, "","");
			mv.addObject("companyInfo", newCompanyInfo);
		}else {
			mv.addObject("companyInfo", companyInfo);
		}
		if (upperDepartment == null) {
			MngDepartmentHistoryDTO newUpperDepartment = new MngDepartmentHistoryDTO(user.getCompanyNo(),"",null,"");
			mv.addObject("upperDepartment", newUpperDepartment);
		}else {
			mv.addObject("upperDepartment", upperDepartment);
		}
		
		mv.setViewName("basicSetting/basicSetting");
		return mv;
	}
	
	@PostMapping("/basicSetting")
	public ModelAndView businessName(@RequestParam String name,ModelAndView mv) {
		
		System.out.println(name);
		
		mv.addObject(name);
		mv.setViewName("basicSetting/basicSetting");
		return mv;
	}
	
	@PostMapping("/company")
	public ModelAndView basicSettingCompany(ModelAndView mv,RedirectAttributes rttr, MngBasicInformationDTO basicInformation,@AuthenticationPrincipal UserImpl user) {
		
		basicInformation.setCompanyRegistrationNo(basicInformation.getCompanyRegistrationNo1()+"-"+basicInformation.getCompanyRegistrationNo2()+"-"+basicInformation.getCompanyRegistrationNo3());
		basicInformation.setIdentificationNo(basicInformation.getIdentificationNo1()+"-"+basicInformation.getIdentificationNo2());
		basicInformation.setCompanyNo(user.getCompanyNo());
		
		System.out.println(basicInformation);
		int result = basicSettingService.insertOrUpdateBasicSettingCompany(basicInformation);
		
		if(result >0) {
            rttr.addFlashAttribute("successMessage", "회사 기본 정보 설정을 완료하였습니다.");
        }else {
            rttr.addFlashAttribute("failedMessage", "회사 기본 정보 설정에 실패하였습니다.");
        }
		
		mv.setViewName("redirect:/basicSetting/basicSetting");
		return mv;
	}
	
	@GetMapping(value="selectBusinessList", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String getDepartment(@AuthenticationPrincipal UserImpl user, @RequestParam String keyword) {
		
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd hh:mm:ss:SSS")
				.setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
				.serializeNulls()
				.disableHtmlEscaping()
				.create();
		
		BusinessDTO businessDTO = new BusinessDTO();
		businessDTO.setKeyword(keyword);
		List<BusinessDTO> list = mngBasicInformationService.getSearchList(businessDTO);
		
		System.out.println(keyword);

		return gson.toJson(list);
	}
	
	
	@PostMapping("/insertUpperDept")
	public ModelAndView insertUpperDept(ModelAndView mv,RedirectAttributes rttr, MngDepartmentHistoryDTO departmentDTO,@AuthenticationPrincipal UserImpl user) {
		
		departmentDTO.setCompanyNo(user.getCompanyNo());
		
		System.out.println(departmentDTO);
		int result = basicSettingService.insertUpperDept(departmentDTO);
		
		if(result >0) {
            rttr.addFlashAttribute("successMessage", "최상위 부서 생성을 완료하였습니다.");
        }else {
            rttr.addFlashAttribute("failedMessage", "최상위 부서 생성을 실패하였습니다.");
        }
		System.out.println("추가성공");
		mv.setViewName("redirect:/basicSetting/basicSetting");
		return mv;
	}
}
