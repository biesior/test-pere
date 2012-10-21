import models.FeaturedModule;
import models.Module;
import models.ModuleVersion;
import play.Application;
import play.GlobalSettings;

import java.util.Arrays;

public class Global extends GlobalSettings {

    public void onStart(Application app) {
        if (Module.find.findRowCount() == 0) {
            String[] versions = {"1.0.0", "1.2.3", "1.2.5", "2.0.0", "2.0.4", "2.1.0"};
            Integer[] featuredIds = new Integer[]{1, 3, 5, 8};

            for (int i = 1; i <= 10; i++) {
                Module module = new Module();
                module.name = "Module " + i;
                module.isFeatured = false;
                module.save();

                if (Arrays.asList(featuredIds).contains(i)) {
                    FeaturedModule featured = new FeaturedModule();
                    featured.name = "Featured for module ID " + module.id;
                    featured.module = module;
                    featured.save();

                    module.isFeatured = true;
                    module.update(module.id);
                }


                for (int y = 0; y < 5; y++) {
                    ModuleVersion moduleVersion = new ModuleVersion();
                    moduleVersion.version = versions[y];
                    moduleVersion.module = module;
                    moduleVersion.save();
                }

            }


        }

    }
}
