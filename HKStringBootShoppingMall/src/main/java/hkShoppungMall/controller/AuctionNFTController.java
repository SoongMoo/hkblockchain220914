package hkShoppungMall.controller;

import java.util.List;

import org.springframework.aot.hint.annotation.Reflective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hkShoppungMall.domain.AuctionDTO;
import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.domain.MemberDTO;
import hkShoppungMall.mapper.AutionMapper;
import hkShoppungMall.mapper.MemberShipMapper;
import hkShoppungMall.service.nft.AutionUploadService;
import jakarta.servlet.http.HttpSession;

@Controller
public class AuctionNFTController {
	@Autowired
	AutionMapper autionMapper;
	@RequestMapping("market")
	public String index() {
		return "market/app";
	}
	@RequestMapping("/main")
	public String main(Model model) {
		List<AuctionDTO> list = autionMapper.auctionSelectAll();
		model.addAttribute("list", list);
		return "market/marketPlace";
	}
	@Autowired
	AutionUploadService autionUploadService;
	@RequestMapping(value="upload", method = RequestMethod.GET)
	public String upload(HttpSession session, Model model) {
		autionUploadService.execute(session,model);
		return "market/myUpload";
	}
	@RequestMapping(value="upload", method = RequestMethod.POST)
	public String upload(Model model) {
		return "redirect:upload";
	}
	@RequestMapping("wallet")
	public String wallet() {
		return "market/myWallet";
	}
	@RequestMapping("createAution")
	public @ResponseBody boolean createAution(
			@RequestParam(value = "title") String title
			,@RequestParam(value = "price") long price
			,@RequestParam(value = "metadata") String metadata
			,@RequestParam(value = "tokenId") String tokenId
			,@RequestParam(value = "owner") String owner
			,@RequestParam(value = "active") String active
			,@RequestParam(value = "finalized") String finalized
			) {
		AuctionDTO dto =  new AuctionDTO();
		dto.setActive(active);
		dto.setFinalized(finalized);
		dto.setMetaData(metadata);
		dto.setOwner(owner);
		dto.setPrice(price);
		dto.setTitle(title);
		dto.setTokenId(tokenId);
		int i = autionMapper.createAution(dto);
		if(i != 1) return false;
		return true;
	}
	@Autowired
	MemberShipMapper memberShipMapper;
	@RequestMapping("transferForm")
	public String transferForm(@RequestParam(value="owner") String owner,
			@RequestParam(value="tokenId") String tokenId,
			Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		MemberDTO dto = memberShipMapper.selectMember(authInfo.getUserId());
		String myAccount = dto.getAccountAddress();
		model.addAttribute("myAccount", myAccount);
		model.addAttribute("tokenId", tokenId);
		model.addAttribute("ownerAddress", owner);
		return "market/transferForm";
	}
	@RequestMapping("finalizeAuction")
	public @ResponseBody void  finalizeAuction(
			@RequestParam(value="toAddress") String owner,
			@RequestParam(value="tokenId") String tokenId
			) {
		AuctionDTO dto = new AuctionDTO();
		dto.setOwner(owner);
		dto.setTokenId(tokenId);
		autionMapper.finalizeAuction(dto);
	}
}







