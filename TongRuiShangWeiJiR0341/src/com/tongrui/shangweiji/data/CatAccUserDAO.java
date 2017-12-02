package com.tongrui.shangweiji.data;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * CatAccUser entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.tongrui.shangweiji.data.CatAccUser
 * @author MyEclipse Persistence Tools
 */

public class CatAccUserDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(CatAccUserDAO.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String PASSWORD = "password";
	public static final String DESCRIPTION = "description";
	public static final String ACTIVE = "active";

	protected void initDao() {
		// do nothing
	}

	public void save(CatAccUser transientInstance) {
		log.debug("saving CatAccUser instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CatAccUser persistentInstance) {
		log.debug("deleting CatAccUser instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CatAccUser findById(java.lang.Integer id) {
		log.debug("getting CatAccUser instance with id: " + id);
		try {
			CatAccUser instance = (CatAccUser) getHibernateTemplate().get(
					"com.tongrui.shangweiji.data.CatAccUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CatAccUser instance) {
		log.debug("finding CatAccUser instance by example");
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
		log.debug("finding CatAccUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CatAccUser as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findByActive(Object active) {
		return findByProperty(ACTIVE, active);
	}

	public List findAll() {
		log.debug("finding all CatAccUser instances");
		try {
			String queryString = "from CatAccUser";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CatAccUser merge(CatAccUser detachedInstance) {
		log.debug("merging CatAccUser instance");
		try {
			CatAccUser result = (CatAccUser) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CatAccUser instance) {
		log.debug("attaching dirty CatAccUser instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CatAccUser instance) {
		log.debug("attaching clean CatAccUser instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CatAccUserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CatAccUserDAO) ctx.getBean("CatAccUserDAO");
	}
}