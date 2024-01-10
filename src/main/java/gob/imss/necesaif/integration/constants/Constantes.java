package gob.imss.necesaif.integration.constants;

public interface Constantes {
    /* Errores generales
     */
    public final static String[] PROC_EXITO = {"0", "Procesada la petici�n."};
    public final static String[] NOHAYDATOS = {"2", "No hay datos que mostrar."};
    /* Estos errores aplican en general para el WebService
     */
    public final static String[] ERR_EXECSP = {"101", "Error: Fallo ocurrido al ejecutar el StoreProcedure."};
    public final static String[] ERR_CNXDBRUTEO = {"102", "Error: Fall� la conexi�n con la base de ruteo."};
    public final static String[] ERR_NOINFRUTEO = {"103", "Error: No se encontro informaci�n en la base de Ruteo."};
    public final static String[] ERR_CNXDB = {"104", "Error: Procesar query y/o intentear conectarse con la base de datos."};
    public final static String[] ERR_ENTRADAINVALIDA = {"105", "Error: Par�metros incompletos en la solicitud."};
    public final static String[] ERR_NOTRATRECETA = {"106", "Error: No hay Tratamiento ni Receta."};
    public final static String[] ERR_ACTUALIZARSP = {"107", "Error: Actualizar Sotore Procedure en la base de datos de la Farmacia Local."};

}
