package no.hiof.akduncan.javalin;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.plugin.rendering.vue.VueComponent;
import no.hiof.akduncan.javalin.controller.PlanetController;
import no.hiof.akduncan.javalin.controller.UniverseController;
import no.hiof.akduncan.javalin.repository.UniverseCSVRepository;
import org.jetbrains.annotations.NotNull;

public class Application {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start();

        app.config.enableWebjars();

        app.get("/helloworld", ctx -> ctx.result("Hello World"));
        app.get("/", new VueComponent("planet-system-overview"));
        app.get("/planet-systems/:planet-system-id", new VueComponent("planet-system-detail"));
        app.get("/planet-systems/:planet-system-id/planets/:planet-id", new VueComponent("planet-detail"));
        app.get("/planet-systems/:planet-system-id/planets/:planet-id/update", new VueComponent("planet-update"));
        app.get("/planet-systems/:planet-system-id/createplanet", new VueComponent("planet-create"));

        UniverseCSVRepository universeRepository = new UniverseCSVRepository();
        UniverseController universeController = new UniverseController(universeRepository);
        PlanetController planetController = new PlanetController(universeRepository);

        //API's

        app.get("api/planet-systems/", new Handler() {
            @Override
            public void handle(Context context) throws Exception {
                universeController.getAllSystems(context);
            }
        });

        app.get("api/planet-systems/:planet-system-id/", new Handler() {
            @Override
            public void handle(Context context) throws Exception {
                universeController.getAPlanetSystem(context);
            }
                }
        );

        app.get("api/planet-systems/:planet-system-id/planets/", new Handler() {
            @Override
            public void handle(Context ctx) throws Exception {
                planetController.getAllPlanets(ctx);
            }
        });


       app.get("api/planet-systems/:planet-system-id/planets/:planet-id", new Handler() {
            @Override
            public void handle(Context ctx) throws Exception {
                planetController.getAPlanet(ctx);
            }
        });


    }
}
