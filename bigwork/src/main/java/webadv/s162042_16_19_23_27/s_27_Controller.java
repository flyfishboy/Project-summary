package webadv.s162042_16_19_23_27;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.ListView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import webadv.s162042_16_19_23_27.DAL.MyBatisRepository;
import webadv.s162042_16_19_23_27.entity.Student;
import webadv.s162042_16_19_23_27.entity.Teacher;
import webadv.s162042_16_19_23_27.entity.course_back_27;
import webadv.s162042_16_19_23_27.entity.grade_27;
import webadv.s162042_16_19_23_27.entity.questionnaire_27;

@Controller
public class s_27_Controller {
	
	private DownloadExcel de=new DownloadExcel();
	@Autowired
	private MyBatisRepository myBatisRepository;
	@Autowired
	private studentRespository sr;
	
	
	@GetMapping("/xiazaiwenjuan") // �ʾ���������������ʾ�
	public String xiazaiwenjuan(Model model, HttpServletRequest request,String c_id) {
		Teacher teacher = (Teacher) request.getSession().getAttribute("t_user");
		String t_id=teacher.getT_id();
		List<questionnaire_27> listQ=sr.findTeacQues(t_id);
		model.addAttribute("listQ",listQ);
		model.addAttribute("t_name", teacher.getT_name());
		
		List<questionnaire_27> listxiazai=sr.findCourQues(c_id);
		
		ArrayList<String[]> context=new ArrayList<>();
		
		String[] context0=listxiazai.get(0).getStringlistname();
		
		for (questionnaire_27 g:listxiazai) {
			context.add(g.getStringlist());
			System.out.println(g.getStringlist());
		}
		
		de.WriteExcel(context0, context);
		return "questionnaire";
	}
	
	@GetMapping("/questionnaire") // �ʾ����������
	public String wenjuan(Model model, HttpServletRequest request) {
		Teacher teacher = (Teacher) request.getSession().getAttribute("t_user");
		String t_id=teacher.getT_id();
		List<questionnaire_27> listQ=sr.findTeacQues(t_id);
		model.addAttribute("listQ",listQ);
		model.addAttribute("t_name", teacher.getT_name());
		return "questionnaire";
	}
	
	
	@GetMapping("/add_questionnaire") // ����ʾ����������
	public String wenjuantianjia(Model model, HttpServletRequest request,String c_id,String q_content1,String q_content2,String q_content3) {
		Teacher teacher = (Teacher) request.getSession().getAttribute("t_user");
		String t_id=teacher.getT_id();
		
		List<Student> list=sr.findAllStu();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
		String q_time = df.format(new Date());
		
		for (int i = 0; i < list.size(); i++) {
			sr.insertQues(list.get(i).getS_id(),c_id, t_id, q_time, q_content1, q_content2, q_content3);
		}
		
		List<questionnaire_27> listQ=sr.findTeacQues(t_id);
		model.addAttribute("listQ",listQ);
		model.addAttribute("t_name", teacher.getT_name());
		
		return "questionnaire";
	}
	
	
	@GetMapping("/student1") // ѧ��������
	public String student1(Model model, HttpServletRequest request) {
		String id = (String) request.getSession().getAttribute("s_id");
		model.addAttribute("stu", myBatisRepository.findStudentById(id));
		return "student1";
	}

	@GetMapping("/student2") // �ʾ�����б�
	public String student2(Model model, HttpServletRequest request) {
		String s_id = (String) request.getSession().getAttribute("s_id");
		List<questionnaire_27> qulist = sr.findAllQues(s_id);
		model.addAttribute("qulist", qulist);
		model.addAttribute("stu", myBatisRepository.findStudentById(s_id));
		return "student2";
	}

	@GetMapping("/student22") // �ʾ������д
	public String student22(Model model, HttpServletRequest request, String s_id, String c_id) {
		String id = (String) request.getSession().getAttribute("s_id");
		questionnaire_27 qu = sr.findOneQues(s_id, c_id);
		model.addAttribute("qu", qu);
		model.addAttribute("stu", myBatisRepository.findStudentById(id));
		return "student22";
	}

	@GetMapping("/tijiaowenjuan") // �ύ�ʾ�
	public String tijiaowenjuan(Model model, HttpServletRequest request, String c_id, String q_answer1,
			String q_answer2, String q_answer3) {
		String s_id = (String) request.getSession().getAttribute("s_id");
		sr.updateOneQues(s_id, c_id, q_answer1, q_answer2, q_answer3);
		List<questionnaire_27> qulist = sr.findAllQues(s_id);
		model.addAttribute("qulist", qulist);
		model.addAttribute("stu", myBatisRepository.findStudentById(s_id));
		return "student2";
	}

	@GetMapping("/student3") // ѧ�������б�
	public String student3(Model model, HttpServletRequest request) {
		String id = (String) request.getSession().getAttribute("s_id");
		List<course_back_27> allCourseBack = sr.findAllCourseBackById(id);
		model.addAttribute("allCourseBack", allCourseBack);
		model.addAttribute("stu", myBatisRepository.findStudentById(id));
		return "student3";
	}

	@GetMapping("/student33") // ѧ��������д
	public String student33(Model model, HttpServletRequest request, String s_id, String c_id) {
		String id = (String) request.getSession().getAttribute("s_id");
		course_back_27 cb = sr.findOneCourseBackById(s_id, c_id);
		model.addAttribute("cb", cb);
		model.addAttribute("stu", myBatisRepository.findStudentById(id));
		return "student33";
	}

	@GetMapping("/tianxiepinke") // �ύ�ʾ�
	public String tianxiepinke(Model model, HttpServletRequest request, String c_id, double cb_score,
			String cb_content) {
		String s_id = (String) request.getSession().getAttribute("s_id");
		sr.updateOneCouBack(s_id, c_id, cb_score, cb_content);
		List<course_back_27> allCourseBack = sr.findAllCourseBackById(s_id);
		model.addAttribute("allCourseBack", allCourseBack);
		model.addAttribute("stu", myBatisRepository.findStudentById(s_id));
		return "student3";
	}

	@GetMapping("/student4") // �γ̳ɼ���ʾ
	public String student4(Model model, HttpServletRequest request,HttpServletResponse response) {
		String id = (String) request.getSession().getAttribute("s_id");
		List<grade_27> allGrade = sr.finaAllGradeBys_Id(id);
		model.addAttribute("allGrade", allGrade);
		model.addAttribute("stu", myBatisRepository.findStudentById(id));
		
		
		
		List<grade_27> allGrade1 = sr.finaAllGradeBys_Id(id);
		
		
		ArrayList<String[]> context=new ArrayList<>();
		String[] context0=allGrade1.get(0).getStringlistname();
		
		for (grade_27 g:allGrade1) {
			context.add(g.getStringlist());
		}
		
		de.WriteExcel(context0, context);
		
		
		
		return "student4";
	}

	
	
	


			
	
	
}