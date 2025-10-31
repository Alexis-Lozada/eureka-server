package com.idgs12.msb.msb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class EntityBEntityA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idEntityBId;

    // ONE TO MANY ES PARA LA TABLA QUE TIENE LA RELACION UNO A MUCHOS
    // MANYTOONE ES PARA LA TABLA QUE TIENE LA RELACION MUCHOS A UNO

    // ENTONCES EN ESTE CASO LA TABLA EntityBEntityA TIENE LA RELACION UNO A MUCHOS
    // PORQUE LA TABLA EntityBEntityA TIENE LA FOREIGN KEY DE EntityB

    // @OneToMany // ME VOY A TRAER LA LISTA DE OBJETOS RELACIONADOS CON EntityB
    // PERO SI YO CONSULTO UN OBJETO DE EntityBEntityA, NO ME TRAE LA LISTA DE
    // OBJETOS RELACIONADOS CON EntityB

}
