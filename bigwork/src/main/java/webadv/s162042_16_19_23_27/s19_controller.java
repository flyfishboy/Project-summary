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

	// ��spring���Ҳ�ע�루����ƥ�伴�ɣ�
	@Autowired
	private MyBatisRepository myBatisRepository;

	@Autowired
	private studentRespository sr;

	// ��ʾ����ѧ��������
	@GetMapping("/admin_showstudent")
	public String showstudent(Model model, HttpServletRequest request) {
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		model.addAttribute("student_list", myBatisRepository.admin_findAllStudents());
		return "admin_showstudent";
	}

	// ����ĳ��ѧ��
	@PostMapping("/admin_showstudent")

	public String admin_findstudent(Model model, String s_name, HttpServletRequest request) {
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		System.out.println(s_name);
		model.addAttribute("student_list", myBatisRepository.findStudentByName(s_name));
		return "admin_showstudent";
	}

	// ���һ��ѧ������Ϣ
	@GetMapping("/admin_addstudent")

	public String addstudent(Model model, HttpServletRequest request) {
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		return "admin_addstudent";
	}

	// �ύ���һ��ѧ������Ϣ
	@PostMapping("/admin_addstudent")
	public String addstudent(Model model, String s_id, String s_password, String s_name, String s_sex, String s_age,

			String s_tel, String s_class, HttpServletRequest request) {
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		System.out.println("���ѧ�� " + s_name);
		if (s_id.equals("") || s_password.equals("") || s_name.equals("") || s_sex.equals("") || s_age.equals("")
				|| s_tel.equals("") || s_class.equals(""))
			model.addAttribute("warn", "���ʧ�ܣ��벹ȫ����");
		else {
			if (myBatisRepository.findStudentById(s_id) != null)
				model.addAttribute("warn", "���ʧ�ܣ���ѧ���Ѵ���");
			else {
				myBatisRepository.addStudent(s_id, s_password, s_name, s_sex, s_age, s_tel, s_class);
				model.addAttribute("warn", "��ӳɹ�");
			}
		}
		return "admin_addstudent";
	}

	// �����޸�ѧ����Ϣ����
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

	// �ύ�޸�һ��ѧ������Ϣ
	@PostMapping("/admin_changestudent")
	public String changestudent(Model model, String s_oldid, String s_id, String s_password, String s_name,
			String s_sex, String s_age,

			String s_tel, String s_class, HttpServletRequest request) {
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		System.out.println("�޸�ѧ�� " + s_name);
		if (s_id.equals("") || s_password.equals("") || s_name.equals("") || s_sex.equals("") || s_age.equals("")
				|| s_tel.equals("") || s_class.equals(""))
			model.addAttribute("warn", "�޸�ʧ�ܣ��벹ȫ����");
		else {

			if (myBatisRepository.findStudentById(s_id) != null&&!s_id.equals(s_oldid))
				model.addAttribute("warn", "�޸�ʧ�ܣ�����ѧ���Ѵ���");
			else {
				myBatisRepository.admin_DeleteStudent(s_oldid);
				myBatisRepository.addStudent(s_id, s_password, s_name, s_sex, s_age, s_tel, s_class);
				model.addAttribute("warn", "�޸ĳɹ�");
				model.addAttribute("student_list", myBatisRepository.admin_findAllStudents());
				return "admin_showstudent";
			}
		}

		model.addAttribute("oldid", s_oldid);
		return "admin_changestudent";
	}

	// ��ʾ���н�ʦ������
	@GetMapping("/admin_showteacher")

	public String showteacher(Model model, HttpServletRequest request) {
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		model.addAttribute("teacher_list", myBatisRepository.admin_findAllTeachers());
		return "admin_showteacher";
	}

	// ����ĳ����ʦ
	@PostMapping("/admin_showteacher")

	public String admin_findteacher(Model model, String t_name, HttpServletRequest request) {
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		System.out.println(t_name);
		model.addAttribute("teacher_list", myBatisRepository.findTeacherByName(t_name));
		return "admin_showteacher";
	}

	// ���һ����ʦ����Ϣ
	@GetMapping("/admin_addteacher")

	public String addteacher(Model model, HttpServletRequest request) {
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		return "admin_addteacher";
	}

	// �ύ���һ����ʦ����Ϣ
	@PostMapping("/admin_addteacher")
	public String addteacher(Model model, String t_id, String t_password, String t_name, String t_sex, String t_age,
			String t_tel, String t_address, String t_role, HttpServletRequest request) {

		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		System.out.println("��ӽ�ʦ " + t_name);
		if (t_id.equals("") || t_password.equals("") || t_name.equals("") || t_sex.equals("") || t_age.equals("")
				|| t_tel.equals("") || t_address.equals(""))
			model.addAttribute("warn", "���ʧ�ܣ��벹ȫ����");
		else {

			if (myBatisRepository.findTeacherById(t_id) != null)
				model.addAttribute("warn", "���ʧ�ܣ��ù����Ѵ���");
			else {
				myBatisRepository.addTeacher(t_id, t_password, t_name, t_sex, t_age, t_tel, t_address, t_role);
				model.addAttribute("warn", "��ӳɹ�");
			}
		}
		return "admin_addteacher";
	}

	// �����޸Ľ�ʦ��Ϣ����
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

	// �ύ�޸�һ����ʦ����Ϣ
	@PostMapping("/admin_changeteacher")
	public String changeteacher(Model model, String t_oldid, String t_id, String t_password, String t_name,
			String t_sex, String t_age,
			String t_tel, String t_address, String t_role, HttpServletRequest request) {
		
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		System.out.println("�޸Ľ�ʦ " + t_name);
		if (t_id.equals("") || t_password.equals("") || t_name.equals("") || t_sex.equals("") || t_age.equals("")
				|| t_tel.equals("") || t_address.equals(""))
			model.addAttribute("warn", "�޸�ʧ�ܣ��벹ȫ����");
		else {
			if (myBatisRepository.findTeacherById(t_id) != null&&!t_id.equals(t_oldid))
				model.addAttribute("warn", "�޸�ʧ�ܣ����¹����Ѵ���");
			else {
				myBatisRepository.admin_DeleteTeacher(t_oldid);
				System.out.println("�޸�  " + t_role);
				myBatisRepository.addTeacher(t_id, t_password, t_name, t_sex, t_age, t_tel, t_address, t_role);
				model.addAttribute("warn", "�޸ĳɹ�");
				model.addAttribute("teacher_list", myBatisRepository.admin_findAllTeachers());
				return "admin_showteacher";
			}
		}
		model.addAttribute("oldid", t_oldid);
		return "admin_changeteacher";
	}

	// ɾ��һ��ѧ������Ϣ
	@PostMapping("/admin_deletestudent")

	public String DeleteStudent(Model model, String s_id, HttpServletRequest request) {
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		System.out.println("ɾ��ѧ�� " + s_id);
		myBatisRepository.admin_DeleteStudent(s_id);
		model.addAttribute("student_list", myBatisRepository.admin_findAllStudents());
		return "admin_showstudent";
	}

	// ɾ��һ����ʦ����Ϣ
	@PostMapping("/admin_deleteteacher")

	public String DeleteTeacher(Model model, String t_id, HttpServletRequest request) {
		String admin_id = (String) request.getSession().getAttribute("admin_id");
		if (admin_id == null || !admin_id.equals("123"))
			return "index";

		System.out.println("ɾ����ʦ " + t_id);
		myBatisRepository.admin_DeleteTeacher(t_id);
		model.addAttribute("teacher_list", myBatisRepository.admin_findAllTeachers());
		return "admin_showteacher";
	}

	// ʵ��Spring Boot ���ļ����ع��ܣ�ӳ����ַΪ/download
	@RequestMapping("/download")
	public String downloadFile(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		// ����Ŀ¼
		// String excelurl="C:/YYYYYYYYYYYYYYYY";

		// ��ȡָ��Ŀ¼�µĵ�һ���ļ�
		// File scFileDir = new File(excelurl);
		// File TrxFiles[] = scFileDir.listFiles();
		// System.out.println(TrxFiles[0]);
		// String fileName = TrxFiles[0].getName(); // ���ص��ļ�����Ҳ���Զ��壬���⣩

		String fileName = "D:/EXCEL.xls";

		System.out.println(fileName);

		// ����ļ�����Ϊ�գ����������
		if (fileName != null) {
			// �����ļ�·��
			// File file = new File(excelurl, fileName);
			File file = new File(fileName);

			System.out.println("��ʼ���ļ�");

			// ����ļ������ڣ����������
			if (file.exists()) {
				System.out.println("��ʼ����");

				// �����ļ�����
				response.setHeader("content-type", "application/octet-stream");
				response.setContentType("application/octet-stream");
				// �����ļ���������ʾ����
				response.setHeader("Content-Disposition",
						"attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

				// ʵ���ļ�����
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
					System.out.println("���سɹ���");
				} catch (Exception e) {
					System.out.println("����ʧ�ܣ�");
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
				System.out.println("�ļ�������");
			}
		}
		return null;
	}

}
