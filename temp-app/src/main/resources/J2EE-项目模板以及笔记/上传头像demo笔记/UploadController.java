package controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	@RequestMapping("upload")
	public ModelAndView upload() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsp/loginAndRegister/upload");
		return mv;
	}

	@RequestMapping("dealupload")
	public void dealupload(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("username");
		String email = req.getParameter("email");
		String headimg = req.getParameter("headimg");

		System.out.println(name + email + headimg);

		// 解析和检查请求，是否是post方式，是否是二进制流格式
		Boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if (!isMultipart) {
			return; // 如果不是就不用上传了
		}

		try {

			// 创建FileItemFactory对象
			FileItemFactory factory = new DiskFileItemFactory();
			// 创建文件上传的处理器
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 解析请求
			List<FileItem> items = upload.parseRequest(req);
			// 迭代出每一个FileItem
			for (FileItem item : items) {
				String fileName = item.getFieldName();
				if (item.isFormField()) {
					// 普通的表单控件
					String value = item.getString("utf-8");
					System.out.println(fileName + "->" + value);
				} else {
					// 上传文件的控件
					System.out.println(fileName + "->" + item.getName()); // 一个的标签的name，一个是文件的name
					String pathName = "./src/main/webapp/assets/img/author-img/";
					item.write(new File(pathName, item.getName())); // 把上传的文件保存到某个文件中
					pathName = "/reading/assets/img/author-img/" + item.getName();
					System.out.println(pathName);
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
