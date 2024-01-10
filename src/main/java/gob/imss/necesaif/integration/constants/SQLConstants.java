package gob.imss.necesaif.integration.constants;

public class SQLConstants {
    public static final String QS_RUTEO_FARMACIA = "SELECT ID, VERSION, USERNAME, CLAVE_PRESUPUESTAL_ORIGEN, " +
            "DRIVER_CLASS, CLAVE_PRESUPUESTAL_FARMACIA, PASSWORD, URL " +
            "FROM CADISPM.RUTEO " +
            "WHERE CLAVE_PRESUPUESTAL_ORIGEN = ?" +
            "AND CLAVE_PRESUPUESTAL_FARMACIA = ?";
}
