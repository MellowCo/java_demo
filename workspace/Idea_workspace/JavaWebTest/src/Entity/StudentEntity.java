package Entity;

public class StudentEntity {
    private int sno;
    private String sname;
    private String sage;
    private String sdept;

    public StudentEntity(String sname, String sage, String sdept) {
        this.sname = sname;
        this.sage = sage;
        this.sdept = sdept;
    }

    public StudentEntity() {
    }

    public StudentEntity(int sno, String sname, String sage, String sdept) {
        this.sno = sno;
        this.sage = sage;
        this.sname = sname;
        this.sdept = sdept;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSage() {
        return sage;
    }

    public void setSage(String sage) {
        this.sage = sage;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSdept() {
        return sdept;
    }

    public void setSdept(String sdept) {
        this.sdept = sdept;
    }
}
