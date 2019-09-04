package webadv.s162042_16_19_23_27;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import webadv.s162042_16_19_23_27.entity.ClassGrade;
import webadv.s162042_16_19_23_27.entity.Course;
import webadv.s162042_16_19_23_27.entity.Record;
import webadv.s162042_16_19_23_27.entity.Teacher;
import webadv.s162042_16_19_23_27.entity.s16_c_g;
import webadv.s162042_16_19_23_27.entity.studentgrade;
import webadv.s162042_16_19_23_27_repository.TeacherRepository1;

@Controller
public class s_23_Controller {

	private DownloadExcel de = new DownloadExcel();

	@Autowired
	private TeacherRepository1 tr;
	private Record record;

	@GetMapping("/Supervisionscore") // 督导评分
	public String Supervisionscore(Model model, HttpServletRequest request, Teacher teacher) {
		teacher = (Teacher) request.getSession().getAttribute("t_user");
		if (teacher.getT_role().equals("是")) {
			model.addAttribute("record_list", tr.findAll());
			model.addAttribute("t_role", teacher.getT_role());
			model.addAttribute("t_name", teacher.getT_name());
			System.out.println(teacher.getT_role());
			return "Supervisionscore";
		} else {
			model.addAttribute("t_name", teacher.getT_name());
			return "FalseRole";
		}
	}

	@PostMapping("/addRecord")
	public String addRecord(Model model, String t_id, String c_id, String r_time, String r_score, String r_text,
			HttpServletRequest request, Teacher teacher) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		r_time = df.format(new Date());
		teacher = (Teacher) request.getSession().getAttribute("t_user");
		System.out.println(teacher.getT_name());
		tr.addRecord(t_id, c_id, r_time, r_score, r_text);
		return "redirect:/Supervisionscore";
	}

	@GetMapping("/findgrade") // 查询成绩
	public String findgrade(Model model, HttpServletRequest request, Teacher teacher) {
		teacher = (Teacher) request.getSession().getAttribute("t_user");
		model.addAttribute("t_name", teacher.getT_name());
		model.addAttribute("t_id", teacher.getT_id());

		List<Course> list = tr.findCourse(teacher.getT_id());
		System.out.println("课程数量："+list.size());
		model.addAttribute("c_list", list);

		ArrayList<String[]> context = new ArrayList<>();

		List<studentgrade> list1 = tr.findAllstudentgrade(list.get(0).getC_id());

		String[] context0 = list1.get(0).getStringlistname();

		for (Course yyy : list) {

			list1 = tr.findAllstudentgrade(yyy.getC_id());

			for (studentgrade g : list1) {

				context.add(g.getStringlist());

			}

		}

		// 加个换行
		String[] b = { "" };
		context.add(b);

		List<ClassGrade> list2 = tr.findClassGrades(list.get(0).getC_id());

		String[] context01 = list2.get(0).getStringlistname();
		context.add(context01);

		for (Course yyy : list) {

			System.out.print("ddsfsdfdfdsfsgrdgfdg       "+yyy.getC_id());
			
			list2 = tr.findClassGrades(yyy.getC_id());

			for (int i = 0; i < list2.size(); i++) {
				list2.get(i).setSum_class_grade(
						list2.get(i).getSum_class_grade() / (list2.get(i).getSum_class_student() / 4));
				list2.get(i).setSum_class_student(list2.get(i).getSum_class_student() / 4);
			}

			for (ClassGrade g : list2) {

				context.add(g.getStringlist());

			}

		}

		de.WriteExcel(context0, context);

		return "findgrade";
	}

	@GetMapping("/TeacMain") // 教师主界面
	public String TeacMain(Model model, HttpServletRequest request, Teacher teacher) {
		teacher = (Teacher) request.getSession().getAttribute("t_user");
		model.addAttribute("t_name", teacher.getT_name());
		model.addAttribute("t_id", teacher.getT_id());
		model.addAttribute("t_sex", teacher.getT_sex());
		model.addAttribute("t_age", teacher.getT_age());
		model.addAttribute("t_tel", teacher.getT_tel());
		model.addAttribute("t_address", teacher.getT_address());
		model.addAttribute("t_role", teacher.getT_role());
		return "TeacMain";
	}

	@PostMapping("/findstudentgrade")
	public String findStudentGgrade(Model model, String c_id, HttpServletRequest request, Teacher teacher) {
		teacher = (Teacher) request.getSession().getAttribute("t_user");
		model.addAttribute("t_id", teacher.getT_id());

		List<Course> list = tr.findCourse(teacher.getT_id());
		model.addAttribute("c_list", list);
		System.out.println(c_id);
		List<studentgrade> list1 = tr.findAllstudentgrade(c_id);
		/*
		 * for(int i=0;i<list.size();i++) { System.out.println(list.get(i).getS_id());
		 * System.out.println(list.get(i).getSumgrade());
		 * System.out.println(list.get(i).getA_absence());
		 * System.out.println(list.get(i).getA_sum()); }
		 */
		model.addAttribute("studentgrade_list", list1);
		return "findgrade";
	}

	@PostMapping("/findclassgrade")
	public String findclassgrade(Model model, String c_id, HttpServletRequest request, Teacher teacher) {
		teacher = (Teacher) request.getSession().getAttribute("t_user");
		System.out.println(c_id);
		List<Course> list = tr.findCourse(teacher.getT_id());
		model.addAttribute("c_list", list);
		List<ClassGrade> list1 = tr.findClassGrades(c_id);
		for (int i = 0; i < list1.size(); i++) {
			list1.get(i)
					.setSum_class_grade(list1.get(i).getSum_class_grade() / (list1.get(i).getSum_class_student() / 4));
			list1.get(i).setSum_class_student(list1.get(i).getSum_class_student() / 4);
		}
		model.addAttribute("class_list", list1);
		return "findgrade";
	}

}