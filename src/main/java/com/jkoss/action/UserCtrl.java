package com.jkoss.action;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.jkoss.biz.UserBiz;
import com.jkoss.pojo.User;
import com.jkoss.tool.Page;



@Controller
@RequestMapping("/mgr/")
public class UserCtrl {

	@Autowired
	private UserBiz ubiz;



	// 登录

	@RequestMapping("lgn.do")
	public String login(String loginName, String password, HttpServletRequest req) {
		User usr = ubiz.login(loginName, password);
		if (usr != null) {

		if (Integer.valueOf(usr.getUserType()) < 1) {
				//
			req.getSession().setAttribute("me", "欢迎游客登录");
				
			
				return "index2";
			}
			req.getSession().setAttribute("usr", usr);
			return "main";
		}
		req.setAttribute("msg", "登录失败");
		return "/index" ;
	}

	// 登出
	@RequestMapping("lgout.do")
	public String logout(HttpServletRequest req, ModelMap map) {
		req.getSession().invalidate(); // 失效
		map.addAttribute("msg", "欢迎下次再来");
		return "redirect:/index.jsp";
	}

// 列出用戶
	@RequestMapping("listUsr.do")
	public String listAtPage(HttpServletRequest req, Page page) {
		if (page == null) {
			page = new Page<User>();

		}
		page.setResults(ubiz.findUserAtPage(page));
		page.setTotalPage(ubiz.findAllPage());
		req.setAttribute("page", page);

		return "/mgr/listuser";
	}
	

	//删除
	@RequestMapping("deleteUser.do")
	public String deleUser(HttpServletRequest req,int user){
		System.out.println("ioioioiooi");
		System.out.println(user);
		ubiz.deleteUsr(user);
			
		return listAtPage(req, null);
	}
	
	
	
	
	
// 准备更新
	@RequestMapping("updtUser1.do")
	public String updateUser(HttpServletRequest req, User updUser, int userId) {

		req.setAttribute("toUpdateUser", ubiz.findUserByID(userId));

		return "/mgr/mergeUsr";
	}

	// 完成更新
	@RequestMapping("updtUser2.do")
	public String updateUser2(HttpServletRequest req, User updUsr) {
		ubiz.updateUser(updUsr);

		req.setAttribute("msg", "更新成功");

		return listAtPage(req, null);
	}

	/*	//	// 完成图片上传
	@RequestMapping("upload.do")
	public String upload(MultipartFile facePic,Model map) {
		if(facePic!=null){
	String touface =	facePic.getOriginalFilename();
	String basePath="C:/Users/admin/Pictures/";
	String toufaceNew=touface.substring(0,touface.lastIndexOf("."))+UUID.randomUUID()+touface.substring(touface.lastIndexOf("."));
	try {
		facePic.transferTo(new File(basePath,toufaceNew));
	} catch (IllegalStateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}		
	map.addAttribute("msg","上传成功");
		return "/index2";
	}*/
	
}
