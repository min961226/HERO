package com.nextLevel.hero.mngBasicInformation.controller;

import java.lang.ProcessBuilder.Redirect;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
import com.nextLevel.hero.mngBasicInformation.model.dto.BusinessDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngBasicInformationDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngBonusDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngDepartmentHistoryDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngInsuranceRateDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngMemberDepartmentDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngSalaryCriteriaDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngVacationTypeDTO;
import com.nextLevel.hero.mngBasicInformation.model.service.MngBasicInformationService;
import com.nextLevel.hero.mngVacation.model.dto.MngVacationDTO;

@Controller
@RequestMapping("/mngBasicInformation")
public class MngBasicInformationController {
	
	private final MngBasicInformationService mngBasicInformationService;
	
	@Autowired
	public MngBasicInformationController(MngBasicInformationService mngBasicInformationService) {
		this.mngBasicInformationService = mngBasicInformationService;
	}

	@GetMapping("/businessList")
	public ModelAndView businessList(ModelAndView mv) {
		
		mv.setViewName("mngBasicInformation/businessList");
		return mv;
	}
	
	@GetMapping(value="/getSearchList", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<BusinessDTO> getSearchList(@RequestParam String keyword,Model model) throws Exception{
		
		
		System.out.println(keyword);
		
		BusinessDTO businessDTO = new BusinessDTO();
		businessDTO.setKeyword(keyword);
		List<BusinessDTO> list = mngBasicInformationService.getSearchList(businessDTO);
		return list;
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
		
		int result1 = mngBasicInformationService.updateDepartment(departmentDTO);
		int result2 = mngBasicInformationService.insertUpdateLogDepartment(departmentDTO);
		
		if(result1 + result2 >1) {
            rttr.addFlashAttribute("successMessage", "부서 수정을 완료하였습니다");
        }else {
            rttr.addFlashAttribute("failedMessage", "부서 수정을 실패하였습니다");
        }
		
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
		int memberCount = mngBasicInformationService.selectMemberCount(user.getCompanyNo());
		System.out.println(insuranceRate);
		System.out.println(insuranceRate.getAsbestosDamagechargeRate());
		
		mv.addObject("memberCount",memberCount);
		mv.addObject("insuranceRate",insuranceRate);
		mv.setViewName("mngBasicInformation/premiumRate");
		return mv;
	}
	@PostMapping("/premiumRate")
	public ModelAndView updatePremiumRate(ModelAndView mv,RedirectAttributes rttr,MngInsuranceRateDTO insuranceRate) {
		
		int result = mngBasicInformationService.insertPremiumRate(insuranceRate);
		
		if(result >0) {
            rttr.addFlashAttribute("successMessage", "보험 요율 수정에 성공하였습니다.");
        }else {
            rttr.addFlashAttribute("failedMessage", "보험 요율 수정에 실패하였습니다.");
        }
		
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
	public ModelAndView mngVacationType(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		List<MngVacationTypeDTO> mngVacationTypeList = mngBasicInformationService.selectVacationTypeList(user.getCompanyNo());
		
		System.out.println(mngVacationTypeList);
		
		mv.addObject("vacationTypeList",mngVacationTypeList);
		mv.setViewName("mngBasicInformation/vacationType");
		return mv;
	}
	
	@PostMapping(value = "insertVacationType")
	public ModelAndView insertVacationType(ModelAndView mv, @AuthenticationPrincipal UserImpl user, MngVacationTypeDTO mngVacationTypeDTO,RedirectAttributes rttr) {
		
		/* 세션에 저장된 회사 번호를 가져와서 DTO에 담아줌 */
		mngVacationTypeDTO.setCompanyNo(user.getCompanyNo());
		/* DTO 값을 담아서 서비스로 이동 */
		int result = mngBasicInformationService.insertVacationType(mngVacationTypeDTO);
		
		if(result >0) {
			rttr.addFlashAttribute("successMessage", "휴가 종류 추가를 완료하였습니다");				//성공시
		}else {
			rttr.addFlashAttribute("failedMessage", "휴가 종류 추가에 실패하였습니다");				//실패시
		}
		mv.setViewName("redirect:/mngBasicInformation/vacationType");							//가야할 페이지
		
		System.out.println(mngVacationTypeDTO);
		return mv;
	}
	
	@PostMapping("/updateVacationType")
	public ModelAndView updateVacationType(ModelAndView mv, @AuthenticationPrincipal UserImpl user,MngVacationTypeDTO mngVacationTypeDTO,RedirectAttributes rttr) {
		mngVacationTypeDTO.setCompanyNo(user.getCompanyNo());
		
		System.out.println("휴가 종류 수정 :" + mngVacationTypeDTO);
		int result = mngBasicInformationService.updateVacationType(mngVacationTypeDTO);
		
		if(result >0) {
			rttr.addFlashAttribute("successMessage", "휴가 종류 수정을 완료하였습니다");
		}else {
			rttr.addFlashAttribute("failedMessage", "휴가 종류 수정에 실패하였습니다");
		}
		mv.setViewName("redirect:/mngBasicInformation/vacationType");
		return mv;
	}
	
	
	
	@GetMapping(value="editVacationType", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String selectOneVacationType(@AuthenticationPrincipal UserImpl user, @RequestParam String selectedVacationNo) {
		
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd hh:mm:ss:SSS")
				.setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
				.serializeNulls()
				.disableHtmlEscaping()
				.create();
		
		int vacationNo = Integer.parseInt(selectedVacationNo);
		MngVacationTypeDTO vacationType = mngBasicInformationService.selectOneVacationType(user.getCompanyNo(),vacationNo);
		
		return gson.toJson(vacationType);
	}
	
	@GetMapping(value="deleteVacation", produces="application/json; charset=UTF-8")
	@ResponseBody
	public ModelAndView deleteVacationType(ModelAndView mv, @AuthenticationPrincipal UserImpl user, @RequestParam String selectedVacationNo) {
		
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd hh:mm:ss:SSS")
				.setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
				.serializeNulls()
				.disableHtmlEscaping()
				.create();
		System.out.println(selectedVacationNo);
		/* ajax로 넘어온 휴가 종류 번호를 int 로 parsing */ 
		int vacationNo = Integer.parseInt(selectedVacationNo);
		
		mngBasicInformationService.deleteVacationType(user.getCompanyNo(),vacationNo);
		
		mv.setViewName("/mngBasicInformation/vacationType");
		
		return mv;
	}
	
	@GetMapping("/salaryType")
	public ModelAndView mngSalaryType(ModelAndView mv,@AuthenticationPrincipal UserImpl user) {
		
		int companyNo = user.getCompanyNo();
		
		List<MngSalaryCriteriaDTO> salaryList = mngBasicInformationService.selectSalaryList(companyNo);
		List<MngBonusDTO> bonusList = mngBasicInformationService.selectBonusList(companyNo);
		
		mv.addObject("salaryList", salaryList);
		mv.addObject("bonusList", bonusList);
		mv.setViewName("/mngBasicInformation/salaryType");
		return mv;
	}
	
	@PostMapping("/insertSalaryCriteria")
	public ModelAndView mngSalaryCriteria(ModelAndView mv,@AuthenticationPrincipal UserImpl user,MngSalaryCriteriaDTO salaryCriteriaDTO, RedirectAttributes rttr) {
		
		System.out.println(salaryCriteriaDTO);
		salaryCriteriaDTO.setCompanyNo(user.getCompanyNo());
		
		int result = mngBasicInformationService.insertSalaryCriteria(salaryCriteriaDTO);
		
		if(result >0) {
			rttr.addFlashAttribute("successMessage", "급여 종류 추가를 완료하였습니다");
		}else {
			rttr.addFlashAttribute("failedMessage", "급여 종류 추가에 실패하였습니다");
		}
		System.out.println(salaryCriteriaDTO);
		System.out.println("급여 추가 값전송함");
		mv.setViewName("redirect:/mngBasicInformation/salaryType");							//가야할 페이지

		return mv;
	}
	
	@PostMapping("/insertBonus")
	public ModelAndView mngBonusType(ModelAndView mv,@AuthenticationPrincipal UserImpl user,MngBonusDTO bonusDTO, RedirectAttributes rttr) {
		
		System.out.println(bonusDTO);
		bonusDTO.setCompanyNo(user.getCompanyNo());
		int result = mngBasicInformationService.insertBonusType(bonusDTO);
		
		if(result >0) {
			rttr.addFlashAttribute("successMessage", "상여 종류 추가를 완료하였습니다");
		}else {
			rttr.addFlashAttribute("failedMessage", "상여 종류 추가에 실패하였습니다");
		}
		System.out.println(bonusDTO);
		System.out.println("급여 추가 값전송함");
		mv.setViewName("redirect:/mngBasicInformation/salaryType");							//가야할 페이지

		return mv;
	}
	
	
	
}
