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
	public Integer candidateDelete(int idx);
	public Integer votersCandidateDelete(int idx);
	public Integer select_voting_account(String account);
	public Integer deleteVoteMe(String account);
	public Integer candidateDown(String account);
}
