import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Appointement {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="APPDATE")
    private String appdate;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "paydate", column = @Column(name = "PAYDATE")),
            @AttributeOverride(name = "amount", column = @Column(name = "AMOUNT"))})
    private Payment payment;

    @ManyToOne
    @JoinColumn(name="PATIENT")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="DOCTOR")
    private Doctor doctor;

    public Appointement(String appdate, Payment payment, Patient patient, Doctor doctor){
        this.appdate=appdate;
        this.doctor=doctor;
        this.patient=patient;
        this.payment=payment;
    }
}
