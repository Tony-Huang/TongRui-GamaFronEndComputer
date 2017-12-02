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
 * TmpTreatmentPlanFraction entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.tongrui.shangweiji.data.server.TmpTreatmentPlanFraction
 * @author MyEclipse Persistence Tools
 */

public class TmpTreatmentPlanFractionDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory
			.getLog(TmpTreatmentPlanFractionDAO.class);
	// property constants
	public static final String FRACTION_NOMBER = "fractionNomber";
	public static final String IS_APPENDED = "isAppended";
	public static final String APPEND_DOCTOR_NAME = "appendDoctorName";
	public static final String PERFORMER_NAME = "performerName";
	public static final String NOTES = "notes";
	public static final String IS_IGRTFLAG = "isIgrtflag";
	public static final String IGRTDX = "igrtdx";
	public static final String IGRTDY = "igrtdy";
	public static final String IGRTDZ = "igrtdz";
	public static final String PHOTO_NUMBER = "photoNumber";
	public static final String IMAGE_PATH = "imagePath";
	public static final String REGISTER = "register";
	public static final String IS_UPDATE_BY_SERVER = "isUpdateByServer";
	public static final String IS_UPDATE_BY_UPPER = "isUpdateByUpper";

	protected void initDao() {
		// do nothing
	}

	public void save(TmpTreatmentPlanFraction transientInstance) {
		log.debug("saving TmpTreatmentPlanFraction instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TmpTreatmentPlanFraction persistentInstance) {
		log.debug("deleting TmpTreatmentPlanFraction instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TmpTreatmentPlanFraction findById(java.lang.Integer id) {
		log.debug("getting TmpTreatmentPlanFraction instance with id: " + id);
		try {
			TmpTreatmentPlanFraction instance = (TmpTreatmentPlanFraction) getHibernateTemplate()
					.get(
							"com.tongrui.shangweiji.data.server.TmpTreatmentPlanFraction",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TmpTreatmentPlanFraction instance) {
		log.debug("finding TmpTreatmentPlanFraction instance by example");
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
		log.debug("finding TmpTreatmentPlanFraction instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TmpTreatmentPlanFraction as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFractionNomber(Object fractionNomber) {
		return findByProperty(FRACTION_NOMBER, fractionNomber);
	}

	public List findByIsAppended(Object isAppended) {
		return findByProperty(IS_APPENDED, isAppended);
	}

	public List findByAppendDoctorName(Object appendDoctorName) {
		return findByProperty(APPEND_DOCTOR_NAME, appendDoctorName);
	}

	public List findByPerformerName(Object performerName) {
		return findByProperty(PERFORMER_NAME, performerName);
	}

	public List findByNotes(Object notes) {
		return findByProperty(NOTES, notes);
	}

	public List findByIsIgrtflag(Object isIgrtflag) {
		return findByProperty(IS_IGRTFLAG, isIgrtflag);
	}

	public List findByIgrtdx(Object igrtdx) {
		return findByProperty(IGRTDX, igrtdx);
	}

	public List findByIgrtdy(Object igrtdy) {
		return findByProperty(IGRTDY, igrtdy);
	}

	public List findByIgrtdz(Object igrtdz) {
		return findByProperty(IGRTDZ, igrtdz);
	}

	public List findByPhotoNumber(Object photoNumber) {
		return findByProperty(PHOTO_NUMBER, photoNumber);
	}

	public List findByImagePath(Object imagePath) {
		return findByProperty(IMAGE_PATH, imagePath);
	}

	public List findByRegister(Object register) {
		return findByProperty(REGISTER, register);
	}

	public List findByIsUpdateByServer(Object isUpdateByServer) {
		return findByProperty(IS_UPDATE_BY_SERVER, isUpdateByServer);
	}

	public List findByIsUpdateByUpper(Object isUpdateByUpper) {
		return findByProperty(IS_UPDATE_BY_UPPER, isUpdateByUpper);
	}

	public List findAll() {
		log.debug("finding all TmpTreatmentPlanFraction instances");
		try {
			String queryString = "from TmpTreatmentPlanFraction";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TmpTreatmentPlanFraction merge(
			TmpTreatmentPlanFraction detachedInstance) {
		log.debug("merging TmpTreatmentPlanFraction instance");
		try {
			TmpTreatmentPlanFraction result = (TmpTreatmentPlanFraction) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TmpTreatmentPlanFraction instance) {
		log.debug("attaching dirty TmpTreatmentPlanFraction instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TmpTreatmentPlanFraction instance) {
		log.debug("attaching clean TmpTreatmentPlanFraction instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TmpTreatmentPlanFractionDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TmpTreatmentPlanFractionDAO) ctx
				.getBean("TmpTreatmentPlanFractionDAO");
	}
}