package com.jdojo.binding;


import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class LowLevelBindingTest {
    public static void main(String[] args) {
        final DoubleProperty radius = new SimpleDoubleProperty(7.0);

        // Creamos un DoubleBinding personalizado usando unha clase anónima
        DoubleBinding areaBinding = new DoubleBinding() {
            {
                // Paso 2: Ligamos á propiedade 'radius' como dependencia.
                // Isto fará que o binding se invalide cando 'radius' cambie.
                this.bind(radius);
            }

            @Override
            protected double computeValue() {
                // Paso 3: A lóxica para calcular a área.
                // Aquí podes poñer calquera lóxica de Java que necesites.
                double r = radius.get();
                return Math.PI * r * r;
            }
        };

        System.out.println("Radio = " + radius.get() + ", Área = " + areaBinding.get());
        // Saída: Radio = 7.0, Área = 153.938...

        // Os bindings de baixo nivel tamén reaccionan aos cambios nas dependencias
        radius.set(14.0);
        System.out.println("Radio = " + radius.get() + ", Área = " + areaBinding.get());
        // Saída: Radio = 14.0, Área = 615.752...
    }
}