package br.univali.compiladores.lexico;

/**
 *
 * @author biankatpas
 */
public class Message
{
     private int Type;
    private String message;
    private boolean error;

    public Message(String message, boolean error) {
        this.message = message;
        this.error = error;
    }

    public Message(int Type, String message, boolean error) {
        this.Type = Type;
        this.message = message;
        this.error = error;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
