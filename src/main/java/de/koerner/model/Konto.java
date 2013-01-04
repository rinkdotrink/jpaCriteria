/*
 * (c) Bernd Müller & Harald Wehr, www.jpainfo.de
 */
package de.koerner.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;

@NamedQueries({
        @NamedQuery(name = "loadSparkonten", query = "select k from Sparkonto k where k.nummer = :nummer"),
        @NamedQuery(name = "loadGirokonten", query = "select k from Girokonto k where k.nummer = :nummer"),
        @NamedQuery(name = "loadKontenHints", query = "select k from Girokonto k where k.kontostand > 9500", hints = {
                @QueryHint(name = "org.hibernate.comment", value = "FIRST_ROWS(10)"),
                @QueryHint(name = "openjpa.hint.OracleSelectHint", value = "/*+ FIRST_ROWS(10) */"),
                @QueryHint(name = "eclipselink.sql.hint", value = "/*+ FIRST_ROWS(10)*/") }) })
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "kontoart", discriminatorType = DiscriminatorType.STRING)
public abstract class Konto {

    private int id;
    private int nummer;
    private BigDecimal kontostand;
    private Set<Kunde> kunden = new HashSet<Kunde>();

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    @ManyToMany(mappedBy = "konten")
    public Set<Kunde> getKunden() {
        return kunden;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKunden(Set<Kunde> kunden) {
        this.kunden = kunden;
    }

    public BigDecimal getKontostand() {
        return kontostand;
    }

    public void setKontostand(BigDecimal kontostand) {
        this.kontostand = kontostand;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

}
