
package webadv.s162042_16_19_23_27;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import webadv.s162042_16_19_23_27.JDBCRepository;
import webadv.s162042_16_19_23_27.DAL.MyBatisRepository;
import webadv.s162042_16_19_23_27.entity.Course;
import webadv.s162042_16_19_23_27.entity.Student;
import webadv.s162042_16_19_23_27.entity.Teacher;

@Controller
public class HomeController {
	// ��spring���Ҳ�ע�루����ƥ�伴�ɣ�
	@Autowired
	private MyBatisRepository myBatisRepository;

	@Autowired
	private JDBCRepository jdbc = new JDBCRepository();
	private Teacher teacher = null;
	private Student student = null;

	//404
	@RequestMapping("/404")
	public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
		return "404";
	}
	
	
	// ����������
	@GetMapping("/")
	public String welcome(Model model,HttpServletRequest request) {
		//DownloadExcel excel=new DownloadExcel();
		//excel.WriteExcel("");
		//excel.ReadExcel("D:/jsl_biao.xls");
		
		request.getSession().invalidate();
		
		return "index";

	}

	// ��¼���棬������ȷ�������û�������
	@PostMapping("/login")

	public String welcome( String id, String psd, String status,Model model, HttpServletRequest request) {

		if (status.equals("S")) {// ѧ��
			student = jdbc.validStudent(id, psd);
			if (student != null) {
				request.getSession().setAttribute("s_id", id);
				model.addAttribute("stu", myBatisRepository.findStudentById(id));
				return "student1";
			}

			else
				return welcome(model,request);

		} else if (status.equals("T")) {// ��ʦ

			teacher = jdbc.validTeacher(id, psd);

			if (teacher != null) {
				request.getSession().setAttribute("t_user" ,teacher);
				return "redirect:/TeacMain";
			} else
				return welcome(model,request);

		} else if (status.equals("A")) {// ����Ա

			if ("123".equals(id) && "123".equals(psd)) {
				model.addAttribute("student_list", myBatisRepository.admin_findAllStudents());

				request.getSession().setAttribute("admin_id", "123");

				return "admin_showstudent";
			}

			else
				return welcome(model,request);

		}
		return welcome(model,request);

	}

}