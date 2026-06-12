package ar.edu.unahur.obj2.composite.mail;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.composite.agrupable.Agrupable;
import ar.edu.unahur.obj2.composite.filtros.Adjunto;
import ar.edu.unahur.obj2.composite.filtros.AsuntoContiene;
import ar.edu.unahur.obj2.composite.filtros.FiltroCompuesto;
import ar.edu.unahur.obj2.composite.filtros.Tamaño;

public class MailTest {
    @Test
    void dadoUnMailConAsuntoMuyImportanteYTamaño250ConAdjuntoDaTestOk() {
        Mail mail = new Mail("Johny","Test", "Muy Importante", 250, true, "Cuerpo");
        Agrupable filtro = new Tamaño(mail, 230);
        Agrupable adj = new Adjunto(mail);
        Agrupable contiene = new AsuntoContiene(mail, "Muy Importante");
        Agrupable compuesto = new FiltroCompuesto(
            Arrays.asList(filtro, adj, contiene)
        );
        mail.setFiltro(compuesto);
        assertTrue(mail.filtrate());
    }
}
