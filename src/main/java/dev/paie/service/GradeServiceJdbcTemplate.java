package dev.paie.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;

@Service
public class GradeServiceJdbcTemplate implements GradeService {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void sauvegarder(Grade nouveauGrade) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO grade (id,code,nbheuresbase,tauxbase) VALUES(?,?,?,?)";
		this.jdbcTemplate.update(sql, nouveauGrade.getId(),nouveauGrade.getCode(),nouveauGrade.getNbHeuresBase(), nouveauGrade.getTauxBase());	
		
	}

	@Override
	public void mettreAJour(Grade gradeModifier) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("update grade set code=?,nbheuresbase=? ,tauxbase=? WHERE id=?", 
				gradeModifier.getCode(),
				gradeModifier.getNbHeuresBase(), 
				gradeModifier.getTauxBase(),
				gradeModifier.getId());
	}

	@Override
	public List<Grade> lister() {
		// TODO Auto-generated method stub
		//String sql = "SELECT * FROM grade" ;
		return jdbcTemplate.query(
				  "SELECT * FROM grade", (rs, rowNum) -> {
					    Grade grade = new Grade();
					    grade.setId(rs.getInt("id"));
					    grade.setCode(rs.getString("code"));
					    grade.setNbHeuresBase(rs.getBigDecimal("nbheuresbase"));
					    grade.setTauxBase(rs.getBigDecimal("tauxbase"));
					    return grade;
					});
	}

}
