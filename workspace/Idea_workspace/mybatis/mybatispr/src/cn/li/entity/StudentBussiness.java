package cn.li.entity;

public class StudentBussiness extends Student{
    private int cardId;
    private String cardInfo;

    public StudentBussiness() {

    }

    public StudentBussiness(int sno, String sName, String sAge, String sDept, int cardId, String cardInfo) {
        super(sno, sName, sAge, sDept);
        this.cardId = cardId;
        this.cardInfo = cardInfo;
    }

    public StudentBussiness(int cardId, String cardInfo) {
        this.cardId = cardId;
        this.cardInfo = cardInfo;
    }

    public StudentBussiness(int sno, String sName, String sAge, String sDept, String sSex, int cardId, String cardInfo) {
        super(sno, sName, sAge, sDept, sSex);
        this.cardId = cardId;
        this.cardInfo = cardInfo;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(String cardInfo) {
        this.cardInfo = cardInfo;
    }

    @Override
    public String toString() {
        return "StudentBussiness{" + super.toString() +
                "cardId=" + cardId +
                ", cardInfo='" + cardInfo + '\'' +
                '}';
    }
}
