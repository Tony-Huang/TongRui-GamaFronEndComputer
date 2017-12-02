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
 * TmpTreatmentPlan entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.tongrui.shangweiji.data.server.TmpTreatmentPlan
 * @author MyEclipse Persistence Tools
 */

public class TmpTreatmentPlanDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TmpTreatmentPlanDAO.class);
	// property constants
	public static final String COURSE_NUMBER = "courseNumber";
	public static final String PLAN_NAME = "planName";
	public static final String DIAGLOSE = "diaglose";
	public static final String TREATMENT_PART = "treatmentPart";
	public static final String FOCUS_COUNT = "focusCount";
	public static final String FRACTION_COUNT = "fractionCount";
	public static final String DOSE = "dose";
	public static final String REFERPER = "referper";
	public static final String DOCTOR_NAME = "doctorName";
	public static final String SERIAL_NUMBER = "serialNumber";
	public static final String APPROVAL_DOCTOR_NAME = "approvalDoctorName";
	public static final String PLAN_X = "planX";
	public static final String PLAN_Y = "planY";
	public static final String PLAN_Z = "planZ";
	public static final String IS_UPDATE_BY_SERVER = "isUpdateByServer";
	public static final String IS_UPDATE_BY_UPPER = "isUpdateByUpper";

	protected void initDao() {
		// do nothing
	}

	public void save(TmpTreatmentPlan transientInstance) {
		log.debug("saving TmpTreatmentPlan instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TmpTreatmentPlan persistentInstance) {
		log.debug("deleting TmpTreatmentPlan instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TmpTreatmentPlan findById(java.lang.Integer id) {
		log.debug("getting TmpTreatmentPlan instance with id: " + id);
		try {
			TmpTreatmentPlan instance = (TmpTreatmentPlan) getHibernateTemplate()
					.get("com.tongrui.shangweiji.data.server.TmpTreatmentPlan",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TmpTreatmentPlan instance) {
		log.debug("finding TmpTreatmentPlan instance by example");
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
		log.debug("finding TmpTreatmentPlan instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TmpTreatmentPlan as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCourseNumber(Object courseNumber) {
		return findByProperty(COURSE_NUMBER, courseNumber);
	}

	public List findByPlanName(Object planName) {
		return findByProperty(PLAN_NAME, planName);
	}

	public List findByDiaglose(Object diaglose) {
		return findByProperty(DIAGLOSE, diaglose);
	}

	public List findByTreatmentPart(Object treatmentPart) {
		return findByProperty(TREATMENT_PART, treatmentPart);
	}

	public List findByFocusCount(Object focusCount) {
		return findByProperty(FOCUS_COUNT, focusCount);
	}

	public List findByFractionCount(Object fractionCount) {
		return findByProperty(FRACTION_COUNT, fractionCount);
	}

	public List findByDose(Object dose) {
		return findByProperty(DOSE, dose);
	}

	public List findByReferper(Object referper) {
		return findByProperty(REFERPER, referper);
	}

	public List findByDoctorName(Object doctorName) {
		return findByProperty(DOCTOR_NAME, doctorName);
	}

	public List findBySerialNumber(Object serialNumber) {
		return findByProperty(SERIAL_NUMBER, serialNumber);
	}

	public List findByApprovalDoctorName(Object approvalDoctorName) {
		return findByProperty(APPROVAL_DOCTOR_NAME, approvalDoctorName);
	}

	public List findByPlanX(Object planX) {
		return findByProperty(PLAN_X, planX);
	}

	public List findByPlanY(Object planY) {
		return findByProperty(PLAN_Y, planY);
	}

	public List findByPlanZ(Object planZ) {
		return findByProperty(PLAN_Z, planZ);
	}

	public List findByIsUpdateByServer(Object isUpdateByServer) {
		return findByProperty(IS_UPDATE_BY_SERVER, isUpdateByServer);
	}

	public List findByIsUpdateByUpper(Object isUpdateByUpper) {
		return findByProperty(IS_UPDATE_BY_UPPER, isUpdateByUpper);
	}

	public List findAll() {
		log.debug("finding all TmpTreatmentPlan instances");
		try {
			String queryString = "from TmpTreatmentPlan";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TmpTreatmentPlan merge(TmpTreatmentPlan detachedInstance) {
		log.debug("merging TmpTreatmentPlan instance");
		try {
			TmpTreatmentPlan result = (TmpTreatmentPlan) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TmpTreatmentPlan instance) {
		log.debug("attaching dirty TmpTreatmentPlan instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TmpTreatmentPlan instance) {
		log.debug("attaching clean TmpTreatmentPlan instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TmpTreatmentPlanDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TmpTreatmentPlanDAO) ctx.getBean("TmpTreatmentPlanDAO");
	}
}