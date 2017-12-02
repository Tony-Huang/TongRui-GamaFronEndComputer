package com.tongrui.shangweiji.data;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * CatDeviceparamValueHistory entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.tongrui.shangweiji.data.CatDeviceparamValueHistory
 * @author MyEclipse Persistence Tools
 */

public class CatDeviceparamValueHistoryDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory
			.getLog(CatDeviceparamValueHistoryDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String VALUE = "value";
	public static final String UPLIMIT = "uplimit";
	public static final String LOWLIMIT = "lowlimit";
	public static final String CREATED_BY = "createdBy";
	public static final String MODIFIED_BY = "modifiedBy";

	protected void initDao() {
		// do nothing
	}

	public void save(CatDeviceparamValueHistory transientInstance) {
		log.debug("saving CatDeviceparamValueHistory instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CatDeviceparamValueHistory persistentInstance) {
		log.debug("deleting CatDeviceparamValueHistory instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CatDeviceparamValueHistory findById(java.lang.Integer id) {
		log.debug("getting CatDeviceparamValueHistory instance with id: " + id);
		try {
			CatDeviceparamValueHistory instance = (CatDeviceparamValueHistory) getHibernateTemplate()
					.get(
							"com.tongrui.shangweiji.data.CatDeviceparamValueHistory",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CatDeviceparamValueHistory instance) {
		log.debug("finding CatDeviceparamValueHistory instance by example");
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
		log.debug("finding CatDeviceparamValueHistory instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CatDeviceparamValueHistory as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByValue(Object value) {
		return findByProperty(VALUE, value);
	}

	public List findByUplimit(Object uplimit) {
		return findByProperty(UPLIMIT, uplimit);
	}

	public List findByLowlimit(Object lowlimit) {
		return findByProperty(LOWLIMIT, lowlimit);
	}

	public List findByCreatedBy(Object createdBy) {
		return findByProperty(CREATED_BY, createdBy);
	}

	public List findByModifiedBy(Object modifiedBy) {
		return findByProperty(MODIFIED_BY, modifiedBy);
	}

	public List findAll() {
		log.debug("finding all CatDeviceparamValueHistory instances");
		try {
			String queryString = "from CatDeviceparamValueHistory";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CatDeviceparamValueHistory merge(
			CatDeviceparamValueHistory detachedInstance) {
		log.debug("merging CatDeviceparamValueHistory instance");
		try {
			CatDeviceparamValueHistory result = (CatDeviceparamValueHistory) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CatDeviceparamValueHistory instance) {
		log.debug("attaching dirty CatDeviceparamValueHistory instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CatDeviceparamValueHistory instance) {
		log.debug("attaching clean CatDeviceparamValueHistory instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CatDeviceparamValueHistoryDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CatDeviceparamValueHistoryDAO) ctx
				.getBean("CatDeviceparamValueHistoryDAO");
	}
}