package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import dao.prototype.IAccountDao;
import entity.Account;
/**
 * 账户控制器
 * @author ZhenLi
 *
 */
@Controller
@RequestMapping("/act")
public class ActController {
	@Autowired
	private IAccountDao actDao;
	
	@RequestMapping("/toadd")
	public ModelAndView toAdd(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/account/add");
		return mv;
	}
	/*,method=RequestMethod.POST*/
	@RequestMapping(value="/add")
	public ModelAndView add(Account act){
		ModelAndView mv = new ModelAndView();
		try {
			actDao.saveOrupdate(act);
			mv.setViewName("account/addSuccess");
		} catch (Exception e) {
			mv.setViewName("account/failure");
			e.printStackTrace();
		}
		System.out.println("1111:"+mv.getViewName());
		return mv;
	}
	
	@RequestMapping(value="/add2")
	@ResponseBody
	public String add2( Account act){
		String result="";
		try {
			actDao.saveOrupdate(act);
			result="success";
		} catch (Exception e) {
			result="failure";
			e.printStackTrace();
		}
		System.out.println("YES");
		return JSONObject.toJSONString(act);
	}
	
	@RequestMapping(value="/list")
	@ResponseBody
	public String list(Account act){
		String result="";
		try {
			actDao.saveOrupdate(act);
			result="success";
		} catch (Exception e) {
			result="failure";
			e.printStackTrace();
		}
		System.out.println("YES");
		return result;
	}
}
