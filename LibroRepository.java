package org.example;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByTituloContainingIgnoreCase(String titulo);
    List<Libro> findByAutor(String autor);
    List<Libro> findByAnioNacimientoAutor(Integer anio);
    List<Libro> findByIdioma(String idioma);
    List<Libro> findByIsbn(String isbn);
}