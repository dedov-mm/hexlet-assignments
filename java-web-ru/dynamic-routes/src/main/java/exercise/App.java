package exercise;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN

// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx -> {
            var companyNumber = ctx.pathParamAsClass("id", Integer.class);

            if (companyNumber.get() > COMPANIES.size() || companyNumber.get() < 0) {
                throw new NotFoundResponse("Company not found");
            }

            String targetId = String.valueOf(companyNumber.get()).trim();

            Map<String, String> result = new HashMap<>();
            for (Map<String, String> company : COMPANIES) {
                if (targetId.equals(company.get("id"))) {
                    result = company;
                    break;
                }
            }

            ctx.json(result);
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(8080);
    }
}
