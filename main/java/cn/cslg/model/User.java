package cn.cslg.model;


public class User {

  private String sno;
  private String name;
  private Integer partid;
  private String password;

  private int flag;

  public int getFlag() {
    return flag;
  }

  public void setFlag(int flag) {
    this.flag = flag;
  }

  public String getSno() {
    return sno;
  }

  public void setSno(String sno) {
    this.sno = sno;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public Integer getPartid() {
    return partid;
  }

  public void setPartid(Integer partid) {
    this.partid = partid;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
