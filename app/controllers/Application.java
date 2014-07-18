package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result ko() {
        return ok(ko.render());
    }
    public static Result angular() {
        return ok(angular.render());
    }
    public static Result vue() {
        return ok(vue.render());
    }
}
