package com.jkoss.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jkoss.biz.ProductBiz;
import com.jkoss.pojo.Product;
import com.jkoss.pojo.User;
import com.jkoss.tool.Page;

@Controller
@RequestMapping("/mgr")
public class ProductCtrl {

	@Autowired
	ProductBiz pbiz;

	@RequestMapping("listPro.do")
	public String AllProdu(HttpServletRequest req, Page page) {
		if (page == null) {
			page = new Page<Product>();

		}

	 //date.addAttribute("allpro",pbiz.findAtPage(page));
		page.setResults(pbiz.findAtPage(page));
		page.setTotalPage(pbiz.findAllPage());
		req.setAttribute("page", page);

		 return "/mgr/listProduct" ;
		//return "/index2";
	}
	
//	// 准备添加   
		@RequestMapping("addUser1.do")
		public String addProject(HttpServletRequest req, Product addpro,Integer proid) {
	
			req.setAttribute("toaddPro",proid);

			return "/mgr/mergePro";
		}

		// 完成添加
		@RequestMapping("addUser2.do")
		public String addProject2(HttpServletRequest req, Product pro) {
			pbiz.addPro(pro);

			req.setAttribute("msg", "更新成功");

			return AllProdu(req, null);
		}


}
