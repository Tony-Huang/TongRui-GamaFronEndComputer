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
 * CatDeviceparamType entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.tongrui.shangweiji.data.CatDeviceparamType
 * @author MyEclipse Persistence Tools
 */

public class CatDeviceparamTypeDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory
			.getLog(CatDeviceparamTypeDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";

	protected void initDao() {
		// do nothing
	}

	public void save(CatDeviceparamType transientInstance) {
		log.debug("saving CatDeviceparamType instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CatDeviceparamType persistentInstance) {
		log.debug("deleting CatDeviceparamType instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CatDeviceparamType findById(java.lang.Integer id) {
		log.debug("getting CatDeviceparamType instance with id: " + id);
		try {
			CatDeviceparamType instance = (CatDeviceparamType) getHibernateTemplate()
					.get("com.tongrui.shangweiji.data.CatDeviceparamType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CatDeviceparamType instance) {
		log.debug("finding CatDeviceparamType instance by example");
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
		log.debug("finding CatDeviceparamType instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CatDeviceparamType as model where model."
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

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findAll() {
		log.debug("finding all CatDeviceparamType instances");
		try {
			String queryString = "from CatDeviceparamType";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CatDeviceparamType merge(CatDeviceparamType detachedInstance) {
		log.debug("merging CatDeviceparamType instance");
		try {
			CatDeviceparamType result = (CatDeviceparamType) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CatDeviceparamType instance) {
		log.debug("attaching dirty CatDeviceparamType instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CatDeviceparamType instance) {
		log.debug("attaching clean CatDeviceparamType instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CatDeviceparamTypeDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CatDeviceparamTypeDAO) ctx.getBean("CatDeviceparamTypeDAO");
	}
}