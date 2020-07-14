package server.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "FAULT_ORDER_ID", nullable = false)
    private FaultOrder faultOrder;
    private byte[] content;

    public Attachment(String name, FaultOrder faultOrder, byte[] content) {
        this.name = name;
        this.faultOrder = faultOrder;
        this.content = content;
    }

}