package Database_stuff;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PaameldteDAO {
	
	@PersistenceContext(name="paameldingDB")
	private EntityManager em;
	
	//metoder
	
	public List<Paameldte> visDeltakerListe(){
		return em.createQuery("select p from Paameldte p", Paameldte.class)
				.getResultList();
	}
}
