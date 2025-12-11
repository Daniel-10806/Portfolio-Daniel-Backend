package portfolio_daniel_backend.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Entidad de dominio que representa un mensaje enviado desde el portafolio.
 */
public class ContactMessage {

    private Long id;
    private String name;
    private String email;
    private String subject;
    private String message;
    private LocalDateTime sentAt;
    private boolean attended;

    protected ContactMessage() {
    }

    public ContactMessage(
            String name,
            String email,
            String subject,
            String message,
            LocalDateTime sentAt,
            boolean attended) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio.");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("El email es obligatorio.");
        }
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("El mensaje no puede estar vacío.");
        }

        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.sentAt = sentAt;
        this.attended = attended;
    }

    public static ContactMessage createNew(String name,
            String email,
            String subject,
            String message) {
        return new ContactMessage(
                name,
                email,
                subject,
                message,
                LocalDateTime.now(),
                false);
    }

    public String getName() {
        return name;
    }

    public void rename(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void changeEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void changeSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void changeMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void changeSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public boolean isAttended() {
        return attended;
    }

    public void markAsAttended() {
        this.attended = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ContactMessage))
            return false;
        ContactMessage that = (ContactMessage) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}