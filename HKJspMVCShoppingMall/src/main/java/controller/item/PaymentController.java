package controller.item;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.ItemDAO;
import model.DTO.AuthInfo;
import model.DTO.PaymentDTO;

public class PaymentController {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String purchaseNum = request.getParameter("purchaseNum");
		String totalPrice = request.getParameter("totalPrice");
		String cardNumber = request.getParameter("cardNumber");
		String paymentCompany = request.getParameter("paymentCompany");
		String paymentMethod = request.getParameter("paymentMethod");
		PaymentDTO dto = new PaymentDTO();
		dto.setCarNum(cardNumber);
		dto.setPaymentCompany(paymentCompany);
		dto.setPaymentMethod(paymentMethod);
		dto.setPurchaseNum(Integer.parseInt(purchaseNum));
		
		ItemDAO dao = new ItemDAO();
		dao.paymentInsert(dto);
		
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("dto");
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("memberId", authInfo.getUserId());
	}
	
	
	
	
	
}
