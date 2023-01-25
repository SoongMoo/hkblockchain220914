package hkShoppungMall.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("votersDTO")
public class VotersDTO {
	int v_id;
	String account;
	int candidate_idx;
	Date v_date;
	String tx_id;
}
