package com.tongrui.shangweiji.data;

public abstract class Entity implements Comparable{
    
   //Integer id;

    public abstract Integer getId() ;

    public abstract void setId(Integer id);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
   @Override
   public int compareTo(Object o){
      Entity obj= (Entity)o;
      if(this.getId()==obj.getId()) return 0;
      else if(this.getId()<obj.getId()) return -1;
      else return 1;
   }
    

}
