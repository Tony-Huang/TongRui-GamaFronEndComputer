package com.tongrui.shangweiji.data;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * CatTreatmentPlanFraction entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 *
 * @see com.tongrui.shangweiji.data.CatTreatmentPlanFraction
 * @author MyEclipse Persistence Tools
 */

public class CatTreatmentPlanFractionDAO extends HibernateDaoSupport {
    private static final Log log = LogFactory
            .getLog(CatTreatmentPlanFractionDAO.class);
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
    public static final String IMAGE_PATH = "imagePath";
    public static final String REGISTER = "register";

    protected void initDao() {
        // do nothing
    }

    public void save(CatTreatmentPlanFraction transientInstance) {
        log.debug("saving CatTreatmentPlanFraction instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CatTreatmentPlanFraction persistentInstance) {
        log.debug("deleting CatTreatmentPlanFraction instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CatTreatmentPlanFraction findById(java.lang.Integer id) {
        log.debug("getting CatTreatmentPlanFraction instance with id: " + id);
        try {
            getHibernateTemplate().find("from CatTreatmentFractionState "); //wys?.useless?
            CatTreatmentPlanFraction instance = (CatTreatmentPlanFraction) getHibernateTemplate()
                    .get(
                    "com.tongrui.shangweiji.data.CatTreatmentPlanFraction",
                    id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByExample(CatTreatmentPlanFraction instance) {
        log.debug("finding CatTreatmentPlanFraction instance by example");
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
        log.debug("finding CatTreatmentPlanFraction instance with property: "
                + propertyName + ", value: " + value);
        try {

            getHibernateTemplate().find("from CatTreatmentFractionState "); //wys?.useless?
            String queryString = "from CatTreatmentPlanFraction as model where model."
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

    public List findByImagePath(Object imagePath) {
        return findByProperty(IMAGE_PATH, imagePath);
    }

    public List findByRegister(Object register) {
        return findByProperty(REGISTER, register);
    }

    public List findAll() {
        log.debug("finding all CatTreatmentPlanFraction instances");
        try {
            String queryString = "from CatTreatmentPlanFraction";
            return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public CatTreatmentPlanFraction merge(
            CatTreatmentPlanFraction detachedInstance) {
        log.debug("merging CatTreatmentPlanFraction instance");
        try {
            CatTreatmentPlanFraction result = (CatTreatmentPlanFraction) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(CatTreatmentPlanFraction instance) {
        log.debug("attaching dirty CatTreatmentPlanFraction instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(CatTreatmentPlanFraction instance) {
        log.debug("attaching clean CatTreatmentPlanFraction instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public static CatTreatmentPlanFractionDAO getFromApplicationContext(
            ApplicationContext ctx) {
        return (CatTreatmentPlanFractionDAO) ctx
                .getBean("CatTreatmentPlanFractionDAO");
    }

    public void updateNotes(String notes, Integer id) {
        Session session  = getHibernateTemplate().getSessionFactory().getCurrentSession(); //wys.TBD
        String hql = String.format("update CatTreatmentPlanFraction t set t.notes =t.notes + '%s' where t.id = %d", notes,id);
        System.out.println(hql);
        Query query = session.createQuery(hql);
        query.executeUpdate();
    }
}