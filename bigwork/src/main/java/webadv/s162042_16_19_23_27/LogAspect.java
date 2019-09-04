package webadv.s162042_16_19_23_27;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;

import webadv.s162042_16_19_23_27.DAL.MyBatisRepository;
import webadv.s162042_16_19_23_27.entity.Course;
import webadv.s162042_16_19_23_27.entity.Student;
import webadv.s162042_16_19_23_27.entity.Teacher;

@Aspect
@Configuration
public class LogAspect {
	@Autowired
	private MyBatisRepository myBatisRepository;

	@Autowired
	private JDBCRepository jdbc = new JDBCRepository();
	private Teacher teacher = null;
	private Student student = null;
	private Course course = null;

	private Logger logger = LoggerFactory.getLogger(LogAspect.class);

	// @Pointcut("execution(public *
	// webadv.example.controller.HomeController.check(..))")
	// public void webLog(){}

	// @Before("webLog()")
	@Before("execution(public String webadv.s162042_16_19_23_27.HomeController.welcome(..)) && args(id,psd,status,..)")
	public void doBefore(String id, String psd, String status) throws Throwable {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String string = "dsfsdfds";

		if (status.equals("S")) {// 学生
			student = jdbc.validStudent(id, psd);
			if (student != null) {
				string = String.format("账号: %s, 身份: 学生 , 登录:  %s , 登录时间:  %s \n", id, "succeeded",
						df.format(new Date()));
			} else
				string = String.format("账号: %s, 身份: 学生 , 登录:  %s , 登录时间:  %s \n", id, "failed", df.format(new Date()));
		} else if (status.equals("T")) {// 教师
			teacher = jdbc.validTeacher(id, psd);
			if (teacher != null) {
				string = String.format("账号: %s, 身份: 教师 , 登录:  %s , 登录时间:  %s \n", id, "succeeded",
						df.format(new Date()));
			} else
				string = String.format("账号: %s, 身份: 教师 , 登录:  %s , 登录时间:  %s \n", id, "failed", df.format(new Date()));
		} else if (status.equals("A")) {// 管理员

			if ("123".equals(id) && "123".equals(psd)) {
				string = String.format("账号: %s, 身份: 管理员 , 登录:  %s , 登录时间:  %s \n", id, "succeeded",
						df.format(new Date()));
			} else
				string = String.format("账号: %s, 身份: 管理员 , 登录:  %s , 登录时间:  %s \n", id, "failed", df.format(new Date()));
		}

		System.out.println(string);
		File file = new File("Login_data.txt");
		FileOutputStream stream = new FileOutputStream(file, true);
		OutputStreamWriter writer = new OutputStreamWriter(stream);
		writer.write(string);
		writer.close();
		stream.close();
	}
}