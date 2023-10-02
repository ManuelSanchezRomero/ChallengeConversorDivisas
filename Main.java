import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorDivisas conversor = new ConversorDivisas();

        try {
            System.out.print("Ingrese la cantidad en MXN (Peso mexicano): ");
            double cantidadMXN = scanner.nextDouble();

            System.out.println("Seleccione la moneda a la que desea convertir:");
            System.out.println("1. USD (Dólar)");
            System.out.println("2. EUR (Euro)");
            System.out.println("3. GBP (Libras Esterlinas)");
            System.out.println("4. JPY (Yen Japonés)");
            System.out.println("5. KRW (Won sul-coreano)");
            System.out.print("Elija una opción (1-5): ");

            int opcion = scanner.nextInt();
            String codigoMoneda;

            switch (opcion) {
                case 1:
                    codigoMoneda = "USD";
                    break;
                case 2:
                    codigoMoneda = "EUR";
                    break;
                case 3:
                    codigoMoneda = "GBP";
                    break;
                case 4:
                    codigoMoneda = "JPY";
                    break;
                case 5:
                    codigoMoneda = "KRW";
                    break;
                default:
                    System.out.println("Opción no válida.");
                    return;
            }

            double resultado = conversor.convertirAMonedaExtranjera(cantidadMXN, codigoMoneda);
            System.out.println("Cantidad en " + conversor.getNombreMoneda(codigoMoneda) + ": " + resultado);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
