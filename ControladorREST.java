package org.example;

@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @PostMapping
    public Libro crearLibro(@RequestBody Libro libro) {
        // ... lógica para buscar el libro en la API y guardar en la base de datos
    }
    // ... otros métodos
}
