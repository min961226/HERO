package com.nextLevel.hero.basicSetting.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
import com.nextLevel.hero.mngBasicInformation.model.dto.MngBonusDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngDepartmentHistoryDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngInsuranceRateDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngSalaryCriteriaDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngVacationTypeDTO;
import com.nextLevel.hero.mngBasicInformation.service.MngBasicInformationService;

@Controller
@RequestMapping("/basicSetting")
public class BasicSettingController {

	private final BasicSettingService basicSettingService;
	private final MngBasicInformationService mngBasicInformationService;

	@Autowired
	public BasicSettingController(BasicSettingService basicSettingService,
			MngBasicInformationService mngBasicInformationService) {
		this.basicSettingService = basicSettingService;
		this.mngBasicInformationService = mngBasicInformationService;

	}

	@GetMapping("/basicSetting")
	public ModelAndView mngCompany(@AuthenticationPrincipal UserImpl user, ModelAndView mv) {

		int companyNo = user.getCompanyNo();

		MngBasicInformationDTO companyInfo = mngBasicInformationService.selectCompanyInformationByCompanyNo(companyNo);
		MngDepartmentHistoryDTO upperDepartment = basicSettingService.selectOneUpperDepartment(companyNo);
		List<MngVacationTypeDTO> vacationTypeList = mngBasicInformationService.selectVacationTypeList(companyNo);
		List<MngSalaryCriteriaDTO> salaryList = mngBasicInformationService.selectSalaryList(companyNo);
		List<MngBonusDTO> bonusList = mngBasicInformationService.selectBonusList(companyNo);
		MngInsuranceRateDTO insuranceRate = mngBasicInformationService.selectInsurance(user.getCompanyNo());
		System.out.println(insuranceRate);

		System.out.println(companyInfo);
		System.out.println(upperDepartment);
		if (companyInfo == null) {
			MngBasicInformationDTO newCompanyInfo = new MngBasicInformationDTO(user.getCompanyNo(), "", "", "", "", "",
					"", "", "", "", "", "", "", "", "", "", null, 'N', 0, "", "");
			mv.addObject("companyInfo", newCompanyInfo);
		} else {
			mv.addObject("companyInfo", companyInfo);
		}
		if (upperDepartment == null) {
			MngDepartmentHistoryDTO newUpperDepartment = new MngDepartmentHistoryDTO(user.getCompanyNo(), "", null, "");
			mv.addObject("upperDepartment", newUpperDepartment);
		} else {
			mv.addObject("upperDepartment", upperDepartment);
		}
		/* 보험요율의 저장 값이 없을경우 */
		if (insuranceRate == null) {

			int businessCode = 0;
			String businessDetail = "";
			BigDecimal industryRate = BigDecimal.ZERO;
			BusinessDTO businessInfo = basicSettingService.selectBusinessInfo(companyNo);

			if (businessInfo == null) {
				MngInsuranceRateDTO newInsuranceRate = new MngInsuranceRateDTO(companyNo, null, BigDecimal.ZERO,
						BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,
						BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,
						BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,
						BigDecimal.ZERO, 'Y', BigDecimal.ZERO, 'Y', BigDecimal.ZERO, BigDecimal.ZERO, 0, "미정",
						BigDecimal.ZERO);
				mv.addObject("insuranceRate", newInsuranceRate);
			} else {
				businessCode = businessInfo.getIdx();
				businessDetail = businessInfo.getBusinessDetail();
				industryRate = businessInfo.getIndustryRate();
				MngInsuranceRateDTO newInsuranceRate = new MngInsuranceRateDTO(companyNo, null, BigDecimal.ZERO,
						BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,
						BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,
						BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,
						BigDecimal.ZERO, 'Y', BigDecimal.ZERO, 'Y', BigDecimal.ZERO, BigDecimal.ZERO, businessCode,
						businessDetail, industryRate);
				mv.addObject("insuranceRate", newInsuranceRate);
			}
		} else {
			mv.addObject("insuranceRate", insuranceRate);
		}

		mv.addObject("vacationTypeList", vacationTypeList);
		mv.addObject("salaryList", salaryList);
		mv.addObject("bonusList", bonusList);

		mv.setViewName("basicSetting/basicSetting");
		return mv;
	}

	@PostMapping("/basicSetting")
	public ModelAndView businessName(@RequestParam String name, ModelAndView mv) {

		System.out.println(name);

		mv.addObject(name);
		mv.setViewName("basicSetting/basicSetting");
		return mv;
	}

	@PostMapping("/company")
	public ModelAndView basicSettingCompany(ModelAndView mv, RedirectAttributes rttr,
			MngBasicInformationDTO basicInformation, @AuthenticationPrincipal UserImpl user) {

		basicInformation.setCompanyRegistrationNo(basicInformation.getCompanyRegistrationNo1() + "-"
				+ basicInformation.getCompanyRegistrationNo2() + "-" + basicInformation.getCompanyRegistrationNo3());
		basicInformation.setIdentificationNo(
				basicInformation.getIdentificationNo1() + "-" + basicInformation.getIdentificationNo2());
		basicInformation.setCompanyNo(user.getCompanyNo());

		System.out.println(basicInformation);
		int result = basicSettingService.insertOrUpdateBasicSettingCompany(basicInformation);

		if (result > 0) {
			rttr.addFlashAttribute("successMessage", "회사 기본 정보 설정을 완료하였습니다.");
		} else {
			rttr.addFlashAttribute("failedMessage", "회사 기본 정보 설정에 실패하였습니다.");
		}

		mv.setViewName("redirect:/basicSetting/basicSetting");
		return mv;
	}

