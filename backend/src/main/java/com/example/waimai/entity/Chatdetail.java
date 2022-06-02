package com.example.waimai.entity;

public class Chatdetail {

    private int id;


    private String content;


    private String userid;


    private String touserid;


    private String touserimg;


    private String userimg;


    private String speaker;

    private String orderid;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setTouserid(String touserid) {
        this.touserid = touserid;
    }

    public void setTouserimg(String touserimg) {
        this.touserimg = touserimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof com.example.waimai.entity.Chatdetail))
            return false;
        com.example.waimai.entity.Chatdetail other = (com.example.waimai.entity.Chatdetail)o;
        if (!other.canEqual(this))
            return false;
        if (getId() != other.getId())
            return false;
        Object this$content = getContent(), other$content = other.getContent();
        if ((this$content == null) ? (other$content != null) : !this$content.equals(other$content))
            return false;
        Object this$userid = getUserid(), other$userid = other.getUserid();
        if ((this$userid == null) ? (other$userid != null) : !this$userid.equals(other$userid))
            return false;
        Object this$touserid = getTouserid(), other$touserid = other.getTouserid();
        if ((this$touserid == null) ? (other$touserid != null) : !this$touserid.equals(other$touserid))
            return false;
        Object this$touserimg = getTouserimg(), other$touserimg = other.getTouserimg();
        if ((this$touserimg == null) ? (other$touserimg != null) : !this$touserimg.equals(other$touserimg))
            return false;
        Object this$userimg = getUserimg(), other$userimg = other.getUserimg();
        if ((this$userimg == null) ? (other$userimg != null) : !this$userimg.equals(other$userimg))
            return false;
        Object this$speaker = getSpeaker(), other$speaker = other.getSpeaker();
        return !((this$speaker == null) ? (other$speaker != null) : !this$speaker.equals(other$speaker));
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.example.waimai.entity.Chatdetail;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + getId();
        Object $content = getContent();
        result = result * 59 + (($content == null) ? 43 : $content.hashCode());
        Object $userid = getUserid();
        result = result * 59 + (($userid == null) ? 43 : $userid.hashCode());
        Object $touserid = getTouserid();
        result = result * 59 + (($touserid == null) ? 43 : $touserid.hashCode());
        Object $touserimg = getTouserimg();
        result = result * 59 + (($touserimg == null) ? 43 : $touserimg.hashCode());
        Object $userimg = getUserimg();
        result = result * 59 + (($userimg == null) ? 43 : $userimg.hashCode());
        Object $speaker = getSpeaker();
        return result * 59 + (($speaker == null) ? 43 : $speaker.hashCode());
    }

    public String toString() {
        return "Chatdetail(id=" + getId() + ", content=" + getContent() + ", userid=" + getUserid() + ", touserid=" + getTouserid() + ", touserimg=" + getTouserimg() + ", userimg=" + getUserimg() + ", speaker=" + getSpeaker() + ")";
    }

    public Chatdetail(int id, String content, String userid, String touserid, String touserimg, String userimg, String speaker) {
        this.id = id;
        this.content = content;
        this.userid = userid;
        this.touserid = touserid;
        this.touserimg = touserimg;
        this.userimg = userimg;
        this.speaker = speaker;
    }

    public Chatdetail() {}

    public int getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public String getUserid() {
        return this.userid;
    }

    public String getTouserid() {
        return this.touserid;
    }

    public String getTouserimg() {
        return this.touserimg;
    }

    public String getUserimg() {
        return this.userimg;
    }

    public String getSpeaker() {
        return this.speaker;
    }
}
