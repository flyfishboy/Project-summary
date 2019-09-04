package webadv.s162042_16_19_23_27_repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import webadv.s162042_16_19_23_27.entity.ClassGrade;
import webadv.s162042_16_19_23_27.entity.Course;
import webadv.s162042_16_19_23_27.entity.Record;
import webadv.s162042_16_19_23_27.entity.Teacher;
import webadv.s162042_16_19_23_27.entity.studentgrade;

@Mapper
public interface TeacherRepository1 {

	@Results(id = "RecordMap", value = { @Result(property = "t_id", column = "t_id", jdbcType = JdbcType.INTEGER),
			@Result(property = "c_id", column = "c_id"),
			@Result(property = "r_time", column = "r_time"),
			@Result(property = "r_score", column = "r_score"),
	@Result(property = "r_text", column = "r_text")})

	@Select("select * from record")
	public List<Record> findAll();
	
	@Select("select * from course where t_id=#{t_id}")
	public List<Course> findCourse(@Param("t_id") String t_id);
	
	@Insert("insert into record (t_id,c_id,r_time,r_score,r_text) values (#{t_id},#{c_id},#{r_time},#{r_score},#{r_text})")
	@ResultMap(value = "RecordMap")
	public  void addRecord(@Param("t_id") String t_id,@Param("c_id") String c_id,@Param("r_time") String r_time,@Param("r_score") String r_score,@Param("r_text") String r_text);
	
	@Select("select * from t_teacher where teacher_account=#{account} and teacher_password=#{password}")
	@ResultMap(value = "RecordMap")
	public Teacher validTeacher(@Param("account") String account, @Param("password") String password);

	@Select("select * from t_teacher where teacher_name like concat('%',#{name},'%')")
	@ResultMap(value = "RecordMap")
	public List<Teacher> findByName(@Param("name") String name);
	
	@Select("select grade.s_id,student.s_name,attendance.a_sum,attendance.a_absence,sum(grade.g_score) as sumgrade from attendance,grade,student where attendance.s_id=grade.s_id and grade.s_id=student.s_id and attendance.c_id=grade.c_id and grade.c_id=#{c_id} group by grade.s_id")
	public List<studentgrade> findAllstudentgrade(@Param("c_id") String c_id);
	
	@Select("select student.s_class,sum(grade.g_score) as sum_class_grade,count(student.s_id) as sum_class_student from grade,student where grade.s_id=student.s_id and grade.c_id=#{c_id} group by student.s_class;")
	public List<ClassGrade> findClassGrades(@Param("c_id") String c_id);
	
}
