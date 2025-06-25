package Util;

import Logica.Biblioteca;
import Logica.NivelEscolar;

import java.util.ArrayList;

public class Inicializar {
    public static void inicializar() {
        ArrayList<String>arbitrosCientif=new ArrayList<String>();
        arbitrosCientif.add("Dr. Ana Torres");
        arbitrosCientif.add("Dr. Luis Fernández");

        ArrayList<String>arbitrosLiteratura=new ArrayList<String>();
        arbitrosLiteratura.add("Prof. Marta Sánchez");

        ArrayList<String>arbitrosCultura=new ArrayList<String>();
        arbitrosCultura.add("Lic. Carlos Pérez");
        Biblioteca.getInstance().agregarLibro(
                "L001",
                "Cien años de soledad",
                "Novela",
                257, true,"Editorial Sudamericana",
                5
        );
        Biblioteca.getInstance().agregarLibro(
                "L002",
                "El amor en los tiempos del cólera",
                "Novela",
                348, true, "Editorial Mondadori",
                3
        );
        Biblioteca.getInstance().agregarLibro(
                "L003",
                "El túnel",
                "Novela",
                150, true,"Editorial Losada",
                4
        );
        Biblioteca.getInstance().agregarLibro(
                "L004",
                "Rayuela",
                "Novela",
                600, true,"Editorial Alfaguara",
                2
        );
        Biblioteca.getInstance().agregarLibro(
                "L005",
                "Crónica de una muerte anunciada",
                "Novela",
                120, true,"Editorial Norma",
                6
        );
        Biblioteca.getInstance().agregarLibro(
                "L006",
                "El Aleph",
                "Cuento",
                200, true,"Editorial Emecé",
                4
        );
        Biblioteca.getInstance().agregrarRevista(
                "R001",
                "National Geographic",
                "Ciencia",
                50, true,2025,
                10,23
        );
        Biblioteca.getInstance().agregrarRevista(
                "R002",
                "Time",
                "Actualidad",
                40, true,2025,
                8,15
        );
        Biblioteca.getInstance().agregrarRevista(
                "R003",
                "Vogue",
                "Moda",
                30, true,2025,
                5,10
        );
        Biblioteca.getInstance().agregrarArticulo(
                "A001",
                "La inteligencia artificial en la educación",
                "Tecnología",
                12, 5,true,arbitrosCientif
        );
        Biblioteca.getInstance().agregrarArticulo(
                "A002",
                "El impacto del cambio climático en la agricultura",
                "Ciencia Ambiental",
                15, 3,true,arbitrosCientif
        );
        Biblioteca.getInstance().agregrarArticulo(
                "A003",
                "La evolución de la música en el siglo XXI",
                "Cultura",
                10, 8, true, arbitrosCultura
        );
        Biblioteca.getInstance().agregrarArticulo(
                "A004",
                "El futuro de la energía renovable",
                "Energía",
                20, 2, true, arbitrosCientif
        );
        Biblioteca.getInstance().agregrarArticulo(
                "A005",
                "La historia de la computación",
                "Tecnología",
                18, 4, true,arbitrosCientif
        );
        Biblioteca.getInstance().agregrarArticulo(
                "A006",
                "El arte de la fotografía digital",
                "Arte",
                25, 6, true, arbitrosCultura
        );
        Biblioteca.getInstance().agregrarArticulo(
                "A007",
                "La influencia de la literatura en la sociedad",
                "Literatura",
                30, 7, true, arbitrosLiteratura
        );
        Biblioteca.getInstance().registrarUsuario(
                "07041282580",
                "Juan",
                "Pérez",
                'M',
                "U001"
        );
        Biblioteca.getInstance().registrarUsuario(
                "03032468565",
                "María",
                "Gómez",
                'F',
                "U002"
        );
        Biblioteca.getInstance().registrarUsuario(
                "04082468369",
                "Carlos",
                "López",
                'M',
                "U003"
        );
        Biblioteca.getInstance().registrarUsuario(
                "05052468535",
                "Ana",
                "Martínez",
                'F',
                "U004"
        );
        Biblioteca.getInstance().registrarUsuario(
                "06062478565",
                "Luis",
                "Hernández",
                'M',
                "U005"
        );
        Biblioteca.getInstance().registrarUsuario(
                "08082488532",
                "Laura",
                "Ramírez",
                'F',
                "U006"
        );
        Biblioteca.getInstance().contratarTrabajador("94072143067","Francisco","Tejera","Bibliotecario Asistente",'M',"59987412","fractej@outlook.com", NivelEscolar.Medio);
        Biblioteca.getInstance().contratarTrabajador("82072129881","Mario","Paz","Bibliotecario",'M',"56631278","mayitopaz@gmail.com", NivelEscolar.Superior);
        Biblioteca.getInstance().contratarTrabajador("85010827821","Jorge", "Pimienta","Asistente Mantenimiento",'M',"56631538","jorgepm@hotmail.es", NivelEscolar.MedioSuperior);
        Biblioteca.getInstance().contratarTrabajador("67012357909","Matilde","Garcia","Asistende Limpieza",'F',"52478560","matilde67@nauta.cu", NivelEscolar.Basico);
        Biblioteca.getInstance().contratarTrabajador("75021828423","José","Díaz","Administrador",'M',"58847621","josediaz@litcubana.com", NivelEscolar.Superior);

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
                "82072129881"
        );
        Biblioteca.getInstance().atenderPrestamo(
                "A001",
                Biblioteca.getInstance().buscarUsuario("U001"),
                "82072129881"
        );

    }
}
