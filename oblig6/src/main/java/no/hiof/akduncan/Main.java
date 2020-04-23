package no.hiof.akduncan;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.plugin.rendering.vue.VueComponent;
import no.hiof.akduncan.controller.ObservationController;
import no.hiof.akduncan.model.*;
import no.hiof.akduncan.repository.ObservationRepo;
import org.jetbrains.annotations.NotNull;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start();

        app.config.enableWebjars();

        app.get("/", new VueComponent("observations-overview"));

        ObservationRepo observationRepo = new ObservationRepo();
        ObservationController observationController = new ObservationController(observationRepo);

        app.get("api/observations", ctx -> observationController.getAllObservations(ctx));
    }
}
