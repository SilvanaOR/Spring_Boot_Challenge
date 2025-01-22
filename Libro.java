package org.example;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private Integer anioNacimientoAutor;
    private String idioma;
    private String isbn;

    // ... constructores, getters y setters
}