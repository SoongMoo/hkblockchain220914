package hkShoppungMall.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PythonController {
	PythonInterpreter intPre = new PythonInterpreter();
	@RequestMapping("/subwayfee")
	public String getSubwayfee(@RequestParam(value="zone" , required = false , defaultValue = "신도림") String zone,
			Model model) throws UnsupportedEncodingException {
		System.out.println(zone);
		String result = commandFunc("src/main/webapp/view/python/subwayfee.py " + zone);
		System.out.println(result);
		model.addAttribute("result", result);
		return "python/subwayfee";
	}
	
	
	@RequestMapping("/gender")
	public String getGender(@RequestParam(value="zone" , required = false , defaultValue = "신도림") String zone,
			Model model) throws UnsupportedEncodingException {
		System.out.println(zone);
		String result = commandFunc("src/main/webapp/view/python/gender.py " + zone);
		System.out.println("result " + result);
		model.addAttribute("result", result);
		return "python/gender";
	}
	
	@RequestMapping("/age")
	public String getAge(@RequestParam(value="zone" , required = false , defaultValue = "신도림") String zone,
			Model model) throws UnsupportedEncodingException {
		System.out.println(zone);
		String result = commandFunc("src/main/webapp/view/python/pythonAge.py " + zone);
		System.out.println("result " + result);
		model.addAttribute("result", result);
		return "python/pythonAge";
	}
	
	@RequestMapping("/python")
	public String getTest(HttpServletRequest request,Model model) {

		intPre.execfile("src/main/webapp/view/python/pythonTest.py");
		//intPre.exec("print(testFunc(5, 10))");
		PyFunction pyFunction = (PyFunction) intPre.get("testFunc", PyFunction.class);
		int a = 10, b = 20;
		PyObject pyobj = pyFunction.__call__(new PyInteger(a), new PyInteger(b));
		System.out.println(pyobj.toString());
		model.addAttribute("pyobj", pyobj.toString());
		
		commandFunc("src/main/webapp/view/python/matplotlibTest.py");
		
		return "python/python";
	}
	public String commandFunc(String fileName) {
		System.out.println(fileName);
		String result = "";
		try {
			Process process  = Runtime.getRuntime().exec("powershell -Command python " + fileName);
			//new BufferedReader( new InputStreamReader(process.getInputStream()));
			BufferedReader reader = new BufferedReader(
			        new InputStreamReader(process.getInputStream()));
			String line = null;
			StringBuffer sb = new StringBuffer();
			while ((line = reader.readLine()) != null) {
			    sb.append(line);
			    sb.append("\n");
			}
			result = sb.toString();
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}