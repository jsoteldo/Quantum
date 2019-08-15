
package com.quantum.modelos;

/**
 *
 * @author QUANTUM
 */
public class Selectequivalencias {
    
    private String Id;
    
    private String Campo;

    

    public Selectequivalencias() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getCampo() {
        return Campo;
    }

    public void setCampo(String Campo) {
        this.Campo = Campo;
    }

    public Selectequivalencias(String Id, String Campo) {
        this.Id = Id;
        this.Campo = Campo;
    }

    @Override
    public String toString() {
        return "Selectequivalencias{" + "Id=" + Id + ", Campo=" + Campo + '}';
    }

    

    
    
    
    
}
