package hkShoppungMall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuctionNFTController {
	@RequestMapping("market")
	public String index() {
		return "market/app";
	}
	@RequestMapping("/main")
	public String main() {
		return "market/marketPlace";
	}
	@RequestMapping(value="upload", method = RequestMethod.GET)
	public String upload() {
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
}
