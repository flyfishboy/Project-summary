package webadv.s162042_16_19_23_27;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import webadv.s162042_16_19_23_27.entity.Course;
import webadv.s162042_16_19_23_27.entity.Teacher;
import webadv.s162042_16_19_23_27.entity.s16_c_g;
import webadv.s162042_16_19_23_27.entity.s16_s_c;
import webadv.s162042_16_19_23_27.entity.s16_t_assess;

@Repository
public class s16_repository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

}
@Mapper
interface Srepository {

		//��ʦ�ܲ鿴���еĽ�ʦ������Ϣ���ο���Ϣ
		@Select("select teacher.t_id,teacher.t_password,teacher.t_name,course.c_id,course.c_name from teacher,course where teacher.t_id = course.t_id;")
		public List<s16_s_c> t_findAllSCourse();
		
		//��ʦͨ������ģ�����������ʦ
		@Select("select teacher.t_id,teacher.t_password,teacher.t_name,course.c_id,course.c_name from teacher,course where teacher.t_id = course.t_id and t_name like concat('%',#{t_name},'%')")
		public List<s16_s_c> t_findteacher(@Param("t_name") String t_name);
		
		//��ʦ�ύ����
		@Select("insert into teac_assess values (#{cs},#{cc},#{ta_content}) ")
		public void  t_evaluation(@Param("cs") String t_id ,@Param("cc") String c_id,@Param("ta_content") String ta_content);
		
		//������֤��ʦ�Ƿ��Ѿ����۹���
		@Select("select c_id from teac_assess;")
		public List<s16_t_assess> t_findAllAssess();
		
		//��ԃ�̎�����ÿ����Ŀ��ÿ���}��ƽ���֣���һ��
		@Select("select teacher.t_id, grade.c_id,avg(g_score) as avg_grade,c_name,g_qn from grade,course,teacher where teacher.t_id='20001' and g_qn='1' and course.t_id=teacher.t_id and grade.c_id=course.c_id group by grade.c_id;")
		public List<s16_c_g> c_findavggrade1(@Param("t_id") String t_id);
		
		//��ԃ�̎�����ÿ����Ŀ��ÿ���}��ƽ���֣������
		@Select("select teacher.t_id, grade.c_id,avg(g_score) as avg_grade,c_name,g_qn from grade,course,teacher where teacher.t_id=#{t_id} and g_qn='2' and course.t_id=teacher.t_id and grade.c_id=course.c_id group by grade.c_id;")
		public List<s16_c_g> c_findavggrade2(@Param("t_id") String t_id);
		
		//��ԃ�̎�����ÿ����Ŀ��ÿ���}��ƽ���֣�������
		@Select("select teacher.t_id, grade.c_id,avg(g_score) as avg_grade,c_name,g_qn from grade,course,teacher where teacher.t_id=#{t_id} and g_qn='3' and course.t_id=teacher.t_id and grade.c_id=course.c_id group by grade.c_id;")
		public List<s16_c_g> c_findavggrade3(@Param("t_id") String t_id);
		
		//��ԃ�̎�����ÿ����Ŀ��ÿ���}��ƽ���֣����ģ�
		@Select("select teacher.t_id, grade.c_id,avg(g_score) as avg_grade,c_name,g_qn from grade,course,teacher where teacher.t_id=#{t_id} and  g_qn='4' and course.t_id=teacher.t_id and grade.c_id=course.c_id group by grade.c_id;")
		public List<s16_c_g> c_findavggrade4(@Param("t_id") String t_id);
		
		//��ʦͨ������ģ�����������ʦ
		@Select("select teacher.t_id, grade.c_id,avg(g_score) as avg_grade,c_name,g_qn from grade,course,teacher where teacher.t_id=#{t_id} and g_qn=#{g_qn} and course.t_id=teacher.t_id and grade.c_id=course.c_id group by grade.c_id;")
		public List<s16_c_g> c_findid(@Param("g_qn") String g_qn,@Param("t_id") String t_id);
}
