package co.edu.icesi.viajes.proyectoicesiviajes.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RecordRepository {

    private final JdbcTemplate jdbcTemplate;

    public RecordRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Record> getAllRecords(String tableName, Long id, Long idContent, Long idUser, Date date) {
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM ").append(tableName);
        List<Object> queryParams = new ArrayList<>();

        if (id != null || idContent != null || idUser != null || date != null) {
            queryBuilder.append(" WHERE ");
            List<String> conditions = new ArrayList<>();

            if (id != null) {
                conditions.add("id = ?");
                queryParams.add(id);
            }
            if (idContent != null) {
                conditions.add("idContent = ?");
                queryParams.add(idContent);
            }
            if (idUser != null) {
                conditions.add("idUser = ?");
                queryParams.add(idUser);
            }
            if (date != null) {
                conditions.add("date = ?");
                queryParams.add(date);
            }

            queryBuilder.append(conditions.stream().collect(Collectors.joining(" AND ")));
        }

        String query = queryBuilder.toString();
        return jdbcTemplate.query(query, queryParams.toArray(), (rs, rowNum) ->
                new Record(
                        rs.getLong("id"),
                        rs.getLong("idContent"),
                        rs.getLong("idUser"),
                        rs.getDate("date")
                ));
    }

}
