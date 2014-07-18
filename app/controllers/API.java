package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Photo;
import play.db.ebean.Transactional;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import java.util.List;

/**
 * Created by shimizu on 2014/07/18.
 */
public class API extends Controller{

    static {
        Photo.InitData();
    }
    @Transactional
    public static Result getList() {
        List<Photo> photos = Photo.find.all();
        return ok(Json.toJson(photos));
    }

    public static Result get(Long id) {
        JsonNode json = request().body().asJson();
        if(json == null) {
            return badRequest("Expecting Json data");
        } else {
            String name = json.findPath("name").textValue();
            if(name == null) {
                return badRequest("Missing parameter [name]");
            } else {
                return ok("Hello " + name);
            }
        }
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result create() {
        final Http.RequestBody body = request().body();
        JsonNode json = body.asJson();
        if(json == null) {
            return badRequest("Expecting Json data");
        } else {
            Photo newPhoto = Json.fromJson(json, Photo.class);
            newPhoto.save();
            return ok(Json.toJson(newPhoto));
        }
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result update(Long id) {
        JsonNode json = request().body().asJson();
        if(json == null) {
            return badRequest("Expecting Json data");
        } else {
            String name = json.findPath("name").textValue();
            if(name == null) {
                return badRequest("Missing parameter [name]");
            } else {
                return ok("Hello " + name);
            }
        }
    }

    public static Result delete(Long id) {
        if(id == null) {
            return badRequest("Expecting Json data");
        } else {
            Photo.find.byId(id).delete();
            return ok();
        }
    }
}
