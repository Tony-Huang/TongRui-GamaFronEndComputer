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
 * CatAccRole entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.tongrui.shangweiji.data.CatAccRole
 * @author MyEclipse Persistence Tools
 */

public class CatAccRoleDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(CatAccRoleDAO.class);
	// property constants
	public static final String ROLE_NAME = "roleName";
	public static final String DESCRIPTION = "description";

	protected void initDao() {
		// do nothing
	}

	public void save(CatAccRole transientInstance) {
		log.debug("saving CatAccRole instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CatAccRole persistentInstance) {
		log.debug("deleting CatAccRole instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CatAccRole findById(java.lang.Integer id) {
		log.debug("getting CatAccRole instance with id: " + id);
		try {
			CatAccRole instance = (CatAccRole) getHibernateTemplate().get(
					"com.tongrui.shangweiji.data.CatAccRole", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CatAccRole instance) {
		log.debug("finding CatAccRole instance by example");
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
		log.debug("finding CatAccRole instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CatAccRole as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRoleName(Object roleName) {
		return findByProperty(ROLE_NAME, roleName);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findAll() {
		log.debug("finding all CatAccRole instances");
		try {
			String queryString = "from CatAccRole";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CatAccRole merge(CatAccRole detachedInstance) {
		log.debug("merging CatAccRole instance");
		try {
			CatAccRole result = (CatAccRole) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CatAccRole instance) {
		log.debug("attaching dirty CatAccRole instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CatAccRole instance) {
		log.debug("attaching clean CatAccRole instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CatAccRoleDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CatAccRoleDAO) ctx.getBean("CatAccRoleDAO");
	}
}