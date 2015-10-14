
package model;

public class Cars {
    private int CARID;
    private String CARMAKE;
    private String CARMODEL;
    private int CARYEAR;        
    private String CARCOLOR;

    public Cars() {
        this.CARID = 0;
        this.CARMAKE = "";
        this.CARMODEL = "";
        this.CARYEAR = 0;
        this.CARCOLOR = "";
    }
    
    public Cars(int CARID, String CARMAKE, String CARMODEL, int CARYEAR, String CARCOLOR) {
        this.CARID = CARID;
        this.CARMAKE = CARMAKE;
        this.CARMODEL = CARMODEL;
        this.CARYEAR = CARYEAR;
        this.CARCOLOR = CARCOLOR;
    }

    public int getCARID() {
        return CARID;
    }

    public void setCARID(int CARID) {
        this.CARID = CARID;
    }

    public String getCARMAKE() {
        return CARMAKE;
    }

    public void setCARMAKE(String CARMAKE) {
        this.CARMAKE = CARMAKE;
    }

    public String getCARMODEL() {
        return CARMODEL;
    }

    public void setCARMODEL(String CARMODEL) {
        this.CARMODEL = CARMODEL;
    }

    public int getCARYEAR() {
        return CARYEAR;
    }

    public void setCARYEAR(int CARYEAR) {
        this.CARYEAR = CARYEAR;
    }

    public String getCARCOLOR() {
        return CARCOLOR;
    }

    public void setCARCOLOR(String CARCOLOR) {
        this.CARCOLOR = CARCOLOR;
    }

    @Override
    public String toString() {
        return "Cars{" + "CARID=" + CARID + ", CARMAKE=" + CARMAKE + ", CARMODEL=" + CARMODEL + ", CARYEAR=" + CARYEAR + ", CARCOLOR=" + CARCOLOR + '}';
    }
   
    
}
