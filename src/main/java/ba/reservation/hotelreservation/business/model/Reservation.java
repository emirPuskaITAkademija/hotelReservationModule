package ba.reservation.hotelreservation.business.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author emir
 */
@Entity
@Table(name = "reservation")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r")
        , @NamedQuery(name = "Reservation.findById", query = "SELECT r FROM Reservation r WHERE r.id = :id")
        , @NamedQuery(name = "Reservation.findByFromDate", query = "SELECT r FROM Reservation r WHERE r.fromDate = :fromDate")
        , @NamedQuery(name = "Reservation.findByToDate", query = "SELECT r FROM Reservation r WHERE r.toDate = :toDate")
        , @NamedQuery(name = "Reservation.findByCheckIn", query = "SELECT r FROM Reservation r WHERE r.checkIn = :checkIn")
        , @NamedQuery(name = "Reservation.findByCheckInDateTime", query = "SELECT r FROM Reservation r WHERE r.checkInDateTime = :checkInDateTime")
        , @NamedQuery(name = "Reservation.findByCheckOut", query = "SELECT r FROM Reservation r WHERE r.checkOut = :checkOut")
        , @NamedQuery(name = "Reservation.findByCheckOutDateTime", query = "SELECT r FROM Reservation r WHERE r.checkOutDateTime = :checkOutDateTime")
        , @NamedQuery(name = "Reservation.findByPrice", query = "SELECT r FROM Reservation r WHERE r.price = :price")
        , @NamedQuery(name = "Reservation.findByStatus", query = "SELECT r FROM Reservation r WHERE r.status = :status")})
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "from_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;
    @Basic(optional = false)
    @Column(name = "to_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date toDate;
    @Basic(optional = false)
    @Column(name = "check_in")
    private boolean checkIn;
    @Column(name = "check_in_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkInDateTime;
    @Basic(optional = false)
    @Column(name = "check_out")
    private boolean checkOut;
    @Column(name = "check_out_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOutDateTime;
    @Column(name = "price")
    private Long price;
    @Column(name = "status")
    private Integer status;
    @JoinColumn(name = "id_guest", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Guest idGuest;
    @JoinColumn(name = "id_room", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Room idRoom;

    public Reservation() {
    }

    public Reservation(Integer id) {
        this.id = id;
    }

    public Reservation(Integer id, Date fromDate, Date toDate, boolean checkIn, boolean checkOut) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public boolean getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckInDateTime() {
        return checkInDateTime;
    }

    public void setCheckInDateTime(Date checkInDateTime) {
        this.checkInDateTime = checkInDateTime;
    }

    public boolean getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
    }

    public Date getCheckOutDateTime() {
        return checkOutDateTime;
    }

    public void setCheckOutDateTime(Date checkOutDateTime) {
        this.checkOutDateTime = checkOutDateTime;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Guest getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(Guest idGuest) {
        this.idGuest = idGuest;
    }

    public Room getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Room idRoom) {
        this.idRoom = idRoom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hotel.business.model.Reservation[ id=" + id + " ]";
    }

}
