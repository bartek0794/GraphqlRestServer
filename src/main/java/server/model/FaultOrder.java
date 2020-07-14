package server.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "FAULT_ORDER")
@Getter @Setter @NoArgsConstructor
public class FaultOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;
    @ManyToOne
    @JoinColumn(name = "STATUS_ID", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "PRIORITY_ID", nullable = false)
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    private Employee employee;

    private String description;
    private String note;

    @Column(name = "CREATE_DATE")
    Date createDate;
    @Column(name = "REALIZATION_DATE")
    Date realizationDate;
    @Column(name = "FINISH_DATE")
    Date finishDate;
    @ManyToOne
    @JoinColumn(name = "RESULT_ID", nullable = false)
    private Result result;


    public FaultOrder(String title, Status status, Priority priority, Customer customer,
                      Employee employee, Status description, Status note,
                      Date createDate, Date realizationDate, Date finishDate, Result result) {
        this.title = title;
        this.status = status;
        this.priority = priority;
        this.customer = customer;
        this.employee = employee;
        this.createDate = createDate;
        this.realizationDate = realizationDate;
        this.finishDate = finishDate;
        this.result = result;
    }

}