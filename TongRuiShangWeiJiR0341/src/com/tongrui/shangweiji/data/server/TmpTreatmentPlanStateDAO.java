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
 * TmpTreatmentPlanState entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.tongrui.shangweiji.data.server.TmpTreatmentPlanState
 * @author MyEclipse Persistence Tools
 */

public class TmpTreatmentPlanStateDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory
			.getLog(TmpTreatmentPlanStateDAO.class);
	// property constants
	public static final String STATE_NAME = "stateName";
	public static final String DESCRIPTION = "description";
	public static final String IS_UPDATE_BY_SERVER = "isUpdateByServer";

	protected void initDao() {
		// do nothing
	}

	public void save(TmpTreatmentPlanState transientInstance) {
		log.debug("saving TmpTreatmentPlanState instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TmpTreatmentPlanState persistentInstance) {
		log.debug("deleting TmpTreatmentPlanState instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TmpTreatmentPlanState findById(java.lang.Integer id) {
		log.debug("getting TmpTreatmentPlanState instance with id: " + id);
		try {
			TmpTreatmentPlanState instance = (TmpTreatmentPlanState) getHibernateTemplate()
					.get(
							"com.tongrui.shangweiji.data.server.TmpTreatmentPlanState",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TmpTreatmentPlanState instance) {
		log.debug("finding TmpTreatmentPlanState instance by example");
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
		log.debug("finding TmpTreatmentPlanState instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TmpTreatmentPlanState as model where model."
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
		log.debug("finding all TmpTreatmentPlanState instances");
		try {
			String queryString = "from TmpTreatmentPlanState";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TmpTreatmentPlanState merge(TmpTreatmentPlanState detachedInstance) {
		log.debug("merging TmpTreatmentPlanState instance");
		try {
			TmpTreatmentPlanState result = (TmpTreatmentPlanState) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TmpTreatmentPlanState instance) {
		log.debug("attaching dirty TmpTreatmentPlanState instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TmpTreatmentPlanState instance) {
		log.debug("attaching clean TmpTreatmentPlanState instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TmpTreatmentPlanStateDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TmpTreatmentPlanStateDAO) ctx
				.getBean("TmpTreatmentPlanStateDAO");
	}
}