package hkShoppungMall.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("candidatesDTO")
public class CandidatesDTO {
	int idx;
	String name;
	int vote;
}
