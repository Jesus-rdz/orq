package gob.imss.necesaif.service;

import gob.imss.necesaif.model.altaTratamiento.AltaTratamientoEntrada;
import gob.imss.necesaif.model.altaTratamiento.AltaTratamientoSalida;
import gob.imss.necesaif.model.cancelaMedicamento.CancelaTratamientoEntrada;
import gob.imss.necesaif.model.cancelaMedicamento.CancelaTratamientoSalida;
import gob.imss.necesaif.model.consultaMedicamento.ConsultaMedicamentoEntrada;
import gob.imss.necesaif.model.consultaMedicamento.ConsultaMedicamentoSalida;
import org.springframework.stereotype.Service;

@Service
public interface appService {
    ConsultaMedicamentoSalida consultaMedicamento(ConsultaMedicamentoEntrada entrada);
    AltaTratamientoSalida altaTratamiento(AltaTratamientoEntrada entrada);
    CancelaTratamientoSalida cancelaTratamiento(CancelaTratamientoEntrada entrada);
}
