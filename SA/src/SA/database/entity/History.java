package SA.database.entity;

public class History {
    private int his_id;
    private String s_id;
    private String his_bg_time;
    private int his_num;
    private String his_acc;
    private String his_spend;
    private String his_deg;
    private String his_type;

    public History(){}
    public History(String b,String c,int d,String e,String f,String g,String h){
        this. s_id=b;
        this.his_bg_time=c;
        this.his_num=d;
        this.his_acc=e;
        this. his_spend=f;
        this. his_deg=g;
        this.his_type=h;
    }

    public int getHis_id() {
        return his_id;
    }

    public void setHis_id(int his_id) {
        this.his_id = his_id;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getHis_bg_time() {
        return his_bg_time;
    }

    public void setHis_bg_time(String his_bg_time) {
        this.his_bg_time = his_bg_time;
    }

    public int getHis_num() {
        return his_num;
    }

    public void setHis_num(int his_num) {
        this.his_num = his_num;
    }

    public String getHis_acc() {
        return his_acc;
    }

    public void setHis_acc(String his_acc) {
        this.his_acc = his_acc;
    }

    public String getHis_spend() {
        return his_spend;
    }

    public void setHis_spend(String his_spend) {
        this.his_spend = his_spend;
    }

    public String getHis_deg() {
        return his_deg;
    }

    public void setHis_deg(String his_deg) {
        this.his_deg = his_deg;
    }

    public String getHis_type() {
        return his_type;
    }

    public void setHis_type(String his_type) {
        this.his_type = his_type;
    }
}
