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
 * CatSystemLog entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.tongrui.shangweiji.data.CatSystemLog
 * @author MyEclipse Persistence Tools
 */

public class CatSystemLogDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(CatSystemLogDAO.class);
	// property constants
	public static final String LOG_MESSAGE = "logMessage";
	public static final String OPERATOR = "operator";
	public static final String NOTES = "notes";
	public static final String PATIENT_ID = "patientId";
	public static final String PATIENT_NAME = "patientName";

	protected void initDao() {
		// do nothing
	}

	public void save(CatSystemLog transientInstance) {
		log.debug("saving CatSystemLog instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CatSystemLog persistentInstance) {
		log.debug("deleting CatSystemLog instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CatSystemLog findById(java.lang.Integer id) {
		log.debug("getting CatSystemLog instance with id: " + id);
		try {
			CatSystemLog instance = (CatSystemLog) getHibernateTemplate().get(
					"com.tongrui.shangweiji.data.CatSystemLog", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CatSystemLog instance) {
		log.debug("finding CatSystemLog instance by example");
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
		log.debug("finding CatSystemLog instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CatSystemLog as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLogMessage(Object logMessage) {
		return findByProperty(LOG_MESSAGE, logMessage);
	}

	public List findByOperator(Object operator) {
		return findByProperty(OPERATOR, operator);
	}

	public List findByNotes(Object notes) {
		return findByProperty(NOTES, notes);
	}

	public List findByPatientId(Object patientId) {
		return findByProperty(PATIENT_ID, patientId);
	}

	public List findByPatientName(Object patientName) {
		return findByProperty(PATIENT_NAME, patientName);
	}

        public List findBySearchCriteria(String logLevel, String start, String end) {
		log.debug("finding CatSystemLog instance with several conditions.");
		try {
			StringBuffer baseQueryString = new StringBuffer("from CatSystemLog as model where 1=1");
                        if(logLevel != null && !"".equals(logLevel)){
                            baseQueryString.append(" and model.catSystemLogLevel.name = '" + logLevel + "'");
                        }
                        if(start!=null && !"".equals(start)){
                          baseQueryString.append(" and model.happenTime >= '"+ start +"'");
                        }
                        if(end!=null && !"".equals(end)){
                           baseQueryString.append(" and model.happenTime <= '"+end + " 23:59:59'");
                        }
                        baseQueryString.append(" order by model.happenTime desc"); //asc is increase order
                        
                        System.out.println("--->query systemLog = "+baseQueryString);
			List result =  getHibernateTemplate().find(baseQueryString.toString());
                        System.out.println("The result size is = " + result.size());
                        return result;
		} catch (RuntimeException re) {
			log.error("find CatSystemLog instance with conditions failed", re);
			throw re;
		}            
        }
        
	public List findAll() {
		log.debug("finding all CatSystemLog instances");
		try {
			String queryString = "from CatSystemLog";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CatSystemLog merge(CatSystemLog detachedInstance) {
		log.debug("merging CatSystemLog instance");
		try {
			CatSystemLog result = (CatSystemLog) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CatSystemLog instance) {
		log.debug("attaching dirty CatSystemLog instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CatSystemLog instance) {
		log.debug("attaching clean CatSystemLog instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CatSystemLogDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CatSystemLogDAO) ctx.getBean("CatSystemLogDAO");
	}
}