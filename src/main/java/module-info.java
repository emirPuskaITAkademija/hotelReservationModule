module ba.reservation.hotelreservation {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.naming;

    requires org.controlsfx.controls;
    requires java.persistence;
    requires java.xml.bind;
    requires org.hibernate.orm.core;
    requires org.hibernate.commons.annotations;
    requires java.sql;
    requires java.sql.rowset;

    opens ba.reservation.hotelreservation to javafx.fxml;
    opens ba.reservation.hotelreservation.business.model to org.hibernate.orm.core;
    exports ba.reservation.hotelreservation;
}