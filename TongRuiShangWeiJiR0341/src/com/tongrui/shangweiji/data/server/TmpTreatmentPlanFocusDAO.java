package com.tongrui.shangweiji.data.server;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TmpTreatmentPlanFocus entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.tongrui.shangweiji.data.server.TmpTreatmentPlanFocus
 * @author MyEclipse Persistence Tools
 */

public class TmpTreatmentPlanFocusDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory
			.getLog(TmpTreatmentPlanFocusDAO.class);
	// property constants
	public static final String FOCUS_NUMBER = "focusNumber";
	public static final String ENABLED = "enabled";
	public static final String PLAN_X = "planX";
	public static final String PLAN_Y = "planY";
	public static final String PLAN_Z = "planZ";
	public static final String COUCH_X = "couchX";
	public static final String COUCH_Y = "couchY";
	public static final String COUCH_Z = "couchZ";
	public static final String PLAN_CURE_PERIOD = "planCurePeriod";
	public static final String CURE_PERIOD = "curePeriod";
	public static final String IS_UPDATE_BY_SERVER = "isUpdateByServer";
	public static final String IS_UPDATE_BY_UPPER = "isUpdateByUpper";

	protected void initDao() {
		// do nothing
	}

	public void save(TmpTreatmentPlanFocus transientInstance) {
		log.debug("saving TmpTreatmentPlanFocus instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TmpTreatmentPlanFocus persistentInstance) {
		log.debug("deleting TmpTreatmentPlanFocus instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TmpTreatmentPlanFocus findById(java.lang.Integer id) {
		log.debug("getting TmpTreatmentPlanFocus instance with id: " + id);
		try {
			TmpTreatmentPlanFocus instance = (TmpTreatmentPlanFocus) getHibernateTemplate()
					.get(
							"com.tongrui.shangweiji.data.server.TmpTreatmentPlanFocus",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TmpTreatmentPlanFocus instance) {
		log.debug("finding TmpTreatmentPlanFocus instance by example");
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
		log.debug("finding TmpTreatmentPlanFocus instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TmpTreatmentPlanFocus as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFocusNumber(Object focusNumber) {
		return findByProperty(FOCUS_NUMBER, focusNumber);
	}

	public List findByEnabled(Object enabled) {
		return findByProperty(ENABLED, enabled);
	}

	public List findByPlanX(Object planX) {
		return findByProperty(PLAN_X, planX);
	}

	public List findByPlanY(Object planY) {
		return findByProperty(PLAN_Y, planY);
	}

	public List findByPlanZ(Object planZ) {
		return findByProperty(PLAN_Z, planZ);
	}

	public List findByCouchX(Object couchX) {
		return findByProperty(COUCH_X, couchX);
	}

	public List findByCouchY(Object couchY) {
		return findByProperty(COUCH_Y, couchY);
	}

	public List findByCouchZ(Object couchZ) {
		return findByProperty(COUCH_Z, couchZ);
	}

	public List findByPlanCurePeriod(Object planCurePeriod) {
		return findByProperty(PLAN_CURE_PERIOD, planCurePeriod);
	}

	public List findByCurePeriod(Object curePeriod) {
		return findByProperty(CURE_PERIOD, curePeriod);
	}

	public List findByIsUpdateByServer(Object isUpdateByServer) {
		return findByProperty(IS_UPDATE_BY_SERVER, isUpdateByServer);
	}

	public List findByIsUpdateByUpper(Object isUpdateByUpper) {
		return findByProperty(IS_UPDATE_BY_UPPER, isUpdateByUpper);
	}

	public List findAll() {
		log.debug("finding all TmpTreatmentPlanFocus instances");
		try {
			String queryString = "from TmpTreatmentPlanFocus";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TmpTreatmentPlanFocus merge(TmpTreatmentPlanFocus detachedInstance) {
		log.debug("merging TmpTreatmentPlanFocus instance");
		try {
			TmpTreatmentPlanFocus result = (TmpTreatmentPlanFocus) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TmpTreatmentPlanFocus instance) {
		log.debug("attaching dirty TmpTreatmentPlanFocus instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TmpTreatmentPlanFocus instance) {
		log.debug("attaching clean TmpTreatmentPlanFocus instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TmpTreatmentPlanFocusDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TmpTreatmentPlanFocusDAO) ctx
				.getBean("TmpTreatmentPlanFocusDAO");
	}
}