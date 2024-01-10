package gob.imss.necesaif.error;

public class ServicioException  extends Exception{
    private String codigoError;

    public ServicioException(String codigoError, String mnsError){
        super(mnsError);
        this.codigoError = codigoError;
    }

    public String getCodigoError() {
        return codigoError;
    }

    public String getMnsError(){
        return super.getMessage();
    }
}
