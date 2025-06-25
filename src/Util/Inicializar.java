package Util;

import Logica.Biblioteca;
import Logica.NivelEscolar;

public class Inicializar {
    public static void inicializar() {
        Biblioteca.getInstance().agregarLibro(
                "L001",
                "Cien años de soledad",
                "Novela",
                257, "Editorial Sudamericana",
                5
        );
        Biblioteca.getInstance().agregarLibro(
                "L002",
                "El amor en los tiempos del cólera",
                "Novela",
                348, "Editorial Mondadori",
                3
        );
        Biblioteca.getInstance().agregarLibro(
                "L003",
                "El túnel",
                "Novela",
                150, "Editorial Losada",
                4
        );
        Biblioteca.getInstance().agregarLibro(
                "L004",
                "Rayuela",
                "Novela",
                600, "Editorial Alfaguara",
                2
        );
        Biblioteca.getInstance().agregarLibro(
                "L005",
                "Crónica de una muerte anunciada",
                "Novela",
                120, "Editorial Norma",
                6
        );
        Biblioteca.getInstance().agregarLibro(
                "L006",
                "El Aleph",
                "Cuento",
                200, "Editorial Emecé",
                4
        );
        Biblioteca.getInstance().agregrarRevista(
                "R001",
                "National Geographic",
                "Ciencia",
                50, 2025,
                10,23
        );
        Biblioteca.getInstance().agregrarRevista(
                "R002",
                "Time",
                "Actualidad",
                40, 2025,
                8,15
        );
        Biblioteca.getInstance().agregrarRevista(
                "R003",
                "Vogue",
                "Moda",
                30, 2025,
                5,10
        );
        Biblioteca.getInstance().agregrarArticulo(
                "A001",
                "La inteligencia artificial en la educación",
                "Tecnología",
                12, 5
        );
        Biblioteca.getInstance().agregrarArticulo(
                "A002",
                "El impacto del cambio climático en la agricultura",
                "Ciencia Ambiental",
                15, 3
        );
        Biblioteca.getInstance().agregrarArticulo(
                "A003",
                "La evolución de la música en el siglo XXI",
                "Cultura",
                10, 8
        );
        Biblioteca.getInstance().agregrarArticulo(
                "A004",
                "El futuro de la energía renovable",
                "Energía",
                20, 2
        );
        Biblioteca.getInstance().agregrarArticulo(
                "A005",
                "La historia de la computación",
                "Tecnología",
                18, 4
        );
        Biblioteca.getInstance().agregrarArticulo(
                "A006",
                "El arte de la fotografía digital",
                "Arte",
                25, 6
        );
        Biblioteca.getInstance().agregrarArticulo(
                "A007",
                "La influencia de la literatura en la sociedad",
                "Literatura",
                30, 7
        );
        Biblioteca.getInstance().registrarUsuario(
                "0704121668369",
                "Juan",
                "Pérez",
                'M',
                "U001"
        );
        Biblioteca.getInstance().registrarUsuario(
                "0303246856515",
                "María",
                "Gómez",
                'F',
                "U002"
        );
        Biblioteca.getInstance().registrarUsuario(
                "0408246836949",
                "Carlos",
                "López",
                'M',
                "U003"
        );
        Biblioteca.getInstance().registrarUsuario(
                "0505246856535",
                "Ana",
                "Martínez",
                'F',
                "U004"
        );
        Biblioteca.getInstance().registrarUsuario(
                "0606246856545",
                "Luis",
                "Hernández",
                'M',
                "U005"
        );
        Biblioteca.getInstance().registrarUsuario(
                "0808246856555",
                "Laura",
                "Ramírez",
                'F',
                "U006"
        );
        Biblioteca.getInstance().contratarTrabajador("94072143067","Francisco","Tejera","Bibliotecario Asistente",'M',"59987412","fractej@outlook.com", NivelEscolar.Medio);
        Biblioteca.getInstance().contratarTrabajador("85010827821","Jorge", "Pimienta","Asistente Mantenimiento",'M',"56631278","jorgepm@hotmail.es", NivelEscolar.MedioSuperior);
        Biblioteca.getInstance().contratarTrabajador("6701235790","Matilde","Garcia","Asistende Limpieza",'F',"52478560","matilde67@nauta.cu", NivelEscolar.Basico);

        Biblioteca.getInstance().atenderPrestamo(
                "L001",
                Biblioteca.getInstance().buscarUsuario("U001"),
                "94072143067"
        );
        Biblioteca.getInstance().atenderPrestamo(
                "L002",
                Biblioteca.getInstance().buscarUsuario("U002"),
                "94072143067"
        );
        Biblioteca.getInstance().atenderPrestamo(
                "L003",
                Biblioteca.getInstance().buscarUsuario("U003"),
                "94072143067"
        );
        Biblioteca.getInstance().atenderPrestamo(
                "L004",
                Biblioteca.getInstance().buscarUsuario("U004"),
                "94072143067"
        );
        Biblioteca.getInstance().atenderPrestamo(
                "L005",
                Biblioteca.getInstance().buscarUsuario("U005"),
                "94072143067"
        );
        Biblioteca.getInstance().atenderPrestamo(
                "R001",
                Biblioteca.getInstance().buscarUsuario("U006"),
                "94072143067"
        );
        Biblioteca.getInstance().atenderPrestamo(
                "A001",
                Biblioteca.getInstance().buscarUsuario("U001"),
                "94072143067"
        );

    }
}
