package hkShoppungMall.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class FileDownLoad {
	public void fileDownLoad(String path, String fileName, String ofileName ,HttpServletRequest request, HttpServletResponse response) {
		String RealPath = request.getServletContext().getRealPath(path);
		String originalFileName = ofileName;
		try {
			originalFileName = URLEncoder.encode(originalFileName,"UTF-8");
		}catch(Exception e) {}
		String storeFileName = fileName;
		response.setContentType("application/octet-stream; charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + originalFileName + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        File file = new File(RealPath + "/" + storeFileName);
        // 웹브라우저쪽으로 output하기 위해서 사용하는 객체 
        ServletOutputStream out1 = null; 
        // 시스템에 있는 파일은 가져오기 위한 객체 
        FileInputStream fis = null;
		try {
			// 웹브라우저에 전송할 수 있게 정보를 가져옴 
			out1 = response.getOutputStream();
			// 시스템에 있는 파일을 가져옴 
			fis = new FileInputStream(file);
			//               fis ---> out1에 복사 
			// fis가 가지고 있는 파일을 out1에 의해 웹브라우저에 전송
	        FileCopyUtils.copy(fis, out1); // 전송 
	        response.flushBuffer();// response에 의해 전송이 된후 response 버퍼를 지운다. 
	        out1.flush();
	        out1.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally {
			 if(fis != null){                 
	                try{ fis.close();}catch(Exception e){}
	            }
		}
	}
}
