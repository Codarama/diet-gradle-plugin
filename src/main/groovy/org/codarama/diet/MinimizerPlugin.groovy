package org.codarama.diet

import com.google.common.collect.Sets
import org.codarama.diet.extensions.MinimizerExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

import java.util.jar.JarFile

/**
 * Created by Ayld on 4/18/15.
 */
public class MinimizerPlugin implements Plugin<Project> {

    private static final String DEFAULT_JAVA_SOURCE_PATH = 'src/main/java'

    public void apply(Project project) {
        project.extensions.create("minimizer", MinimizerExtension)

        project.task('minimize') << {
            Set<File> dirs = project.sourceSets.main.allJava.getSrcDirs()
            // TODO standard null and == 0 validations
            if (dirs.size() > 1) {
                throw new IllegalStateException("Found more than one source dir: " + dirs +
                        ", Diet currently supports single source dir projects only. Sorry :(")
            }
            File srcDir = dirs.iterator().next()

            Set<File> libJars = Sets.newHashSet()aa
            project.configurations.compile.each {
                File file -> libJars.add(file)
            }

            JarFile minimizedJar = project.minimizer.minimize(srcDir.getAbsolutePath(), libJars)
            println 'jar: ' + minimizedJar.getName()
        }
    }
}
