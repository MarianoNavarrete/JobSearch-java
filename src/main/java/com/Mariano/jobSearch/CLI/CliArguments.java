package com.Mariano.jobSearch.CLI;

import com.beust.jcommander.Parameter;
import feign.Param;

public class CliArguments {
    CliArguments(){

    }
    @Parameter(
            required = true,
            descriptionKey = "KEYWORD",
            description = "KEYWORD",
            validateWith = CliKeywordValidator.class
    )
    private String keyWord;

    @Parameter(
            names = {"--location", "-l"},
            description = "Cada busqueda puede incluir una ubicacion"
    )
    private String location;

    @Parameter(
            names = {"--page", "-p"},
            description = "selecciona un numero para pagina"
    )
    private int page=0;

    @Parameter(
            names = {"--fulltime"},
            description = "requiere un trabajo fulltime"
    )
    private boolean isFullTime=false;

    @Parameter(
            names = {"--markdown"},
            description = "obtener los resultados en markdown"
    )
    private boolean isMarkdown=false;

    @Parameter(
            names = {"--help", "-h"},
            help = true,
            validateWith = CliHelpValidator.class,
            description = "mostrar ayuda"
    )
    private boolean isHelp;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public void setFullTime(boolean fullTime) {
        isFullTime = fullTime;
    }

    public boolean isMarkdown() {
        return isMarkdown;
    }

    public void setMarkdown(boolean markdown) {
        isMarkdown = markdown;
    }

    public boolean isHelp() {
        return isHelp;
    }

    public void setHelp(boolean help) {
        isHelp = help;
    }

    @Override
    public String toString() {
        return "CliArguments{" +
                "keyWord='" + keyWord + '\'' +
                ", location='" + location + '\'' +
                ", page=" + page +
                ", isFullTime=" + isFullTime +
                ", isMarkdown=" + isMarkdown +
                ", isHelp=" + isHelp +
                '}';
    }

    public static CliArguments newInstance(){
        return new CliArguments();
    }
}
