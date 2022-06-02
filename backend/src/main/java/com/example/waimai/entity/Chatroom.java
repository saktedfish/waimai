package com.example.waimai.entity;


public class Chatroom {

    private int id;

    private String orderid;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    private String userid;


    private String userimg;

   
    private String touserid;

    
    private String touserimg;

  
    private String tousernickname;


    private String timetoint;

  
    private String lasttime;

    
    private String lastcontent;

    private String ordername;

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    private int tiaoshu;

    public void setId(int id) {
        this.id = id;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }

    public void setTouserid(String touserid) {
        this.touserid = touserid;
    }

    public void setTouserimg(String touserimg) {
        this.touserimg = touserimg;
    }

    public void setTousernickname(String tousernickname) {
        this.tousernickname = tousernickname;
    }

    public void setTimetoint(String timetoint) {
        this.timetoint = timetoint;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }

    public void setLastcontent(String lastcontent) {
        this.lastcontent = lastcontent;
    }

    public void setTiaoshu(int tiaoshu) {
        this.tiaoshu = tiaoshu;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof com.example.waimai.entity.Chatroom))
            return false;
        com.example.waimai.entity.Chatroom other = (com.example.waimai.entity.Chatroom)o;
        if (!other.canEqual(this))
            return false;
        if (getId() != other.getId())
            return false;
        Object this$userid = getUserid(), other$userid = other.getUserid();
        if ((this$userid == null) ? (other$userid != null) : !this$userid.equals(other$userid))
            return false;
        Object this$userimg = getUserimg(), other$userimg = other.getUserimg();
        if ((this$userimg == null) ? (other$userimg != null) : !this$userimg.equals(other$userimg))
            return false;
        Object this$touserid = getTouserid(), other$touserid = other.getTouserid();
        if ((this$touserid == null) ? (other$touserid != null) : !this$touserid.equals(other$touserid))
            return false;
        Object this$touserimg = getTouserimg(), other$touserimg = other.getTouserimg();
        if ((this$touserimg == null) ? (other$touserimg != null) : !this$touserimg.equals(other$touserimg))
            return false;
        Object this$tousernickname = getTousernickname(), other$tousernickname = other.getTousernickname();
        if ((this$tousernickname == null) ? (other$tousernickname != null) : !this$tousernickname.equals(other$tousernickname))
            return false;
        Object this$timetoint = getTimetoint(), other$timetoint = other.getTimetoint();
        if ((this$timetoint == null) ? (other$timetoint != null) : !this$timetoint.equals(other$timetoint))
            return false;
        Object this$lasttime = getLasttime(), other$lasttime = other.getLasttime();
        if ((this$lasttime == null) ? (other$lasttime != null) : !this$lasttime.equals(other$lasttime))
            return false;
        Object this$lastcontent = getLastcontent(), other$lastcontent = other.getLastcontent();
        return ((this$lastcontent == null) ? (other$lastcontent != null) : !this$lastcontent.equals(other$lastcontent)) ? false : (!(getTiaoshu() != other.getTiaoshu()));
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.example.waimai.entity.Chatroom;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + getId();
        Object $userid = getUserid();
        result = result * 59 + (($userid == null) ? 43 : $userid.hashCode());
        Object $userimg = getUserimg();
        result = result * 59 + (($userimg == null) ? 43 : $userimg.hashCode());
        Object $touserid = getTouserid();
        result = result * 59 + (($touserid == null) ? 43 : $touserid.hashCode());
        Object $touserimg = getTouserimg();
        result = result * 59 + (($touserimg == null) ? 43 : $touserimg.hashCode());
        Object $tousernickname = getTousernickname();
        result = result * 59 + (($tousernickname == null) ? 43 : $tousernickname.hashCode());
        Object $timetoint = getTimetoint();
        result = result * 59 + (($timetoint == null) ? 43 : $timetoint.hashCode());
        Object $lasttime = getLasttime();
        result = result * 59 + (($lasttime == null) ? 43 : $lasttime.hashCode());
        Object $lastcontent = getLastcontent();
        result = result * 59 + (($lastcontent == null) ? 43 : $lastcontent.hashCode());
        return result * 59 + getTiaoshu();
    }

    public String toString() {
        return "Chatroom(id=" + getId() + ", userid=" + getUserid() + ", userimg=" + getUserimg() + ", touserid=" + getTouserid() + ", touserimg=" + getTouserimg() + ", tousernickname=" + getTousernickname() + ", timetoint=" + getTimetoint() + ", lasttime=" + getLasttime() + ", lastcontent=" + getLastcontent() + ", tiaoshu=" + getTiaoshu() + ")";
    }

    public Chatroom(int id, String userid, String userimg, String touserid, String touserimg, String tousernickname, String timetoint, String lasttime, String lastcontent, int tiaoshu) {
        this.id = id;
        this.userid = userid;
        this.userimg = userimg;
        this.touserid = touserid;
        this.touserimg = touserimg;
        this.tousernickname = tousernickname;
        this.timetoint = timetoint;
        this.lasttime = lasttime;
        this.lastcontent = lastcontent;
        this.tiaoshu = tiaoshu;
    }

    public Chatroom() {}

    public int getId() {
        return this.id;
    }

    public String getUserid() {
        return this.userid;
    }

    public String getUserimg() {
        return this.userimg;
    }

    public String getTouserid() {
        return this.touserid;
    }

    public String getTouserimg() {
        return this.touserimg;
    }

    public String getTousernickname() {
        return this.tousernickname;
    }

    public String getTimetoint() {
        return this.timetoint;
    }

    public String getLasttime() {
        return this.lasttime;
    }

    public String getLastcontent() {
        return this.lastcontent;
    }

    public int getTiaoshu() {
        return this.tiaoshu;
    }
}

