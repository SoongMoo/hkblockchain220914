package hkShoppungMall.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PythonController {
	PythonInterpreter intPre;
	@RequestMapping("/python")
	public String getTest(Model model) {
		intPre = new PythonInterpreter();
		intPre.execfile("src/main/webapp/view/python/pythonTest.py");
		//intPre.exec("print(testFunc(5, 10))");
		PyFunction pyFunction = (PyFunction) intPre.get("testFunc", PyFunction.class);
		int a = 10, b = 20;
		PyObject pyobj = pyFunction.__call__(new PyInteger(a), new PyInteger(b));
		System.out.println(pyobj.toString());
		model.addAttribute("pyobj", pyobj.toString());
		
		try {
			Process process  = Runtime.getRuntime().exec("cmd /c python src/main/webapp/view/python/matplotlibTest.py");
			new BufferedReader(
			        new InputStreamReader(process.getInputStream()));
			/*
			BufferedReader reader = new BufferedReader(
			        new InputStreamReader(process.getInputStream()));
			String line = null;
			StringBuffer sb = new StringBuffer();
			while ((line = reader.readLine()) != null) {
			    sb.append(line);
			    sb.append("\n");
			}
			String result = sb.toString();
			System.out.println(result);
			*/
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "python/python";
	}
}