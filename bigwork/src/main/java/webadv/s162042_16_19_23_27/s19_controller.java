package webadv.s162042_16_19_23_27;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import webadv.s162042_16_19_23_27.DAL.MyBatisRepository;
import webadv.s162042_16_19_23_27.entity.Student;
import webadv.s162042_16_19_23_27.entity.Teacher;

@Controller
public class s19_controller {

	// 进spring查找并注入（类型匹配即可）
	@Autowired
	private MyBatisRepository myBatisRepository;

	@Autowired
	private studentRespository sr;

	// 显示所有学生的名单
	@GetMapping("/admin_showstudent")
	public String showstudent(Model model, HttpServletRequest request) {
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		model.addAttribute("student_list", myBatisRepository.admin_findAllStudents());
		return "admin_showstudent";
	}

	// 查找某个学生
	@PostMapping("/admin_showstudent")

	public String admin_findstudent(Model model, String s_name, HttpServletRequest request) {
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		System.out.println(s_name);
		model.addAttribute("student_list", myBatisRepository.findStudentByName(s_name));
		return "admin_showstudent";
	}

	// 添加一个学生的信息
	@GetMapping("/admin_addstudent")

	public String addstudent(Model model, HttpServletRequest request) {
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		return "admin_addstudent";
	}

	// 提交添加一个学生的信息
	@PostMapping("/admin_addstudent")
	public String addstudent(Model model, String s_id, String s_password, String s_name, String s_sex, String s_age,

			String s_tel, String s_class, HttpServletRequest request) {
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		System.out.println("添加学生 " + s_name);
		if (s_id.equals("") || s_password.equals("") || s_name.equals("") || s_sex.equals("") || s_age.equals("")
				|| s_tel.equals("") || s_class.equals(""))
			model.addAttribute("warn", "添加失败，请补全输入");
		else {
			if (myBatisRepository.findStudentById(s_id) != null)
				model.addAttribute("warn", "添加失败，该学号已存在");
			else {
				myBatisRepository.addStudent(s_id, s_password, s_name, s_sex, s_age, s_tel, s_class);
				model.addAttribute("warn", "添加成功");
			}
		}
		return "admin_addstudent";
	}

	// 进入修改学生信息界面
	@PostMapping("/admin_tochangestudent")

	public String tochangestudent(Model model, String oldid, HttpServletRequest request) {
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		model.addAttribute("oldid", oldid);
		
		
		
		Student student=myBatisRepository.findStudentById(oldid);
		
		model.addAttribute("s_id", student.getS_id());
		model.addAttribute("s_password", student.getS_password());
		model.addAttribute("s_name", student.getS_name());
		//model.addAttribute("s_sex", student.getS_sex());
		model.addAttribute("s_age", student.getS_age());
		model.addAttribute("s_tel", student.getS_tel());
		model.addAttribute("s_class", student.getS_class());
		
		
		return "admin_changestudent";
	}

	// 提交修改一个学生的信息
	@PostMapping("/admin_changestudent")
	public String changestudent(Model model, String s_oldid, String s_id, String s_password, String s_name,
			String s_sex, String s_age,

			String s_tel, String s_class, HttpServletRequest request) {
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		System.out.println("修改学生 " + s_name);
		if (s_id.equals("") || s_password.equals("") || s_name.equals("") || s_sex.equals("") || s_age.equals("")
				|| s_tel.equals("") || s_class.equals(""))
			model.addAttribute("warn", "修改失败，请补全输入");
		else {

			if (myBatisRepository.findStudentById(s_id) != null&&!s_id.equals(s_oldid))
				model.addAttribute("warn", "修改失败，该新学号已存在");
			else {
				myBatisRepository.admin_DeleteStudent(s_oldid);
				myBatisRepository.addStudent(s_id, s_password, s_name, s_sex, s_age, s_tel, s_class);
				model.addAttribute("warn", "修改成功");
				model.addAttribute("student_list", myBatisRepository.admin_findAllStudents());
				return "admin_showstudent";
			}
		}

		model.addAttribute("oldid", s_oldid);
		return "admin_changestudent";
	}

	// 显示所有教师的名单
	@GetMapping("/admin_showteacher")

	public String showteacher(Model model, HttpServletRequest request) {
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		model.addAttribute("teacher_list", myBatisRepository.admin_findAllTeachers());
		return "admin_showteacher";
	}

	// 查找某个教师
	@PostMapping("/admin_showteacher")

	public String admin_findteacher(Model model, String t_name, HttpServletRequest request) {
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		System.out.println(t_name);
		model.addAttribute("teacher_list", myBatisRepository.findTeacherByName(t_name));
		return "admin_showteacher";
	}

	// 添加一个教师的信息
	@GetMapping("/admin_addteacher")

	public String addteacher(Model model, HttpServletRequest request) {
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		return "admin_addteacher";
	}

