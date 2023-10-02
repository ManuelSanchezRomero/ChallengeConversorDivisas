import java.util.HashMap;
import java.util.Map;

class Moneda {
    private String codigo;
    private String nombre;

    public Moneda(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
}

class TasaDeCambio {
    private Moneda moneda;
    private double tasa;

    public TasaDeCambio(Moneda moneda, double tasa) {
        this.moneda = moneda;
        this.tasa = tasa;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public double getTasa() {
        return tasa;
    }
}

public class ConversorDivisas {
    private Map<String, TasaDeCambio> tasasDeCambio;

    public ConversorDivisas() {
        tasasDeCambio = new HashMap<>();
        tasasDeCambio.put("USD", new TasaDeCambio(new Moneda("USD", "Dólar"), 0.05));
        tasasDeCambio.put("EUR", new TasaDeCambio(new Moneda("EUR", "Euro"), 0.045));
        tasasDeCambio.put("GBP", new TasaDeCambio(new Moneda("GBP", "Libra Esterlina"), 0.04));
        tasasDeCambio.put("JPY", new TasaDeCambio(new Moneda("JPY", "Yen Japonés"), 5.0));
        tasasDeCambio.put("KRW", new TasaDeCambio(new Moneda("KRW", "Won sul-coreano"), 57.0));
    }

    public double convertirAMonedaExtranjera(double cantidad, String codigoMoneda) {
        TasaDeCambio tasaDeCambio = tasasDeCambio.get(codigoMoneda);
        if (tasaDeCambio == null) {
            throw new IllegalArgumentException("Código de moneda no válido: " + codigoMoneda);
        }
        return cantidad * tasaDeCambio.getTasa();
    }

    // Obtener el nombre de la moneda por abreviatura
    public String getNombreMoneda(String codigoMoneda) {
        TasaDeCambio tasaDeCambio = tasasDeCambio.get(codigoMoneda);
        if (tasaDeCambio == null) {
            throw new IllegalArgumentException("Código de moneda no válido: " + codigoMoneda);
        }
        return tasaDeCambio.getMoneda().getNombre();
    }
}
