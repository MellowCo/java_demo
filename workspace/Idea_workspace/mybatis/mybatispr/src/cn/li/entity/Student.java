package cn.li.entity;

public class Student {
    private int sno;
    private String sName;
    private String sAge;
    private String sDept;
    private String sSex;
    //关联StudntCard
    private StudentCard card;

    public StudentCard getCard() {
        return card;
    }

    public void setCard(StudentCard card) {
        this.card = card;
    }

    public Student(int sno, String sName, String sAge, String sDept) {
        this.sno = sno;
        this.sName = sName;
        this.sAge = sAge;
        this.sDept = sDept;
    }

    public Student() {
    }

    public Student(int sno, String sName, String sAge, String sDept, String sSex) {
        this.sno = sno;
        this.sName = sName;
        this.sAge = sAge;
        this.sDept = sDept;
        this.sSex = sSex;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", sName='" + sName + '\'' +
                ", sAge='" + sAge + '\'' +
                ", sDept='" + sDept + '\'' +
                ", sSex='" + sSex + '\'' +
                // ", cardid='" + card.getCardId() + '\'' +
                // ", cardinfo='" + card.getCardInfo() + '\'' +
                '}';
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsAge() {
        return sAge;
    }

    public void setsAge(String sAge) {
        this.sAge = sAge;
    }

    public String getsDept() {
        return sDept;
    }

    public void setsDept(String sDept) {
        this.sDept = sDept;
    }
}
