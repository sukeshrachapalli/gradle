package com.javatpoint.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import com.javatpoint.beans.Student;  
  
public class StudDao {  
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Student s){  
    String sql="insert into Student values(?,?,?,?)";  
    return template.update(sql,new Object[] { s.getId(),s.getName(),s.getcgpa(),s.getDepartment() });  
}  
public int update(Student s){  
    String sql="update Student set name='"+s.getName()+"', cgpa="+s.getcgpa()+",department='"+s.getDepartment()+"' where id="+s.getId()+"";  
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from Student where id="+id+"";  
    return template.update(sql);  
}  
public Student getStudById(int id){  
    String sql="select * from Student where id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Student>(Student.class));  
}  
public List<Student> getStudents(){  
    return template.query("select * from Student",new RowMapper<Student>(){  
        public Student mapRow(ResultSet rs, int row) throws SQLException {  
            Student s=new Student();  
            s.setId(rs.getInt(1));  
            s.setName(rs.getString(2));  
            s.setcgpa(rs.getFloat(3));  
            s.setDepartment(rs.getString(4));  
            return s;  
        }  
    });  
}  
}  