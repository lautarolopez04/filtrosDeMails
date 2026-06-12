package ar.edu.unahur.obj2.composite.filtros;

import ar.edu.unahur.obj2.composite.mail.Mail;

public class Tamaño extends FiltroSimple {
    private Integer tamañoMinimo;

    public Tamaño(Mail mail, Integer tamañoMinimo) {
        super(mail);
        this.tamañoMinimo = tamañoMinimo;
    }

    @Override
    protected Boolean doAplicar() {
        return Boolean.valueOf(mail.getTamaño()>=tamañoMinimo);
    }
    

}
