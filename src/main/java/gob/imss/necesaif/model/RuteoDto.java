package gob.imss.necesaif.model;

public class RuteoDto {
    private int id;
    private int version;
    private String username;
    private String clavePresupuestalOrigen;
    private String driverClass;
    private String clavePresupuestalFarmacia;
    private String password;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClavePresupuestalOrigen() {
        return clavePresupuestalOrigen;
    }

    public void setClavePresupuestalOrigen(String clavePresupuestalOrigen) {
        this.clavePresupuestalOrigen = clavePresupuestalOrigen;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getClavePresupuestalFarmacia() {
        return clavePresupuestalFarmacia;
    }

    public void setClavePresupuestalFarmacia(String clavePresupuestalFarmacia) {
        this.clavePresupuestalFarmacia = clavePresupuestalFarmacia;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
