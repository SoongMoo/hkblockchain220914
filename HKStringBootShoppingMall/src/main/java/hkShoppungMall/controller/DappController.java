package hkShoppungMall.controller;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import hkShoppungMall.domain.CandidatesDTO;
import hkShoppungMall.domain.VotersDTO;
import hkShoppungMall.mapper.VotingMapper;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class DappController {
	@RequestMapping(value="auction")
	public String auction(@RequestParam(value="my_account", required = false ) 
								String my_account, Model model) {
		model.addAttribute("my_account", my_account);
		return"auction/auction";
	}
	@Autowired
	VotingMapper votingMapper;
	@RequestMapping(value="vote")
	public String vote(Model model) {
		List<CandidatesDTO> candidates_list =  votingMapper.candidatesSelect();
		int candidates_sum_vote = votingMapper.selectVotingSum();
		model.addAttribute("candidates_list", candidates_list);
		model.addAttribute("candidates_sum_vote", candidates_sum_vote);
		return"vote/index";
	}
	@RequestMapping("candidate")
	public @ResponseBody ModelAndView candidate() {
		return new ModelAndView("vote/candidate");
	}
	@RequestMapping("candidateOk")
	public void candidateOk(@RequestParam(value="name") String name,
			HttpServletResponse response) {
		CandidatesDTO dto = new CandidatesDTO();
		dto.setName(name);
		votingMapper.insertCandidate(dto);
		try {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String str=  "<script language='javascript'>" 
				  +  " opener.document.location.reload();"
		          +  " window.self.close();"
		          +  "</script>";
		out.print(str);
		out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="voteWrite", method=RequestMethod.POST)
	public void voteWrite(@RequestParam(value="idx")int idx,
			@RequestParam(value="name")String name,
			@RequestParam(value="account")String account,
			@RequestParam(value="tx_id")String tx_id) {
		System.out.println(account +"계정이 "+name + "에 투표를 시도합니다.");
		votingMapper.candidateUpdate(idx);
		VotersDTO dto = new VotersDTO();
		dto.setAccount(account);
		dto.setCandiddate_idx(idx);
		dto.setTx_id(tx_id);
		votingMapper.voteInsert(dto);
		System.out.println(account + "계정의 투표가 완료되었습니다.");
	}
}
