package org.codarama.diet

import org.codarama.diet.extensions.MinimizerExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by Ayld on 4/18/15.
 */
public class MinimizerPlugin implements Plugin<Project> {

    public MinimizerPlugin() {
    }

    public void apply(Project project) {
        // Add the 'greeting' extension object
        project.extensions.create("minimizer", MinimizerExtension)
        // Add a task that uses the configuration
        project.task('minimize') << {
            println project.minimizer.message
        }
    }
}
