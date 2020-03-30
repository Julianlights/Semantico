package codigo;

/**
 *
 * @author Marcelo Lopez
 */
public class Test {
    
    String sstring;
    int entero_1;
    private float flot;
    float testData;
    double dob;

    // El constructor puede quedar vacío
    // El constructor NO siempre debe de llevar  los atributos ceclarados
    // Los nombres de los atributos en el constructor puede ser diferente del nombre de los atributos declarados
    // El constructor puede ser private o public
    
    public Test(String data, int Int, double doble, float testData) {}
    
    

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getInt() {
        return Int;
    }

    public void setInt(int Int) {
        this.Int = Int;
    }

    public double getDoble() {
        return doble;
    }

    public void setDoble(double doble) {
        this.doble = doble;
    }

    public float getTestData() {
        return testData;
    }

    public void setTestData(float testData) {
        this.testData = testData;
    }      
}
