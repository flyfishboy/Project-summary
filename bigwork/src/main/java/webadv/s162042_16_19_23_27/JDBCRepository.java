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

//�����ݿ�����в����뷵�صȷ���
@Repository
public class JDBCRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 
	 * @Title: validTeacher
	 * @Description: TODO(�ж��Ƿ��������ʦ�������˺����룬������ʦ����)
	 * @param account
	 * @param password
	 * @return Teacher
	 * @author ��
	 */
	public Teacher validTeacher(String account, String password) {
		String sql = "select * from bigwork.teacher where t_id=? and t_password=md5(?)";
		RowMapper<Teacher> rowMapper = new BeanPropertyRowMapper<Teacher>(Teacher.class);// ӳ��
		List<Teacher> list = jdbcTemplate.query(sql, rowMapper, account, password);// ǰ����̶�������������Ȳ��̶�
		if (list != null && list.size() > 0) {
			System.out.println(list.get(0).getT_id());
			return list.get(0);
		} else
			return null;
	}

	/**
	 * 
	 * @Title: validStudent
	 * @Description: TODO(�ж��Ƿ������ѧ���������˺����룬����ѧ������)
	 * @param account
	 * @param password
	 * @return Student
	 * @author ��
	 */
	public Student validStudent(String account, String password) {
		String sql = "select * from bigwork.student where s_id=? and s_password=md5(?)";
		RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);// ӳ��
		List<Student> list = jdbcTemplate.query(sql, rowMapper, account, password);// ǰ����̶�������������Ȳ��̶�
		if (list != null && list.size() > 0) {
			System.out.println(list.get(0).getS_id());
			return list.get(0);
		} else
			return null;
	}

}
