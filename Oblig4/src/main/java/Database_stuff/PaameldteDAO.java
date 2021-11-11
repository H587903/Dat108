package Database_stuff;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import Hjelpeklasser.PassordUtil;

@Stateless
public class PaameldteDAO {
	
	@PersistenceContext(name="paameldingDB")
	private EntityManager em;
	
	//metoder
	
	public List<Paameldte> visDeltakerListe(){
		try {
			List<Paameldte> liste =  em.createQuery("SELECT p FROM Paameldte p", Paameldte.class)
					.getResultList();
			liste = liste.stream().sorted(Comparator.comparing(Paameldte::getFornavn)
					.thenComparing(Comparator.comparing(Paameldte::getEtternavn)))
					.collect(Collectors.toList());
			return liste;
		}catch(NoResultException e) {
			return null;
		}
		
	}
	
	public boolean sjekkMobilFinst(String mobil) {
		try {
			em.createQuery("SELECT p FROM Paameldte p WHERE p.mobil = ?1", Paameldte.class).setParameter(1, mobil).getSingleResult();
			return true;
		}catch(NoResultException e) {
			return false;
		}
	}
	
	public boolean sjekkLogin(String passord, String mobil) {
		try {
			Paameldte paameldte = em.createQuery("SELECT p FROM Paameldte p WHERE p.mobil = ?1", Paameldte.class).setParameter(1, mobil).getSingleResult();
			return PassordUtil.validerMedSalt(passord, paameldte.getSalt(), paameldte.getPassord());
		}catch(NoResultException e) {
			return false;
		}
	}
	
	
	
	public void skrivTilDatabase(Paameldte p) {
		em.persist(p);
	}
}



