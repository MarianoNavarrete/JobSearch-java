package com.Mariano.jobSearch;

import com.Mariano.jobSearch.API.APIJOBS;
import com.Mariano.jobSearch.API.ApiFunctions;
import com.Mariano.jobSearch.CLI.CliArguments;
import com.beust.jcommander.JCommander;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.Mariano.jobSearch.CommanderFunctions.buildCommanderWithName;
import static com.Mariano.jobSearch.CommanderFunctions.pasrseArguments;
import com.Mariano.jobSearch.API.ApiFunctions;
import  com.Mariano.jobSearch.CLI.CliFunctions;
public class JobSearch {
    public static void main(String[] args) {
        JCommander jCommander = buildCommanderWithName("job-search", CliArguments::newInstance);
        Stream<CliArguments> streamOfCli =
                pasrseArguments(jCommander, args, JCommander::usage)
                .orElse(Collections.emptyList())
                .stream()
                .map(obje -> (CliArguments) obje);
        Optional<CliArguments> cliArguments = streamOfCli.filter(cli -> !cli.isHelp())
                .filter((cli -> cli.getKeyWord() !=null))
                .findFirst();

        cliArguments.map(CliFunctions::toMap)
                .map(JobSearch::executeRequest)
                .orElse(Stream.empty())
                .forEach(System.out::println);
    }

    private static  Stream<JobPosition> executeRequest(Map<String, Object> params){
        APIJOBS api = ApiFunctions.buildApi(APIJOBS.class, "https://jobs.github.com/api");

        return Stream.of(params)
                .map(api::jobs)
                .flatMap((Collection::stream));
    }
}
