package fr.epita.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.epita.datamodel.MCQChoice;

public class MCQChoiceJPADAO extends GenericDAO<MCQChoice>{

	@Override
	public List<MCQChoice> search(MCQChoice criteria) {
		Session session = this.sf.openSession();
		Query<MCQChoice> query = session.createQuery("from MCQChoice c where c.valid = :valid and c.choice like :choiceContent", MCQChoice.class);
		query.setParameter("valid", criteria.isValid());
		query.setParameter("choiceContent", criteria.getChoice());
		List<MCQChoice> resultList = query.getResultList();
		return resultList;
	}
	

}
