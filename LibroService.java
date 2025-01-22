package org.example;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Libro> buscarPorTitulo(String titulo) {
        return libroRepository.findByTituloContainingIgnoreCase(titulo);
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public List<String> listarAutores() {
        return libroRepository.findAll().stream().map(Libro::getAutor).distinct().collect(Collectors.toList());
    }

    public List<Libro> listarAutoresVivosEnAnio(Integer anio) {
        return libroRepository.findAll().stream()
                .filter(libro -> libro.getAnioNacimientoAutor() > anio)
                .collect(Collectors.toList());
    }

    public List<Libro> listarLibrosPorIdioma(String idioma) {
        return libroRepository.findByIdioma(idioma);
    }

    public Libro buscarLibroPorIsbn(String isbn) {
        return libroRepository.findByIsbn(isbn);
    }

    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    // Método auxiliar para buscar libros en Gutendex y guardarlos
    public Libro buscarYGuardarLibro(String isbn) {
        Libro libro = buscarLibroEnGutendex(isbn);
        if (libro != null) {
            return guardarLibro(libro);
        }
        return null;
    }

    private Libro buscarLibroEnGutendex(String isbn) {
        String url = "https://gutendex.com/books/" + isbn;
        try {
            ResponseEntity<Libro> response = restTemplate.getForEntity(url, Libro.class);
            return response.getBody();
        } catch (RestClientException e) {
            // Manejar excepciones
            return null;
        }
    }
}