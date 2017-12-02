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
 * CatAccOperation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.tongrui.shangweiji.data.CatAccOperation
 * @author MyEclipse Persistence Tools
 */

public class CatAccOperationDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(CatAccOperationDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";

	protected void initDao() {
		// do nothing
	}

	public void save(CatAccOperation transientInstance) {
		log.debug("saving CatAccOperation instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CatAccOperation persistentInstance) {
		log.debug("deleting CatAccOperation instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CatAccOperation findById(java.lang.Integer id) {
		log.debug("getting CatAccOperation instance with id: " + id);
		try {
			CatAccOperation instance = (CatAccOperation) getHibernateTemplate()
					.get("com.tongrui.shangweiji.data.CatAccOperation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CatAccOperation instance) {
		log.debug("finding CatAccOperation instance by example");
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
		log.debug("finding CatAccOperation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CatAccOperation as model where model."
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
		log.debug("finding all CatAccOperation instances");
		try {
			String queryString = "from CatAccOperation";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CatAccOperation merge(CatAccOperation detachedInstance) {
		log.debug("merging CatAccOperation instance");
		try {
			CatAccOperation result = (CatAccOperation) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CatAccOperation instance) {
		log.debug("attaching dirty CatAccOperation instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CatAccOperation instance) {
		log.debug("attaching clean CatAccOperation instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CatAccOperationDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CatAccOperationDAO) ctx.getBean("CatAccOperationDAO");
	}
}