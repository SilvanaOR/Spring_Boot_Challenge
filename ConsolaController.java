package org.example;

@Component
public class ConsolaController {
    @Autowired
    private LibroService libroService;

    @Autowired
    private Scanner scanner;

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar todos los libros");
            System.out.println("3. Listar autores");
            System.out.println("4. Listar autores vivos en un año");
            System.out.println("5. Listar libros por idioma");
            System.out.println("6. Buscar y guardar libro por ISBN");
            System.out.println("7. Salir");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título: ");
                    String titulo = scanner.next();
                    List<Libro> libros = libroService.buscarPorTitulo(titulo);
                    mostrarResultados(libros);
                    break;
                case 2:
                    List<Libro> todosLosLibros = libroService.listarLibros();
                    mostrarResultados(todosLosLibros);
                    break;
                case 3:
                    List<String> autores = libroService.listarAutores();
                    System.out.println("Autores:");
                    autores.forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Ingrese el año: ");
                    int anio = scanner.nextInt();
                    List<Libro> autoresVivos = libroService.listarAutoresVivosEnAnio(anio);
                    mostrarResultados(autoresVivos);
                    break;
                case 5:
                    System.out.print("Ingrese el idioma: ");
                    String idioma = scanner.next();
                    List<Libro> librosPorIdioma = libroService.listarLibrosPorIdioma(idioma);
                    mostrarResultados(librosPorIdioma);
                    break;
                case 6:
                    System.out.print("Ingrese el ISBN: ");
                    String isbn = scanner.next();
                    Libro libroGuardado = libroService.buscarYGuardarLibro(isbn);
                    if (libroGuardado != null) {
                        System.out.println("Libro guardado con éxito: " + libroGuardado);
                    } else {
                        System.out.println("No se encontró el libro o hubo un error al guardarlo.");
                    }
                    break;
                case 7:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private void mostrarResultados(List<Libro> libros) {
        if (libros.isEmpty()) {
            System.out.println("No se encontraron resultados.");
        } else {
            for (Libro libro : libros) {
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor());
                System.out.println("Año: " + libro.getAnioNacimientoAutor());
                System.out.println("Idioma: " + libro.getIdioma());
                System.out.println("------------------------");
            }
        }
    }
}
