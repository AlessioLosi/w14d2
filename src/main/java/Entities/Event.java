package Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "titolo", nullable = false)
    private String titolo;
    @Column(name = "data_evento", nullable = true)
    private LocalDate data_evento;
    @Column(name = "descrizione", nullable = true)
    private String descrizione;
    @Column(name = "numero_partecipanti", nullable = true)
    private int numero_partecipanti;
    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    public Event() {
    }

    ;

    public Event(String titolo, LocalDate data_evento, String descrizione, int numero_partecipanti, EventType eventType) {
        this.titolo = titolo;
        this.data_evento = data_evento;
        this.descrizione = descrizione;
        this.numero_partecipanti = numero_partecipanti;
        this.eventType = eventType;
    }

    public String titolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate data_evento() {
        return data_evento;
    }

    public String descrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setData_evento(LocalDate data_evento) {
        this.data_evento = data_evento;
    }

    public int numero_partecipanti() {
        return numero_partecipanti;
    }

    public void setNumero_partecipanti(int numero_partecipanti) {
        this.numero_partecipanti = numero_partecipanti;
    }

    public EventType eventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public long id() {
        return id;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo=" + titolo +
                ", data=" + data_evento +
                ", descrizione=" + descrizione +
                ", numero partecipanti=" + numero_partecipanti +
                ", tipologia=" + eventType +
                '}';
    }
}
