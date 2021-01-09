package com.Mariano.jobSearch.CLI;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class CliKeywordValidator implements IParameterValidator {

    @Override
    public void validate(String name, String value) throws ParameterException {
        if(!value.matches("^[a-zA-Z]+[0-9]*$")){
            System.out.println("criterio no valido");
            throw new ParameterException("solo letras y numeros");
        }
    }
}
