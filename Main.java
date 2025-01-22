package org.example;

@SpringBootApplication
public class CatalogoLibrosApplication {
    public static void main(String[] args) {
        SpringApplication.run(CatalogoLibrosApplication.class, args);

        ApplicationContext context = SpringApplication.run(CatalogoLibrosApplication.class, args);
        ConsolaController consolaController = context.getBean(ConsolaController.class);
        consolaController.iniciar();
    }
}