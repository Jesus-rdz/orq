package gob.imss.necesaif.service;

import gob.imss.necesaif.data.dao.DAOFarmacia;
import gob.imss.necesaif.integration.constants.Constantes;
import gob.imss.necesaif.model.altaTratamiento.AltaTratamientoEntrada;
import gob.imss.necesaif.model.altaTratamiento.AltaTratamientoSalida;
import gob.imss.necesaif.model.cancelaMedicamento.CancelaTratamientoEntrada;
import gob.imss.necesaif.model.cancelaMedicamento.CancelaTratamientoSalida;
import gob.imss.necesaif.model.cancelaMedicamento.Receta;
import gob.imss.necesaif.model.cancelaMedicamento.Tratamiento;
import gob.imss.necesaif.model.consultaMedicamento.ConsultaMedicamentoEntrada;
import gob.imss.necesaif.model.consultaMedicamento.ConsultaMedicamentoSalida;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class appServiceImpl implements appService {

    private final static Logger logger = Logger.getLogger(appServiceImpl.class);

    @Autowired
    private DAOFarmacia daoFarmacia;

    @Override
    public ConsultaMedicamentoSalida consultaMedicamento(ConsultaMedicamentoEntrada entrada) {
        ConsultaMedicamentoSalida salida = new ConsultaMedicamentoSalida();
        try {
            salida = daoFarmacia.exeConsultaMedicamento(entrada);
        } catch (Exception e){
            e.printStackTrace();
            salida.setMensaje(Constantes.ERR_CNXDB[1]);
            salida.setEstatus(Constantes.ERR_CNXDB[0]);
        }
        return salida;
    }

    @Override
    public AltaTratamientoSalida altaTratamiento(AltaTratamientoEntrada entrada) {
        AltaTratamientoSalida salida = new AltaTratamientoSalida();
        try{
            salida = daoFarmacia.exeAltaTratamiento(entrada);
            salida.setClasificacionPresupuestal(entrada.getClasificacionPresupuestalFarmacia());
            if(salida.getEstatus().equals(Constantes.ERR_ACTUALIZARSP[0])){
                // si error De actualizacion SP
                try{
                    CancelaTratamientoEntrada cancelaTratamientoEntrada = new CancelaTratamientoEntrada();
                    cancelaTratamientoEntrada.setClasificacionPresupuestal(entrada.getClasificacionPresupuestalSolicitante());
                    cancelaTratamientoEntrada.setClasificacionPresupuestalFarmacia(entrada.getClasificacionPresupuestalFarmacia());
                    cancelaTratamientoEntrada.setNumeroReceta(entrada.getTratamiento().get(0).getReceta().get(0).getNumeroDocumento());
                    //borrar por Tratamiento para que se eliminen todas las recetas
                    CancelaTratamientoSalida CancelaTratamientoSalida = new CancelaTratamientoSalida();
                    CancelaTratamientoSalida = daoFarmacia.exeCancelaTratamiento(0, cancelaTratamientoEntrada);
                    salida.setEstatus(CancelaTratamientoSalida.getEstatus());
                    salida.setMensaje(CancelaTratamientoSalida.getMensaje());
                } catch (Exception ex){
                    ex.getStackTrace();
                    salida.setEstatus(Constantes.ERR_EXECSP[0]);
                    salida.setMensaje(Constantes.ERR_EXECSP[1]);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            salida.setEstatus(Constantes.ERR_CNXDB[0]);
            salida.setMensaje(Constantes.ERR_CNXDB[1]);
        }
        return salida;
    }

    @Override
    public CancelaTratamientoSalida cancelaTratamiento(CancelaTratamientoEntrada entrada) {
        CancelaTratamientoSalida salida = new CancelaTratamientoSalida();
        logger.info("Servicio Cancela Tratamiento");
        List<Tratamiento> listTratamiento = new ArrayList<>();
        Tratamiento tratamiento = new Tratamiento();
        try {
            if(entrada.getNumeroReceta().length() > 0){
                logger.info("Cancela por receta.");
                salida = daoFarmacia.exeCancelaTratamiento(1, entrada);
                List<Receta> listReceta = new ArrayList<>();
                Receta receta = new Receta();
                receta.setEstatusReceta(salida.getEstatus());
                receta.setMensajeReceta(salida.getMensaje());
                receta.setNumeroDocumento(entrada.getNumeroReceta());
                listReceta.add(receta);
                tratamiento.setReceta(listReceta);
            } else if (entrada.getTratamiento().length() > 0) {
                logger.info("Cancela por tratamiento.");
                salida = daoFarmacia.exeCancelaTratamiento(0, entrada);
                tratamiento.setEstatusTratamiento(salida.getEstatus());
                tratamiento.setNumeroTratamiento(entrada.getTratamiento());
                listTratamiento.add(tratamiento);
                salida.setTratamiento(listTratamiento);
            } else {
                salida.setEstatus(Constantes.ERR_NOTRATRECETA[0]);
                salida.setMensaje(Constantes.ERR_NOTRATRECETA[1]);
            }
        } catch (Exception e){
            e.printStackTrace();
            salida.setEstatus(Constantes.ERR_CNXDB[0]);
            salida.setMensaje(Constantes.ERR_CNXDB[1]);
        }
        return salida;
    }

}
