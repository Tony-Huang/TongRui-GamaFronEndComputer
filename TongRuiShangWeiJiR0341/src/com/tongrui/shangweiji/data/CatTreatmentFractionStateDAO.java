package com.tongrui.shangweiji.data;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * CatTreatmentFractionState entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.tongrui.shangweiji.data.CatTreatmentFractionState
 * @author MyEclipse Persistence Tools
 */

public class CatTreatmentFractionStateDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory
			.getLog(CatTreatmentFractionStateDAO.class);
	// property constants
	public static final String STATE_NAME = "stateName";
	public static final String DESCRIPTION = "description";

	protected void initDao() {
		// do nothing
	}

	public void save(CatTreatmentFractionState transientInstance) {
		log.debug("saving CatTreatmentFractionState instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CatTreatmentFractionState persistentInstance) {
		log.debug("deleting CatTreatmentFractionState instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CatTreatmentFractionState findById(java.lang.Integer id) {
		log.debug("getting CatTreatmentFractionState instance with id: " + id);
		try {
			CatTreatmentFractionState instance = (CatTreatmentFractionState) getHibernateTemplate()
					.get(
							"com.tongrui.shangweiji.data.CatTreatmentFractionState",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CatTreatmentFractionState instance) {
		log.debug("finding CatTreatmentFractionState instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CatTreatmentFractionState instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CatTreatmentFractionState as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStateName(Object stateName) {
		return findByProperty(STATE_NAME, stateName);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findAll() {
		log.debug("finding all CatTreatmentFractionState instances");
		try {
			String queryString = "from CatTreatmentFractionState";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CatTreatmentFractionState merge(
			CatTreatmentFractionState detachedInstance) {
		log.debug("merging CatTreatmentFractionState instance");
		try {
			CatTreatmentFractionState result = (CatTreatmentFractionState) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CatTreatmentFractionState instance) {
		log.debug("attaching dirty CatTreatmentFractionState instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CatTreatmentFractionState instance) {
		log.debug("attaching clean CatTreatmentFractionState instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CatTreatmentFractionStateDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CatTreatmentFractionStateDAO) ctx
				.getBean("CatTreatmentFractionStateDAO");
	}
}