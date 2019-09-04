package cn.keshe.entity;

public class file {
        private String filename;
        private String workname;
        private String s_id;
        private String t_id;
    private String id;

        public file() {
        }

        public file(String id, String filename, String workname, String s_id, String t_id) {
            this.id=id;
            this.filename=filename;
            this.workname=workname;
            this.s_id=s_id;
            this.t_id=t_id;
        }

    public void setId(String s_id) {
        id = s_id;
    }

        public void setFilename(String s_id) {
            filename = s_id;
        }

        public void setWorkname(String s_name) {
            workname = s_name;
        }

        public void setS_id(String s_password) {
            s_id = s_password;
        }

        public void setT_id(String s_sex) {
            t_id = s_sex;
        }

        public String getS_id() {
            return s_id;
        }

        public String getT_id() {
            return t_id;
        }

        public String getFilename() {
            return filename;
        }

        public String getWorkname() {
            return workname;
        }

    public String getId() {
        return id;
    }

}
