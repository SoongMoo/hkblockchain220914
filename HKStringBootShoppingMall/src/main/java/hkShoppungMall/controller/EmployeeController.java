package hkShoppungMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hkShoppungMall.command.EmployeeCommand;
import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.service.EmailCheckService;
import hkShoppungMall.service.employees.EmployeeDeleteService;
import hkShoppungMall.service.employees.EmployeeDelsService;
import hkShoppungMall.service.employees.EmployeeInfoservice;
import hkShoppungMall.service.employees.EmployeeModifyService;
import hkShoppungMall.service.employees.EmployeeUpdateService;
import hkShoppungMall.service.employees.EmployeesListService;
import hkShoppungMall.service.employees.EmployeesWriteService;


@Controller
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	EmployeesWriteService employeesWriteService; 
	@Autowired
	EmployeesListService employeesListService;
	@Autowired
	EmployeeInfoservice employeeInfoservice;
	@Autowired
	EmployeeModifyService employeeModifyService; 
	@Autowired
	EmployeeUpdateService employeeUpdateService;
	@Autowired
	EmployeeDeleteService employeeDeleteService ;
	@Autowired
	EmployeeDelsService employeeDelsService;
	@Autowired
	EmailCheckService emailCheckService;

	
	@ModelAttribute
	EmployeeCommand setEmployeeCommand() {
		return new EmployeeCommand();
	}
	
	
	
	@RequestMapping(value = "empDels" , method = RequestMethod.POST)
	public String empDels(@RequestParam(value = "delete") String [] delete) {
		employeeDelsService.execute(delete);
		return "redirect:empList";
	}
	
	
	@RequestMapping(value="empDelete", method = RequestMethod.POST)
	public String empDelete(EmployeeCommand employeeCommand,
		Model model) {
		employeeDeleteService.execute(employeeCommand,model);
		return "thymeleaf/employee/empdel";
	}

	@RequestMapping(value= "empModify" , method = RequestMethod.POST)
	public String empModify(@RequestParam(value="empPw") String empPw,
			@RequestParam(value="empId") String empId,
			Model model) {
		String path = employeeModifyService.execute(empId,empPw, model);
		return path;
	}
	@RequestMapping("empInfo")
	public String empInfo(@RequestParam(value = "num") String empNum,
			Model model) {
		employeeInfoservice.execute(empNum,model );
		return "thymeleaf/employee/empInfo";
	}
	@RequestMapping("empList")
	public String empList(Model model) {
		
		employeesListService.execute(model);
		return "thymeleaf/employee/empList";
	}
	@RequestMapping("empJoin")
	public String empJoin(Model model) {
		//model.addAttribute("employeeCommand", new EmployeeCommand());
		return "thymeleaf/employee/empForm";
	}
	@RequestMapping(value = "empWrite", method = RequestMethod.GET)
	public   String empWrite1() {
		return "thymeleaf/employee/empForm";
	}
	@RequestMapping(value = "empWrite", method = RequestMethod.POST)
	public String empWrite(@Validated EmployeeCommand employeeCommand,
			BindingResult result) {
		if (result.hasErrors()) {
			return "thymeleaf/employee/empForm";
		}
		if(!employeeCommand.isEmpPwEqualsEmpPwCon()) {
			result.rejectValue("empPwCon", "employeeCommand.empPwCon", "비밀번호 확인이 다릅니다.");
			return "thymeleaf/employee/empForm";
		}
		AuthInfo i = emailCheckService.execute(employeeCommand.getEmpEmail());
		if(i != null) {
			result.rejectValue("empEmail", "employeeCommand.empEmail", "사용중인 이메일 입니다아앙.");
			return "thymeleaf/employee/empForm";
		}
		employeesWriteService.execute(employeeCommand);
		return "redirect:/";
	}
}

