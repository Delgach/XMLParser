public class Valute {

    private String id;
    private String numCode;
    private String charCode;
    private int nominal;
    private String name;
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Valute{" + "\n" +
                "id = " + id +  "\n" +
                "numCode = " + numCode +   "\n"+
                "charCode = " + charCode +   "\n" +
                "nominal = " + nominal + "\n" +
                "name = " + name  + "\n" +
                "value = " + value + "\n" +
                '}' + "\n" ;
    }
}
