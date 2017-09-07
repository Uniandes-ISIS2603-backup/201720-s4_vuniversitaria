/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.entities;
import java.io.Serializable;
import javax.persistence.Entity;
/**
 *
 * @author NOA_WERMEID
 */
@Entity
public class ReglaEntity extends BaseEntity implements Serializable
{
    private String regla;

    public String getRegla() {
        return regla;
    }

    public void setRegla(String regla) {
        this.regla = regla;
    }
    
}
