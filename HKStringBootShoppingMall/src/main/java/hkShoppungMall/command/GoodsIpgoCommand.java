package hkShoppungMall.command;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class GoodsIpgoCommand {
	@NotBlank(message = "번호를 10글자 입력하여 주세요.")
	String goodsNum;
	
	@NotNull (message = "입고일을 입력해주세요")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date ipgoDate; // Tue Jan 10 00:00:00 KST 2023
	
	@NotNull (message = "입고 수량을 입력해주세요")
	Integer ipgoQty;
	
	@NotNull (message = "제조일을 입력해주세요")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	LocalDateTime madeDate;
}
