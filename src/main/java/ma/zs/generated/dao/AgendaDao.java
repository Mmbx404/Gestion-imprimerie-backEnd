package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.Agenda;


@Repository
public interface AgendaDao extends JpaRepository<Agenda,Long> {

	Agenda findByReference(String reference);
       int deleteByReference(String reference);


}