	@GetMapping(value = "selectBusinessList", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String getDepartment(@AuthenticationPrincipal UserImpl user, @RequestParam String keyword) {

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss:SSS").setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).serializeNulls().disableHtmlEscaping().create();

		BusinessDTO businessDTO = new BusinessDTO();
		businessDTO.setKeyword(keyword);
		List<BusinessDTO> list = mngBasicInformationService.getSearchList(businessDTO);

		System.out.println(keyword);

		return gson.toJson(list);
	}

	@PostMapping("/insertUpperDept")
	public ModelAndView insertUpperDept(ModelAndView mv, RedirectAttributes rttr, MngDepartmentHistoryDTO departmentDTO,
			@AuthenticationPrincipal UserImpl user) {

		departmentDTO.setCompanyNo(user.getCompanyNo());

		System.out.println(departmentDTO);
		int result = basicSettingService.insertUpperDept(departmentDTO);

		if (result > 0) {
			rttr.addFlashAttribute("successMessage", "최상위 부서 생성을 완료하였습니다.");
		} else {
			rttr.addFlashAttribute("failedMessage", "최상위 부서 생성을 실패하였습니다.");
		}
		System.out.println("추가성공");
		mv.setViewName("redirect:/basicSetting/basicSetting");
		return mv;
	}

	@PostMapping("/insertVacationType")
	public ModelAndView insertVacationType(ModelAndView mv, RedirectAttributes rttr, MngVacationTypeDTO vacationTypeDTO,
			@AuthenticationPrincipal UserImpl user) {

		vacationTypeDTO.setCompanyNo(user.getCompanyNo());

		System.out.println(vacationTypeDTO);
		int result = mngBasicInformationService.insertVacationType(vacationTypeDTO);

		if (result > 0) {
			rttr.addFlashAttribute("successMessage", "휴가 종류 생성을 완료하였습니다.");
		} else {
			rttr.addFlashAttribute("failedMessage", "휴가 종류 생성을 실패하였습니다.");
		}

		mv.setViewName("redirect:/basicSetting/basicSetting");
		return mv;
	}

	@PostMapping("/insertSalary")
	public ModelAndView insertSalary(ModelAndView mv, RedirectAttributes rttr, MngSalaryCriteriaDTO salaryCriteriaDTO,
			@AuthenticationPrincipal UserImpl user) {

		salaryCriteriaDTO.setCompanyNo(user.getCompanyNo());

		System.out.println(salaryCriteriaDTO);
		int result = mngBasicInformationService.insertSalaryCriteria(salaryCriteriaDTO);

		if (result > 0) {
			rttr.addFlashAttribute("successMessage", "급여 종류 생성을 완료하였습니다.");
		} else {
			rttr.addFlashAttribute("failedMessage", "급여 종류 생성을 실패하였습니다.");
		}

		mv.setViewName("redirect:/basicSetting/basicSetting");
		return mv;
	}

	@PostMapping("/insertBonus")
	public ModelAndView insertBonus(ModelAndView mv, RedirectAttributes rttr, MngBonusDTO bonusDTO,
			@AuthenticationPrincipal UserImpl user) {

		bonusDTO.setCompanyNo(user.getCompanyNo());

		System.out.println(bonusDTO);
		int result = mngBasicInformationService.insertBonusType(bonusDTO);

		if (result > 0) {
			rttr.addFlashAttribute("successMessage", "상여 종류 생성을 완료하였습니다.");
		} else {
			rttr.addFlashAttribute("failedMessage", "상여 종류 생성을 실패하였습니다.");
		}

		mv.setViewName("redirect:/basicSetting/basicSetting");
		return mv;
	}

	@PostMapping("/insertInsuranceRate")
	public ModelAndView insertInsuranceRate(ModelAndView mv, RedirectAttributes rttr,
			MngInsuranceRateDTO insuranceRateDTO, @AuthenticationPrincipal UserImpl user) {

		insuranceRateDTO.setCompanyNo(user.getCompanyNo());

		System.out.println(insuranceRateDTO);
		int result = basicSettingService.insertInsuranceRate(insuranceRateDTO);

		if (result > 0) {
			rttr.addFlashAttribute("successMessage", "보험 요율 설정을 완료하였습니다.");
		} else {
			rttr.addFlashAttribute("failedMessage", "보험 요율 설정을 실패하였습니다.");
		}

		mv.setViewName("redirect:/basicSetting/basicSetting");
		return mv;
	}

	@GetMapping("/finish")
	public ModelAndView finishBasicSetting(ModelAndView mv, RedirectAttributes rttr,
			@AuthenticationPrincipal UserImpl user) {

		int result = basicSettingService.finishBasicSetting(user.getNo());

		if (result > 0) {
			rttr.addFlashAttribute("successMessage", "초기 세팅 설정을 완료하였습니다.      초기세팅 적용을 위해서 재로그인 해주세요");
		} else {
			rttr.addFlashAttribute("failedMessage", "초기 세팅 설정을 실패하였습니다.");
		}

		mv.setViewName("redirect:/member/login");
		return mv;
	}

}
