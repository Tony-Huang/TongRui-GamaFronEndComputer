package com.tongrui.shangweiji.data;

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
 * CatTreatmentPlan entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.tongrui.shangweiji.data.CatTreatmentPlan
 * @author MyEclipse Persistence Tools
 */

public class CatTreatmentPlanDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(CatTreatmentPlanDAO.class);
	// property constants
	public static final String COURSE_NUMBER = "courseNumber";
	public static final String PLAN_NAME = "planName";
	public static final String DIAGLOSE = "diaglose";
	public static final String TREATMENT_PART = "treatmentPart";
	public static final String FOCUS_COUNT = "focusCount";
	public static final String DOSE = "dose";
	public static final String REFERPER = "referper";
	public static final String DOCTOR_NAME = "doctorName";
	public static final String SERIAL_NUMBER = "serialNumber";
	public static final String APPROVAL_DOCTOR_NAME = "approvalDoctorName";

	protected void initDao() {
		// do nothing
	}

	public void save(CatTreatmentPlan transientInstance) {
		log.debug("saving CatTreatmentPlan instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CatTreatmentPlan persistentInstance) {
		log.debug("deleting CatTreatmentPlan instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CatTreatmentPlan findById(java.lang.Integer id) {
		log.debug("getting CatTreatmentPlan instance with id: " + id);
		try {
                          CatTreatmentPlan instance = (CatTreatmentPlan) getHibernateTemplate()
					.get("com.tongrui.shangweiji.data.CatTreatmentPlan", id);
                        
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<CatTreatmentPlan> findByStateId(java.lang.Integer id) {
		log.debug("getting CatTreatmentPlan instance with state id: " + id);
		try {
			StringBuffer baseQueryString = new StringBuffer( "from CatTreatmentPlan as model where model.catTreatmentPlanState.id = "+ id );
			return getHibernateTemplate().find(baseQueryString.toString());
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CatTreatmentPlan instance) {
		log.debug("finding CatTreatmentPlan instance by example");
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
		log.debug("finding CatTreatmentPlan instance with property: "
				+ propertyName + ", value: " + value);
		try {
                     getHibernateTemplate().find("from com.tongrui.shangweiji.data.CatTreatmentPlanState");
			String queryString = "from CatTreatmentPlan as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
        
       public List findBySearchCriteria(String name,Integer planId, Date start, Date end){
         log.debug("finding CatTreatmentPlan instance with several conditions. ");
		try {
                     
			StringBuffer baseQueryString = new StringBuffer( "from CatTreatmentPlan as model where 1=1");
                        if(name!=null && !name.equals("")){
                          baseQueryString.append(" and model.catTreatmentPatientCase.name= '" + name+"'" );
                        }
                        if(planId!=null && !planId.equals("")){
                            baseQueryString.append(" and model.serialNumber =  " +planId);
                        }
                        if(start!=null){
                          baseQueryString.append(" and model.planDate >="+ start);
                        }
                        if(end!=null){
                           baseQueryString.append(" and model.planDate <="+ end );
                        }
                        
			return getHibernateTemplate().find(baseQueryString.toString());
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
       }
        
       
       
       public List findBySearchCriteria(String name,Integer planId, String start, String end){
         log.debug("finding CatTreatmentPlan instance with several conditions. ");
		try {
                     
			StringBuffer baseQueryString = new StringBuffer( "from CatTreatmentPlan as model where 1=1");
                        if(name!=null && !name.equals("")){
                          baseQueryString.append(" and model.catTreatmentPatientCase.name LIKE '%" + name+"%'");
                        }
                        if(planId!=null && !planId.equals("")){
                            baseQueryString.append(" and model.id = " +planId.intValue());
                        }
                        if(start!=null){
                          baseQueryString.append(" and model.planDate >= '"+ start +"'");
                        }
                        if(end!=null){
                           baseQueryString.append(" and model.planDate <= '"+end + "'");
                        }
                        
                        System.out.println("--->query plan="+baseQueryString);
                        List result=  getHibernateTemplate().find(baseQueryString.toString());
                        System.out.println("result size="+result.size());
			return result;
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

	public List findAll() {
		log.debug("finding all CatTreatmentPlan instances");
		try {
                     //CatTreatmentPatientCase
			String queryString = "from CatTreatmentPlan";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CatTreatmentPlan merge(CatTreatmentPlan detachedInstance) {
		log.debug("merging CatTreatmentPlan instance");
		try {
			CatTreatmentPlan result = (CatTreatmentPlan) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CatTreatmentPlan instance) {
		log.debug("attaching dirty CatTreatmentPlan instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CatTreatmentPlan instance) {
        log.debug("attaching clean CatTreatmentPlan instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void update(CatTreatmentPlan instance) {
        log.debug("update CatTreatmentPlan instance");
        try {
            getHibernateTemplate().update(instance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("uptate failed", re);
            throw re;
        }
    }
    
	public static CatTreatmentPlanDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CatTreatmentPlanDAO) ctx.getBean("CatTreatmentPlanDAO");
	}
}