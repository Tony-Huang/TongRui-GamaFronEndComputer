package com.tongrui.shangweiji.data;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * CatTreatmentCollType entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.tongrui.shangweiji.data.CatTreatmentCollType
 * @author MyEclipse Persistence Tools
 */

public class CatTreatmentCollTypeDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory
			.getLog(CatTreatmentCollTypeDAO.class);
	// property constants
	public static final String SIZE = "size";
	public static final String OUTFACTOR = "outfactor";

	protected void initDao() {
		// do nothing
	}

	public void save(CatTreatmentCollType transientInstance) {
		log.debug("saving CatTreatmentCollType instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CatTreatmentCollType persistentInstance) {
		log.debug("deleting CatTreatmentCollType instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CatTreatmentCollType findById(java.lang.Integer id) {
		log.debug("getting CatTreatmentCollType instance with id: " + id);
		try {
			CatTreatmentCollType instance = (CatTreatmentCollType) getHibernateTemplate()
					.get("com.tongrui.shangweiji.data.CatTreatmentCollType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CatTreatmentCollType instance) {
		log.debug("finding CatTreatmentCollType instance by example");
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
		log.debug("finding CatTreatmentCollType instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CatTreatmentCollType as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySize(Object size) {
		return findByProperty(SIZE, size);
	}

	public List findByOutfactor(Object outfactor) {
		return findByProperty(OUTFACTOR, outfactor);
	}

	public List findAll() {
		log.debug("finding all CatTreatmentCollType instances");
		try {
			String queryString = "from CatTreatmentCollType";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CatTreatmentCollType merge(CatTreatmentCollType detachedInstance) {
		log.debug("merging CatTreatmentCollType instance");
		try {
			CatTreatmentCollType result = (CatTreatmentCollType) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CatTreatmentCollType instance) {
		log.debug("attaching dirty CatTreatmentCollType instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CatTreatmentCollType instance) {
		log.debug("attaching clean CatTreatmentCollType instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CatTreatmentCollTypeDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CatTreatmentCollTypeDAO) ctx.getBean("CatTreatmentCollTypeDAO");
	}
}