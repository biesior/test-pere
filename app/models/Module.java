package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Module extends Model {

    // this dummy field is for forcing DB drop while testing, change its name to anything and you'll "purge" DB... don't use in LIFE!!!
    public String hykdkddysa;

    @Id
    public Long id;
    public String name;


    // Note that this 'fields' won't create a DB columns, but will create joins in query
    @OneToOne(mappedBy = "module")
    public FeaturedModule featured;

    @OneToMany(mappedBy = "module")
    public List<ModuleVersion> versions;

    // that field can be useful
    public Boolean isFeatured;

    public static Finder<Long, Module> find
            = new Finder<Long, Module>(Long.class, Module.class);

    public static List<Module> findAllFeatured() {
        return find.select("id,name").where().eq("isFeatured", true).findList();
    }

    public static List<Module> findAllNotFeatured() {
        // give here list of field to select WITHOUT featured, otherwise it will create a JOIN to featured which will
        // result that you will be not able to get records without associations
        return find.select("id, name").where().eq("isFeatured", false).findList();
    }
}
