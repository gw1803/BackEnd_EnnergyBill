package br.cefet.ElectricityBill.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Data é campo obrigatório para inserir ou modificar uma Conta")
    @Column(nullable = false, length = 50)
    private String data;

    @NotNull(message = "Valor é campo obrigatório para inserir ou modificar uma Conta")
    @Column(nullable = false, length = 50)
    private double valor;

    @ManyToOne
    @JoinColumn(name = "id_person", nullable=false, foreignKey = @ForeignKey(name="fk_bill_person") )
    private Person person;

}
