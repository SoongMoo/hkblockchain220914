package hkShoppungMall.service;

import java.util.List;
import org.springframework.ui.Model;

public class StartEndPageService {
	public void execute(Model model, int count, int limit, int page, int limitPage,
			String goodsWord, List list) {
		int maxPage = (int)((double)count / limit + 0.95) ; // 11/10 = 1.1 + 0.9
		int startPage = (int)(((double)page / limitPage) + 0.95 - 1 ) * limitPage  + 1; //1
		int endPage = startPage + limitPage -1;  // 10
		if(endPage > maxPage ) endPage  = maxPage;
		
		model.addAttribute("limit", limit);
		model.addAttribute("count", count);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		model.addAttribute("goodsWord", goodsWord);
		model.addAttribute("list", list);
		System.out.println(startPage);
		System.out.println(endPage);
	}
}
