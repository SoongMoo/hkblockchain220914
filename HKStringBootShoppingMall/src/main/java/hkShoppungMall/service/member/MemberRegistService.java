package hkShoppungMall.service.member;

import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import hkShoppungMall.command.MemberCommand;
import hkShoppungMall.domain.CartDTO;
import hkShoppungMall.domain.MemberDTO;
import hkShoppungMall.mapper.MemberMapper;

@Service
public class MemberRegistService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MemberMapper memberMapper ;
	Integer i;
	public Integer execute(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		try {
			dto.setGender(memberCommand.getGender());
			dto.setMemberAddr(memberCommand.getMemberAddr());
			dto.setMemberBirth(memberCommand.getMemberBirth());
			dto.setMemberEmail(memberCommand.getMemberEmail());
			dto.setMemberId(memberCommand.getMemberId());
			dto.setMemberName(memberCommand.getMemberName());
			dto.setMemberNum(memberCommand.getMemberNum());
			dto.setMemberPhone(memberCommand.getMemberPhone());
			dto.setMemberPw(passwordEncoder.encode(memberCommand.getMemberPw()));
			dto.setMemberRegist(Timestamp.valueOf(memberCommand.getMemberRegist()));
			i = memberMapper.memberInsert(dto);
			System.out.println(i + "개행이(가) 삽입되었습니다.");
		}catch(Exception e) {
			i = null;
			
		}
		return i;
	}
	
	public void createPdf(MemberCommand memberCommand, String fileName) {
		String result = ""; 
		try {
			Document document = new Document(); // pdf문서를 처리하는 객체
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
			document.open(); 
			BaseFont baseFont = BaseFont.createFont("src/main/resources/static/font/NanumBarunGothic.ttf", BaseFont.IDENTITY_H,
                    BaseFont.EMBEDDED);
			
			Font font = new Font(baseFont, 12);
			
			
			
			PdfPTable table = new PdfPTable(2); // 2개의 셀을 가진 테이블 객체를 생성 (pdf파일에 나타날 테이블)
			Chunk chunk = new Chunk("회원 정보", font); // 타이틀 객체를 생성 (타이틀의 이름을 회원정보로 하고 위에 있는 font를 사용)
			
			Paragraph ph = new Paragraph(chunk);
            ph.setAlignment(Element.ALIGN_CENTER);
            document.add(ph); // 문단을 만들어서 가운데 정렬 (타이틀의 이름을 가운데 정렬한다는 뜻)
 
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE); // 줄바꿈 (왜냐하면 타이틀에서 두줄을 내린후에 셀(테이블)이 나오기 때문)
            
            PdfPCell cell = new PdfPCell(new Phrase("회원 정보", font)); // 셀의 이름과 폰트를 지정해서 셀을 생성한다.
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); // 셀의 정렬방식을 지정한다. (가운데정렬)
            cell.setColspan(2);
            
            /// 회원 번호
            PdfPCell cell1 = new PdfPCell(new Phrase("회원 번호", font)); // 셀의 이름과 폰트를 지정해서 셀을 생성한다.
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 셀의 정렬방식을 지정한다. (가운데정렬)
 
            PdfPCell cell2 = new PdfPCell(new Phrase(memberCommand.getMemberNum(), font));
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
 
            
            // 회원아이디
            PdfPCell cell21 = new PdfPCell(new Phrase("회원 아이디", font));
            cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
 
            PdfPCell cell22 = new PdfPCell(new Phrase(memberCommand.getMemberId(), font));
            cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
 
            // 회원 이름
            PdfPCell cell31 = new PdfPCell(new Phrase("회원 아이디", font));
            cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
 
            PdfPCell cell32 = new PdfPCell(new Phrase(memberCommand.getMemberName(), font));
            cell32.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            // 회원 주소
            PdfPCell cell41 = new PdfPCell(new Phrase("회원 아이디", font));
            cell41.setHorizontalAlignment(Element.ALIGN_CENTER);
 
            PdfPCell cell42 = new PdfPCell(new Phrase(memberCommand.getMemberAddr(), font));
            cell42.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            table.addCell(cell); // 그리고 테이블에 위에서 생성시킨 셀을 넣는다.
            table.addCell(cell1); 
            table.addCell(cell2);
            table.addCell(cell21);
            table.addCell(cell22);
            table.addCell(cell31);
            table.addCell(cell32);
            table.addCell(cell41);
            table.addCell(cell42);
           
            document.add(table); // 웹접근 객체에 table를 저장한다.
            document.close(); // 저장이 끝났으면 document객체를 닫는다.
            result = "pdf 파일이 생성되었습니다.";
    
		}catch(Exception e) {
			 e.printStackTrace();
	         result = "pdf 파일 생성 실패...";
		}
		System.out.println(result);
	}
}











