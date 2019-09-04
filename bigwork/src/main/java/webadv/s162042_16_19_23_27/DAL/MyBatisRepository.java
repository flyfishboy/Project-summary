package webadv.s162042_16_19_23_27.DAL;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import webadv.s162042_16_19_23_27.entity.Student;
import webadv.s162042_16_19_23_27.entity.Teacher;


@Mapper
public interface MyBatisRepository {

	// 管理员删除教师 s19
	@Select("delete from teacher where t_id=#{t_id}")
	public Teacher admin_DeleteTeacher(@Param("t_id") String t_id);

	// 管理员删除学生 s19
	@Select("delete from student where s_id=#{s_id}")
	public Student admin_DeleteStudent(@Param("s_id") String s_id);

	// 管理员查询所有教师 s19
	@Select("select * from teacher")
	public List<Teacher> admin_findAllTeachers();

	// 管理员查询所有学生 s19
	@Select("select * from student")
	public List<Student> admin_findAllStudents();

	// 表示变量
	@Select("select * from t_teacher where teacher_account=#{account} and teacher_password=md5(#{password})")
	// @ResultMap(value = "teacherMap")
	// 方法内参数（和#account对应）
	public Teacher validTeacher(@Param("account") String account, @Param("password") String password);

	// 按ID查询某个老师 s19
	@Select("select * from teacher where t_id=#{t_id}")
	// @ResultMap(value = "teacherMap")
	public Teacher findTeacherById(@Param("t_id") String t_name);

	// 按ID查询某个学生 s19
	@Select("select * from student where s_id= #{s_id}")
	public Student findStudentById(@Param("s_id") String s_name);

	// 按名称查询某些老师 s19
	@Select("select * from teacher where t_name like concat('%',#{t_name},'%')")
	// @ResultMap(value = "teacherMap")
	public List<Teacher> findTeacherByName(@Param("t_name") String t_name);

	// 按名称查询某些学生 s19
	@Select("select * from student where s_name like concat('%',#{s_name},'%')")
	public List<Student> findStudentByName(@Param("s_name") String s_name);

	// 添加某个学生 s19
	@Select("insert into student values (#{s_id},md5(#{s_password}),#{s_name},#{s_sex},#{s_age},#{s_tel},#{s_class})  ")
	public Student addStudent(@Param("s_id") String s_id, @Param("s_password") String s_password,
			@Param("s_name") String s_name, @Param("s_sex") String s_sex, @Param("s_age") String s_age,
			@Param("s_tel") String s_tel, @Param("s_class") String s_class);

	// 添加某个教师 s19
	@Select("insert into teacher values (#{t_id},md5(#{t_password}),#{t_name},#{t_sex},#{t_age},#{t_tel},#{t_address},#{t_role})  ")
	public Teacher addTeacher(@Param("t_id") String t_id, @Param("t_password") String t_password,
			@Param("t_name") String t_name, @Param("t_sex") String t_sex, @Param("t_age") String t_age,
			@Param("t_tel") String t_tel, @Param("t_address") String t_address, @Param("t_role") String t_role);

	
	// 管理员修改某个学生,就是进行删除和新增的操作 s19

	// 管理员修改某个老师,就是进行删除和新增的操作 s19

	
}

