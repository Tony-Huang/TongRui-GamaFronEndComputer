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
 * CatTreatmentPlanState entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.tongrui.shangweiji.data.CatTreatmentPlanState
 * @author MyEclipse Persistence Tools
 */

public class CatTreatmentPlanStateDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory
			.getLog(CatTreatmentPlanStateDAO.class);
	// property constants
	public static final String STATE_NAME = "stateName";
	public static final String DESCRIPTION = "description";

	protected void initDao() {
		// do nothing
	}

	public void save(CatTreatmentPlanState transientInstance) {
		log.debug("saving CatTreatmentPlanState instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CatTreatmentPlanState persistentInstance) {
		log.debug("deleting CatTreatmentPlanState instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CatTreatmentPlanState findById(java.lang.Integer id) {
		log.debug("getting CatTreatmentPlanState instance with id: " + id);
		try {
			CatTreatmentPlanState instance = (CatTreatmentPlanState) getHibernateTemplate()
					.get("com.tongrui.shangweiji.data.CatTreatmentPlanState",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CatTreatmentPlanState instance) {
		log.debug("finding CatTreatmentPlanState instance by example");
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
		log.debug("finding CatTreatmentPlanState instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CatTreatmentPlanState as model where model."
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
		log.debug("finding all CatTreatmentPlanState instances");
		try {
			String queryString = "from CatTreatmentPlanState";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CatTreatmentPlanState merge(CatTreatmentPlanState detachedInstance) {
		log.debug("merging CatTreatmentPlanState instance");
		try {
			CatTreatmentPlanState result = (CatTreatmentPlanState) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CatTreatmentPlanState instance) {
		log.debug("attaching dirty CatTreatmentPlanState instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CatTreatmentPlanState instance) {
		log.debug("attaching clean CatTreatmentPlanState instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CatTreatmentPlanStateDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CatTreatmentPlanStateDAO) ctx
				.getBean("CatTreatmentPlanStateDAO");
	}
}