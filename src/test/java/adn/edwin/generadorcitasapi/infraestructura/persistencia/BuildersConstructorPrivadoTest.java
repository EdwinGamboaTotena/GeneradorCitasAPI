package adn.edwin.generadorcitasapi.infraestructura.persistencia;

import adn.edwin.generadorcitasapi.infraestructura.persistencia.builder.CitaBuilder;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.builder.CuponBuilder;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.builder.ProductoBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class BuildersConstructorPrivadoTest {

    @Test
    public void productoBuilderConstructorTest() {
        //arange
        final Constructor<?>[] constructors = ProductoBuilder.class.getDeclaredConstructors();
        //act
        for (Constructor<?> constructor : constructors) {
            //assert
            Assert.assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        }
    }

    @Test
    public void cuponBuilderConstructorTest() {
        //arange
        final Constructor<?>[] constructors = CuponBuilder.class.getDeclaredConstructors();
        //act
        for (Constructor<?> constructor : constructors) {
            //assert
            Assert.assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        }
    }

    @Test
    public void citaBuilderConstructorTest() {
        //arange
        final Constructor<?>[] constructors = CitaBuilder.class.getDeclaredConstructors();
        //act
        for (Constructor<?> constructor : constructors) {
            //assert
            Assert.assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        }
    }
}
