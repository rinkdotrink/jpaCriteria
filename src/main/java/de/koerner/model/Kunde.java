/*
 * (c) Bernd Müller & Harald Wehr, www.jpainfo.de
 */

package de.koerner.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Kunde {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer kundennummer;
    private String vorname;
    private String nachname;
    @Temporal(TemporalType.DATE)
    private Date geburtsdatum;
    private Character geschlecht;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "WOHNORT_ID")
    private Adresse wohnort;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Konto> konten = new HashSet<Konto>();
    
    // weitere Getter und Setter Methoden ...

    public Set<Konto> getKonten() {
        return konten;
    }

    public Adresse getWohnort() {
        return wohnort;
    }

    public void setWohnort(Adresse wohnort) {
        this.wohnort = wohnort;
    }

    public void setKonten(Set<Konto> konten) {
        this.konten = konten;
    }

    public void addKonto(Konto k) {
        k.getKunden().add(this);
        konten.add(k);
    }

    public Kunde() {
    }

    public Kunde(int id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVorname() {
        return this.vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return this.nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Date getGeburtsdatum() {
        return this.geburtsdatum;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public Character getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(Character geschlecht) {
        this.geschlecht = geschlecht;
    }

    public Integer getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(Integer kundennummer) {
        this.kundennummer = kundennummer;
    }
}
