package exercise;

import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        var app = Javalin.create(config -> {
            // Включаем логгирование при разработке
            config.bundledPlugins.enableDevLogging();
        });

        var phones = Data.getPhones();
        var domains = Data.getDomains();

        // Описываем, что будет происходить при GET запросе на адрес /
        // Метод json() кодирует тело ответа в JSON строку и вызывает метод result()
        // Дополнительно устанавливает в ответе заголовок content type со значением json
        app.get("/phones", ctx -> ctx.json(phones));
        app.get("/domains", ctx -> ctx.json(domains));

        // Возвращаем настроенное приложение
        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(8080);
    }
}
