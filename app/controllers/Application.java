package controllers;

import models.Module;
import models.ModuleVersion;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.List;

public class Application extends Controller {

    public static Result index() {

        return show("2.0.4");
    }

    public static Result show(String version){

        List<ModuleVersion> allByVersion = ModuleVersion.findAll(version);
        List<ModuleVersion> featuredByVersion = ModuleVersion.findFeatured(version);
        List<ModuleVersion> notFeaturedByVersion = ModuleVersion.findNotFeatured(version);

        List<Module> allFeatured = Module.findAllFeatured();
        List<Module> allNotFeatured = Module.findAllNotFeatured();

        return ok(index.render(
                version,
                allByVersion,
                featuredByVersion,
                notFeaturedByVersion,
                allFeatured,
                allNotFeatured
        ));
    }

}