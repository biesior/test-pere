package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class ModuleVersion extends Model {

    @Id
    public Long id;

    @ManyToOne
    public Module module;

    public String version;

    public static Finder<Long, ModuleVersion> find
            = new Finder<Long, ModuleVersion>(Long.class, ModuleVersion.class);

    // TODO: AD 1.: How to find (from ModuleVersion) Modules not within a rel with FeaturedModules
    // Note: it's far easier to setup Module's isFeatured flag for the module while saving/updating, than later searching the relations
    // to make it working as you wish you need to write a custom query with two joins, while with this flag you have only one join + isFeatured check

    public static List<ModuleVersion> findAll(String version) {
        return find.fetch("module").where().like("version", version).findList();
    }

    public static List<ModuleVersion> findFeatured(String version) {
        return find.fetch("module").where().like("version", version).eq("module.isFeatured", true).findList();
    }

    public static List<ModuleVersion> findNotFeatured(String version) {
        return find.fetch("module").where().like("version", version).eq("module.isFeatured", false).findList();
    }
}
