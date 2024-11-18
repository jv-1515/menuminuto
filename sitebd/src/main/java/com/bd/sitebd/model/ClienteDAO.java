import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;

import jakarta.annotation.PostConstruct;

public class ClienteDAO {
    @Autowired

    JdbcTemplate jdbc;
    
    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserir(Cliente cli){
        String sql = "INSERT INTO cliente (nome, cpf) VALUES (?, ?)";
        Object[] parametros = new Object[2];
        

    }
}