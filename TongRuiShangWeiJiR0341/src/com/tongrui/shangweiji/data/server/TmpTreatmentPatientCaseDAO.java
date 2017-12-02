package com.tongrui.shangweiji.data.server;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TmpTreatmentPatientCase entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.tongrui.shangweiji.data.server.TmpTreatmentPatientCase
 * @author MyEclipse Persistence Tools
 */

public class TmpTreatmentPatientCaseDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory
			.getLog(TmpTreatmentPatientCaseDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String PATIENT_ID = "patientId";
	public static final String SEX = "sex";
	public static final String AGE = "age";
	public static final String HEIGHT = "height";
	public static final String WEIGHT = "weight";
	public static final String ADDRESS = "address";
	public static final String PHONE = "phone";
	public static final String NOTES = "notes";
	public static final String IS_UPDATE_BY_SERVER = "isUpdateByServer";

	protected void initDao() {
		// do nothing
	}

	public void save(TmpTreatmentPatientCase transientInstance) {
		log.debug("saving TmpTreatmentPatientCase instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TmpTreatmentPatientCase persistentInstance) {
		log.debug("deleting TmpTreatmentPatientCase instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TmpTreatmentPatientCase findById(java.lang.Integer id) {
		log.debug("getting TmpTreatmentPatientCase instance with id: " + id);
		try {
			TmpTreatmentPatientCase instance = (TmpTreatmentPatientCase) getHibernateTemplate()
					.get(
							"com.tongrui.shangweiji.data.server.TmpTreatmentPatientCase",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TmpTreatmentPatientCase instance) {
		log.debug("finding TmpTreatmentPatientCase instance by example");
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
		log.debug("finding TmpTreatmentPatientCase instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TmpTreatmentPatientCase as model where model."
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

	public List findByPatientId(Object patientId) {
		return findByProperty(PATIENT_ID, patientId);
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	public List findByHeight(Object height) {
		return findByProperty(HEIGHT, height);
	}

	public List findByWeight(Object weight) {
		return findByProperty(WEIGHT, weight);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByNotes(Object notes) {
		return findByProperty(NOTES, notes);
	}

	public List findByIsUpdateByServer(Object isUpdateByServer) {
		return findByProperty(IS_UPDATE_BY_SERVER, isUpdateByServer);
	}

	public List findAll() {
		log.debug("finding all TmpTreatmentPatientCase instances");
		try {
			String queryString = "from TmpTreatmentPatientCase";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TmpTreatmentPatientCase merge(
			TmpTreatmentPatientCase detachedInstance) {
		log.debug("merging TmpTreatmentPatientCase instance");
		try {
			TmpTreatmentPatientCase result = (TmpTreatmentPatientCase) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TmpTreatmentPatientCase instance) {
		log.debug("attaching dirty TmpTreatmentPatientCase instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TmpTreatmentPatientCase instance) {
		log.debug("attaching clean TmpTreatmentPatientCase instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TmpTreatmentPatientCaseDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TmpTreatmentPatientCaseDAO) ctx
				.getBean("TmpTreatmentPatientCaseDAO");
	}
}