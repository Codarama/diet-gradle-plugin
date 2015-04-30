package org.codarama.diet.extensions

import org.codarama.diet.api.DefaultMinimizer

import java.util.jar.JarFile

/**
 * Created by Ayld on 4/29/15.
 */
public class MinimizerExtension {

    public JarFile minimize(String srcDirAbsPath, Set<File> libs) {
        return DefaultMinimizer
                .sources(srcDirAbsPath)
                .libs(libs)
                .minimize()
                .getJar()
    }
}
