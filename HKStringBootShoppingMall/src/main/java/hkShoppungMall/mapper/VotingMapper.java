package hkShoppungMall.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import hkShoppungMall.domain.CandidatesDTO;
import hkShoppungMall.domain.VotersDTO;

@Repository(value="hkShoppungMall.mapper.VotingMapper")
public interface VotingMapper {
	public Integer insertCandidate(CandidatesDTO dto);
	public List<CandidatesDTO>  candidatesSelect();
	public Integer selectVotingSum();
	public Integer candidateUpdate(int idx);
	public Integer voteInsert(VotersDTO dto);
}
