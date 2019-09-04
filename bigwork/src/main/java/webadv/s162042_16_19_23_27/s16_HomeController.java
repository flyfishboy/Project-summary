package webadv.s162042_16_19_23_27;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webadv.s162042_16_19_23_27.entity.Teacher;
import webadv.s162042_16_19_23_27.entity.grade_27;
import webadv.s162042_16_19_23_27.entity.s16_c_g;
import webadv.s162042_16_19_23_27.entity.s16_s_c;
import webadv.s162042_16_19_23_27.entity.s16_t_assess;

@Controller
public class s16_HomeController {
	private DownloadExcel de=new DownloadExcel();
	
	@Autowired
	private Srepository Srepository;
	public static ArrayList<String> list;
	
	
	// 显示所有教师的名单
	@GetMapping("/evaluation")
	public String showteacher(Model model ,HttpServletRequest request,Teacher teacher) {
		teacher=(Teacher)request.getSession().getAttribute("t_user");
		 model.addAttribute("t_name", teacher.getT_name());
		List<s16_s_c> fd=Srepository.t_findAllSCourse();
		System.out.print(fd.get(0).getT_id());
		model.addAttribute("s16_s_c_list", Srepository.t_findAllSCourse());
		return "evaluation";
	}
		
	// 模糊查找教师
	@PostMapping("/evaluation")
	public String admin_findteacher(Model model, String t_name,HttpServletRequest request,Teacher teacher) {
		teacher=(Teacher)request.getSession().getAttribute("t_user");
		model.addAttribute("t_name", teacher.getT_name());
		System.out.println(t_name);
		model.addAttribute("s16_s_c_list", Srepository.t_findteacher(t_name));
		return "evaluation";
	}
	
	//教师填写评价  (session)
	 @PostMapping("/evaluation2") 
		public String welcome2(Model model,String t_id,String c_id,String message,String t_name,HttpServletRequest request,Teacher teacher) {    
		  teacher=(Teacher)request.getSession().getAttribute("t_user");
			model.addAttribute("t_name", teacher.getT_name());
		  model.addAttribute("cs", t_id);
		  model.addAttribute("cc", c_id);
		   return "evaluation2";
		}
	 
	  @PostMapping("/evaluation4") //教师填写评价2
		public String welcome4(Model model,String ta_content,String t_name,String t_id,String c_id ,HttpServletRequest request,Teacher teacher) {    
		  teacher=(Teacher)request.getSession().getAttribute("t_user");
			model.addAttribute("t_name", teacher.getT_name());
		  System.out.println(ta_content);
		  System.out.println("df.........."+t_id);
		  System.out.println("df.........."+c_id);
		  List<s16_t_assess> fd=Srepository.t_findAllAssess();
		  for(int i=0;i<fd.size();i++) {
			  s16_t_assess s16_as=fd.get(i);
			 // System.out.println("cg.........."+s16_as.getC_id());
			  if (s16_as.getC_id().equals(c_id)) {
					return "redirect:/alreadyEva";
				}
		  }
			 model.addAttribute("content", ta_content);
			  Srepository.t_evaluation(t_id,c_id, ta_content);
		   return "redirect:/evaluation";	
		}
	  
	  @GetMapping("/alreadyEva")  //提示已经评价了
		public String alert(Model model,HttpServletRequest request,Teacher teacher) {  
		  teacher=(Teacher)request.getSession().getAttribute("t_user");
			model.addAttribute("t_name", teacher.getT_name());
		   return "alreadyEva";	
		}
	 
	  @GetMapping("/e_analysis")  //试卷分析界面
		public String welcome4(Model model,HttpServletRequest request,Teacher teacher) {   
		  teacher=(Teacher)request.getSession().getAttribute("t_user");
		  System.out.println(teacher.getT_id());
		  model.addAttribute("t_name", teacher.getT_name());
		  model.addAttribute("t_id", teacher.getT_id());
		  model.addAttribute("s16_c_g_list",Srepository.c_findavggrade1(teacher.getT_id()));
		  model.addAttribute("s16_c_g_list2",Srepository.c_findavggrade2(teacher.getT_id()));
		  model.addAttribute("s16_c_g_list3",Srepository.c_findavggrade3(teacher.getT_id()) );
		  model.addAttribute("s16_c_g_list4",Srepository.c_findavggrade4(teacher.getT_id()) );
		  
		  
			model.addAttribute("t_name", teacher.getT_name());
			
			
			
			
			
			
			List<s16_c_g> g1=Srepository.c_findavggrade1(teacher.getT_id());
			List<s16_c_g> g2=Srepository.c_findavggrade2(teacher.getT_id());
			List<s16_c_g> g3=Srepository.c_findavggrade3(teacher.getT_id());
			List<s16_c_g> g4=Srepository.c_findavggrade4(teacher.getT_id());
			
		
			
			ArrayList<String[]> context=new ArrayList<>();
			String[] context0=g1.get(0).getStringlistname();
			int num=1;
			for (s16_c_g g:g1) {
				context.add(g.getStringlist());
				
				model.addAttribute("chart"+num, g.getAvg_grade());
				num+=4;
			}
			
			 num=2;
			for (s16_c_g g:g2) {
				context.add(g.getStringlist());
				
				model.addAttribute("chart"+num, g.getAvg_grade());
				num+=4;
			}
			
			 num=3;
			for (s16_c_g g:g3) {
				context.add(g.getStringlist());
				
				model.addAttribute("chart"+num, g.getAvg_grade());
				num+=4;
			}
			
			 num=4;
			for (s16_c_g g:g4) {
				context.add(g.getStringlist());
				
				model.addAttribute("chart"+num, g.getAvg_grade());
				num+=4;
			}
			
			de.WriteExcel(context0, context);
			
			
		   return "e_analysis";	
		}
	  
	    // 试卷分析通过题号查询
		@PostMapping("/e_analysis")
		public String find_grade(Model model, String g_qn,HttpServletRequest request,Teacher teacher) {
			System.out.println(g_qn);
			teacher=(Teacher)request.getSession().getAttribute("t_user");
			model.addAttribute("t_name", teacher.getT_name());
			model.addAttribute("t_id", teacher.getT_id());
			model.addAttribute("s16_c_g_list", Srepository.c_findid(g_qn,teacher.getT_id()));
			
			
			
			List<s16_c_g> g1=Srepository.c_findavggrade1(teacher.getT_id());
			List<s16_c_g> g2=Srepository.c_findavggrade2(teacher.getT_id());
			List<s16_c_g> g3=Srepository.c_findavggrade3(teacher.getT_id());
			List<s16_c_g> g4=Srepository.c_findavggrade4(teacher.getT_id());
			
		
			
			ArrayList<String[]> context=new ArrayList<>();
			String[] context0=g1.get(0).getStringlistname();
			int num=1;
			for (s16_c_g g:g1) {
				context.add(g.getStringlist());
				
				model.addAttribute("chart"+num, g.getAvg_grade());
				num+=4;
			}
			
			 num=2;
			for (s16_c_g g:g2) {
				context.add(g.getStringlist());
				
				model.addAttribute("chart"+num, g.getAvg_grade());
				num+=4;
			}
			
			 num=3;
			for (s16_c_g g:g3) {
				context.add(g.getStringlist());
				
				model.addAttribute("chart"+num, g.getAvg_grade());
				num+=4;
			}
			
			 num=4;
			for (s16_c_g g:g4) {
				context.add(g.getStringlist());
				
				model.addAttribute("chart"+num, g.getAvg_grade());
				num+=4;
			}
			
			
			return "e_analysis";
		}


}
