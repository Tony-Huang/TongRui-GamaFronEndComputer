/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.ui.usermanagement;

/**
 *
 * @author Administrator
 */
public class UserObject {
    
    private String name;
    private int originalIndex;
    
    public UserObject(String name){
     this.name= name;
    }
    
     public UserObject(String name,int index){
     this.name= name;
     this.originalIndex = index;
    }
    
    public UserObject(){
    }
    
    public String toString(){
        return name;
    }
    
    public boolean equals(Object obj) {
	boolean result = false;
        if(this.getName()==null) return false;
        if(obj==null) return false;
        
        if(obj instanceof UserObject){
           UserObject uo = (UserObject)obj;
           if(uo.getName().equals(this.getName())){
           return true;
           }
           else
               return false;
        }
        
        if(obj instanceof String){
         if(this.getName().equals(obj)){
         return true;
         }
         else 
             return false;
        }
        return result;
    }
    
    
  //=================================
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOriginalIndex() {
        return originalIndex;
    }

    public void setOriginalIndex(int originalIndex) {
        this.originalIndex = originalIndex;
    }
    
    
    
}
