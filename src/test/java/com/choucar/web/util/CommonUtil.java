package com.choucar.web.util;

//import org.apache.commons.lang.WordUtils;

import java.util.ArrayList;
import java.util.Collections;

public class CommonUtil {


    public static ArrayList<Integer> numerosAleatorios(int numeroIncial, int numeroFinal) {

        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = numeroIncial; i <= numeroFinal; i++) {
            numeros.add(i);
        }
        Collections.shuffle(numeros);

        return numeros;
    }

}
