package webadv.s162042_16_19_23_27;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.DefaultEditorKit.InsertTabAction;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import webadv.s162042_16_19_23_27.entity.Student;
import webadv.s162042_16_19_23_27.entity.course_back_27;
import webadv.s162042_16_19_23_27.entity.grade_27;
import webadv.s162042_16_19_23_27.entity.questionnaire_27;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

@Mapper
public interface studentRespository {

	//��ѯ����ѧ����Ϣ
	@Select("select * from student") 
	public List<Student> findAllStu();
	
	//��ѯĳ��ʦ�������ʾ�
	@Select("select questionnaire.c_id,c_name,q_content1,q_content2,q_content3,q_time from questionnaire,course where course.c_id=questionnaire.c_id and questionnaire.t_id=#{t_id} group by questionnaire.c_id")
	public List<questionnaire_27> findTeacQues(@Param("t_id") String t_id);
	
	//��ѯĳ�ſγ�����д���ʾ�
	@Select("select questionnaire.c_id,c_name,questionnaire.s_id,q_content1,q_answer1,q_content2,q_answer2,q_content3,q_answer3,q_time from questionnaire,course where course.c_id=questionnaire.c_id and questionnaire.c_id=#{c_id}")
	public List<questionnaire_27> findCourQues(@Param("c_id") String c_id);
	
	//����ʾ�
	@Insert("insert into questionnaire(s_id,c_id,t_id,q_time,q_content1,q_content2,q_content3) values(#{s_id},#{c_id},#{t_id},#{q_time},#{q_content1},#{q_content2},#{q_content3})")
	public void insertQues(@Param("s_id") String s_id,@Param("c_id") String c_id,@Param("t_id") String t_id,@Param("q_time") String q_time,@Param("q_content1") String q_content1,@Param("q_content2") String q_content2,@Param("q_content3") String q_content3);
	
	//��ѯĳ��ѧ�������ʾ�
	@Select("select s_id,questionnaire.c_id,questionnaire.t_id,q_time,q_content1,q_answer1,q_content2,q_answer2,q_content3,q_answer3,c_name,t_name from questionnaire,course,teacher where s_id=#{s_id} and questionnaire.c_id=course.c_id and course.t_id=teacher.t_id") 
	public List<questionnaire_27> findAllQues(@Param("s_id") String s_id);
	
	
	//��ѯĳ���ʾ�
	@Select("select s_id,questionnaire.c_id,questionnaire.t_id,q_time,q_content1,q_answer1,q_content2,q_answer2,q_content3,q_answer3,c_name,t_name from questionnaire,course,teacher where s_id=#{s_id} and questionnaire.c_id=#{c_id} and questionnaire.c_id=course.c_id and course.t_id=teacher.t_id") 
	public questionnaire_27 findOneQues(@Param("s_id") String s_id,@Param("c_id") String c_id);
	
	//�ύ�ʾ�
	@Update("update questionnaire set q_answer1=#{q_answer1},q_answer2=#{q_answer2},q_answer3=#{q_answer3} where s_id=#{s_id} and c_id=#{c_id}") 
	public void updateOneQues(@Param("s_id") String s_id,@Param("c_id") String c_id,@Param("q_answer1") String q_answer1,@Param("q_answer2") String q_answer2,@Param("q_answer3") String q_answer3);
	
	//��ѯһ��ѧ�����п�Ŀ�ɼ�
	@Select("select grade.s_id,grade.c_id,sum(g_score) as sumgrade,c_name,t_name from grade,course,teacher where s_id=#{s_id} and course.c_id=grade.c_id and course.t_id=teacher.t_id group by c_id")
	public List<grade_27> finaAllGradeBys_Id(@Param("s_id") String s_id);
	
	//��ѯһ��ѧ����������
	@Select("select course_back.s_id,course_back.c_id,cb_score,cb_content,c_name,t_name from course_back,course,teacher where s_id=#{s_id} and course.c_id=course_back.c_id and course.t_id=teacher.t_id")
	public List<course_back_27> findAllCourseBackById(@Param("s_id") String s_id);
	
	//��ѯһ������
	@Select("select course_back.s_id,course_back.c_id,cb_score,cb_content,c_name,t_name from course_back,course,teacher where s_id=#{s_id} and course_back.c_id=#{c_id} and course.c_id=course_back.c_id and course.t_id=teacher.t_id")
	public course_back_27 findOneCourseBackById(@Param("s_id") String s_id,@Param("c_id") String c_id);
	
	//�������μ�¼
	@Update("update course_back set cb_score=#{cb_score},cb_content=#{cb_content} where s_id=#{s_id} and c_id=#{c_id}") 
	public void updateOneCouBack(@Param("s_id") String s_id,@Param("c_id") String c_id,@Param("cb_score") double cb_score,@Param("cb_content") String cb_content);
}
