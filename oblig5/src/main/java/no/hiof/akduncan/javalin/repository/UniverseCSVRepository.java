package no.hiof.akduncan.javalin.repository;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import no.hiof.akduncan.javalin.model.Planet;
import no.hiof.akduncan.javalin.model.PlanetSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UniverseCSVRepository implements IUniverseRepository{
    CsvMapper mapper = new CsvMapper();

    CsvSchema sclema = mapper.schemaFor(PlanetSystem.class)
            .withSkipFirstDataRow(true)
            .withColumnSeparator('|').withoutQuoteChar();

    MappingIterator<PlanetSystem> iterator = mapper
            .readerFor(PlanetSystem.class)
            .with(sclema).readValues("planets_100.csv");

    List<PlanetSystem> hotelSummaries = iterator.readAll();

    
}
