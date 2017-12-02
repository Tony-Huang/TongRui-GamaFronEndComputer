package com.tongrui.shangweiji.data.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO  {
	private static final Log log = LogFactory.getLog(BaseHibernateDAO.class);
	
	
	public Session getSession() {
		//return sessionFactory.openSession();
		return sessionFactory.getCurrentSession();
	}
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public SessionFactory getSessionFactory(){
    	return this.sessionFactory;
    	
    }
    
    //=========================================
    //=== advanced usage
    //=========================================
    public void save(Entity transientInstance) {
		log.debug("saving  instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void saveOrUpdate(Entity instance){
		this.attachDirty(instance);
		
	}

	public void delete(Entity persistentInstance) {
		log.debug("deleting  instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public Entity merge(Entity detachedInstance) {
		log.debug("merging  instance");
		try {
			Entity result = (Entity) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Entity instance) {
		log.debug("attaching dirty  instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Entity instance) {
		log.debug("attaching clean  instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public static void main(String[] args){
		
		
		System.out.println("---");
		
	}
    
}