	// 提交添加一个教师的信息
	@PostMapping("/admin_addteacher")
	public String addteacher(Model model, String t_id, String t_password, String t_name, String t_sex, String t_age,
			String t_tel, String t_address, String t_role, HttpServletRequest request) {

		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		System.out.println("添加教师 " + t_name);
		if (t_id.equals("") || t_password.equals("") || t_name.equals("") || t_sex.equals("") || t_age.equals("")
				|| t_tel.equals("") || t_address.equals(""))
			model.addAttribute("warn", "添加失败，请补全输入");
		else {

			if (myBatisRepository.findTeacherById(t_id) != null)
				model.addAttribute("warn", "添加失败，该工号已存在");
			else {
				myBatisRepository.addTeacher(t_id, t_password, t_name, t_sex, t_age, t_tel, t_address, t_role);
				model.addAttribute("warn", "添加成功");
			}
		}
		return "admin_addteacher";
	}

	// 进入修改教师信息界面
	@PostMapping("/admin_tochangeteacher")

	public String tochangeteacjer(Model model, String oldid, HttpServletRequest request) {
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		model.addAttribute("oldid", oldid);
		
		Teacher teacher=myBatisRepository.findTeacherById(oldid);
		
		
		model.addAttribute("t_id", teacher.getT_id());
		model.addAttribute("t_password", teacher.getT_password());
		model.addAttribute("t_name", teacher.getT_name());
		//model.addAttribute("t_sex", teacher.getT_id());
		model.addAttribute("t_age", teacher.getT_age());
		model.addAttribute("t_tel", teacher.getT_tel());
		model.addAttribute("t_address", teacher.getT_address());
		//model.addAttribute("t_role", teacher.getT_id());
		
		return "admin_changeteacher";
	}

	// 提交修改一个教师的信息
	@PostMapping("/admin_changeteacher")
	public String changeteacher(Model model, String t_oldid, String t_id, String t_password, String t_name,
			String t_sex, String t_age,
			String t_tel, String t_address, String t_role, HttpServletRequest request) {
		
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		System.out.println("修改教师 " + t_name);
		if (t_id.equals("") || t_password.equals("") || t_name.equals("") || t_sex.equals("") || t_age.equals("")
				|| t_tel.equals("") || t_address.equals(""))
			model.addAttribute("warn", "修改失败，请补全输入");
		else {
			if (myBatisRepository.findTeacherById(t_id) != null&&!t_id.equals(t_oldid))
				model.addAttribute("warn", "修改失败，该新工号已存在");
			else {
				myBatisRepository.admin_DeleteTeacher(t_oldid);
				System.out.println("修改  " + t_role);
				myBatisRepository.addTeacher(t_id, t_password, t_name, t_sex, t_age, t_tel, t_address, t_role);
				model.addAttribute("warn", "修改成功");
				model.addAttribute("teacher_list", myBatisRepository.admin_findAllTeachers());
				return "admin_showteacher";
			}
		}
		model.addAttribute("oldid", t_oldid);
		return "admin_changeteacher";
	}

	// 删除一个学生的信息
	@PostMapping("/admin_deletestudent")

	public String DeleteStudent(Model model, String s_id, HttpServletRequest request) {
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		System.out.println("删除学生 " + s_id);
		myBatisRepository.admin_DeleteStudent(s_id);
		model.addAttribute("student_list", myBatisRepository.admin_findAllStudents());
		return "admin_showstudent";
	}

	// 删除一个教师的信息
	@PostMapping("/admin_deleteteacher")

	public String DeleteTeacher(Model model, String t_id, HttpServletRequest request) {
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		System.out.println("删除教师 " + t_id);
		myBatisRepository.admin_DeleteTeacher(t_id);
		model.addAttribute("teacher_list", myBatisRepository.admin_findAllTeachers());
		return "admin_showteacher";
	}

	// 实现Spring Boot 的文件下载功能，映射网址为/download
	@RequestMapping("/download")
	public String downloadFile(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		// 所在目录
		// String excelurl="C:/YYYYYYYYYYYYYYYY";

		// 获取指定目录下的第一个文件
		// File scFileDir = new File(excelurl);
		// File TrxFiles[] = scFileDir.listFiles();
		// System.out.println(TrxFiles[0]);
		// String fileName = TrxFiles[0].getName(); // 下载的文件名（也可自定义，随意）

		String fileName = "D:/EXCEL.xls";

		System.out.println(fileName);

		// 如果文件名不为空，则进行下载
		if (fileName != null) {
			// 设置文件路径
			// File file = new File(excelurl, fileName);
			File file = new File(fileName);

			System.out.println("开始读文件");

			// 如果文件名存在，则进行下载
			if (file.exists()) {
				System.out.println("开始下载");

				// 配置文件下载
				response.setHeader("content-type", "application/octet-stream");
				response.setContentType("application/octet-stream");
				// 下载文件能正常显示中文
				response.setHeader("Content-Disposition",
						"attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

				// 实现文件下载
				byte[] buffer = new byte[1024];
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				try {
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					OutputStream os = response.getOutputStream();
					int i = bis.read(buffer);
					while (i != -1) {
						os.write(buffer, 0, i);
						i = bis.read(buffer);
					}
					System.out.println("下载成功！");
				} catch (Exception e) {
					System.out.println("下载失败！");
				} finally {
					if (bis != null) {
						try {
							bis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (fis != null) {
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			} else {
				System.out.println("文件不存在");
			}
		}
		return null;
	}

}
