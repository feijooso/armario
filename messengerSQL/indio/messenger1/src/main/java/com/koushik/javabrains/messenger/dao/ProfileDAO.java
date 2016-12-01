package com.koushik.javabrains.messenger.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.koushik.javabrains.messenger.model.Profile;


 
public class ProfileDAO {
    
    public void addProfile(Profile beanp){
        Session session = SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        addProfile(session,beanp);        
        tx.commit();
        session.close();
        
    }
    
    private void addProfile(Session session, Profile beanp){
        Profile profile = new Profile();
        
        profile.setProfileName(beanp.getProfileName());
        profile.setFirstName(beanp.getFirstName());
        profile.setLastName(beanp.getLastName());
        profile.setCreated(beanp.getCreated());
        
        session.save(profile);
    }
    
    public List<Profile> getProfile(){
        Session session = SessionUtil.getSession();    
        Query query = session.createQuery("from Profile");
        List<Profile> profile =  query.list();
        return profile;
    }
 
    public int deleteProfile(long id) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "delete from Profile where id = :id";
        Query query = session.createQuery(hql);
        query.setLong("id",id);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
        return rowCount;
    }
    
    public int updateProfile(long id, Profile prf){
         if(id <=0)  
               return 0;  
         Session session = SessionUtil.getSession();
            Transaction tx = session.beginTransaction();
            String hql = "update Profile set profileName=:profileName, firstName=:firstName, lastName=:lastName, created=:created where id = :id";
            Query query = session.createQuery(hql);
            query.setLong("id",id);
            query.setString("profileName",prf.getProfileName());
            query.setString("firstName",prf.getFirstName());
            query.setString("lastName", prf.getFirstName());
            query.setDate("created", prf.getCreated());
            int rowCount = query.executeUpdate();
            System.out.println("Rows affected: " + rowCount);
            tx.commit();
            session.close();
            return rowCount;
    }
}