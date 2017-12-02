package com.tongrui.shangweiji.data.server;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TmpTreatmentFractionState entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.tongrui.shangweiji.data.server.TmpTreatmentFractionState
 * @author MyEclipse Persistence Tools
 */

public class TmpTreatmentFractionStateDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory
			.getLog(TmpTreatmentFractionStateDAO.class);
	// property constants
	public static final String STATE_NAME = "stateName";
	public static final String DESCRIPTION = "description";
	public static final String IS_UPDATE_BY_SERVER = "isUpdateByServer";

	protected void initDao() {
		// do nothing
	}

	public void save(TmpTreatmentFractionState transientInstance) {
		log.debug("saving TmpTreatmentFractionState instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TmpTreatmentFractionState persistentInstance) {
		log.debug("deleting TmpTreatmentFractionState instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TmpTreatmentFractionState findById(java.lang.Integer id) {
		log.debug("getting TmpTreatmentFractionState instance with id: " + id);
		try {
			TmpTreatmentFractionState instance = (TmpTreatmentFractionState) getHibernateTemplate()
					.get(
							"com.tongrui.shangweiji.data.server.TmpTreatmentFractionState",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TmpTreatmentFractionState instance) {
		log.debug("finding TmpTreatmentFractionState instance by example");
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
		log.debug("finding TmpTreatmentFractionState instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TmpTreatmentFractionState as model where model."
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

	public List findByIsUpdateByServer(Object isUpdateByServer) {
		return findByProperty(IS_UPDATE_BY_SERVER, isUpdateByServer);
	}

	public List findAll() {
		log.debug("finding all TmpTreatmentFractionState instances");
		try {
			String queryString = "from TmpTreatmentFractionState";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TmpTreatmentFractionState merge(
			TmpTreatmentFractionState detachedInstance) {
		log.debug("merging TmpTreatmentFractionState instance");
		try {
			TmpTreatmentFractionState result = (TmpTreatmentFractionState) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TmpTreatmentFractionState instance) {
		log.debug("attaching dirty TmpTreatmentFractionState instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TmpTreatmentFractionState instance) {
		log.debug("attaching clean TmpTreatmentFractionState instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TmpTreatmentFractionStateDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TmpTreatmentFractionStateDAO) ctx
				.getBean("TmpTreatmentFractionStateDAO");
	}
}