package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
//        app.get("/users/{id}", ctx -> {
//            var userId = ctx.pathParamAsClass("id", Long.class).get();
//
//            var user = USERS.stream()
//                    .filter(u -> u.getId() == userId)
//                    .findFirst()
//                    .orElseThrow(() -> new NotFoundResponse("User not found"));
//
//            ctx.json(user);
//        });

        app.get("/users/{id}", ctx -> {
            var userId = ctx.pathParamAsClass("id", Long.class).get();
            var user = USERS.stream()
                    .filter(u -> u.getId() == userId)
                    .findFirst()
                    .orElseThrow(() -> new NotFoundResponse("User not found"));
            var page = new UserPage(user);
            var test = page;
            ctx.render("users/show.jte", model("page", page));
        });

        app.get("/users", ctx -> {
            var header = "Users";
            var page = new UsersPage(USERS, header);
            ctx.render("users/index.jte", model("page", page));
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(8080);
    }
}
