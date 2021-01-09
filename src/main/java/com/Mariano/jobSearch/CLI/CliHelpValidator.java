package com.Mariano.jobSearch.CLI;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class CliHelpValidator implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        boolean actualValue = Boolean.parseBoolean((value));
        if(actualValue){
            throw new ParameterException("ayuda");
        }
    }
}
