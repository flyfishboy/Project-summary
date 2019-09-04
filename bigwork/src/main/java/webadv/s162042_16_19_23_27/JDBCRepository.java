package webadv.s162042_16_19_23_27;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import webadv.s162042_16_19_23_27.entity.Student;
import webadv.s162042_16_19_23_27.entity.Teacher;

//对数据库的所有操作与返回等方法
@Repository
public class JDBCRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 
	 * @Title: validTeacher
	 * @Description: TODO(判断是否有这个老师，输入账号密码，返回老师类型)
	 * @param account
	 * @param password
	 * @return Teacher
	 * @author 砬
	 */
	public Teacher validTeacher(String account, String password) {
		String sql = "select * from bigwork.teacher where t_id=? and t_password=md5(?)";
		RowMapper<Teacher> rowMapper = new BeanPropertyRowMapper<Teacher>(Teacher.class);// 映射
		List<Teacher> list = jdbcTemplate.query(sql, rowMapper, account, password);// 前两项固定，后几项参数长度不固定
		if (list != null && list.size() > 0) {
			System.out.println(list.get(0).getT_id());
			return list.get(0);
		} else
			return null;
	}

	/**
	 * 
	 * @Title: validStudent
	 * @Description: TODO(判断是否有这个学生，输入账号密码，返回学生类型)
	 * @param account
	 * @param password
	 * @return Student
	 * @author 砬
	 */
	public Student validStudent(String account, String password) {
		String sql = "select * from bigwork.student where s_id=? and s_password=md5(?)";
		RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);// 映射
		List<Student> list = jdbcTemplate.query(sql, rowMapper, account, password);// 前两项固定，后几项参数长度不固定
		if (list != null && list.size() > 0) {
			System.out.println(list.get(0).getS_id());
			return list.get(0);
		} else
			return null;
	}

}
