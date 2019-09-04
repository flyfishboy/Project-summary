package webadv.s162042_16_19_23_27;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//拦截器
@Configuration          
public class WebConfig implements WebMvcConfigurer   {
    
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new AuthInterceptor());     
        registration.addPathPatterns("/**");         //所有路径都被拦截
        registration.excludePathPatterns("/", "/login.html", "/user/login","/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg", "/**/*.jpeg", "/**/*.gif", "/**/fonts/*", "/**/*.svg","/login","/Supervisionscore","/addRecord","/findgrade","/TeacMain",
        		"/findstudentgrade","/findclassgrade","/student1","/student2","/student3","/student4","/student22",
        		"/tijiaowenjuan","/student33","/tianxiepinke","/evaluation","/evaluation2","/evaluation4",
        		"/alreadyEva","/e_analysis","/e_analysis","/admin_showstudent","/admin_showstudent",
        		"/admin_addstudent","/admin_addstudent","/admin_tochangestudent","/admin_changestudent",
        		"/admin_showteacher","/admin_showteacher","/admin_addteacher","/admin_addteacher",
        		"/admin_tochangeteacher","/admin_changeteacher","/admin_deletestudent","/admin_deleteteacher",
        		"/download","/404","/xiazaiwenjuan");       //添加不拦截路径

    }

}
