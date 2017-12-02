package com.tongrui.shangweiji.data;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * CatAccPrivilege entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.tongrui.shangweiji.data.CatAccPrivilege
 * @author MyEclipse Persistence Tools
 */

public class CatAccPrivilegeDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(CatAccPrivilegeDAO.class);
	// property constants
	public static final String ACTIVE = "active";

	protected void initDao() {
		// do nothing
	}

	public void save(CatAccPrivilege transientInstance) {
		log.debug("saving CatAccPrivilege instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CatAccPrivilege persistentInstance) {
		log.debug("deleting CatAccPrivilege instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CatAccPrivilege findById(java.lang.Integer id) {
		log.debug("getting CatAccPrivilege instance with id: " + id);
		try {
			CatAccPrivilege instance = (CatAccPrivilege) getHibernateTemplate()
					.get("com.tongrui.shangweiji.data.CatAccPrivilege", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CatAccPrivilege instance) {
		log.debug("finding CatAccPrivilege instance by example");
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
		log.debug("finding CatAccPrivilege instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CatAccPrivilege as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByActive(Object active) {
		return findByProperty(ACTIVE, active);
	}

	public List findAll() {
		log.debug("finding all CatAccPrivilege instances");
		try {
			String queryString = "from CatAccPrivilege";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CatAccPrivilege merge(CatAccPrivilege detachedInstance) {
		log.debug("merging CatAccPrivilege instance");
		try {
			CatAccPrivilege result = (CatAccPrivilege) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CatAccPrivilege instance) {
		log.debug("attaching dirty CatAccPrivilege instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CatAccPrivilege instance) {
		log.debug("attaching clean CatAccPrivilege instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CatAccPrivilegeDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CatAccPrivilegeDAO) ctx.getBean("CatAccPrivilegeDAO");
	}
}